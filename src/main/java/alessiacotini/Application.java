package alessiacotini;

import alessiacotini.DAO.ElementoDAO;
import alessiacotini.DAO.PrestitoDAO;
import alessiacotini.DAO.UtenteDAO;
import alessiacotini.entities.Libro;
import alessiacotini.entities.Prestito;
import alessiacotini.entities.Rivista;
import alessiacotini.entities.Utente;
import alessiacotini.enums.GenereLibro;
import alessiacotini.enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;


public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library-proj-pu");
    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //CREO SPAZIO DB

        ElementoDAO elementoDAO = new ElementoDAO(entityManager);
        PrestitoDAO prestitoDAO = new PrestitoDAO(entityManager);
        UtenteDAO utenteDAO = new UtenteDAO(entityManager);

        //UTENTI
        Utente robertsmith = new Utente("Robert", "Smith", LocalDate.of(1959,04,21));
        Utente flea = new Utente("Michael Peter", "Balzary", LocalDate.of(1962,10,16));
        Utente travis = new Utente("Travis", "Barker", LocalDate.of(1975,11,14));
        Utente billie = new Utente("Billie Joe", "Armstrong", LocalDate.of(1972,02,17));
        Utente mgk = new Utente("Colson", "Baker", LocalDate.of(1990,04,22));
        Utente kurt = new Utente("Kurt", "Cobain", LocalDate.of(1967, 2, 20));
        Utente dave = new Utente("Dave", "Grohl", LocalDate.of(1969, 1, 14));
        Utente eddie = new Utente("Eddie", "Vedder", LocalDate.of(1964, 12, 23));
        Utente chester = new Utente("Chester", "Bennington", LocalDate.of(1976, 3, 20));
        Utente hayley = new Utente("Hayley", "Williams", LocalDate.of(1988, 12, 27));
        Utente gerard = new Utente("Gerard", "Way", LocalDate.of(1977, 4, 9));
        Utente amy = new Utente("Amy", "Lee", LocalDate.of(1981, 12, 13));
        Utente deryck = new Utente("Deryck", "Whibley", LocalDate.of(1980, 3, 21));
        Utente trent = new Utente("Trent", "Reznor", LocalDate.of(1965, 5, 17));
        Utente lars = new Utente("Lars", "Ulrich", LocalDate.of(1963, 12, 26));

        //SALVO

        //utenteDAO.save(robertsmith);
        //utenteDAO.save(flea);utenteDAO.save(travis);utenteDAO.save(billie);utenteDAO.save(mgk);utenteDAO.save(kurt);utenteDAO.save(dave);utenteDAO.save(eddie);
        //utenteDAO.save(chester);utenteDAO.save(hayley);utenteDAO.save(gerard);utenteDAO.save(amy);utenteDAO.save(deryck);utenteDAO.save(trent);utenteDAO.save(lars);

        //ELEMENTI

        Libro lasolitudinedeinumeriprimi = new Libro("La solitudine dei numeri primi",2008, 256, "Paolo Giordano", GenereLibro.CRESCITA_PERSONALE);
        Libro unonessunocentomila = new Libro("Uno, nessuno e centomila", 1926, 220, "Luigi Pirandello", GenereLibro.CLASSICI);
        Libro baronerampante = new Libro("Il barone rampante", 1957, 288, "Italo Calvino", GenereLibro.AVVENTURA);
        Libro lafabbricadipile = new Libro("La fabbrica di cioccolato", 1964, 180, "Roald Dahl", GenereLibro.FANTASY);
        Libro ilprofumo = new Libro("Il Profumo", 1985, 260, "Patrick Süskind", GenereLibro.GIALLO_THRILLER);
        Libro dioesiste = new Libro("Dio di illusioni", 1992, 620, "Donna Tartt", GenereLibro.BIOGRAFIA);
        Libro totalrecall = new Libro("Total Recall - La mia storia incredibile", 2012, 650, "Arnold Schwarzenegger", GenereLibro.AVVENTURA);
        Libro born2run = new Libro("Born to Run", 2016, 510, "Bruce Springsteen", GenereLibro.HORROR);
        Libro life = new Libro("Life", 2010, 540, "Keith Richards", GenereLibro.CONTEMPORANEO);
        Libro cacciatorediaquiloni = new Libro("Il cacciatore di aquiloni", 2003, 390, "Khaled Hosseini", GenereLibro.HORROR);
        Libro ombravento = new Libro("L'ombra del vento", 2001, 460, "Carlos Ruiz Zafón", GenereLibro.GIALLO_THRILLER);
        Libro insurgent = new Libro("Divergent", 2011, 480, "Veronica Roth", GenereLibro.FANTASY);
        Libro memento = new Libro("Cecità", 1995, 300, "José Saramago", GenereLibro.FANTASY);
        Libro colpadellestelle = new Libro("Colpa delle stelle", 2012, 320, "John Green", GenereLibro.ROMANCE);
        Libro fahrenheit = new Libro("Fahrenheit 451", 1953, 180, "Ray Bradbury", GenereLibro.CRESCITA_PERSONALE);

        Rivista vogue = new Rivista("Vogue", 1892, 160, Periodicita.MENSILE);
        Rivista rollingstone = new Rivista("Rolling Stone", 1967, 120, Periodicita.MENSILE);
        Rivista nationalgeographic = new Rivista("National Geographic", 1888, 140, Periodicita.MENSILE);
        Rivista time = new Rivista("Time Magazine", 1923, 80, Periodicita.SETTIMANALE);
        Rivista focus = new Rivista("Focus", 1992, 110, Periodicita.MENSILE);
        Rivista gq = new Rivista("GQ", 1931, 150, Periodicita.MENSILE);
        Rivista Internazionale = new Rivista("Internazionale", 1993, 90, Periodicita.SETTIMANALE);
        Rivista wired = new Rivista("Wired", 1993, 130, Periodicita.MENSILE);
        Rivista vanityfair = new Rivista("Vanity Fair", 1913, 170, Periodicita.SETTIMANALE);
        Rivista theeconomist = new Rivista("The Economist", 1843, 75, Periodicita.SETTIMANALE);
        Rivista scientificamerican = new Rivista("Scientific American", 1845, 100, Periodicita.MENSILE);
        Rivista forbes = new Rivista("Forbes", 1917, 115, Periodicita.MENSILE);
        Rivista elle = new Rivista("Elle", 1945, 180, Periodicita.MENSILE);
        Rivista edge = new Rivista("Edge", 1993, 112, Periodicita.MENSILE);
        Rivista lespresso = new Rivista("L'Espresso", 1955, 85, Periodicita.SETTIMANALE);

        //SALVO

        //elementoDAO.save(lasolitudinedeinumeriprimi);
        //elementoDAO.save(unonessunocentomila);elementoDAO.save(lafabbricadipile);elementoDAO.save(ilprofumo);elementoDAO.save(dioesiste);elementoDAO.save(insurgent);
        //elementoDAO.save(totalrecall);elementoDAO.save(life);elementoDAO.save(cacciatorediaquiloni);elementoDAO.save(ombravento);elementoDAO.save(baronerampante);
        //elementoDAO.save(born2run);elementoDAO.save(time);elementoDAO.save(theeconomist);elementoDAO.save(scientificamerican);elementoDAO.save(Internazionale);
        //elementoDAO.save(nationalgeographic);elementoDAO.save(focus);elementoDAO.save(colpadellestelle);elementoDAO.save(forbes);elementoDAO.save(gq);
        //elementoDAO.save(rollingstone);elementoDAO.save(wired);elementoDAO.save(memento);elementoDAO.save(elle);elementoDAO.save(lespresso);
        //elementoDAO.save(vanityfair);elementoDAO.save(vogue);elementoDAO.save(fahrenheit);elementoDAO.save(edge);

        //PRESTITI

        Prestito preuno = new Prestito(robertsmith,vogue);
        Prestito predue = new Prestito(flea, rollingstone);
        Prestito pretre = new Prestito(travis, fahrenheit);
        Prestito prequattro = new Prestito(billie, ombravento);
        Prestito precinque = new Prestito(mgk, wired);


        //SALVO

        //prestitoDAO.save(preuno);prestitoDAO.save(predue);prestitoDAO.save(pretre);prestitoDAO.save(prequattro);prestitoDAO.save(precinque);


        //TEST DEI METODI

        //System.out.println("METODO UNO");

        //try {
        //System.out.println(elementoDAO.getByISBN(""));
        //} catch (Exception e) {
        //    System.err.println("Errore ISBN: " + e.getMessage());
        //}

        //System.out.println("METODO DUE");

        //try {
        //    elementoDAO.deleteByISBN("");
        //} catch (Exception e) {
        //System.err.println("Errore ISBN: " + e.getMessage());
        //}


        //System.out.println("METODO TRE");
        //try {
        //    System.out.println(elementoDAO.getByYear());
        //} catch (Exception e) {
        //    System.err.println("Errore Anno : " + e.getMessage());
        //}

        //System.out.println("METODO QUATTRO");

        //try {
        //    System.out.println(elementoDAO.getByAuthor(""));
        //} catch (Exception e) {
        //    System.err.println("ERRORE AUTORE: " + e.getMessage());
        //}

        //System.out.println("METODO CINQUE");

        //try {
        //    System.out.println(elementoDAO.getByTitle(""));
        //} catch (Exception e) {
        //    System.err.println("ERRORE TITOLO : " + e.getMessage());
        //}

        //System.out.println("METODO SEI");

        //try {
        //    System.out.println(prestitoDAO.getPrestitiScadutiNonRestituiti());
        //} catch (Exception e) {
        //    System.err.println("ERRORE PRESTITI : " + e.getMessage());
        //}

        //System.out.println("METODO SETTE");

        //try {
        //System.out.println(prestitoDAO.getPrestitiInCorso(""));
        //} catch (Exception e) {
        //System.err.println("ERRORE PRESTITI : " + e.getMessage());
        //}

        System.out.println("Hello");

    }
}
