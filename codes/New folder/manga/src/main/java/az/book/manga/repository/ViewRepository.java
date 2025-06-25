package az.book.manga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.book.manga.model.TestEntity;

public interface ViewRepository extends JpaRepository<TestEntity, Integer>{

}