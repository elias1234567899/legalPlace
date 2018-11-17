/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalPlace.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author abbasturki.elias
 */
@Entity
public class User implements Serializable{
    
     private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String mail;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_user", fetch = FetchType.LAZY)
//    private List<Todo> todos;

    public User() {
    }

    public User(String mail) {
        this.mail = mail;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id) {
        this.id_user = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

//    public List<Todo> getTodos() {
//        return todos;
//    }
//
//    public void setTodos(List<Todo> todos) {
//        this.todos = todos;
//    }

    @Override
    public String toString() {
        return "User{" + "mail=" + mail + '}';
    }
    
    
}
