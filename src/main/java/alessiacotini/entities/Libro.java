package alessiacotini.entities;

import alessiacotini.enums.GenereLibro;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "libri")
@DiscriminatorValue("libro")
public class Libro extends Elemento{

    //ATTRIBUTI

    @Column(name = "autore")
    private String autore;

    @Column (name = "genere")
    private GenereLibro genere;

    //COSTRUTTORI

    protected Libro(){}
    public Libro(String titolo, int anno_pubblicazione,int numero_pagine,String autore, GenereLibro genere){
        super(titolo, anno_pubblicazione, numero_pagine); // LI PRENDONO DA ELEMENTO
        this.autore = autore;
        this.genere = genere;
    }

    //GETTER E SETTER - I SETTER PER IL MOMENTO NON SERVONO MA PER COMPLETEZZA LI IMPLEMENTO


    public String getAutore() {
        return autore;
    }

    public GenereLibro getGenere() {
        return genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(GenereLibro genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "elemento_id=" + getElemento_id() +
                ", isbn='" + getIsbn() + '\'' +
                ", titolo='" + getTitolo() + '\'' +
                ", anno_pubblicazione=" + getAnno_pubblicazione() +
                ", numero_pagine=" + getNumero_pagine() +
                "autore='" + autore + '\'' +
                ", genere=" + genere +
                '}';
    }
}
