package com.igor.msbook.service;

import com.igor.msbook.model.Book;

public interface BookService {

    Book findBook(Long id, String currency);
}
