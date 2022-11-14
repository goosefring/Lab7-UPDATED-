package ca.sait.services;

import ca.sait.dataaccess.RoleDB;
import java.util.List;
import models.Role;

/**
 *
 * @author Rehan Bhatti
 */
public class RoleService {
    
    public List<Role> getAll() throws Exception {
        
        RoleDB roleDB = new RoleDB();
        
        List<Role> roles = roleDB.getAll();
        
        return roles;
    }
}
