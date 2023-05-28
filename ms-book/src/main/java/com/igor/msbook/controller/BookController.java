package com.igor.msbook.controller;

import com.igor.msbook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}/{currency}")
    public ResponseEntity getBook(@PathVariable("id") Long id,
                                  @PathVariable("currency") String currency) {
        return ResponseEntity.ok(bookService.findBook(id, currency));
    }
}
