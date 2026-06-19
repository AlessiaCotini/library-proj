package alessiacotini.entities;

import jakarta.persistence.*;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "utenti")
public class Utente {

    //ATTRIBUTI

    @Id
    @Column (name= "utente_id")
    @GeneratedValue
    private UUID utente_id;

    @Column (name = "nome_utente")
    private String nome_utente;

    @Column(name = "cognome_utente")
    private String cognome_utente;

    @Column(name = "data_di_nascita")
    private LocalDate data_di_nascita;

    @Column(name = "numero_di_tessera")
    private String numero_di_tessera;

    //COSTRUTTORI

    protected Utente(){}
    public Utente (String nome_utente, String cognome_utente, LocalDate data_di_nascita){
        this.nome_utente = nome_utente;
        this.cognome_utente = cognome_utente;
        this.data_di_nascita = data_di_nascita;
    }

    //GETTER E SETTER

    public String getNumero_di_tessera() {
        SecureRandom random = new SecureRandom();
        long numerotessera = 100_000_000_000L + (Math.abs(random.nextLong()) % 900_000_000_000L);
        return numerotessera + "T";
        //TUTTE LE TESSERE FINISCONO CON LA LETTERA T DOPO 12 N CASUALI
    }

    public String getNome_utente() {
        return nome_utente;
    }

    public String getCognome_utente() {
        return cognome_utente;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public void setNome_utente(String nome_utente) {
        this.nome_utente = nome_utente;
    }

    public void setCognome_utente(String cognome_utente) {
        this.cognome_utente = cognome_utente;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "utente_id=" + utente_id +
                ", nome_utente='" + nome_utente + '\'' +
                ", cognome_utente='" + cognome_utente + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", numero_di_tessera='" + numero_di_tessera + '\'' +
                '}';
    }
}
