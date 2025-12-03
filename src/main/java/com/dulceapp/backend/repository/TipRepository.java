package com.dulceapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dulceapp.backend.entity.Tip;

public interface TipRepository extends JpaRepository<Tip, Integer>{

}
