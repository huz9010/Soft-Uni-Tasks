package com.javadb.spring_data_auto_mapping_objects.repositories;

import com.javadb.spring_data_auto_mapping_objects.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
