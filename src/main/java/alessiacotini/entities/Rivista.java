package alessiacotini.entities;

import alessiacotini.enums.Periodicita;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "riviste")
@DiscriminatorValue("rivista")
public class Rivista extends Elemento{

    //ATTRIBUTO

    @Column(name = "periodicità")
    private Periodicita periodicita;

    //COSTRUTTORI

    protected Rivista(){}
    public Rivista(String titolo, int anno_pubblicazione,int numero_pagine, Periodicita periodicita){
        super(titolo, anno_pubblicazione, numero_pagine);

        this.periodicita = periodicita;
    }

    //GETTER E SETTER

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "elemento_id=" + getElemento_id() +
                ", isbn='" + getIsbn() + '\'' +
                ", titolo='" + getTitolo() + '\'' +
                ", anno_pubblicazione=" + getAnno_pubblicazione() +
                ", numero_pagine=" + getNumero_pagine() +
                "periodicita=" + periodicita +
                '}';
    }
}
