package com.binarxbca.chapter5.repository;

import com.binarxbca.chapter5.model.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, String> {
    @Query(value = "select * from film where name = :name", nativeQuery = true)
    public List<Film> findFilmByName(@Param("name") String name);
}