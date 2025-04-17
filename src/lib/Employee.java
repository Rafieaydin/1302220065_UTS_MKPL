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
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	public int getAnnualIncomeTax() {
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		return TaxFunction.calculateTax(salary.getMonthlySalary(), salary.getOtherMonthlyIncome(), JoinDate.monthWorkingInYear(), salary.getAnnualDeductible(), family.getSpouseIdNumber().equals(""), family.getNumberOfChildren());
	}
}
