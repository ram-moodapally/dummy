/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.WellnessPlatformOrganization;
import Business.UserAccount.UserAccount;
import userinterface.LabAssistantRole.LabAssistantWorkAreaJPanel;
import javax.swing.JPanel;
import userinterface.WellnessPlatformAdminRole.WellnessPlatformAdminWorkAreaJPanel;
/**
 *
 * @author shreyasprasad
 */
public class WellnessPlatformAdminRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
        return new WellnessPlatformAdminWorkAreaJPanel(userProcessContainer,account,(WellnessPlatformOrganization)organization,enterprise,business,network);
    }
    
    
}


//package Business.Role;
//
//import Business.EcoSystem;
//import Business.Enterprise.Enterprise;
//import Business.Network.Network;
//import Business.Organization.LabOrganization;
//import Business.Organization.Organization;
//import Business.UserAccount.UserAccount;
//import userinterface.LabAssistantRole.LabAssistantWorkAreaJPanel;
//import javax.swing.JPanel;
//
///**
// *
// * @author raunak
// */
//public class LabRole extends Role {
//
//    @Override
//    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
//        return new LabAssistantWorkAreaJPanel(userProcessContainer,account,(LabOrganization)organization,enterprise,business,network);
//    }
//    
//}
