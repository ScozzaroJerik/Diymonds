package com.javasampleapproach.diymonds.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AnnuncioGioiello")
public class AnnuncioGioiello {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "idVenditore", nullable = false)
    private long idVenditore;
    @Column(name = "descrizione", nullable = false)
    private String descrizione;
    @Column(name = "gioiello", nullable = false)
    private Gioiello gioiello;
    @Column(name = "prezzo", nullable = false)
    private int prezzo;

    public AnnuncioGioiello() {
    }

    public AnnuncioGioiello(long id, long idVenditore, String descrizione, Gioiello gioiello, int prezzo) {
        this.id = id;
        this.idVenditore = idVenditore;
        this.descrizione = descrizione;
        this.gioiello = gioiello;
        this.prezzo = prezzo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdVenditore() {
        return idVenditore;
    }

    public void setIdVenditore(long idVenditore) {
        this.idVenditore = idVenditore;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Gioiello getGioello() {
        return gioiello;
    }

    public void setGioello(Gioiello gioiello) {
        this.gioiello = gioiello;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnuncioGioiello that = (AnnuncioGioiello) o;
        return id == that.id && idVenditore == that.idVenditore && prezzo == that.prezzo && Objects.equals(descrizione, that.descrizione) && Objects.equals(gioiello, that.gioiello);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idVenditore, descrizione, gioiello, prezzo);
    }

    @Override
    public String toString() {
        return "AnnuncioGioiello{" +
                "id=" + id +
                ", idVenditore=" + idVenditore +
                ", descrizione='" + descrizione + '\'' +
                ", gioello=" + gioiello +
                ", prezzo=" + prezzo +
                '}';
    }
}
