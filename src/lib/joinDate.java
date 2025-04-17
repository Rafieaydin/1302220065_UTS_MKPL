package lib;

import java.time.LocalDate;
public class joinDate {
    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private int monthWorkingInYear;
    
    public joinDate(int yearJoined, int monthJoined, int dayJoined){
        this.yearJoined = yearJoined;
	this.monthJoined = monthJoined;
	this.dayJoined = dayJoined;
    }
    
    public int getYearJoined() {
        return yearJoined;
    }

    public int getMonthJoined() {
        return monthJoined;
    }

    public int getDayJoined() {
        return dayJoined;
    }


    public int monthWorkingInYear(){
        LocalDate date = LocalDate.now();
		
	if (date.getYear() == yearJoined) {
            monthWorkingInYear = date.getMonthValue() - monthJoined;
	}else {
            monthWorkingInYear = 12;
	}
        return monthWorkingInYear;
    }
    
    
}
