package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	EmployeeProfile employee;
        joinDate JoinDate;
        Salary salary;
	FamilyDetails family;
	
	public Employee(EmployeeProfile employee, joinDate date, FamilyDetails family) {
		this.employee = employee;
                this.JoinDate = date;
                this.family = family;
	}
	
	public int getAnnualIncomeTax() {
		return TaxFunction.calculateTax(salary.getMonthlySalary(), salary.getOtherMonthlyIncome(), JoinDate.monthWorkingInYear(), salary.getAnnualDeductible(), family.getSpouseIdNumber().equals(""), family.getNumberOfChildren());
	}
}
