/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DrugSupplier;

import Business.Chemical.Chemical;
import Business.Doctor.Patient;
import Business.Drug.Drug;
import Business.EcoSystem;
import Business.Gene.Gene;
import Business.Network.Network;
import Business.Organization.DrugOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DrugWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author kasai
 */
public class GenerateDrugNewDrugJPanel extends javax.swing.JPanel {

    /**
     * Creates new form GenerateDrugNewDrugJPanel
     */
    private JPanel userProcessContainer;
    private Patient patient;
    private DrugOrganization drugOrganization;
    private UserAccount userAccount;
    private Network network;
    private EcoSystem business;
    private static Logger log = Logger.getLogger(GenerateDrugNewDrugJPanel.class);
    private static final String CLASS_NAME = GenerateDrugNewDrugJPanel.class.getName();

    public GenerateDrugNewDrugJPanel(JPanel userProcessContainer, Patient patient, DrugOrganization drugOrganization, UserAccount userAccount, Network network,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.patient = patient;
        this.drugOrganization = drugOrganization;
        this.userAccount = userAccount;
        this.network = network;
        this.business = business;
        patientTxtField.setText(patient.getPatientName());
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        newDrugTbl = new javax.swing.JTable();
        patientNameLbl = new javax.swing.JLabel();
        patientTxtField = new javax.swing.JTextField();
        resultLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        addnewdrugBtn = new javax.swing.JButton();
        newDrugTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newDrugTbl.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        newDrugTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Gene", "Chemical Compound"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        newDrugTbl.setRowHeight(30);
        jScrollPane.setViewportView(newDrugTbl);

        add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 168, 650, 240));

        patientNameLbl.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 24)); // NOI18N
        patientNameLbl.setForeground(new java.awt.Color(0, 0, 102));
        patientNameLbl.setText("Patient Name :");
        add(patientNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 99, 170, 30));

        patientTxtField.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        patientTxtField.setEnabled(false);
        add(patientTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 99, 294, 30));

        resultLbl.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 48)); // NOI18N
        resultLbl.setForeground(new java.awt.Color(0, 0, 102));
        resultLbl.setText("New Drug");
        add(resultLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 29, -1, -1));

        backBtn.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 24)); // NOI18N
        backBtn.setForeground(new java.awt.Color(0, 0, 102));
        backBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\vgout\\AED_ASSIGNMENT\\AED_ASSIGNMENT_LAB\\biogen_finalproject\\BioGen_FinalProject\\src\\Image\\backbtn")); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 537, 170, -1));

        addnewdrugBtn.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        addnewdrugBtn.setForeground(new java.awt.Color(0, 0, 102));
        addnewdrugBtn.setText("Add New Drug");
        addnewdrugBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnewdrugBtnActionPerformed(evt);
            }
        });
        add(addnewdrugBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 430, 220, 41));
        add(newDrugTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 435, 267, 41));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/newDrug.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, 80));
    }// </editor-fold>//GEN-END:initComponents

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) newDrugTbl.getModel();

        List<String> newDiseaseGenes = new ArrayList<String>();
        for (Gene gene : patient.getGeneHistory().getGeneHistory()) {
            newDiseaseGenes.add(gene.getGeneName());
        }

        int i = 0;
        Map<String, String> GeneChem = new TreeMap<String, String>((String.CASE_INSENSITIVE_ORDER));
        for (Drug d : business.getDrugList().getDrugList()) {

            for (i = 0; i < d.getChemicalList().getChemList().size(); i++) {

                Chemical c = d.getChemicalList().getChemList().get(i);
                Gene g = d.getGeneHistory().getGeneHistory().get(i);
                GeneChem.put(g.getGeneName(), c.getChemicalName());
            }

        }

        Map<String, String> newDrugFinal = new TreeMap<String, String>((String.CASE_INSENSITIVE_ORDER));
        for (String s : newDiseaseGenes) {

            if (GeneChem.containsKey(s)) {

                newDrugFinal.put(s, GeneChem.get(s));
            }
        }

        for (Map.Entry<String, String> entry : newDrugFinal.entrySet()) {
            String key = entry.getKey();
            String values = entry.getValue();
            Object[] row = new Object[2];
            row[0] = key;
            row[1] = values;
            model.addRow(row);
        }

    }
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        LabResultsJpanel dwjp = (LabResultsJpanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void addnewdrugBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnewdrugBtnActionPerformed
        // TODO add your handling code here:
        String drugName = newDrugTxt.getText().trim();
        if(drugName.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter the drug name");
            return;
        }
        ArrayList<String>drugCheck = new ArrayList<>();
        for(Drug d:business.getDrugList().getDrugList())
        {
            drugCheck.add(d.getDrugName().toLowerCase());
        }
        if(drugCheck.contains(drugName))
        {
             JOptionPane.showMessageDialog(null, " Drug name already exists ");
            return;
        }
        Drug d = business.getDrugList().addDrugList();
        d.setDrugName(drugName);
        patient.setNewDrug(drugName);
        int count = newDrugTbl.getRowCount();
        for (int i = 0; i < count; i++) {
            String s = newDrugTbl.getValueAt(i, 0).toString();
            d.getGeneHistory().addGeneList().setGeneName(s);
            String t = newDrugTbl.getValueAt(i, 1).toString();
            d.getChemicalList().addChemicalList().setChemicalName(t);

        }
        JOptionPane.showMessageDialog(null,"New Drug is added succesfully");
        log.debug(userAccount+" "+"added new drug"+" "+drugName);


    }//GEN-LAST:event_addnewdrugBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addnewdrugBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable newDrugTbl;
    private javax.swing.JTextField newDrugTxt;
    private javax.swing.JLabel patientNameLbl;
    private javax.swing.JTextField patientTxtField;
    private javax.swing.JLabel resultLbl;
    // End of variables declaration//GEN-END:variables
}
