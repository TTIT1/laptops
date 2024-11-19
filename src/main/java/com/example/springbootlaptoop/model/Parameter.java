package com.example.springbootlaptoop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "parameter")
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tùy chọn
    private Long id; // Khoá chính

    private String Chip;
    private String memory;
    private String ram;
    private double price;

    @OneToOne(mappedBy = "parameter")//ánh xạ ngược lại
    @JsonBackReference // Phía ngược lại của tham chiếu
    private Laptop laptop;
 
    @Override
public String toString() {
    return memory + ", " + ram + ", " + price + ", " + Chip;
}

    public String getChip() {
        return Chip;
    }
    public void setChip(String chip) {
        Chip = chip;
    }
    public String getMemory() {
        return memory;
    }
    public void setMemory(String memory) {
        this.memory = memory;
    }
    public String getRam() {
        return ram;
    }
    public void setRam(String ram) {
        this.ram = ram;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Laptop getLaptop() {
        return laptop;
    }
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
    public Parameter(String chip, String memory, String ram, double price,
            com.example.springbootlaptoop.model.Laptop laptop) {
        Chip = chip;
        this.memory = memory;
        this.ram = ram;
        this.price = price;
        this.laptop = laptop;
    }
    public Parameter() {
    }

}
