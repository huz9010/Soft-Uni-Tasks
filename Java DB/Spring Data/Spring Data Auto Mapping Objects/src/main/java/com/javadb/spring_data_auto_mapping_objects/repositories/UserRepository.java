package com.javadb.spring_data_auto_mapping_objects.repositories;

import com.javadb.spring_data_auto_mapping_objects.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);
    Optional<User> findFirstByEmailAndPassword(String email, String password);
}
