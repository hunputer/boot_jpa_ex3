package com.example.api.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private long id;

    private String name;
    private String contents;

    @ManyToOne
    @JoinColumn(name = "cust_no")
    private Customer customer;

}
