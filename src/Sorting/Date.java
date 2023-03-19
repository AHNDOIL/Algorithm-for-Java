package Sorting;

public class Date implements Comparable<Date> {

    private final int month;
    private final int day;
    private final int year;

    public Date(int month, int day, int year){
        //if(!isValid(month, day, year)) throw new IllegalArgumentException("Invalid date");
        this.month = month;
        this.day = day;
        this.year = year;
    }



    public int compareTo(Date that) { // 비교기준 확립
        if (this.year < that.year) return -1;
        if (this.year > that.year) return +1;
        if (this.month < that.month) return -1;
        if (this.month > that.month) return +1;
        if (this.day < that.day) return -1;
        if (this.day > that.day) return +1;
        return 0;
}
}
