/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kivaryhma.mvc;

import kivaryhma.mvc.Controller;
import kivaryhma.entries.Entry;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import kivaryhma.entries.Article;
import kivaryhma.entries.Book;
import kivaryhma.entries.Inproceedings;
import kivaryhma.entries.Masterthesis;
import kivaryhma.entries.Phdthesis;
import kivaryhma.entries.Proceedings;

/**
 *
 * @author toffe
 */
public class Form extends javax.swing.JFrame implements ActionListener {

    private Controller controller;
    private JLabel[] labels = new JLabel[10];
    private JTextField[] articleFields = new JTextField[10];
    private JTextField[] bookFields = new JTextField[11];
    private JTextField[] inproceedingsFields = new JTextField[14];
    private JTextField[] phdthesisFields = new JTextField[9];
    private JTextField[] masterthesisFields = new JTextField[9];
    private JTextField[] proceedingsFields = new JTextField[11];
    private JFileChooser fileChooser = new JFileChooser();
    private int beingEdited = -1;

    /**
     * Creates new form Frame2
     */
    public Form() {
        //Luodaan komponentit
        initComponents();

        //Actionlisteneri submit napille
        submitArticle.addActionListener(this);

        //Kaikki tekstikentät fields-listoihin helpompaa käsittelyä varten
        gatherArticleTextFields();
        gatherBookTextFields();
        gatherInproceedingsTextFields();
        gatherPhdthesisTextFields();
        gatherMasterthesisTextFields();
        gatherProceedingsTextFields();

        //Poistetaan placeholderit jotka tuli netbeansin lomakkeenluojan mukana
        String[] temp = new String[0];
        jList1.setListData(temp);
    }

    public void submitArticleForm() {
        //Lähetetään lista controllerille
        checkIfBeingEdited();
        controller.sendArticleFormParameters(gatherValues(articleFields));
        updateList();
    }

    public void submitBookForm() {
        //Lähetetään kontrollerimetodille tavarat bookformista
        checkIfBeingEdited();
        controller.sendBookFormParameters(gatherValues(bookFields));
        updateList();
    }

    public void submitInproceedingsForm() {
        //lähetetään kontrollerimetodille tavarat inproceedings formista
        checkIfBeingEdited();
        controller.sendInproceedingsFormParameters(gatherValues(inproceedingsFields));
        updateList();
    }

    public void submitPhdthesisForm() {
        checkIfBeingEdited();
        controller.sendPhdthesisFormParameters(gatherValues(phdthesisFields));
        updateList();
    }

    public void submitMasterthesisForm() {
        checkIfBeingEdited();
        controller.sendMasterthesisFormParameters(gatherValues(masterthesisFields));
        updateList();
    }

    public void submitProceedingsForm() {
        checkIfBeingEdited();
        controller.sendProceedingsFormParameters(gatherValues(proceedingsFields));
        updateList();
    }

    public void checkIfBeingEdited() {
        //poistetaan muokkauksen yhteydessä se vanha versio
        if (beingEdited != -1) {
            int[] toBeRemoved = {beingEdited};
            controller.removeReferences(toBeRemoved);
            beingEdited = -1;
        }
    }

    public void saveToFile() {
        this.fileChooser.setCurrentDirectory(new File("."));
        int retrieval = this.fileChooser.showSaveDialog(rootPane);
        if (retrieval == JFileChooser.APPROVE_OPTION) {
            try {
                controller.addSelectedReferences(jList1.getSelectedIndices());
                controller.saveToFile(fileChooser.getSelectedFile().getName());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(rootPane, "Jokin meni pieleen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    //Kerätään arvot tekstikentistä
    public String[] gatherValues(JTextField[] fields) {
        String[] values = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            values[i] = fields[i].getText();
        }
        return values;
    }

    //Päivitetään listanäkymä
    public void updateList() {
        ArrayList<String> data = new ArrayList<String>();
        for (Entry entry : controller.getEntries()) {
            data.add(entry.getAuthor() + " - " + entry.getYear() + " - " + entry.getTitle());
        }
        jList1.setListData(data.toArray());
    }

    public void registerController(Controller controller) {
        this.controller = controller;
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
        inproceedingsPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        articleAuthor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        articleTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        articleJournal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        articleYea = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        articleVolume = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        articleNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        articlePages = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        articleMonth = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        articleNote = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        articleKey = new javax.swing.JTextField();
        submitArticle = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        bookAuthor = new javax.swing.JTextField();
        bookTitle = new javax.swing.JTextField();
        bookPublisher = new javax.swing.JTextField();
        bookYear = new javax.swing.JTextField();
        bookVolume = new javax.swing.JTextField();
        bookSeries = new javax.swing.JTextField();
        bookAddress = new javax.swing.JTextField();
        bookEdition = new javax.swing.JTextField();
        bookMonth = new javax.swing.JTextField();
        bookNote = new javax.swing.JTextField();
        bookKey = new javax.swing.JTextField();
        bookSubmit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        inproceedingsAuthor = new javax.swing.JTextField();
        inproceedingsTitle = new javax.swing.JTextField();
        inproceedingsBooktitle = new javax.swing.JTextField();
        inproceedingsYear = new javax.swing.JTextField();
        inproceedingsEditor = new javax.swing.JTextField();
        inproceedingsVolume = new javax.swing.JTextField();
        inproceedingsSeries = new javax.swing.JTextField();
        inproceedingsPages = new javax.swing.JTextField();
        inproceedingsAddress = new javax.swing.JTextField();
        inproceedingsMonth = new javax.swing.JTextField();
        inproceedingsOrganization = new javax.swing.JTextField();
        inproceedingsPublisher = new javax.swing.JTextField();
        inproceedingsNote = new javax.swing.JTextField();
        inproceedingsKey = new javax.swing.JTextField();
        submitInproceedings = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        phdthesisAuthor = new javax.swing.JTextField();
        phdthesisTitle = new javax.swing.JTextField();
        phdthesisSchool = new javax.swing.JTextField();
        phdthesisYear = new javax.swing.JTextField();
        phdthesisType = new javax.swing.JTextField();
        phdthesisAddress = new javax.swing.JTextField();
        phdthesisMonth = new javax.swing.JTextField();
        phdthesisNote = new javax.swing.JTextField();
        submitPhdthesis = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        phdthesisKey = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        masterthesisAuthor = new javax.swing.JTextField();
        masterthesisTitle = new javax.swing.JTextField();
        masterthesisSchool = new javax.swing.JTextField();
        masterthesisYear = new javax.swing.JTextField();
        masterthesisType = new javax.swing.JTextField();
        masterthesisAddress = new javax.swing.JTextField();
        masterthesisMonth = new javax.swing.JTextField();
        masterthesisNote = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        masterthesisKey = new javax.swing.JTextField();
        submitMasterthesis = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        proceedingsPublisher = new javax.swing.JTextField();
        proceedingsMonth = new javax.swing.JTextField();
        proceedingsAddress = new javax.swing.JTextField();
        proceedingsSeries = new javax.swing.JTextField();
        proceedingsVolume = new javax.swing.JTextField();
        proceedingsEditor = new javax.swing.JTextField();
        proceedingsYear = new javax.swing.JTextField();
        proceedingsTitle = new javax.swing.JTextField();
        proceedingsOrganization = new javax.swing.JTextField();
        proceedingsNote = new javax.swing.JTextField();
        proceedingsKey = new javax.swing.JTextField();
        submitProceedings = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        virheViesti = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        searchBar = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        Edit = new javax.swing.JButton();
        readBiBTeX = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Author *");

        jLabel3.setText("Journal *");

        articleTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                articleTitleActionPerformed(evt);
            }
        });

        jLabel2.setText("Title *");

        jLabel4.setText("Year *");

        jLabel5.setText("Volume *");

        jLabel6.setText("Number");

        jLabel7.setText("Pages");

        jLabel8.setText("Month");

        jLabel9.setText("Note");

        jLabel10.setText("Key *");

        submitArticle.setText("Submit Article");
        submitArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitArticleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(articleJournal)
                            .addComponent(articleAuthor)
                            .addComponent(articleTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(articleNumber)
                            .addComponent(articleVolume)
                            .addComponent(articleYea, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(articleNote)
                            .addComponent(articlePages)
                            .addComponent(articleMonth)
                            .addComponent(articleKey))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(submitArticle)
                        .addGap(0, 150, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(articleAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(articleJournal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(articleTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(articleYea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(articleVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(articleNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(articlePages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(articleMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(articleNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(articleKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(30, 30, 30)
                .addComponent(submitArticle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inproceedingsPane.addTab("Article", jPanel2);

        jLabel11.setText("Author *");

        jLabel12.setText("Title *");

        jLabel13.setText("Publisher *");

        jLabel14.setText("Year *");

        jLabel15.setText("Volume");

        jLabel16.setText("Series");

        jLabel17.setText("Address");

        jLabel18.setText("Edition");

        jLabel19.setText("Month");

        jLabel20.setText("Note");

        jLabel21.setText("Key *");

        bookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTitleActionPerformed(evt);
            }
        });

        bookSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSeriesActionPerformed(evt);
            }
        });

        bookNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookNoteActionPerformed(evt);
            }
        });

        bookKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookKeyActionPerformed(evt);
            }
        });

        bookSubmit.setText("Submit Book");
        bookSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(bookAuthor)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookPublisher)
                            .addComponent(bookYear)
                            .addComponent(bookVolume)
                            .addComponent(bookSeries)
                            .addComponent(bookAddress)
                            .addComponent(bookEdition)
                            .addComponent(bookMonth)
                            .addComponent(bookNote)
                            .addComponent(bookKey)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(bookSubmit))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(bookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(bookPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(bookYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(bookVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(bookSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(bookAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(bookEdition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(bookMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(bookNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(bookKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bookSubmit)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        inproceedingsPane.addTab("Book", jPanel3);

        jLabel22.setText("Author  *");

        jLabel23.setText("Title *");

        jLabel24.setText("Booktitle *");

        jLabel25.setText("Year *");

        jLabel26.setText("Editor");

        jLabel27.setText("Volume");

        jLabel28.setText("Series");

        jLabel29.setText("Pages");

        jLabel30.setText("Address");

        jLabel31.setText("Month");

        jLabel32.setText("Organization");

        jLabel33.setText("Publisher");

        jLabel34.setText("Note");

        jLabel35.setText("Key *");

        inproceedingsYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inproceedingsYearActionPerformed(evt);
            }
        });

        submitInproceedings.setText("Submit Inproceedings");
        submitInproceedings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitInproceedingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inproceedingsOrganization, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inproceedingsMonth, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inproceedingsAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inproceedingsPages, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inproceedingsSeries, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inproceedingsVolume, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inproceedingsEditor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inproceedingsYear)
                            .addComponent(inproceedingsPublisher)
                            .addComponent(inproceedingsNote)
                            .addComponent(inproceedingsKey)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inproceedingsBooktitle)
                            .addComponent(inproceedingsTitle)
                            .addComponent(inproceedingsAuthor)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(submitInproceedings)
                        .addGap(0, 84, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(inproceedingsAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(inproceedingsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsBooktitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inproceedingsKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitInproceedings)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inproceedingsPane.addTab("Inproceedings", jPanel4);

        jLabel36.setText("Author *");

        jLabel37.setText("Title *");

        jLabel38.setText("School *");

        jLabel39.setText("Year *");

        jLabel40.setText("Type");

        jLabel41.setText("Address");

        jLabel42.setText("Month");

        jLabel43.setText("Note");

        phdthesisAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phdthesisAuthorActionPerformed(evt);
            }
        });

        phdthesisTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phdthesisTitleActionPerformed(evt);
            }
        });

        phdthesisYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phdthesisYearActionPerformed(evt);
            }
        });

        phdthesisType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phdthesisTypeActionPerformed(evt);
            }
        });

        submitPhdthesis.setText("Submit Phdthesis");
        submitPhdthesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPhdthesisActionPerformed(evt);
            }
        });

        jLabel52.setText("Key *");

        phdthesisKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phdthesisKeyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(submitPhdthesis)
                        .addGap(0, 115, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel37)
                                        .addComponent(jLabel38)
                                        .addComponent(jLabel39)
                                        .addComponent(jLabel40)
                                        .addComponent(jLabel41)
                                        .addComponent(jLabel42)
                                        .addComponent(jLabel43))
                                    .addGap(20, 20, 20))
                                .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel52))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phdthesisAuthor)
                            .addComponent(phdthesisTitle)
                            .addComponent(phdthesisSchool)
                            .addComponent(phdthesisYear)
                            .addComponent(phdthesisType)
                            .addComponent(phdthesisAddress)
                            .addComponent(phdthesisMonth)
                            .addComponent(phdthesisNote)
                            .addComponent(phdthesisKey))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(phdthesisAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(phdthesisTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(phdthesisSchool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phdthesisAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phdthesisYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phdthesisType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phdthesisMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phdthesisNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phdthesisKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitPhdthesis)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        inproceedingsPane.addTab("Phdthesis", jPanel5);

        jLabel44.setText("Author *");

        jLabel45.setText("Title *");

        jLabel46.setText("School *");

        jLabel47.setText("Year *");

        jLabel48.setText("Type");

        jLabel49.setText("Address");

        jLabel50.setText("Month");

        jLabel51.setText("Note");

        masterthesisAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterthesisAuthorActionPerformed(evt);
            }
        });

        jLabel53.setText("Key *");

        submitMasterthesis.setText("Submit masterthesis");
        submitMasterthesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitMasterthesisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(18, 18, 18)
                        .addComponent(masterthesisAuthor))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(masterthesisSchool)
                            .addComponent(masterthesisYear)
                            .addComponent(masterthesisType)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(35, 35, 35)
                        .addComponent(masterthesisTitle))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel49)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel53))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(masterthesisAddress)
                                    .addComponent(masterthesisMonth)
                                    .addComponent(masterthesisNote)
                                    .addComponent(masterthesisKey, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                            .addComponent(submitMasterthesis))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(masterthesisAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(masterthesisTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(masterthesisSchool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(masterthesisYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(masterthesisType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(masterthesisAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(masterthesisMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(masterthesisNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(masterthesisKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitMasterthesis)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        inproceedingsPane.addTab("Masterthesis", jPanel6);

        jLabel54.setText("Title *");

        jLabel55.setText("Year *");

        jLabel56.setText("Editor");

        jLabel57.setText("Volume");

        jLabel58.setText("Series");

        jLabel59.setText("Address");

        jLabel60.setText("Month");

        jLabel61.setText("Publisher");

        jLabel62.setText("Organization");

        jLabel63.setText("Note");

        jLabel64.setText("Key *");

        proceedingsMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedingsMonthActionPerformed(evt);
            }
        });

        submitProceedings.setText("Submit proceedings");
        submitProceedings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitProceedingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62)
                            .addComponent(jLabel61)
                            .addComponent(jLabel60)
                            .addComponent(jLabel59)
                            .addComponent(jLabel58)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57)
                            .addComponent(jLabel55)
                            .addComponent(jLabel54)
                            .addComponent(jLabel63)
                            .addComponent(jLabel64))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proceedingsTitle)
                            .addComponent(proceedingsYear)
                            .addComponent(proceedingsEditor)
                            .addComponent(proceedingsVolume)
                            .addComponent(proceedingsSeries)
                            .addComponent(proceedingsAddress)
                            .addComponent(proceedingsMonth)
                            .addComponent(proceedingsPublisher)
                            .addComponent(proceedingsOrganization)
                            .addComponent(proceedingsNote)
                            .addComponent(proceedingsKey)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(submitProceedings)
                        .addGap(0, 96, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addGap(72, 72, 72))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(proceedingsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(proceedingsYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(proceedingsEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56))))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedingsVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedingsSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedingsAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedingsMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedingsPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedingsOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedingsNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proceedingsKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitProceedings)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        inproceedingsPane.addTab("Proceedings", jPanel7);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Bibtex");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bibtexButton(evt);
            }
        });

        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButton(evt);
            }
        });

        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchBarKeyTyped(evt);
            }
        });

        jLabel65.setText("Search");

        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        readBiBTeX.setText("Read BiBTex");
        readBiBTeX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readBiBTeXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inproceedingsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(virheViesti)
                            .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(readBiBTeX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel65)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(virheViesti)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(Edit))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel65))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(readBiBTeX)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inproceedingsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public JFileChooser getFileChooser() {
        return this.fileChooser;
    }
    private void bibtexButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bibtexButton

        this.saveToFile();
    }//GEN-LAST:event_bibtexButton

    private void articleTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_articleTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_articleTitleActionPerformed

    private void bookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookTitleActionPerformed

    private void bookSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSeriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookSeriesActionPerformed

    private void bookNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookNoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookNoteActionPerformed

    private void bookKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookKeyActionPerformed

    private void inproceedingsYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inproceedingsYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inproceedingsYearActionPerformed

    private void bookSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSubmitActionPerformed
        submitBookForm();
        updateList();
        emptyReferenceTextFields(bookFields);
    }//GEN-LAST:event_bookSubmitActionPerformed

    private void submitInproceedingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitInproceedingsActionPerformed
        submitInproceedingsForm();
        updateList();
        emptyReferenceTextFields(inproceedingsFields);
    }//GEN-LAST:event_submitInproceedingsActionPerformed

    private void phdthesisAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phdthesisAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phdthesisAuthorActionPerformed

    private void phdthesisTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phdthesisTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phdthesisTitleActionPerformed

    private void phdthesisYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phdthesisYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phdthesisYearActionPerformed

    private void phdthesisTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phdthesisTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phdthesisTypeActionPerformed

    private void submitPhdthesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPhdthesisActionPerformed
        submitPhdthesisForm();
        updateList();
        emptyReferenceTextFields(phdthesisFields);
    }//GEN-LAST:event_submitPhdthesisActionPerformed

    private void phdthesisKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phdthesisKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phdthesisKeyActionPerformed

    private void masterthesisAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterthesisAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masterthesisAuthorActionPerformed

    private void submitMasterthesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitMasterthesisActionPerformed
        submitMasterthesisForm();
        updateList();
        emptyReferenceTextFields(masterthesisFields);
    }//GEN-LAST:event_submitMasterthesisActionPerformed

    private void proceedingsMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedingsMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proceedingsMonthActionPerformed

    private void submitProceedingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitProceedingsActionPerformed
        submitProceedingsForm();
        updateList();
        emptyReferenceTextFields(proceedingsFields);
    }//GEN-LAST:event_submitProceedingsActionPerformed

    private void removeButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButton
        int array[] = jList1.getSelectedIndices();
        controller.removeReferences(array);
        updateList();
    }//GEN-LAST:event_removeButton

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchBarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyTyped
        controller.setSearchWord(searchBar.getText());
        updateList();
    }//GEN-LAST:event_searchBarKeyTyped

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        int e = jList1.getSelectedIndex();
        if (e == -1); // estää edit napin painamisen ilman valittua
        else {
            //Entry test = controller.getEntry(e); // kutsutaan tyyppiä vastaava palautus metodi
            Entry test = controller.getEntries().get(e);
            beingEdited = e;
            if (test.getEntrytype().matches("Article")) {
                putArticleTextFields((Article) test);
            } else if (test.getEntrytype().matches("Book")) {
                putBookTextFields((Book) test);
            } else if (test.getEntrytype().matches("Proceedings")) {
                putProceedingsTextFields((Proceedings) test);
            } else if (test.getEntrytype().matches("Inproceedings")) {
                putInproceedingsTextFields((Inproceedings) test);
            } else if (test.getEntrytype().matches("Masterthesis")) {
                putMasterthesisTextFields((Masterthesis) test);
            } else if (test.getEntrytype().matches("Phdthesis")) {
                putPhdthesisTextFields((Phdthesis) test);
            }
            updateList();
        }
    }//GEN-LAST:event_EditActionPerformed
    public JButton getReadBiBTex() {
        return this.readBiBTeX;
    }

    private void readBiBTeXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readBiBTeXActionPerformed
        this.fileChooser.setCurrentDirectory(new File("."));
        int valinta = this.fileChooser.showOpenDialog(this);

        if (valinta == JFileChooser.APPROVE_OPTION) {
            try {
                controller.readBiBTeXFile(fileChooser.getSelectedFile().getAbsolutePath());
            } catch (Exception ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.updateList();

    }//GEN-LAST:event_readBiBTeXActionPerformed

    private void submitArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitArticleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitArticleActionPerformed

    /**
     * @param args the command line arguments
     */
    public void display() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Edit;
    private javax.swing.JTextField articleAuthor;
    private javax.swing.JTextField articleJournal;
    private javax.swing.JTextField articleKey;
    private javax.swing.JTextField articleMonth;
    private javax.swing.JTextField articleNote;
    private javax.swing.JTextField articleNumber;
    private javax.swing.JTextField articlePages;
    private javax.swing.JTextField articleTitle;
    private javax.swing.JTextField articleVolume;
    private javax.swing.JTextField articleYea;
    private javax.swing.JTextField bookAddress;
    private javax.swing.JTextField bookAuthor;
    private javax.swing.JTextField bookEdition;
    private javax.swing.JTextField bookKey;
    private javax.swing.JTextField bookMonth;
    private javax.swing.JTextField bookNote;
    private javax.swing.JTextField bookPublisher;
    private javax.swing.JTextField bookSeries;
    private javax.swing.JButton bookSubmit;
    private javax.swing.JTextField bookTitle;
    private javax.swing.JTextField bookVolume;
    private javax.swing.JTextField bookYear;
    private javax.swing.JTextField inproceedingsAddress;
    private javax.swing.JTextField inproceedingsAuthor;
    private javax.swing.JTextField inproceedingsBooktitle;
    private javax.swing.JTextField inproceedingsEditor;
    private javax.swing.JTextField inproceedingsKey;
    private javax.swing.JTextField inproceedingsMonth;
    private javax.swing.JTextField inproceedingsNote;
    private javax.swing.JTextField inproceedingsOrganization;
    private javax.swing.JTextField inproceedingsPages;
    private javax.swing.JTabbedPane inproceedingsPane;
    private javax.swing.JTextField inproceedingsPublisher;
    private javax.swing.JTextField inproceedingsSeries;
    private javax.swing.JTextField inproceedingsTitle;
    private javax.swing.JTextField inproceedingsVolume;
    private javax.swing.JTextField inproceedingsYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField masterthesisAddress;
    private javax.swing.JTextField masterthesisAuthor;
    private javax.swing.JTextField masterthesisKey;
    private javax.swing.JTextField masterthesisMonth;
    private javax.swing.JTextField masterthesisNote;
    private javax.swing.JTextField masterthesisSchool;
    private javax.swing.JTextField masterthesisTitle;
    private javax.swing.JTextField masterthesisType;
    private javax.swing.JTextField masterthesisYear;
    private javax.swing.JTextField phdthesisAddress;
    private javax.swing.JTextField phdthesisAuthor;
    private javax.swing.JTextField phdthesisKey;
    private javax.swing.JTextField phdthesisMonth;
    private javax.swing.JTextField phdthesisNote;
    private javax.swing.JTextField phdthesisSchool;
    private javax.swing.JTextField phdthesisTitle;
    private javax.swing.JTextField phdthesisType;
    private javax.swing.JTextField phdthesisYear;
    private javax.swing.JTextField proceedingsAddress;
    private javax.swing.JTextField proceedingsEditor;
    private javax.swing.JTextField proceedingsKey;
    private javax.swing.JTextField proceedingsMonth;
    private javax.swing.JTextField proceedingsNote;
    private javax.swing.JTextField proceedingsOrganization;
    private javax.swing.JTextField proceedingsPublisher;
    private javax.swing.JTextField proceedingsSeries;
    private javax.swing.JTextField proceedingsTitle;
    private javax.swing.JTextField proceedingsVolume;
    private javax.swing.JTextField proceedingsYear;
    private javax.swing.JButton readBiBTeX;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton submitArticle;
    private javax.swing.JButton submitInproceedings;
    private javax.swing.JButton submitMasterthesis;
    private javax.swing.JButton submitPhdthesis;
    private javax.swing.JButton submitProceedings;
    private javax.swing.JLabel virheViesti;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        //Napinpainallus submittaa formin
        submitArticleForm();
        //Päivitetään lista sivussa ja tyhjennetään tekstikentät
        emptyReferenceTextFields(articleFields);
        updateList();
    }

    public void gatherProceedingsTextFields() {
        proceedingsFields[0] = proceedingsTitle;
        proceedingsFields[1] = proceedingsYear;
        proceedingsFields[2] = proceedingsEditor;
        proceedingsFields[3] = proceedingsVolume;
        proceedingsFields[4] = proceedingsSeries;
        proceedingsFields[5] = proceedingsAddress;
        proceedingsFields[6] = proceedingsMonth;
        proceedingsFields[7] = proceedingsPublisher;
        proceedingsFields[8] = proceedingsOrganization;
        proceedingsFields[9] = proceedingsNote;
        proceedingsFields[10] = proceedingsKey;
    }

    public void putProceedingsTextFields(Proceedings p) {
        proceedingsFields[0].setText(p.getTitle());
        proceedingsFields[1].setText(p.getYear());
        proceedingsFields[2].setText(p.getEditor());
        proceedingsFields[3].setText(p.getVolume());
        proceedingsFields[4].setText(p.getSeries());
        proceedingsFields[5].setText(p.getAddress());
        proceedingsFields[6].setText(p.getMonth());
        proceedingsFields[7].setText(p.getPublisher());
        proceedingsFields[8].setText(p.getOrganization());
        proceedingsFields[9].setText(p.getNote());
        proceedingsFields[10].setText(p.getKey());
    }

    public void gatherMasterthesisTextFields() {
        masterthesisFields[0] = masterthesisAuthor;
        masterthesisFields[1] = masterthesisTitle;
        masterthesisFields[2] = masterthesisSchool;
        masterthesisFields[3] = masterthesisYear;
        masterthesisFields[4] = masterthesisType;
        masterthesisFields[5] = masterthesisAddress;
        masterthesisFields[6] = masterthesisMonth;
        masterthesisFields[7] = masterthesisNote;
        masterthesisFields[8] = masterthesisKey;
    }

    public void putMasterthesisTextFields(Masterthesis m) {
        masterthesisFields[0].setText(m.getAuthor());
        masterthesisFields[1].setText(m.getTitle());
        masterthesisFields[2].setText(m.getSchool());
        masterthesisFields[3].setText(m.getYear());
        masterthesisFields[4].setText(m.getType());
        masterthesisFields[5].setText(m.getAddress());
        masterthesisFields[6].setText(m.getMonth());
        masterthesisFields[7].setText(m.getNote());
        masterthesisFields[8].setText(m.getKey());
    }

    public void gatherPhdthesisTextFields() {
        phdthesisFields[0] = phdthesisAuthor;
        phdthesisFields[1] = phdthesisTitle;
        phdthesisFields[2] = phdthesisSchool;
        phdthesisFields[3] = phdthesisYear;
        phdthesisFields[4] = phdthesisType;
        phdthesisFields[5] = phdthesisAddress;
        phdthesisFields[6] = phdthesisMonth;
        phdthesisFields[7] = phdthesisNote;
        phdthesisFields[8] = phdthesisKey;
    }

    public void putPhdthesisTextFields(Phdthesis p) {
        phdthesisFields[0].setText(p.getAuthor());
        phdthesisFields[1].setText(p.getTitle());
        phdthesisFields[2].setText(p.getSchool());
        phdthesisFields[3].setText(p.getYear());
        phdthesisFields[4].setText(p.getType());
        phdthesisFields[5].setText(p.getAddress());
        phdthesisFields[6].setText(p.getMonth());
        phdthesisFields[7].setText(p.getNote());
        phdthesisFields[8].setText(p.getKey());
    }

    public void gatherBookTextFields() {
        bookFields[0] = bookAuthor;
        bookFields[1] = bookTitle;
        bookFields[2] = bookPublisher;
        bookFields[3] = bookYear;
        bookFields[4] = bookVolume;
        bookFields[5] = bookSeries;
        bookFields[6] = bookAddress;
        bookFields[7] = bookEdition;
        bookFields[8] = bookMonth;
        bookFields[9] = bookNote;
        bookFields[10] = bookKey;
    }

    public void putBookTextFields(Book b) {
        bookFields[0].setText(b.getAuthor());
        bookFields[1].setText(b.getTitle());
        bookFields[2].setText(b.getPublisher());
        bookFields[3].setText(b.getYear());
        bookFields[4].setText(b.getVolume());
        bookFields[5].setText(b.getSeries());;
        bookFields[6].setText(b.getAddress());
        bookFields[7].setText(b.getEdition());
        bookFields[8].setText(b.getMonth());
        bookFields[9].setText(b.getNote());
        bookFields[10].setText(b.getKey());
    }

    public void gatherArticleTextFields() {
        articleFields[0] = articleAuthor;
        articleFields[1] = articleJournal;
        articleFields[2] = articleTitle;
        articleFields[3] = articleYea;
        articleFields[4] = articleVolume;
        articleFields[5] = articleNumber;
        articleFields[6] = articlePages;
        articleFields[7] = articleMonth;
        articleFields[8] = articleNote;
        articleFields[9] = articleKey;
    }

    public void putArticleTextFields(Article a) {
        articleFields[0].setText(a.getAuthor());
        articleFields[1].setText(a.getJournal());
        articleFields[2].setText(a.getTitle());
        articleFields[3].setText(a.getYear());
        articleFields[4].setText(a.getVolume());
        articleFields[5].setText(a.getNumber());
        articleFields[6].setText(a.getPages());
        articleFields[7].setText(a.getMonth());
        articleFields[8].setText(a.getNote());
        articleFields[9].setText(a.getKey());
    }

    public void gatherInproceedingsTextFields() {
        inproceedingsFields[0] = inproceedingsAuthor;
        inproceedingsFields[1] = inproceedingsTitle;
        inproceedingsFields[2] = inproceedingsBooktitle;
        inproceedingsFields[3] = inproceedingsYear;
        inproceedingsFields[4] = inproceedingsEditor;
        inproceedingsFields[5] = inproceedingsVolume;
        inproceedingsFields[6] = inproceedingsSeries;
        inproceedingsFields[7] = inproceedingsPages;
        inproceedingsFields[8] = inproceedingsAddress;
        inproceedingsFields[9] = inproceedingsMonth;
        inproceedingsFields[10] = inproceedingsOrganization;
        inproceedingsFields[11] = inproceedingsPublisher;
        inproceedingsFields[12] = inproceedingsNote;
        inproceedingsFields[13] = inproceedingsKey;
    }

    public void putInproceedingsTextFields(Inproceedings i) {
        inproceedingsFields[0].setText(i.getAuthor());
        inproceedingsFields[1].setText(i.getTitle());
        inproceedingsFields[2].setText(i.getBooktitle());
        inproceedingsFields[3].setText(i.getYear());
        inproceedingsFields[4].setText(i.getEditor());
        inproceedingsFields[5].setText(i.getVolume());
        inproceedingsFields[6].setText(i.getSeries());
        inproceedingsFields[7].setText(i.getPages());
        inproceedingsFields[8].setText(i.getAddress());
        inproceedingsFields[9].setText(i.getMonth());
        inproceedingsFields[10].setText(i.getOrganization());
        inproceedingsFields[11].setText(i.getPublisher());
        inproceedingsFields[12].setText(i.getNote());
        inproceedingsFields[13].setText(i.getKey());
    }

    public JTextField[] getBookFields() {
        return bookFields;
    }

    public JButton getSubmitArticleButton() {
        return this.submitArticle;
    }

    public JButton getJButton1() {
        return this.jButton1;
    }

    public JButton getJButton2() {
        return this.jButton2;
    }

    public JButton getJButtonEdit() {
        return this.Edit;
    }

    public JTextField[] getInproceedingsFields() {
        return inproceedingsFields;
    }

    public JTextField[] getPhdthesisFields() {
        return phdthesisFields;
    }

    public JTextField[] getMasterthesisFields() {
        return masterthesisFields;
    }

    public JTextField[] getProceedingsFields() {
        return proceedingsFields;
    }

    public JTextField[] getArticleFields() {
        return articleFields;
    }

    public JList getReferenceList() {
        return jList1;
    }

    //metodi tyhjentää jonkun lomakkeen tekstikentät
    public void emptyReferenceTextFields(JTextField[] fields) {
        for (int i = 0; i < fields.length; i++) {
            fields[i].setText("");
        }
    }

    public void setVirheViesti(String viesti) {
        virheViesti.setText(viesti);
    }

    public JLabel getVirheViesti() {
        return virheViesti;
    }

    public JTextField getSearchBar() {
        return searchBar;
    }
}
