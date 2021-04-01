
package Objects;


public class EmployeeIdentity {
    
    private String Employee_Id;
    private String Employee_Fname;
    private String Employee_Lname;

    public EmployeeIdentity(String Employee_Id, String Employee_Fname, String Employee_Lname) {
        this.Employee_Id = Employee_Id;
        this.Employee_Fname = Employee_Fname;
        this.Employee_Lname = Employee_Lname;
    }

    public String getEmployee_Id() {
        return Employee_Id;
    }

    public String getEmployee_Fname() {
        return Employee_Fname;
    }

    public String getEmployee_Lname() {
        return Employee_Lname;
    }

    public void setEmployee_Id(String Employee_Id) {
        this.Employee_Id = Employee_Id;
    }

    public void setEmployee_Fname(String Employee_Fname) {
        this.Employee_Fname = Employee_Fname;
    }

    public void setEmployee_Lname(String Employee_Lname) {
        this.Employee_Lname = Employee_Lname;
    }
    
    
    
}
