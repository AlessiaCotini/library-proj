package alessiacotini.DAO;

import alessiacotini.entities.Elemento;
import alessiacotini.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import alessiacotini.exception.NoResultException;

import java.util.List;

public class ElementoDAO {
    private final EntityManager entityManager;

    //COSTRUTTORE
    public ElementoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // SALVO L'ELEMENTO
    public void save(Elemento elemento){
        EntityTransaction transazione = this.entityManager.getTransaction();
        try {
            transazione.begin();
            this.entityManager.persist(elemento);
            transazione.commit();
            System.out.println("L'evento "+ elemento.getTitolo() + " è stato aggiunto al DATABASE");
        } catch (Exception e) {
            if (transazione.isActive()) transazione.rollback();
            throw new RuntimeException("Errore durante il salvataggio: " + e.getMessage());
        }
    }

    // RICERCO L ELEMENTO TRAMITE ISBN
    public Elemento getByISBN(String isbn) {
        try {
            return this.entityManager.createQuery(
                            "SELECT e FROM Elemento e WHERE e.isbn = :param", Elemento.class)
                    .setParameter("param", isbn)
                    .getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            throw new NoResultException("ISBN ricercato non disponibile in archivio");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    //RICERCO E CANCELLO UTILIZZANDO IL METODO SOPRA
    public void deleteByISBN(String isbn) {
        Elemento elementoDalDB = this.getByISBN(isbn);
        EntityTransaction transazione = this.entityManager.getTransaction();
        try {
            transazione.begin();
            this.entityManager.remove(elementoDalDB);
            transazione.commit();
            System.out.println("L'elemento '" + elementoDalDB.getTitolo() + "' è stato eliminato dal DATABASE");
        } catch (Exception e) {
            if (transazione.isActive()) transazione.rollback();
            throw new RuntimeException("Errore durante l'eliminazione dell'elemento, " + e.getMessage());
        }
    }

    // RICERCO L ELEMENTO TRAMITE ANNO
    public List<Elemento> getByYear(int anno) {
        try {
            List<Elemento> elementi = this.entityManager.createQuery(
                            "SELECT e FROM Elemento e WHERE e.anno_pubblicazione = :param", Elemento.class)
                    .setParameter("param", anno)
                    .getResultList();

            if (elementi.isEmpty()) {
                throw new NoResultException("Nulla di disponibile in archivio per l'anno ricercato!");
            }
            return elementi;
        } catch (NoResultException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Errore nella ricerca per anno: " + e.getMessage());
        }
    }

    // RICERCO L ELEMENTO TRAMITE AUTORE
    public List<Libro> getByAuthor(String nome_autore) {
        try {
            List<Libro> libri = this.entityManager.createQuery(
                            "SELECT lib FROM Libro lib WHERE lib.autore = :param", Libro.class)
                    .setParameter("param", nome_autore)
                    .getResultList();
            if (libri.isEmpty()) {
                throw new NoResultException("L'autore ricercato non ha prodotto risultati");
            }
            return libri;
        } catch (NoResultException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Errore nella ricerca per autore: " + e.getMessage());
        }
    }

    // RICERCO PER TITOLO O PARTE DI ESSO
    public List<Libro> getByTitle(String titolo){
        try{
            List<Libro> libriTrovati = this.entityManager.createQuery(
                            "SELECT lib FROM Libro lib WHERE lib.titolo LIKE :param", Libro.class)
                    .setParameter("param", "%" + titolo + "%")
                    .getResultList();
            if (libriTrovati.isEmpty()) {
                throw new NoResultException("La ricerca per il titolo " + titolo + " non ha prodotto risultati.");
            }
            return libriTrovati;
        } catch (NoResultException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Errore durante la ricerca nel database: " + e.getMessage());
        }
    }
}
