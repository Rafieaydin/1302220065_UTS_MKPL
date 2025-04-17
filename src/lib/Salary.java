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
public class Salary {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;
    private boolean isForeigner;
    
    public Salary(boolean isForeigner){
        this.isForeigner = isForeigner;
    }
    
    public void setMonthlySalary(int grade) {	
             switch (grade) {
                case 1:
                      monthlySalary = 5000000;
                       if (isForeigner) {
                           monthlySalary = (int) (3000000 * 1.5);
                       }
                case 2:
                    monthlySalary = 5000000;
                    if (isForeigner) {
                        monthlySalary = (int) (3000000 * 1.5);
                    }
                case 3:
                    monthlySalary = 7000000;
                    if (isForeigner) {
                        monthlySalary = (int) (3000000 * 1.5);
                    }
                default:
                    throw new IllegalArgumentException("Invalid grade: " + grade);
            }
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}

        public int getMonthlySalary() {
            return monthlySalary;
        }

        public int getOtherMonthlyIncome() {
            return otherMonthlyIncome;
        }

        public int getAnnualDeductible() {
            return annualDeductible;
        }
        
        
        
}
