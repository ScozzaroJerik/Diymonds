package com.javasampleapproach.diymonds.model;

import javax.persistence.*;

@Entity
@Table(name = "Utente")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "username", nullable = false)
    private String username;


    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public User() {
    }

    public User(String username, String nome,String cognome, String email, String password) {
        this.username = username;
        this.cognome = cognome;
        this.nome=nome;
        this.email=email;
        this.password=password;
    }


    public long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", cog='" + cognome + '\'' +
                ", psw='" + password + '\'' +
                '}';
    }


}