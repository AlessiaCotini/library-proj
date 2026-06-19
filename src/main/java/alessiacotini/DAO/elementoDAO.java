package alessiacotini.DAO;

import alessiacotini.entities.Elemento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class elementoDAO {

    //EM
    private final EntityManager entityManager;

    //COSTR
    public elementoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //METODO
    public void save(Elemento elemento){
        EntityTransaction transazione = this.entityManager.getTransaction();
        transazione.begin();
        this.entityManager.persist(elemento);
        transazione.commit();
        System.out.println("L'evento "+ elemento.getTitolo() + " è stato aggiunto al DATABASE");
    }
}
