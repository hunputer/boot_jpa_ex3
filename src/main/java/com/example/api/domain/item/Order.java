package com.example.api.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @Setter
@Table(name = "torder")
public class Order {

    @Id
    @GeneratedValue
    private long id;
    private String itemId;

}
