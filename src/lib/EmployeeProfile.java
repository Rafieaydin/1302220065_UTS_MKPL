/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

/**
 *
 * @author LOQ
 */
public class EmployeeProfile {
    private final String employeeId;
    private final String firstName;
    private final String lastName;
    private final String idNumber;
    private final String address;
    private final String gender;
    

    public EmployeeProfile(String employeeId, String firstName, String lastName, String idNumber, String address, String gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.gender = gender;
    }

    // Getter untuk setiap field
    public String getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getIdNumber() { return idNumber; }
    public String getAddress() { return address; }
    public String getGender() { return gender; }
}
