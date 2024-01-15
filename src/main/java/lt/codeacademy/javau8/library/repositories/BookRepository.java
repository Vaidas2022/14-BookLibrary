package lt.codeacademy.javau8.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.javau8.library.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
