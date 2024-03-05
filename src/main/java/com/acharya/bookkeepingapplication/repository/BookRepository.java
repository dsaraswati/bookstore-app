package com.acharya.bookkeepingapplication.repository;

import com.acharya.bookkeepingapplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findById(Integer id);

    @Query("SELECT b FROM book b WHERE b.title ILIKE %?1%")
    List<Book> searchByTitle(String title);

    @Query("SELECT b FROM book b WHERE b.genre ILIKE %?1%")
    List<Book> searchByGenre(String genre);

    @Query(value = "SELECT b.id as id, b.title as title, b.price as price, b.genre as genre,b.id as author_id FROM book b JOIN author a ON b.author_id = a.id WHERE a.name ILIKE %?1%", nativeQuery = true)
    List<Book> searchByAuthor(String authorName);
}
