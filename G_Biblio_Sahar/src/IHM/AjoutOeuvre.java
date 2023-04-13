package IHM;

import Utility.BibalExceptions;
import Utility.DBConnection;
import Utility.ModelTableau;
import control.OeuvreControl;
import entite.Livre;
import entite.Magazine;
import entite.Oeuvre;

import static Utility.Utility.closeStatementResultSet;
import static Utility.Utility.initialiseRequetePreparee;
import static Utility.Utility.showMessageSucces;

import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Diallo & Janati
 */
public class AjoutOeuvre extends javax.swing.JDialog {

    public AjoutOeuvre(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIdentifiant();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bibliotheque_icone.png")));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panAjoutOeuvre = new javax.swing.JPanel();
        panAjoutBas = new javax.swing.JPanel();
        typeOeuvreLabel = new javax.swing.JLabel();
        identifiantLabel = new javax.swing.JLabel();
        auteurField = new javax.swing.JFormattedTextField();
        identifiantField = new javax.swing.JFormattedTextField();
        auteurLabel = new javax.swing.JLabel();
        titreLabel = new javax.swing.JLabel();
        titreField = new javax.swing.JFormattedTextField();
        typeOeuvreCombo = new javax.swing.JComboBox();
        categorieLabel = new javax.swing.JLabel();
        categorieField = new javax.swing.JFormattedTextField();
        ajouterBouton = new javax.swing.JButton();
        ajouterBouton.setForeground(new Color(255, 255, 255));
        ajouterBouton.setBackground(new Color(115, 191, 189));
        annulerBouton = new javax.swing.JButton();
        annulerBouton.setForeground(new Color(255, 255, 255));
        annulerBouton.setBackground(new Color(115, 191, 189));
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajout Oeuvre");

        jPanel1.setBackground(new Color(92, 186, 186));
        jPanel1.setName("Gestion personnel"); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1162, 608));
        jPanel1.setRequestFocusEnabled(false);

        panAjoutOeuvre.setBackground(new Color(92, 186, 186));

        panAjoutBas.setBackground(new Color(92, 186, 186));
        panAjoutBas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        typeOeuvreLabel.setFont(new Font("Century Gothic", Font.BOLD, 18)); // NOI18N
        typeOeuvreLabel.setForeground(new Color(255, 255, 255));
        typeOeuvreLabel.setText("Type de livre");

        identifiantLabel.setFont(new Font("Century Gothic", Font.BOLD, 18)); // NOI18N
        identifiantLabel.setForeground(new Color(255, 255, 255));
        identifiantLabel.setText("ID-Livre");

        auteurField.setPreferredSize(new java.awt.Dimension(123, 26));

        identifiantField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        identifiantField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        identifiantField.setToolTipText("");
        identifiantField.setEnabled(false);
        identifiantField.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        identifiantField.setPreferredSize(new java.awt.Dimension(123, 26));

        auteurLabel.setFont(new Font("Century Gothic", Font.BOLD, 18)); // NOI18N
        auteurLabel.setForeground(new Color(255, 255, 255));
        auteurLabel.setText("Auteur");

        titreLabel.setFont(new Font("Century Gothic", Font.BOLD, 18)); // NOI18N
        titreLabel.setForeground(new Color(255, 255, 255));
        titreLabel.setText("Titre");

        titreField.setPreferredSize(new java.awt.Dimension(123, 26));

        typeOeuvreCombo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        typeOeuvreCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Livre", "Magazine" }));
        typeOeuvreCombo.setPreferredSize(new java.awt.Dimension(123, 26));

        categorieLabel.setFont(new Font("Century Gothic", Font.BOLD, 18)); // NOI18N
        categorieLabel.setForeground(new Color(255, 255, 255));
        categorieLabel.setText("Catégorie");

        categorieField.setPreferredSize(new java.awt.Dimension(123, 26));

        ajouterBouton.setFont(new Font("Century Gothic", Font.BOLD, 16)); // NOI18N
        ajouterBouton.setText("Ajouter");
        ajouterBouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter(evt);
            }
        });

        annulerBouton.setFont(new Font("Century Gothic", Font.BOLD, 16)); // NOI18N
        annulerBouton.setText("Annuler");
        annulerBouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerBoutonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAjoutBasLayout = new javax.swing.GroupLayout(panAjoutBas);
        panAjoutBas.setLayout(panAjoutBasLayout);
        panAjoutBasLayout.setHorizontalGroup(
            panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAjoutBasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAjoutBasLayout.createSequentialGroup()
                        .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(auteurLabel)
                            .addComponent(titreLabel)
                            .addComponent(identifiantLabel)
                            .addComponent(typeOeuvreLabel)
                            .addComponent(categorieLabel))
                        .addGap(62, 62, 62)
                        .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(typeOeuvreCombo, 0, 190, Short.MAX_VALUE)
                            .addComponent(identifiantField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titreField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(auteurField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categorieField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAjoutBasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(annulerBouton)
                        .addGap(34, 34, 34)
                        .addComponent(ajouterBouton)))
                .addContainerGap())
        );
        panAjoutBasLayout.setVerticalGroup(
            panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAjoutBasLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeOeuvreLabel)
                    .addComponent(typeOeuvreCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(identifiantLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(identifiantField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titreLabel)
                    .addComponent(titreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(auteurLabel)
                    .addComponent(auteurField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categorieLabel)
                    .addComponent(categorieField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(panAjoutBasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouterBouton)
                    .addComponent(annulerBouton))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout panAjoutOeuvreLayout = new javax.swing.GroupLayout(panAjoutOeuvre);
        panAjoutOeuvre.setLayout(panAjoutOeuvreLayout);
        panAjoutOeuvreLayout.setHorizontalGroup(
            panAjoutOeuvreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAjoutOeuvreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panAjoutBas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panAjoutOeuvreLayout.setVerticalGroup(
            panAjoutOeuvreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAjoutOeuvreLayout.createSequentialGroup()
                .addComponent(panAjoutBas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        titleLabel.setFont(new Font("Century Gothic", Font.BOLD, 36)); // NOI18N
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setText("Ajout Livre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panAjoutOeuvre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(2, 2, 2)
                .addComponent(panAjoutOeuvre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajouter(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter

        try {
            Oeuvre oeuvre = getOeuvreInfos();
            OeuvreControl.ajouter(oeuvre);
            ((ModelTableau) GestionOeuvresExemplaires.tableListeOeuvre.getModel())
                    .addRow(
                            new Object[]{oeuvre.getId(), oeuvre.getTitre(), oeuvre.getAuteur(),
                                oeuvre.getCategorie(), oeuvre.getClass().getSimpleName(), 0, 0});
            setIdentifiant();
            clearField();
            showMessageSucces("Oeuvre ajoutée avec succès");
        } catch (BibalExceptions e) {
            System.out.println("IHM.AjoutOeuvre.ajouterBoutonActionPerformed()");
        }
    }//GEN-LAST:event_ajouter

    private Oeuvre getOeuvreInfos() {
        int identifiant = Integer.parseInt(identifiantField.getText());
        String titre = titreField.getText();
        String auteur = auteurField.getText();
        String categorie = categorieField.getText();
        String typeOeuvre = typeOeuvreCombo.getSelectedItem().toString();

        if (typeOeuvre.equals(Magazine.class.getSimpleName())) {
            return new Magazine(identifiant, titre, auteur, categorie);
        }
        return new Livre(identifiant, titre, auteur, categorie);
    }
    private void annulerBoutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerBoutonActionPerformed
        this.dispose();
    }//GEN-LAST:event_annulerBoutonActionPerformed

    private void clearField() {
        titreField.setText("");
        auteurField.setText("");
        categorieField.setText("");
    }

    private void setIdentifiant() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            final String SQL_SELECT_ID = "SELECT id FROM oeuvre ORDER BY id DESC LIMIT 1";
            preparedStatement = initialiseRequetePreparee(DBConnection.getConnection(),
                    SQL_SELECT_ID, new Object[0]);
            resultSet = preparedStatement.executeQuery();
            int identifiant = 1;
            if (resultSet.first()) {
                identifiant = resultSet.getInt("id");
            }
            identifiantField.setText((identifiant + 1) + "");
        } catch (SQLException | BibalExceptions e) {
            JOptionPane.showMessageDialog(null, "Erreurs d'accès à la base de données",
                    "Erreurs", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeStatementResultSet(preparedStatement, resultSet);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterBouton;
    private javax.swing.JButton annulerBouton;
    private javax.swing.JFormattedTextField auteurField;
    private javax.swing.JLabel auteurLabel;
    private javax.swing.JFormattedTextField categorieField;
    private javax.swing.JLabel categorieLabel;
    private javax.swing.JFormattedTextField identifiantField;
    private javax.swing.JLabel identifiantLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panAjoutBas;
    private javax.swing.JPanel panAjoutOeuvre;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JFormattedTextField titreField;
    private javax.swing.JLabel titreLabel;
    private javax.swing.JComboBox typeOeuvreCombo;
    private javax.swing.JLabel typeOeuvreLabel;
    // End of variables declaration//GEN-END:variables
}
