/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;
import Business.Role.Role;
import Business.Role.WellnessPlatformAdminRole;
import java.util.ArrayList;


/**
 *
 * @author shreyasprasad
 */
public class WellnessPlatformOrganization extends  Organization{
 
    public WellnessPlatformOrganization(){
        super(Organization.Type.WellnessPlatform.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WellnessPlatformAdminRole());
        return roles;
    }    



}


   
    
  