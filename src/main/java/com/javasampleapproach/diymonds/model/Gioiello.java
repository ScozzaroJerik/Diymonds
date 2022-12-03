package com.javasampleapproach.diymonds.model;

import java.util.ArrayList;
import java.util.Objects;


public class Gioiello {

    private String nome;
    private ArrayList<String> materiali;
    private float peso;
    private String tipo;

    public Gioiello() {
    }

    public Gioiello(String nome, ArrayList<String> materiali,float peso, String tipo) {
        this.nome = nome;
        this.materiali = materiali;
        this.peso = peso;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getMateriali() {
        return materiali;
    }

    public void setMateriali(ArrayList<String> materiali) {
        this.materiali = materiali;
    }

    public float getPeso() {
        return peso;
    }

    public String getTipo() {
        return tipo;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gioiello gioiello = (Gioiello) o;
        return Objects.equals(nome, gioiello.nome) && Objects.equals(materiali, gioiello.materiali);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, materiali);
    }

    @Override
    public String toString() {
        return "Gioello{" +
                "nome='" + nome + '\'' +
                ", materiali=" + materiali +
                '}';
    }
}
