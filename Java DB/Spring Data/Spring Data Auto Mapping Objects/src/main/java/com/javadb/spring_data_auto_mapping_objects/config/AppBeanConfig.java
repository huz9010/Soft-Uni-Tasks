package com.javadb.spring_data_auto_mapping_objects.config;

import com.javadb.spring_data_auto_mapping_objects.models.dtos.GameAddDto;
import com.javadb.spring_data_auto_mapping_objects.models.dtos.GameEditDto;
import com.javadb.spring_data_auto_mapping_objects.models.entities.Game;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper -> {
                    mapper.map(GameAddDto::getThumbnailUrl, Game::setImageUrl);
                    mapper.map(GameAddDto::getTrailer, Game::setTrailerId);
                });

        return modelMapper;
    }
}
