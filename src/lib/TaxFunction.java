package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */	
    private static final int BASE_TAX_FREE_INCOME = 54_000_000;
    private static final int MARRIED_TAX_FREE_BONUS = 4_500_000;
    private static final int PER_CHILD_TAX_FREE_BONUS = 1_500_000;
    private static final double TAX_RATE = 0.05;
    private static final int MAX_CHILDREN_FOR_TAX = 3;
    private static final int MAX_MONTHS_WORKING = 12;
    
    public static int calculateTax(TaxParameter params) {
        validateMonthsWorking(params.getNumberOfMonthsWorking());
        int effectiveChildren = Math.min(params.getNumberOfChildren(), MAX_CHILDREN_FOR_TAX);
        int taxableIncome = calculateTaxableIncome(params);
        int taxFreeIncome = calculateTaxFreeIncome(params.isIsMarried(), effectiveChildren);
        
        int tax = (int) Math.round(TAX_RATE * (taxableIncome - taxFreeIncome));
        return Math.max(0, tax);
    }

    private static void validateMonthsWorking(int numberOfMonthsWorking) {
        if (numberOfMonthsWorking > MAX_MONTHS_WORKING) {
            throw new IllegalArgumentException("More than 12 months worked per year");
        }
    }

    private static int calculateTaxableIncome(TaxParameter params) {
        return ((params.getMonthlySalary() + params.getOtherMonthlyIncome()) * params.getNumberOfMonthsWorking()) - params.getDeductible();
    }

    private static int calculateTaxFreeIncome(boolean isMarried, int numberOfChildren) {
        int taxFreeIncome = BASE_TAX_FREE_INCOME;
        if (isMarried) {
            taxFreeIncome += MARRIED_TAX_FREE_BONUS;
        }
        taxFreeIncome += numberOfChildren * PER_CHILD_TAX_FREE_BONUS;
        return taxFreeIncome;
    }
}
