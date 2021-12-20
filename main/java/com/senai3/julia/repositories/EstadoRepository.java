package com.senai3.julia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai3.julia.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

} 
