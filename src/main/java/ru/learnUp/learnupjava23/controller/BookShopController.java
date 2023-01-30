package ru.learnUp.learnupjava23.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.learnUp.learnupjava23.dao.entity.Author;
import ru.learnUp.learnupjava23.dao.entity.Book;
import ru.learnUp.learnupjava23.dao.service.AuthorService;
import ru.learnUp.learnupjava23.dao.service.BookService;

import java.util.List;



@Slf4j
@Controller
@RequestMapping("/bookshop")
public class BookShopController {

    private final ApplicationContext context;

    public BookShopController(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/books")
    public String books(Model model) {

        BookService bookService = context.getBean((BookService.class));
        List<Book> books = bookService.getBooks();

        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/authors")
    public String authors(Model model) {

        AuthorService authorService = context.getBean((AuthorService.class));
        List<Author> authors = authorService.getAuthors();

        model.addAttribute(
                "authors",
                authors
        );
        return "authors";
    }
}
