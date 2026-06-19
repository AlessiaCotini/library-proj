package alessiacotini.DAO;

import alessiacotini.entities.Elemento;
import alessiacotini.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class prestitoDAO {
    //EM
    private final EntityManager entityManager;

    //COSTRUTTORE
    public prestitoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //METODO
    public void save(Prestito prestito){
        EntityTransaction transazione = this.entityManager.getTransaction();
        transazione.begin();
        this.entityManager.persist(prestito);
        transazione.commit();
        System.out.println("L'utente "+prestito.getUtente()+" ha aggiunto "+ prestito.getPrestito_id() + " ai suoi prestiti.");
    }
}