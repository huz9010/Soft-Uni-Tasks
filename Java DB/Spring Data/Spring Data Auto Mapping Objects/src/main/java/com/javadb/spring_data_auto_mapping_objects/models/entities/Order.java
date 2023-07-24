package com.javadb.spring_data_auto_mapping_objects.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private User buyer;
    private Set<Game> products;

    public Order() {
    }

    @ManyToOne
    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @ManyToMany
    public Set<Game> getProducts() {
        return products;
    }

    public void setProducts(Set<Game> products) {
        this.products = products;
    }
}
