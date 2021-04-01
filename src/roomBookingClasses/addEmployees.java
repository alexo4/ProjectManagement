
package roomBookingClasses;

import Objects.EmployeeIdentity;
import java.util.ArrayList;
import static libraryFunctions.repository.getAllNames;


public class addEmployees {
    
    public static ArrayList<EmployeeIdentity> searchEmployees(String employeeNameSearch){
        
        ArrayList<EmployeeIdentity> allNames = getAllNames();
        ArrayList<EmployeeIdentity> namesFound = new ArrayList();
        
        
        for (int i = 0; i < allNames.size(); i++) {
            if(allNames.get(i).getEmployee_Fname().toLowerCase().contains(employeeNameSearch.toLowerCase())){
                namesFound.add(allNames.get(i));
                                
            }else if(allNames.get(i).getEmployee_Lname().toLowerCase().contains(employeeNameSearch.toLowerCase())){
                namesFound.add(allNames.get(i));
            }
        }
        return namesFound;
    }
    
}
