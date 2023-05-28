package com.igor.msbook.service;

import com.igor.msbook.model.Book;
import com.igor.msbook.proxy.CambioProxy;
import com.igor.msbook.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CambioProxy proxy;


    @Override
    public Book findBook(Long id, String currency) {
        var book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not Found"));
        var response = proxy.getCambio(book.getPrice(), "USD", currency);
        var cambio = response.getBody();
        book.setPrice(cambio.getConvertedValue());
        return book;
    }
}
