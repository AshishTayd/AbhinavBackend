package com.gtasterix.AbhinavNGO.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String First_Name;
    private String Last_Name;
    private String Mail_id;
    private String Mobile_no1;
    private String Mobile_no2;
    private String Father_Name;
    private String Mother_Name;
    private String DOB;
    private String Address;
    private String state;
   private String Pincode;
   private String Category;
   private String marial_status;
    private String Religion;
private String Citizen_of_india;
private String Any_Disability;

}
