package br.com.omniatechnology.recyclerviewmvvm;

import java.io.Serializable;

public class User implements Serializable {

    private String nome;
    private String email;

    public User(){

    }

    public User(String nome, String email){
        this();
        this.nome = nome;
        this.email = email;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
