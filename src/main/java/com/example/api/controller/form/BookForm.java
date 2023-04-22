package com.example.api.controller.form;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {

    private Long id;
    private String name;
    private String contents;
    private Long custNo;
    private String custName;
    private int age;

}
