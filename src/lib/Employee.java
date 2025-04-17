package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	EmployeeProfile employee;
        joinDate JoinDate;
	private boolean gender; //true = Laki-laki, false = Perempuan
        Salary salary;
	
	private String spouseName;
	private String spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(EmployeeProfile employee, joinDate date, String address, boolean gender) {
		this.employee = employee;
                this.JoinDate = date;
		this.gender = gender;
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	
	public void setSpouse(String spouseName, String spouseIdNumber, EmployeeProfile employee) {
		this.spouseName = spouseName;
		this.spouseIdNumber = employee.getIdNumber();
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		return TaxFunction.calculateTax(salary.getMonthlySalary(), salary.getOtherMonthlyIncome(), JoinDate.monthWorkingInYear(), salary.getAnnualDeductible(), spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
