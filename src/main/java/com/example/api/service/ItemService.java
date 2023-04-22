package com.example.api.service;

import com.example.api.controller.form.BookForm;
import com.example.api.domain.item.Book;
import com.example.api.domain.item.Customer;
import com.example.api.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(Book book){
        itemRepository.save(book);
    }

    public Book getOne(long id){
       return itemRepository.getOne(id);
    }

    public List<Book> getList(){
        return itemRepository.getList();
    }

    public List<BookForm> getListByCust(String custName){
        return itemRepository.getListByCust(custName);
    }

    public List<Customer> getCustByAge(int age){
        return itemRepository.getCustByAge(age);
    }



}
