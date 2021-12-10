/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.Doctor.Prescription;
import Business.Doctor.PrescriptionList;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;

import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.PharmacyWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
/**
 *
 * @author vgout
 */
public class PrescriptionJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PrescriptionJPanel
     */
    private PrescriptionList prescriptionList;
    private DoctorOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private JPanel userProcessContainer;
    private Prescription prescription;
    private DoctorWorkRequest docreq;
    private Network network;
    private EcoSystem system;
    private static Logger log = Logger.getLogger(PrescriptionJPanel.class);
    private static final String CLASS_NAME = PrescriptionJPanel.class.getName();
    private static final String filePath = "./prescription data.txt";

    public PrescriptionJPanel(JPanel userProcessContainer, PrescriptionList List, UserAccount account, Enterprise enterprise, DoctorOrganization organization, EcoSystem system, Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise = enterprise;
        this.organization = organization;
        this.network = network;
        this.system = system;
        
        populateWorkRequestTable();
       // DateChooser.setMinSelectableDate(new Date());
       
        
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        doctorPrescriptionLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        nameTxtField = new javax.swing.JTextField();
        ageLbl = new javax.swing.JLabel();
        ageTxtField = new javax.swing.JTextField();
        sexLbl = new javax.swing.JLabel();
        sexcomboBox = new javax.swing.JComboBox<String>();
        diagnosisLbl = new javax.swing.JLabel();
        medicationLbl = new javax.swing.JLabel();
        diagnosisComboBox = new javax.swing.JComboBox<String>();
        timesADayLbl = new javax.swing.JLabel();
        forLbl = new javax.swing.JLabel();
        savePrescriptionBtn = new javax.swing.JButton();
        noofTimesTxt = new javax.swing.JSpinner();
        noofDaysTxt = new javax.swing.JSpinner();
        scrollPane2 = new javax.swing.JScrollPane();
        prescriptionJTable = new javax.swing.JTable();
        dateLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        DateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        medicationCombobox = new javax.swing.JComboBox<String>();

        setBackground(new java.awt.Color(153, 153, 255));
        setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 48)); // NOI18N
        setPreferredSize(new java.awt.Dimension(2000, 1200));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doctorPrescriptionLbl.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 48)); // NOI18N
        doctorPrescriptionLbl.setForeground(new java.awt.Color(0, 0, 102));
        doctorPrescriptionLbl.setText("Doctor Prescription");
        add(doctorPrescriptionLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        nameLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        nameLbl.setForeground(new java.awt.Color(0, 0, 102));
        nameLbl.setText("Name:");
        add(nameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));
        add(nameTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 287, -1));

        ageLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        ageLbl.setForeground(new java.awt.Color(0, 0, 102));
        ageLbl.setText("Age:");
        add(ageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));
        add(ageTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 287, -1));

        sexLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        sexLbl.setForeground(new java.awt.Color(0, 0, 102));
        sexLbl.setText("Sex:");
        add(sexLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        sexcomboBox.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 18)); // NOI18N
        sexcomboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please select--", "Male", "Female" }));
        sexcomboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexcomboBoxActionPerformed(evt);
            }
        });
        add(sexcomboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 287, -1));

        diagnosisLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        diagnosisLbl.setForeground(new java.awt.Color(0, 0, 102));
        diagnosisLbl.setText("Diagnosis:");
        add(diagnosisLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        medicationLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        medicationLbl.setForeground(new java.awt.Color(0, 0, 102));
        medicationLbl.setText("Medication:");
        add(medicationLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 424, -1, -1));

        diagnosisComboBox.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        diagnosisComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please select--", "Achondroplasia", "Marfansyndrome", "Cysticfibrosis", "TaySachs", "Haemophilia", "Mosaicism", "Downsyndrome", "Turnersyndrome" }));
        diagnosisComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnosisComboBoxActionPerformed(evt);
            }
        });
        add(diagnosisComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 287, 30));

        timesADayLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        timesADayLbl.setForeground(new java.awt.Color(0, 0, 102));
        timesADayLbl.setText("Times a Day:");
        add(timesADayLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 424, -1, -1));

        forLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        forLbl.setForeground(new java.awt.Color(0, 0, 102));
        forLbl.setText("For:");
        add(forLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(966, 424, -1, -1));

        savePrescriptionBtn.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 24)); // NOI18N
        savePrescriptionBtn.setForeground(new java.awt.Color(0, 0, 102));
        savePrescriptionBtn.setText("SAVE  PRESCRIPTION");
        savePrescriptionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePrescriptionBtnActionPerformed(evt);
            }
        });
        add(savePrescriptionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, -1, 40));

        noofTimesTxt.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        add(noofTimesTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 429, 170, 31));

        noofDaysTxt.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        add(noofDaysTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 429, 171, 30));

        prescriptionJTable.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 20)); // NOI18N
        prescriptionJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Name", "Total Quantity", "Reciever"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        prescriptionJTable.setRowHeight(25);
        scrollPane2.setViewportView(prescriptionJTable);

        add(scrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 818, 173));

        dateLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        dateLbl.setForeground(new java.awt.Color(0, 0, 102));
        dateLbl.setText("Date: ");
        add(dateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 79, -1));

        backBtn.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 24)); // NOI18N
        backBtn.setForeground(new java.awt.Color(0, 0, 102));
        backBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\vgout\\AED_ASSIGNMENT\\AED_ASSIGNMENT_LAB\\biogen_finalproject\\BioGen_FinalProject\\src\\Image\\backbtn")); // NOI18N
        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 748, -1, -1));
        add(DateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, 180, 32));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DoctorPrescription.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 140, 130));

        medicationCombobox.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        medicationCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please select--", "Galafold", "Onpattro", "Revcovi", "Tegsedi", "Haegarda", "Brineura", "Mepsevii", "Spinraza" }));
        medicationCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicationComboboxActionPerformed(evt);
            }
        });
        add(medicationCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 426, 287, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void savePrescriptionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePrescriptionBtnActionPerformed
        // TODO add your handling code here:

        Prescription p = new Prescription();
        p.setDaignosis(diagnosisComboBox.getSelectedItem().toString());
        p.setMedicineName(medicationCombobox.getSelectedItem().toString());

        p.setNoofTimesInaday((Integer) noofTimesTxt.getValue());

        p.setTotalDays((Integer) noofDaysTxt.getValue());
        p.setNetworkName(network.getName());
        
        
        
        String age = ageTxtField.getText();
        boolean flag = true;
        try {
            Integer.parseInt(age);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Age must be integer!");
            flag = false;
            return;
        }

        if (p.getDaignosis().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the daignosis!");
            flag = false;
            return;
        } else if (nameTxtField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the patient name!");
            flag = false;
            return;

        }
         if(((Integer) noofTimesTxt.getValue())==0|| ((Integer) noofDaysTxt.getValue())==0)
                {
                     JOptionPane.showMessageDialog(null, "Please enter the no of days or no times !");
             flag = false;
             return;
                }
         if(DateChooser.getDate()==null)
         {
             JOptionPane.showMessageDialog(null, "Please select the date !");
             flag = false;
             return;
         }
         if(medicationCombobox.getSelectedIndex()<=0)
         {
             JOptionPane.showMessageDialog(null, "Please select the Medication Name !");
             flag = false;
         }
         if(sexcomboBox.getSelectedIndex()<=0)
         {
          JOptionPane.showMessageDialog(null, "Please select the Medication Name !");
             flag = false;   
             return;
         }
         if(diagnosisComboBox.getSelectedIndex()<=0)
         {
             JOptionPane.showMessageDialog(null, "please select the diagonsis name");
             flag=false;
             return;
         }
        
        if (flag == true) {
            
            
            organization.addPrescription(p);

            PharmacyWorkRequest request = new PharmacyWorkRequest();

            request.setMedicationName(medicationCombobox.getSelectedItem().toString());
            request.setQuantity(((Integer) noofTimesTxt.getValue()) * ((Integer) noofDaysTxt.getValue()));
            request.setSender(userAccount);
            request.setStatus("Sent");
            System.out.println(request.getMedicationName());
            JOptionPane.showMessageDialog(null, "Prescription added successfully");

            System.out.println("****" + enterprise.getName());
            Organization org = null;

                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof PharmacyOrganization) {
                            org = organization;
                            System.out.println("****" + org);
                            log.debug(org);
                            log.debug("Current Enterprise\t" +enterprise);
                               log.debug("Current Organization\t" +org);
                               log.debug("Current Network\t" +network);
                            break;
                        }
                    }
                }
            
            if (org != null) {

                org.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
                log.debug("request sent to Pharmacy");
            }
            
           

            populateWorkRequestTable();
            saveRecord(p.getNetworkName(),p.getDaignosis(),p.getMedicineName());
            nameTxtField.setText("");
            ageTxtField.setText("");
             noofTimesTxt.setValue(0);
             noofDaysTxt.setValue(0);
             sexcomboBox.setSelectedIndex(0);
             medicationCombobox.setSelectedIndex(0);
            
        }


    }//GEN-LAST:event_savePrescriptionBtnActionPerformed
    
    public void saveRecord(String network,String disease,String medicine){
        try {
            FileWriter file = new FileWriter(filePath,true);
            BufferedWriter bw = new BufferedWriter(file);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(network+","+disease+","+medicine);
            pw.flush();
            pw.close();
            log.debug("saving prescription details to prescription data.txt");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(PrescriptionJPanel.class.getName()).log(Level.SEVERE, null, ex);
            log.error("prescription data.txt" +ex);
           
        }
        
    }
    
    private void diagnosisComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnosisComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosisComboBoxActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        log.debug("going back to Doctors work area");
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void sexcomboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexcomboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexcomboBoxActionPerformed

    private void medicationComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicationComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medicationComboboxActionPerformed


    public void populateWorkRequestTable() {

        DefaultTableModel model = (DefaultTableModel) prescriptionJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request instanceof PharmacyWorkRequest) {
                Object[] row = new Object[4];

                String medication = ((PharmacyWorkRequest) request).getMedicationName();

                System.out.println("****" + medication);
                row[0] = (PharmacyWorkRequest) request;
                int quantity = ((PharmacyWorkRequest) request).getQuantity();
                row[1] = quantity;
                row[2] = request.getReceiver();
                String result = request.getStatus();
                row[3] = result == null ? "Waiting" : result;

                model.addRow(row);

            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JLabel ageLbl;
    private javax.swing.JTextField ageTxtField;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JComboBox<String> diagnosisComboBox;
    private javax.swing.JLabel diagnosisLbl;
    private javax.swing.JLabel doctorPrescriptionLbl;
    private javax.swing.JLabel forLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> medicationCombobox;
    private javax.swing.JLabel medicationLbl;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JSpinner noofDaysTxt;
    private javax.swing.JSpinner noofTimesTxt;
    private javax.swing.JTable prescriptionJTable;
    private javax.swing.JButton savePrescriptionBtn;
    private javax.swing.JScrollPane scrollPane2;
    private javax.swing.JLabel sexLbl;
    private javax.swing.JComboBox<String> sexcomboBox;
    private javax.swing.JLabel timesADayLbl;
    // End of variables declaration//GEN-END:variables
}
