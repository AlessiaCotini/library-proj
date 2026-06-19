package alessiacotini.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "prestiti_in_corso")
public class Prestito {

    //ATTRIBUTI

    @Id
    @Column(name= "prestito_id")
    @GeneratedValue
    private UUID prestito_id;

    //MOLTI PRESTITI POSSONO ESSERE ADDOCIATI ALL'ID DI UN UTENTE

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    //MOLTI ELEMENTI POSSONO ESSERE ASSOCIATI AD UN PRESTITO
    //MA NON E' RICHIESTO QUINDI MANY PRESTITI POSSONO ESSERE ASSOCIATI TO ONE LIBRO/RIVISTA
    //CON LA PREROGATIVA CHE CI SIANO N LIBRI/RIVISTE DELLO STESSO TIPO ALL INTERNO DELLA LIBRERIA

    @ManyToOne
    @JoinColumn(name="elemento_id", nullable = false)
    private Elemento elemento;

    //COSTRUTTORI

    protected Prestito(){}
    public Prestito(Utente utente, Elemento elemento){
        this.utente= utente;
        this.elemento = elemento;
    }

    //GETTER E SETTER


    public Utente getUtente() {
        return utente;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElementi(Elemento elemento) {
        this.elemento = elemento;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
