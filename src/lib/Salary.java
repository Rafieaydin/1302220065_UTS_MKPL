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
    
    private static final int GRADE_1_SALARY = 3_000_000;
    private static final int GRADE_2_SALARY = 5_000_000;
    private static final int GRADE_3_SALARY = 7_000_000;
    private static final double FOREIGNER_BONUS_MULTIPLIER = 1.5;
    
    public Salary(boolean isForeigner){
        this.isForeigner = isForeigner;
    }
    

	private int determineBaseSalary(int grade) {
            switch (grade) {
                case 1:
                    return GRADE_1_SALARY;
                case 2:
                    return GRADE_2_SALARY;
                case 3:
                    return GRADE_3_SALARY;
                default:
                    throw new IllegalArgumentException("Invalid grade: " + grade);
            }
        }
        
        private int applyForeignerBonus(int baseSalary) {
            return (int) (baseSalary * FOREIGNER_BONUS_MULTIPLIER);
        }
        
        public void setMonthlySalary(int grade) {	
            monthlySalary = this.determineBaseSalary(grade);
             if (isForeigner) {
                 monthlySalary = this.applyForeignerBonus(monthlySalary);
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
