package com.brunozarth.equipmentapi.entity;


import javax.persistence.*;


@Entity
@Table(name = "client")
public class Client {
    // client: id, name, adress, email, phone


    public Client(Long id, String name, String adress, String email, String phone) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
    }

    public Client(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String adress;

    private String email;

    private String phone;


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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
