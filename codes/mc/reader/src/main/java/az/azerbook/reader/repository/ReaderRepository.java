package az.azerbook.reader.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import az.azerbook.reader.entity.ReaderEntity;

public interface ReaderRepository extends JpaRepository<ReaderEntity, Integer>{

}