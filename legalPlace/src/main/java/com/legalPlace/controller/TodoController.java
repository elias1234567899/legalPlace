/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalPlace.controller;

import com.legalPlace.dao.TodoRepository;
import com.legalPlace.model.Todo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abbasturki.elias
 */
@RestController
@RequestMapping(path = "/todos")
@CrossOrigin("*")
public class TodoController {
    
    @Autowired
    private TodoRepository todoRepository;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }
    
     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Todo> getTodo(@PathVariable Long id) {
        return todoRepository.findById(id);
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Todo save(@RequestBody Todo t) {
        return todoRepository.save(t);
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return true;
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Todo update(@PathVariable Long id, @RequestBody Todo t) {
        t.setId(id);
        return todoRepository.save(t);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Page<Todo> search(@RequestParam(name="mc",defaultValue = "") String mc,
                                @RequestParam(name="page",defaultValue = "0") int page,
                                @RequestParam(name="size",defaultValue = "5") int size) {
        return todoRepository.search("%"+mc+"%", new PageRequest(page, size));
    }
    
}
