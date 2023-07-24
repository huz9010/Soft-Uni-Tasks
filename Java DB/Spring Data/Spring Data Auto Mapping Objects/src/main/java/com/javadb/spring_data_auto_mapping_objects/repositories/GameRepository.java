package com.javadb.spring_data_auto_mapping_objects.repositories;

import com.javadb.spring_data_auto_mapping_objects.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findFirstById(Long id);

    @Query("SELECT g.title, g.price FROM Game g")
    List<String> findAllGames();

    Optional<Game> findAllByTitleEquals(String title);
}
