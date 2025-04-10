/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.models;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mauricio
 */
@Entity
public class Competitor implements Serializable{
     
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id; 
    
    @NotNull 
    @Column(name = "create_at", updatable = false) 
    @Temporal(TemporalType.DATE) 
    private Calendar createdAt;
    
    @NotNull 
    @Column(name = "updated_at") 
    @Temporal(TemporalType.DATE) 
    private Calendar updatedAt;
     
    private String name;
    
    private String surname;
    
    private int age;
    
    private String telephone;
    
    private String cellphone;
    
    private String address;
    
    private String password;
    
    private String city;
    
    private String country;
    
    private boolean winner;

    @OneToMany(cascade=ALL, mappedBy="competitor") 
    private Set<Producto> products;
    
    public Competitor(){
        
    }
    
    public Competitor(String nameN, String surnameN, int ageN,String telephoneN, String cellphoneN, String addressN, String passwordN, String cityN, String countryN,boolean winnerN){
        name=nameN;
        surname=surnameN;
        age=ageN;
        telephone=telephoneN;
        cellphone=cellphoneN;
        address=addressN;
        password=passwordN;
        city=cityN;
        country=countryN;
        winner=winnerN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public Set<Producto> getProducts() {
        return products;
    }

    public void setProducts(Set<Producto> products) {
        this.products = products;
    }
    
    @PreUpdate 
    private void updateTimestamp() { 
        this.updatedAt = Calendar.getInstance(); 
    } 
  
    @PrePersist 
    private void creationTimestamp() { 
        this.createdAt = this.updatedAt = Calendar.getInstance(); 
    }
    
}
