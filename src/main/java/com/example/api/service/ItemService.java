package com.example.api.service;

import com.example.api.domain.item.Book;
import com.example.api.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

}
