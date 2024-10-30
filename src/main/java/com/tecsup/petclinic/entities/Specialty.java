package com.tecsup.petclinic.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "specialties")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "office")
    private String office;
    @Column(name = "h_open")
    private Integer hOpen;
    @Column(name = "h_close")
    private Integer hClose;

    public Specialty() {}

    public Specialty(Integer id, String name, String office, Integer hOpen, Integer hClose) {
        this.id = id;
        this.name = name;
        this.office = office;
        this.hOpen = hOpen;
        this.hClose = hClose;
    }

    public Specialty(String name, String office, Integer hOpen, Integer hClose) {
        this.name = name;
        this.office = office;
        this.hOpen = hOpen;
        this.hClose = hClose;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer gethClose() {
        return hClose;
    }

    public void sethClose(Integer hClose) {
        this.hClose = hClose;
    }

    public Integer gethOpen() {
        return hOpen;
    }

    public void sethOpen(Integer hOpen) {
        this.hOpen = hOpen;
    }
}
