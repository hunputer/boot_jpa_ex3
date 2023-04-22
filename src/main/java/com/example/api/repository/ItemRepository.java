package com.example.api.repository;

import com.example.api.controller.form.BookForm;
import com.example.api.domain.item.Book;
import com.example.api.domain.item.Customer;
import lombok.RequiredArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Book book){
        em.persist(book);
    }

    public Book getOne(Long id){
        return em.find(Book.class, id);
    }

    public List<Book> getList(){
        TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);
        return query.getResultList();
    }

    public List<BookForm> getListByCust(String name){
        List<BookForm> result = new ArrayList<>();

        Query query = em.createQuery("select b,c from Book b inner join b.customer c where c.name=:name")
                .setParameter("name", name);

        List<Object[]> list = query.getResultList();

        for(Object[] row: list){
            BookForm bookForm = new BookForm();
            Book book = (Book)row[0];
            Customer customer = (Customer)row[1];

            bookForm.setCustNo(customer.getId());
            bookForm.setCustName(customer.getName());
            bookForm.setId(book.getId());
            bookForm.setName(book.getName());
            bookForm.setContents(book.getContents());

            result.add(bookForm);
        }

        return result;
    }

    public List<Customer> getCustByAge(int age){
        TypedQuery query = em.createQuery("select c from Customer c " +
                                             "where age > :age", Customer.class)
                        .setParameter("age", age);
        return query.getResultList();
    }



}
