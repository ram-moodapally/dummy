/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.WellnessPlatformAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import Business.Organization.WellnessPlatformOrganization;
import org.apache.log4j.Logger;
/**
 *
 * @author shreyasprasad
 */
public class WellnessPlatformAdminWorkAreaJPanel extends javax.swing.JPanel {

    
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private  WellnessPlatformOrganization wellnessPlatformOrganization;
    private Network network;
    private Enterprise enterprise;
    private static Logger log = Logger.getLogger(WellnessPlatformAdminWorkAreaJPanel.class);
    private static final String CLASS_NAME = WellnessPlatformAdminWorkAreaJPanel.class.getName();
    /**
     * Creates new form WellnessPlatformAdminWorkAreaJPanel
     */
    public WellnessPlatformAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.business = business;
        this.wellnessPlatformOrganization = (WellnessPlatformOrganization) organization;
        this.enterprise = enterprise;
        this.network = network;
        log.debug(userAccount+" "+"logged in");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
