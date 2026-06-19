package alessiacotini.DAO;

import alessiacotini.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import alessiacotini.exception.NoResultException;

import java.time.LocalDate;
import java.util.List;

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

    //RICERCA ELEMENTI ATTUALMENTE IN PRESTITO DATO UN CODICE UTENTE
    //PER ESSERE IN PRESTITO NON DEVE ESSERE STATO RESTITUITO

    public List<Prestito> getPrestitiInCorso(String codice_tessera) {
        try {
            List<Prestito> prestitiTrovati = this.entityManager.createQuery(
                            "SELECT pre FROM Prestito pre WHERE pre.utente.numero_di_tessera = :param AND pre.data_restituzione_effettiva IS NULL",
                            Prestito.class)
                    .setParameter("param", codice_tessera)
                    .getResultList();
            if (prestitiTrovati.isEmpty()) {
                throw new NoResultException("Nessun prestito in corso trovato per la tessera: " + codice_tessera);
            }
            return prestitiTrovati;
        } catch (NoResultException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Errore durante la ricerca dei prestiti: " + e.getMessage());
        }
    }

    //RICERCA DI PRESTITI SCADUTI O NON RESTITUITI
    public List<Prestito> getPrestitiScadutiNonRestituiti() {
        try {
            List<Prestito> prestitiTrovati = this.entityManager.createQuery(
                            "SELECT pre FROM Prestito pre WHERE pre.data_restituzione_effettiva IS NULL AND pre.data_restituzione_prevista < :param",
                            Prestito.class)
                    .setParameter("param", LocalDate.now())
                    .getResultList();
            if (prestitiTrovati.isEmpty()) {
                throw new NoResultException("La ricerca non ha prodotto risultati");
            }
            return prestitiTrovati;
        } catch (NoResultException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Errore durante la ricerca dei prestiti: " + e.getMessage());
        }
    }

    }


