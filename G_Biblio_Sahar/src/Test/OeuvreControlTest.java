import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import control.OeuvreControl;
import entite.Oeuvre;
public class OeuvreControlTest {
    private OeuvreControl OeuvreControl;

    @Before
    public void setUp() throws SQLException {
      //  db.init();
       OeuvreControl = new OeuvreControl();
    }

//    @After
//    public void tearDown() throws SQLException {
//        db.close();
//    }

    @Test
    public void testGetAll() {
        ArrayList<Oeuvre> Oeuvre = OeuvreControl.getListOeuvres();
        assertNotNull(Oeuvre);
        assertTrue(Oeuvre.size() > 0);
    }

    @Test
    public void testAdd() {
        int id=12;
        String titre = "Test Livre";
        String auteur = "Test Auteur";
        String categorie = "Test Description";
        OeuvreControl.ajouter(id, titre, auteur, categorie);

        ArrayList<Oeuvre> livres = OeuvreControl.getListOeuvres();
        Oeuvre Oeuvre = Oeuvre.get(Oeuvre.size() - 1);

        assertEquals(id, lastLivre.getId());
        assertEquals(titre, lastLivre.getTitre());
        assertEquals(auteur, lastLivre.getAuteur());
        assertEquals(categorie, Oeuvre.getCategorie());
    }

    @Test
    public void testSupprimer() {
        ArrayList<Oeuvre> livres = OeuvreControl.getListOeuvres();
        int countBefore = livres.size();

        Livre livre = livres.get(0);
        int id = livre.getId();
        OeuvreControl.Supprimer(id);

        livres = OeuvreControl.getListOeuvres();
        int countAfter = livres.size();

        assertEquals(countBefore - 1, countAfter);
        assertNull(OeuvreControl.getById(id));
    }

    @Test
    public void testUpdate() {
        ArrayList<Oeuvre> Oeuvre = OeuvreControl.getListOeuvres();
        Oeuvre li = Oeuvre.get(0);

      
        String newTitre = "New Titre";
        String newAuteur = "New Auteur";
        String newCategorie = "New Categorie";

        OeuvreControl.update(li.getId(),  newTitre, newAuteur, newCategorie);
        Oeuvre updatedo = OeuvreControl.getById(Oeuvre.getId());

       
        assertEquals(newTitre, updatedo.getTitre());
        assertEquals(newAuteur, updatedo.getAuteur());
        assertEquals(newCategorie, updatedo.getCategorie());
    }

    @Test
    public void testSearch() {
        ArrayList<Oeuvre> o = OeuvreControl.findByTitre("test");
        assertNotNull(o);
        assertTrue(!o.isEmpty());
    }

    @Test
    public void testGetById() {
        ArrayList<Oeuvre> o = OeuvreControl.getListOeuvres();
        Oeuvre li = o.get(0);

        assertNotNull(OeuvreControl.getById(o.getId()));
        assertNull(OeuvreControl.getById(-1));
    }