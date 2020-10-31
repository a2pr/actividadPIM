package com.example.myapplication;

import java.io.Serializable;

public class Usuario implements Serializable {

    private static final long serialVerisonUID =1L;
    private String email, nome, password;
    private int admin;

    public Usuario(String nome,String email,  String password, int admin) {
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.admin = admin;
    }

    public String getLogin() {
        return email;
    }

    public void setLogin(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin() {
        return admin;
    }

    public String isAdmin(){
        return this.admin ==1 ? "Is Admin": "not Admin";
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }


}
