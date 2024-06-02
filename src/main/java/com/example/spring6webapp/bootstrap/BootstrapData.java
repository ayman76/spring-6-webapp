package com.example.spring6webapp.bootstrap;

import com.example.spring6webapp.domain.Author;
import com.example.spring6webapp.domain.Book;
import com.example.spring6webapp.domain.Publisher;
import com.example.spring6webapp.repository.AuthorRepository;
import com.example.spring6webapp.repository.BookRepository;
import com.example.spring6webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ayman = new Author();
        ayman.setFirstName("Ayman");
        ayman.setLastName("Mohamed");

        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setIsbn("1234123");

        Publisher publisher1 = new Publisher();
        publisher1.setName("Publisher 1");
        publisher1.setCity("New York");
        publisher1.setAddress("New York");
        publisher1.setState("New York");
        publisher1.setZip("12132");

        Author aymanSaved = authorRepository.save(ayman);
        Book book1Saved = bookRepository.save(book1);
        Publisher publisher1Saved = publisherRepository.save(publisher1);


        aymanSaved.getBooks().add(book1Saved);
        authorRepository.save(aymanSaved);

        Author ahmed = new Author();
        ahmed.setFirstName("Ahmed");
        ahmed.setLastName("Khaled");

        Book book2 = new Book();
        book2.setTitle("Book 2");
        book2.setIsbn("5468898");

        Publisher publisher2 = new Publisher();
        publisher2.setName("Publisher 2");
        publisher2.setCity("New York");
        publisher2.setAddress("New York");
        publisher2.setState("New York");
        publisher2.setZip("12132");


        Author ahmedSaved = authorRepository.save(ahmed);
        Book book2Saved = bookRepository.save(book2);
        Publisher publisher2Saved = publisherRepository.save(publisher2);

        book1Saved.setPublisher(publisher1Saved);
        book2Saved.setPublisher(publisher2Saved);
        bookRepository.save(book1Saved);
        bookRepository.save(book2Saved);

        ahmedSaved.getBooks().add(book2Saved);
        authorRepository.save(ahmedSaved);

        System.out.println("In Bootstrap");
        System.out.println("Authors Count: " + authorRepository.count());
        System.out.println("Books Count: " + bookRepository.count());
        System.out.println("Publishers Count: " + publisherRepository.count());
    }
}
