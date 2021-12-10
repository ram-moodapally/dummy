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
import userinterface.UserRole.UserJPanel;
/**
 *
 * @author shreyasprasad
 */
public class User extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
        return new UserJPanel(userProcessContainer, account, (WellnessPlatformOrganization)organization,enterprise,network);
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
