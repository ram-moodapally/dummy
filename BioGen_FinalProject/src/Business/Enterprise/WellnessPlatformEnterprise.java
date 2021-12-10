/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author shreyasprasad
 */
public class WellnessPlatformEnterprise extends Enterprise{
 
    public WellnessPlatformEnterprise(String name){
    super(name,EnterpriseType.WellnessPlatform);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    
}
