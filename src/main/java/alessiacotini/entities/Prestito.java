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
    @JoinColumn(name = "utente_id")
    private Utente utente;

    //MOLTI ELEMENTI POSSONO ESSERE ASSOCIATI AD UN PRESTITO

    @OneToMany
    @JoinColumn(name="prestito_id")
    private List<Elemento> elementi;

    //COSTRUTTORI

    protected Prestito(){}
    public Prestito(Utente utente, List<Elemento> elementi){
        this.utente= utente;
        this.elementi = elementi;
    }

    //GETTER E SETTER


    public Utente getUtente() {
        return utente;
    }

    public List<Elemento> getElementi() {
        return elementi;
    }

    public void setElementi(List<Elemento> elementi) {
        this.elementi = elementi;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
