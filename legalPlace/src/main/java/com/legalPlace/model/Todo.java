/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.legalPlace.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author abbasturki.elias
 */
@Entity
public class Todo implements Serializable{
    
     private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String title;
     private String description;
     @Temporal(TemporalType.DATE)
     private Date date;
     
//    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private User id_user;

     public Todo(){
         
     }
     
    public Todo(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public User getId_user() {
//        return id_user;
//    }
//
//    public void setId_user(User idUser) {
//        this.id_user = idUser;
//    }
    
    

    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", title=" + title + ", description=" + description + ", date=" + date + '}';
    }
    
     
     
}
