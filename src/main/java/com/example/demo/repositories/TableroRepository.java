package com.example.demo.repositories;

import com.example.demo.models.Tablero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableroRepository extends JpaRepository<Tablero, Long> {
}
