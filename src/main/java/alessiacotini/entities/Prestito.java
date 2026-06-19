package alessiacotini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
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

    @Column(name="data_inizio")
    private LocalDate data_inizio;

    @Column(name="data_restituzione_prevista")
    private LocalDate data_restituzione_prevista;

    @Column(name="data_restituzione_effettiva")
    private LocalDate data_restituzione_effettiva;

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
    public Prestito(Utente utente, Elemento elemento,LocalDate data_inizio,LocalDate data_restituzione_prevista,LocalDate data_restituzione_effettiva ){
        this.utente= utente;
        this.elemento = elemento;
        this.data_inizio = LocalDate.now();
        this.data_restituzione_prevista = LocalDate.now().plusDays(30);
        this.data_restituzione_effettiva = data_restituzione_effettiva;
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

    public LocalDate getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(LocalDate data_inizio) {
        this.data_inizio = data_inizio;
    }

    public LocalDate getData_restituzione_prevista() {
        return data_restituzione_prevista;
    }

    public void setData_restituzione_prevista(LocalDate data_restituzione_prevista) {
        this.data_restituzione_prevista = data_restituzione_prevista;
    }

    public LocalDate getData_restituzione_effettiva() {
        return data_restituzione_effettiva;
    }

    public void setData_restituzione_effettiva(LocalDate data_restituzione_effettiva) {
        this.data_restituzione_effettiva = data_restituzione_effettiva;
    }
}
