package alessiacotini.DAO;

import alessiacotini.entities.Elemento;
import alessiacotini.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class utenteDAO {

    //EM
    private final EntityManager entityManager;

    //COSTR
    public utenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //METODO
    public void save(Utente utente){
        EntityTransaction transazione = this.entityManager.getTransaction();
        transazione.begin();
        this.entityManager.persist(utente);
        transazione.commit();
        System.out.println("L'utente "+ utente.getNome_utente() + " "+ utente.getCognome_utente()+
                " è stato aggiunto al database");
    }
}