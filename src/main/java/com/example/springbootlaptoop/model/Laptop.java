package com.example.springbootlaptoop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tùy chọn
    private Long id; // Khoá chính

   
    private String laptopName;
    private String trademark;

    @OneToOne(cascade = CascadeType.ALL) // Đảm bảo rằng các thao tác như lưu hoặc xóa trên laptop cũng sẽ được áp dụng cho parameter liên kết.                             
    @JoinColumn (name = "parameter_id" )// khóa ngoại
    @JsonManagedReference // Quản lý tham chiếu để ko bị lỗi dư liệu

    private Parameter  parameter;
    
    @Override
    public String toString() {
        return laptopName + " - " + trademark + " - " + (parameter != null ? parameter.toString() : "No Parameter Info");
    }
    public Laptop() {
    }
    public Laptop(String laptopName, String trademark,Parameter parameter) {
        this.laptopName = laptopName;
        this.trademark = trademark;
        this.parameter = parameter;
    }
  
    public Parameter getParameter() {
        return parameter;
    }
    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
  
    public String getLaptopName() {
        return laptopName;
    }
    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }
    public String getTrademark() {
        return trademark;
    }
    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }
}
