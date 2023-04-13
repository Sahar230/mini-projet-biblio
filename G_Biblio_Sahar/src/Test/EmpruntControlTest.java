package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

import entite.Emprunt;
import entite.Exemplaire ;
import entite.Oeuvre;
import entite.Usager;
import Utility.BibalExceptions;
import control.EmpruntControl;

class EmpruntControlTest {

    @Test
    void testEmprunter() throws BibalExceptions {
        // Créer un usager et l'ajouter à la base de données
        Usager usager = new Usager();
        usager.setNom("Dupont");
        usager.setPrenom("Jean");
        usager.setTel("jean.dupont@test.com");
        usager.ajouter(usager);

        // Créer une oeuvre et l'ajouter à la base de données
        Oeuvre oeuvre = new Oeuvre();
        oeuvre.setTitre("L'Étranger");
        oeuvre.setAuteur("Albert Camus");
        oeuvre.ajouter(oeuvre);

        // Ajouter un exemplaire de l'oeuvre à la base de données
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setOeuvresExamplaire(oeuvre);
        exemplaire.ajouter(oeuvre, "");

        // Emprunter l'exemplaire par l'usager
        EmpruntControl.emprunter(usager.getId(), oeuvre.getTitre());

        // Vérifier que l'exemplaire est maintenant emprunté
        ArrayList<Exemplaire> exemplaires = new Exemplaire().findExemplaireDispo(oeuvre);
        assertEquals(1, exemplaires.size());
        assertEquals(exemplaire.getId(), exemplaires.get(0).getId());

        // Vérifier que l'usager a maintenant un emprunt en cours
        ArrayList<Emprunt> emprunts = new Emprunt().findEmprunts(oeuvre);
        assertEquals(1, emprunts.size());
        assertEquals(exemplaire.getId(), emprunts.get(0).getId());
    }

    @Test
    void testRendre() throws BibalExceptions {
        // Créer un usager et l'ajouter à la base de données
        Usager usager = new Usager();
        usager.setNom("Dupont");
        usager.setPrenom("Jean");
        usager.setTel("jean.dupont@test.com");
        usager.ajouter(usager);

        // Créer une oeuvre et l'ajouter à la base de données
        Oeuvre oeuvre = new Oeuvre();
        oeuvre.setTitre("L'Étranger");
        oeuvre.setAuteur("Albert Camus");
        oeuvre.ajouter(oeuvre);

        // Ajouter un exemplaire de l'oeuvre à la base de données
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setOeuvresExamplaire(oeuvre);
        exemplaire.ajouter(oeuvre,null);

        // Emprunter l'exemplaire par l'usager
        EmpruntControl.emprunter(usager.getId(), oeuvre.getTitre());

        // Rendre l'exemplaire par l'usager
        Emprunt emprunt = new Emprunt().find(usager, exemplaire.getId(), oeuvre);
        EmpruntControl.rendre(emprunt);

        // Vérifier que l'exemplaire est maintenant disponible
        ArrayList<Exemplaire> exemplaires = new Exemplaire().findExemplaireDispo(oeuvre);
        assertEquals(1, exemplaires.size());
    }}
