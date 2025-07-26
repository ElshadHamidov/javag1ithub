package az.azerbook.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.azerbook.book.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer>{

	List<BookEntity> findAllByUserId(Integer userId);

}