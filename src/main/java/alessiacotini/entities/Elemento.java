package alessiacotini.entities;

import jakarta.persistence.*;

import java.security.SecureRandom;
import java.util.UUID;

@Entity
@Table(name = "elementi")
@Inheritance(strategy = InheritanceType.JOINED)
//JOINED PER EVITARE COLONNE DI NULL
@DiscriminatorColumn(name = "tipo_di_elemento")
public abstract class Elemento {

    //ATTRIBUTI

    @Id
    @Column (name= "elemento_id")
    @GeneratedValue
    private UUID elemento_id;

    @Column (name = "isbn")
    private String isbn;

    @Column (name = "titolo")
    private String titolo;


    @Column (name = "anno_pubblicazione")
    private int anno_pubblicazione;


    @Column (name = "numero_pagine")
    private int numero_pagine;

    //COSTRUTTORI

    protected Elemento(){}
    public Elemento(String titolo, int anno_pubblicazione,int numero_pagine ){
      this.titolo = titolo;
      this.anno_pubblicazione = anno_pubblicazione;
      this.numero_pagine = numero_pagine;
    }

    //GETTER E SETTER - I SETTER PER IL MOMENTO NON SERVONO MA PER COMPLETEZZA LI IMPLEMENTO

    //GENERO UN NUMERO CASUALE MO DI ISBN
    @PrePersist
    public void generaIsbn() {
        if (this.isbn == null) {
            SecureRandom random = new SecureRandom();
            long numeroCasuale = random.nextLong(900_000_000_000L);
            long ISBN = 100_000_000_000L + numeroCasuale;
            this.isbn = ISBN + "0";
        }
    }
    public String getIsbn() {
        return this.isbn;
    }

    public UUID getElemento_id() {
        return elemento_id;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public int getNumero_pagine() {
        return numero_pagine;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAnno_pubblicazione(int anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public void setNumero_pagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "elemento_id=" + elemento_id +
                ", isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
