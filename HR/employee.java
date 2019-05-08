package HR;

import java.util.Comparator;


//Class creates and initialises variables for employee arraylist. as well as setting functions, getter and setters throughout the program.

public class employee implements Comparable<employee> {
    public int employeeID;
    public String employeefirstName;
    public String employeelastName;
    public int employeeDateOfBirth;
    public String employeeAddress1;
    public String employeeTownCity;
    public String employeeCounty;
    public String employeePostCode;
    public String employeeContactNumber;
    public String employeeEmailAddress;
    public String employeePosition;
    public int employeeStartDate;

    public employee(int id, String firstName, String lastName, int dateOfBirth, String address1, String townCity,
                    String county, String postCode, String contactNumber, String emailAddress, String position, int startDate) {
        employeeID = id;
        employeefirstName = firstName;
        employeelastName = lastName;
        employeeDateOfBirth = dateOfBirth;
        employeeAddress1 = address1;
        employeeTownCity = townCity;
        employeeCounty = county;
        employeePostCode = postCode;
        employeeContactNumber = contactNumber;
        employeeEmailAddress = emailAddress;
        employeePosition = position;
        employeeStartDate = startDate;

    }



    @Override
    public String toString() { //This override allows printing of entire list in manager class.
        return "Employee Id: " + this.getEmployeeID() +
                "Name: " + this.getEmployeefirstName()+" "+this.getEmployeelastName()
        +"Address: " + this.getEmployeeAddress1()+ " "+ this.getEmployeeTownCity()+ " " +this.getEmployeeCounty()+
                " " +this.getEmployeePostCode()+ " Contact details: " + this.getEmployeeContactNumber()+ " " +
                 this.getEmployeeEmailAddress()+ " "+ "Employee details: " + this.getEmployeePosition();

    }

    public int getEmployeeID() {
        return employeeID;
    } //getters for all variables

    public String getEmployeefirstName() {
        return employeefirstName;
    }

    public String getEmployeelastName() {
        return employeelastName;
    }

    public int getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public String getEmployeeAddress1() {
        return employeeAddress1;
    }

    public String getEmployeeTownCity() {
        return employeeTownCity;
    }

    public String getEmployeeCounty() {
        return employeeCounty;
    }

    public String getEmployeePostCode() {
        return employeePostCode;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public String getEmployeeEmailAddress() {
        return employeeEmailAddress;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public int getEmployeeStartDate() {
        return employeeStartDate;
    }

    public boolean findDetails(int id) {

        return (id == this.employeeID);

    }


    public employee(int employeeID) {
        this.employeeID = employeeID;
    } //setters for all variables

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setEmployeefirstName(String employeefirstName) {
        this.employeefirstName = employeefirstName;
    }

    public void setEmployeelastName(String employeelastName) {
        this.employeelastName = employeelastName;
    }

    public void setEmployeeDateOfBirth(int employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public void setEmployeeAddress1(String employeeAddress1) {
        this.employeeAddress1 = employeeAddress1;
    }

    public void setEmployeeTownCity(String employeeTownCity) {
        this.employeeTownCity = employeeTownCity;
    }

    public void setEmployeeCounty(String employeeCounty) {
        this.employeeCounty = employeeCounty;
    }

    public void setEmployeePostCode(String employeePostCode) {
        this.employeePostCode = employeePostCode;
    }

    public void setEmployeeContactNumber(String employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public void setEmployeeEmailAddress(String employeeEmailAddress) {
        this.employeeEmailAddress = employeeEmailAddress;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public void setEmployeeStartDate(int employeeStartDate) {
        this.employeeStartDate = employeeStartDate;
    }

    public String getAllStrings() {

        return employeefirstName;



    }

    @Override
        public int compareTo (employee e){

            String name = e.employeefirstName;
            return this.employeefirstName.compareTo(name);
        }

        public static Comparator<employee> employeeComparator = new Comparator<employee>() {
            @Override
            public int compare(employee e1, employee e2) {
                String author1 = e1.employeefirstName.toUpperCase();
                String author2 = e2.employeelastName.toUpperCase();
                return author1.compareTo(author2);

            }

        };

    }

