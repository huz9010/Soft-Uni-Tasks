package com.javadb.spring_data_auto_mapping_objects.services.impl;

import com.javadb.spring_data_auto_mapping_objects.models.dtos.GameAddDto;
import com.javadb.spring_data_auto_mapping_objects.models.dtos.GameEditDto;
import com.javadb.spring_data_auto_mapping_objects.models.dtos.GameViewAllDto;
import com.javadb.spring_data_auto_mapping_objects.models.dtos.GameViewDetailsDto;
import com.javadb.spring_data_auto_mapping_objects.models.entities.Game;
import com.javadb.spring_data_auto_mapping_objects.repositories.GameRepository;
import com.javadb.spring_data_auto_mapping_objects.services.GameService;
import com.javadb.spring_data_auto_mapping_objects.services.UserService;
import com.javadb.spring_data_auto_mapping_objects.utils.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.javadb.spring_data_auto_mapping_objects.constants.ErrorMessages.*;
import static com.javadb.spring_data_auto_mapping_objects.constants.Messages.*;

@Service
public class GameServiceImpl implements GameService {

    private final String GAME_DETAILS_PRINT_FORMAT = "Title: %s%n" +
            "Price: %s%n" +
            "Description: %s%n" +
            "Release date: %s%n";

    private final GameRepository gameRepository;
    private final UserService userService;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public GameServiceImpl(GameRepository gameRepository, UserService userService, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.userService = userService;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {


        if (!userService.isAdminLoggedIn()) {
            System.out.println(NOT_LOGGED_IN_AS_ADMIN);
            return;
        }

        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.violation(gameAddDto);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);

        gameRepository.save(game);
        System.out.printf(ADDED_GAME, game.getTitle());
    }

    @Override
    public void editGame(String[] args) {
        if (!userService.isAdminLoggedIn()) {
            System.out.println(NOT_LOGGED_IN_AS_ADMIN);
            return;
        }

        Optional<Game> gameToEdit = gameRepository.findFirstById(Long.valueOf(args[1]));

        if (gameToEdit.isEmpty()) {
            System.out.println(GAME_NOT_FOUND);
        }

        Map<String, String> valuesToUpdate = new HashMap<>();

        for (int i = 2; i < args.length; i++) {
            String[] updateArgs = args[i].split("=");
            valuesToUpdate.put(updateArgs[0], updateArgs[1]);
        }

        GameEditDto gameEditDto = modelMapper.map(gameToEdit.get(), GameEditDto.class);

        gameEditDto.updateFields(valuesToUpdate);

        Game gameToSave = this.modelMapper.map(gameEditDto, Game.class);

        gameRepository.save(gameToSave);

        System.out.println(EDITED_GAME);

    }

    @Override
    public void viewAllGames() {
        List<GameViewAllDto> allGamesInfo = gameRepository.findAllGames().stream().map(game -> {
            String[] info = game.split(",");
            return new GameViewAllDto(info[0], BigDecimal.valueOf(Double.parseDouble(info[1])));
        }).collect(Collectors.toList());

        allGamesInfo.forEach(g -> System.out.println(g.getTitle() + " " + g.getPrice().setScale(2, RoundingMode.HALF_UP)));
    }

    @Override
    public void viewDetailsOfGame(String title) {
        Optional<Game> game = gameRepository.findAllByTitleEquals(title);

        if (game.isEmpty()) {
            System.out.println(GAME_NOT_FOUND);
            return;
        }

        GameViewDetailsDto gameDetails = modelMapper.map(game.get(), GameViewDetailsDto.class);

        System.out.printf(GAME_DETAILS_PRINT_FORMAT, gameDetails.getTitle(),
                gameDetails.getPrice(),
                gameDetails.getDescription(),
                DateTimeFormatter.ofPattern("dd-MM-yyyy").format(gameDetails.getReleaseDate()));
    }
}
