package com.example.realestate.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.realestate.Entities.Casa;


public interface CasaRepository extends JpaRepository<Casa,Long>
{
    List<Casa> findByPais(String pais);
}

