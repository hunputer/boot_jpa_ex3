package com.example.api.controller;

import com.example.api.controller.form.BookForm;
import com.example.api.domain.item.Book;
import com.example.api.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item/new")
    public String saveItem(BookForm bookForm){

        Book book = new Book();
        book.setName(bookForm.getName());
        book.setContents(bookForm.getContents());

        itemService.saveItem(book);

        return "redirect:/";
    }

}
