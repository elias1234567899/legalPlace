/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalPlace.dao;

import com.legalPlace.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author abbasturki.elias
 */
public interface TodoRepository extends JpaRepository<Todo,Long>{
    
    @Query("select c from Todo c where c.title like :X")
    public Page<Todo> search(@Param("X")String mc,Pageable pageable);
    
}
