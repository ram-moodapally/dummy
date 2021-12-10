/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmacyRole;

import Business.Enterprise.Enterprise;
import Business.MedicalInventory.MedicalInventory;
import Business.MedicalInventory.MedicalInventoryList;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DrugWorkRequest;
import Business.WorkQueue.PharmacyWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author venu0
 */
public class PharmacyWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form PharmacyWorkArea
     */
    JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private MedicalInventoryList mil;
    private Organization org;
    private PharmacyOrganization pharmorg;
    private Network network;
    private static Logger log = Logger.getLogger(PharmacyWorkArea.class);
    private static final String CLASS_NAME = PharmacyWorkArea.class.getName();
//PharmacyWorkArea(userProcessContainer, account, (PharmacyOrganization)organization,enterprise,network);
    public PharmacyWorkArea(JPanel userProcessContainer, UserAccount userAccount, PharmacyOrganization organization, Enterprise enterprise, Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.pharmorg = organization;
        this.network = network;
        reorderTable();
        populateDocTable();
        log.debug(userAccount+" "+"logged in");
    }

    public void reorderTable() {
        int rowCount = reorderTable.getRowCount();
        DefaultTableModel model = (DefaultTableModel) reorderTable.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (MedicalInventory mi : pharmorg.getMedList()) {
            Object row[] = new Object[6];
            row[0] = mi;
            row[1] = mi.getSerialNumber();
            row[2] = mi.getAvailQuantity();
            row[3] = mi.getRequiredQuantity();
            row[4] = mi.getReorderStatus();
            //row[5] = mi.getReorderStatus();
            model.addRow(row);
        }
    }

    public void populateDocTable() {
        DefaultTableModel model = (DefaultTableModel) docrequestTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : pharmorg.getWorkQueue().getWorkRequestList()) {
            System.out.println("entering medication");
           
             if(request instanceof PharmacyWorkRequest){
            Object[] row = new Object[3];
            row[0] = ((PharmacyWorkRequest) request).getMedicationName();
            row[1] = ((PharmacyWorkRequest) request).getQuantity();
            row[2] = ((PharmacyWorkRequest) request).getStatus();

            model.addRow(row);
             }
        }
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
        docrequestTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        reorderTable = new javax.swing.JTable();
        serialNumLbl = new javax.swing.JLabel();
        serialNumberTxtField = new javax.swing.JTextField();
        medicineNameLbl = new javax.swing.JLabel();
        medicineNameTxtField = new javax.swing.JTextField();
        availQuantityLbl = new javax.swing.JLabel();
        availQuantityTxtField = new javax.swing.JTextField();
        reqQuantityLbl = new javax.swing.JLabel();
        reqQuantityTxtField = new javax.swing.JTextField();
        viewRequestsBtn = new javax.swing.JButton();
        addMedicineBtn = new javax.swing.JButton();
        viewDetailsBtn = new javax.swing.JButton();
        statusCheckBtn = new javax.swing.JButton();
        pharmacyLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        docrequestTable.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        docrequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEDICINE NAME", "QUANTITY", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        docrequestTable.setRowHeight(25);
        jScrollPane.setViewportView(docrequestTable);

        add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 686, 714, 177));

        reorderTable.setBorder(new javax.swing.border.MatteBorder(null));
        reorderTable.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        reorderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEDICINE NAME", "SERIAL NUMBER ", "AVAILABILE QUANTITY", "REQUIRED QUANTITY", "REORDER STATUS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reorderTable.setRowHeight(25);
        jScrollPane1.setViewportView(reorderTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 111, 871, 238));

        serialNumLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        serialNumLbl.setForeground(new java.awt.Color(0, 0, 102));
        serialNumLbl.setText("SERIAL NUMBER: ");
        add(serialNumLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 382, 241, 23));

        serialNumberTxtField.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 20)); // NOI18N
        add(serialNumberTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 382, 252, 30));

        medicineNameLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        medicineNameLbl.setForeground(new java.awt.Color(0, 0, 102));
        medicineNameLbl.setText("MEDICINE NAME: ");
        add(medicineNameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 229, 25));

        medicineNameTxtField.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 20)); // NOI18N
        add(medicineNameTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 423, 252, 30));

        availQuantityLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        availQuantityLbl.setForeground(new java.awt.Color(0, 0, 102));
        availQuantityLbl.setText("AVAILABLE QUANTITY:");
        add(availQuantityLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 467, 282, -1));

        availQuantityTxtField.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 20)); // NOI18N
        add(availQuantityTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 252, 30));

        reqQuantityLbl.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        reqQuantityLbl.setForeground(new java.awt.Color(0, 0, 102));
        reqQuantityLbl.setText("REQUIRED QUANTITY:");
        add(reqQuantityLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 506, 293, -1));

        reqQuantityTxtField.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 20)); // NOI18N
        reqQuantityTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqQuantityTxtFieldActionPerformed(evt);
            }
        });
        add(reqQuantityTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 510, 252, 30));

        viewRequestsBtn.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 24)); // NOI18N
        viewRequestsBtn.setForeground(new java.awt.Color(0, 0, 102));
        viewRequestsBtn.setText("VIEW REQUESTS");
        viewRequestsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRequestsBtnActionPerformed(evt);
            }
        });
        add(viewRequestsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 520, 251, -1));

        addMedicineBtn.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 24)); // NOI18N
        addMedicineBtn.setForeground(new java.awt.Color(0, 0, 102));
        addMedicineBtn.setText("ADD MEDICINE");
        addMedicineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMedicineBtnActionPerformed(evt);
            }
        });
        add(addMedicineBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 251, -1));

        viewDetailsBtn.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 24)); // NOI18N
        viewDetailsBtn.setForeground(new java.awt.Color(0, 0, 102));
        viewDetailsBtn.setText("VIEW DETAILS");
        viewDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsBtnActionPerformed(evt);
            }
        });
        add(viewDetailsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 450, 251, -1));

        statusCheckBtn.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 24)); // NOI18N
        statusCheckBtn.setForeground(new java.awt.Color(0, 0, 102));
        statusCheckBtn.setText("INVENTORY STATUS CHECK");
        statusCheckBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusCheckBtnActionPerformed(evt);
            }
        });
        add(statusCheckBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 200, 350, -1));

        pharmacyLbl.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 48)); // NOI18N
        pharmacyLbl.setForeground(new java.awt.Color(0, 0, 102));
        pharmacyLbl.setText("Pharmacy Work Area");
        add(pharmacyLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pharamacy.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/medicine.jpg"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 570, 110, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void reqQuantityTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqQuantityTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reqQuantityTxtFieldActionPerformed

    private void viewRequestsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRequestsBtnActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ViewRequestJPanel", new ViewRequestsJPanel(userProcessContainer, userAccount, enterprise, org));
        layout.next(userProcessContainer);


    }//GEN-LAST:event_viewRequestsBtnActionPerformed

    private void addMedicineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMedicineBtnActionPerformed
        // TODO add your handling code here:

        MedicalInventory m = new MedicalInventory();
        String name = medicineNameTxtField.getText().trim();
        String error_message = "";
        String avail = availQuantityTxtField.getText();
        try {
            Integer.parseInt(avail);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Available quantity must be integer");
            return;

        }
        if(name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please enter the name ");
            return;
        }
        
        m.setMedicineName(medicineNameTxtField.getText());
        try{
        int availableQuantity = Integer.parseInt(availQuantityTxtField.getText());
        m.setAvailQuantity(availableQuantity);
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "serial number must be integer!");
            return;
        }
        try{
        int serialNumber = Integer.parseInt(serialNumberTxtField.getText());
        m.setSerialNumber(serialNumber);
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "serial number must be integer!");
            return;
        }
        String req = reqQuantityTxtField.getText();
        try {
           
            m.setRequiredQuantity( Integer.parseInt(req));
        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Required quantity must be integer!");
            return;
        }
       
//        ArrayList<String> medicineCheck = new ArrayList<>();
//        for(MedicalInventory mc:pharmorg.getMedList())
//        {
//            medicineCheck.add(mc.getMedicineName().toLowerCase());
//        }
//        if(medicineCheck.contains(name.toLowerCase()))
//        {
//            JOptionPane.showMessageDialog(null, "medicine already existed please update the quantity by clicking on view details");
//            return;
//        }
        pharmorg.addMedicine(m);
        m.setReorderStatus("N");

        DefaultTableModel dtm = (DefaultTableModel) reorderTable.getModel();

        dtm.setRowCount(0);
        for (MedicalInventory mi : pharmorg.getMedList()) {
            Object row[] = new Object[5];
            row[0] = mi;
            row[1] = mi.getSerialNumber();
            row[2] = mi.getAvailQuantity();
            row[3] = mi.getRequiredQuantity();
            row[4] = mi.getReorderStatus();
            dtm.addRow(row);
        }

        JOptionPane.showMessageDialog(null, "Medicine Added Successfully", "Warning", JOptionPane.INFORMATION_MESSAGE);
        log.debug("medicine added successfully");
        serialNumberTxtField.setText("");
        medicineNameTxtField.setText("");
        availQuantityTxtField.setText("");
        reqQuantityTxtField.setText("");

    }//GEN-LAST:event_addMedicineBtnActionPerformed

    private void viewDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsBtnActionPerformed
        // TODO add your handling code here:
        int row = reorderTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        MedicalInventory mi = (MedicalInventory) reorderTable.getValueAt(row, 0);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("UpdateEntryJPanel", new ViewDetailsJPanel(userProcessContainer, userAccount, enterprise, mi));
        log.debug(userAccount+" "+"entering view details page");
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewDetailsBtnActionPerformed

    private void statusCheckBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusCheckBtnActionPerformed
        // TODO add your handling code here:
        int medicinecheck=0; 
        for (MedicalInventory mi : pharmorg.getMedList()) {
            medicinecheck++;
         }
         
         if(medicinecheck<=0)
        {
            JOptionPane.showMessageDialog(null,"No medicines are present for invetory check  ");
            return;
        }
        for (MedicalInventory mi : pharmorg.getMedList()) {

            if (mi.getAvailQuantity() <= mi.getRequiredQuantity()) {
                if (!mi.getReorderStatus().equals("Y")) {
                    DrugWorkRequest request = new DrugWorkRequest();
                    
                    mi.setReorderStatus("Y");
                    request.setDrugName(mi.getMedicineName());
                    request.setQuantity(mi.getRequiredQuantity());
                    request.setSender(userAccount);

                    userAccount.getWorkQueue().getWorkRequestList().add(request);
                    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                        System.out.println("***** Organization Name:" + enterprise.getName());
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            System.out.println("***** Organization Name:" + organization.getName());
                            if (organization.getName().equals("Drug Organization")) {
                                System.out.println("True");

                                System.out.println("***** organization Name" + organization.getName());

                                organization.getWorkQueue().getWorkRequestList().add(request);
                                log.debug(userAccount+" "+"sending request to Drug Organization");
                            }
                        }

                    }

                }

            }
        }
        JOptionPane.showMessageDialog(null, "Inventory status checked and updated!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        reorderTable();
    }//GEN-LAST:event_statusCheckBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMedicineBtn;
    private javax.swing.JLabel availQuantityLbl;
    private javax.swing.JTextField availQuantityTxtField;
    private javax.swing.JTable docrequestTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel medicineNameLbl;
    private javax.swing.JTextField medicineNameTxtField;
    private javax.swing.JLabel pharmacyLbl;
    private javax.swing.JTable reorderTable;
    private javax.swing.JLabel reqQuantityLbl;
    private javax.swing.JTextField reqQuantityTxtField;
    private javax.swing.JLabel serialNumLbl;
    private javax.swing.JTextField serialNumberTxtField;
    private javax.swing.JButton statusCheckBtn;
    private javax.swing.JButton viewDetailsBtn;
    private javax.swing.JButton viewRequestsBtn;
    // End of variables declaration//GEN-END:variables
}
