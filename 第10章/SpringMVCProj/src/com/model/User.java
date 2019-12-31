package com.model;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  

  
  
@Entity  
@Table(name="User")  
public class User {  
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(length=32)    
    private Integer id;  
      
    @Column(length=32)  
    private String name;  
      
    @Column(length=32)  
    private Integer age;  
  
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public Integer getAge() {  
        return age;  
    }  
  
    public void setAge(Integer age) {  
        this.age = age;  
    }  
  
}  