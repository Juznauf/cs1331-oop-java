import java.util.Date;

public class Employee {
    private String name;
    private Date hireDate;

    public Employee(String aName, Date aHireDate) {
        // disallowNullArguments(aName, aHireDate);
        name = aName;
        hireDate = aHireDate;
    }
    public String getName() {
        return name;
        }
    public Date getHireDate() {
        return hireDate;
        } // and toString(), etc. ...
}