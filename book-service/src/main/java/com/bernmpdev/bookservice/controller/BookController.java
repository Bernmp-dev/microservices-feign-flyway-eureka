package com.bernmpdev.bookservice.controller;

import com.bernmpdev.bookservice.model.BookEntity;
import com.bernmpdev.bookservice.model.CambioEntity;
import com.bernmpdev.bookservice.proxy.CambioProxy;
import com.bernmpdev.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy proxy;

    @GetMapping("/{id}/{currency}")
    public BookEntity getBook(
            @PathVariable Long id,
            @PathVariable String currency
    ) {

        BookEntity book = repository
                .findById(id)
                .orElseThrow((
                ) -> new RuntimeException("Book not found"));

        CambioEntity cambio = proxy.getCambio(book.getPrice(), "USD", currency);

        String PORT = environment.getProperty("local.server.port");
        book.setEnvironment(
                "Book port"
                + PORT
                + "Cambio Port"
                + cambio.getEnvironment()
        );
        book.setPrice(cambio.getConvertedValue().doubleValue());
        book.setCurrency(currency);

        return book;
    }

}
