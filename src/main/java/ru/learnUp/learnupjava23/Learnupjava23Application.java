package ru.learnUp.learnupjava23;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUp.learnupjava23.dao.entity.Book;
import ru.learnUp.learnupjava23.dao.service.BookService;
import ru.learnUp.learnupjava23.dao.service.BookstoreService;
import ru.learnUp.learnupjava23.exceptions.NotEnoughBooksException;

@Slf4j
@SpringBootApplication
@EnableCaching
public class Learnupjava23Application {

    public static void main(String[] args) throws InterruptedException {

        ConfigurableApplicationContext context = SpringApplication.run(Learnupjava23Application.class, args);

        BookService bookService = context.getBean(BookService.class);
    }

    static void updateAsync(BookstoreService service, Book book) {

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    service.buyBook(book, 1);
                    log.info("Book purchase completed!");
                } catch (NotEnoughBooksException e) {
                    log.warn("Sorry, there are no such number of books... try again later");
                }
            }).start();
        }
    }
}
