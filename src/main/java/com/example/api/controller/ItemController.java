package com.example.api.controller;

import com.example.api.controller.form.BookForm;
import com.example.api.domain.item.Book;
import com.example.api.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/item/one")
    public String getItemOne(){

        return "itemOne";
    }

    @PostMapping("/item/one")
    public String getItemOneResult(BookForm bookForm, Model model){

        model.addAttribute("book", itemService.getOne(bookForm.getId()));

        return "itemOne";
    }

    @GetMapping("/item/list")
    public String getItemList(BookForm bookForm, Model model){

        List<Book> list = itemService.getList();

        model.addAttribute("bookList", list);

        return "itemList";
    }

    @PostMapping("/item/listbycust")
    public String getItemListByCust(BookForm bookForm, Model model){

        List<BookForm> bookFormList = itemService.getListByCust(bookForm.getCustName());
        model.addAttribute("bookFormList", bookFormList);

        return "itemListByCust";
    }

}
