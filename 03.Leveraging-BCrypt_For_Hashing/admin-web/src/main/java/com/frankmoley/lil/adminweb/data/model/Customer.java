package com.frankmoley.lil.adminweb.data.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="contact_name")
    private String contactName;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phoneNumber;
}