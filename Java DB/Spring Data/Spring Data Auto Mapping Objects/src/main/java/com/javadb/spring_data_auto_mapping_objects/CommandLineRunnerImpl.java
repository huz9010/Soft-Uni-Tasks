package com.javadb.spring_data_auto_mapping_objects;

import com.javadb.spring_data_auto_mapping_objects.models.dtos.GameAddDto;
import com.javadb.spring_data_auto_mapping_objects.models.dtos.UserLoginDto;
import com.javadb.spring_data_auto_mapping_objects.models.dtos.UserRegisterDto;
import com.javadb.spring_data_auto_mapping_objects.services.GameService;
import com.javadb.spring_data_auto_mapping_objects.services.UserService;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements org.springframework.boot.CommandLineRunner {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final String MENU = "Enter command or 0 to end the program: ";
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(MENU);
        String command = reader.readLine();

        while (!command.equals("0")) {
            String[] commandParts = command.split("\\|");

            switch (commandParts[0]) {
                case "RegisterUser" ->
                        userService.registerUser(new UserRegisterDto(commandParts[1], commandParts[2], commandParts[3], commandParts[4]));

                case "LoginUser" -> userService.loginUser(new UserLoginDto(commandParts[1], commandParts[2]));

                case "Logout" -> userService.logout();

                case "AddGame" -> gameService.addGame(new GameAddDto(commandParts[1], new BigDecimal(commandParts[2]), Double.parseDouble(commandParts[3]),
                        commandParts[4], commandParts[5], commandParts[6], LocalDate.parse(commandParts[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))));

                case "EditGame" -> gameService.editGame(commandParts);

                case "AllGames" -> gameService.viewAllGames();

                case "DetailGame" -> gameService.viewDetailsOfGame(commandParts[1]);

                default -> {
                    System.out.println("Enter valid command!");
                    command = reader.readLine();
                    continue;
                }
            }
            System.out.println(MENU);
            command = reader.readLine();
        }
    }
}
