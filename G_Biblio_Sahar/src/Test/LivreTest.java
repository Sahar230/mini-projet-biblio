package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import control.ReservationControl;
import entite.Livre;
import entite.Oeuvre;
import entite.Reservation;
import entite.Livre;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

class LivreTest {

    private Livre livre;

    @Before
    public void setUp() {
        livre = new Livre(1,  "Titre", "Auteur", "Categorie");
    }

    @Test
    public void testGetId() {
        assertEquals(1, livre.getId());
    }

    @Test
    public void testGetIsbn() {
        assertEquals("1234567890", livre.getId());
    }

    @Test
    public void testGetTitre() {
        assertEquals("Titre", livre.getTitre());
    }

    @Test
    public void testGetAuteur() {
        assertEquals("Auteur", livre.getAuteur());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Description", livre.getCategorie());
    }

    @Test
    public void testAddReservation() {
    	Oeuvre o=new Oeuvre();
        ReservationControl reservation = new ReservationControl();
        
        o.reserver(reservation);
        ArrayList<Reservation> reservations = o.getReservationsOeuvre();
        assertTrue(reservations.contains(reservation));
    }

    @Test
    public void testToString() {
        String expected = "Livre{id=1, titre=Titre, auteur=Auteur, description=Description, reservations=[]}";
        assertEquals(expected, livre.toString());
    }
}

