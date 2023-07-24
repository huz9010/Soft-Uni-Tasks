package com.javadb.spring_data_auto_mapping_objects.services;

import com.javadb.spring_data_auto_mapping_objects.models.dtos.GameAddDto;

public interface GameService {
    void addGame(GameAddDto addGameDto);

    void editGame(String[] args);

    void viewAllGames();

    void viewDetailsOfGame(String title);
}
