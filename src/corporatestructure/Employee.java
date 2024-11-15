package corporatestructure;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private String timeZone; // https://mkyong.com/java8/java-display-all-zoneid-and-its-utc-offset/
    private String firstDay;
    private Double hourlyWage;

    public Employee(int id, String name, String timeZone, String firstDay, Double hourlyWage) {
        this.id = id;
        this.name = name;
        this.timeZone = timeZone;
        this.firstDay = firstDay;
        this.hourlyWage = hourlyWage;
    }

    @Override
    public int hashCode() { // a manual override
        int code = 17; // using prime numbers bc of a reason that i don't understand (yet)
        code = code * 31 + id; // int's default value can't be null, so no conditions in this line
        code = code * 31 + (name != null ? name.hashCode() : 0); // ternary conditional operator (inline if)
        code = code * 31 + (firstDay != null ? firstDay.hashCode() : 0); // (a ? b : c) == (if a then b otherwise c)
        return code; // id should be unique, but someone's id could be entered incorrectly. but then it's rather impossible to have id and name and firstDay identical to another employee
    }

    @Override
    public boolean equals(Object compared) { // type of the equals method is Object. if i tried to use another type, it would become overloading instead of overriding
        if (compared == this) { // check whether we're trying to compare the object to itself
            return true;
        }
        if (compared == null) { // if i used a null reference, i'd get a NullPointerException (not good)
            return false;
        }
        if (this.getClass() != compared.getClass()) { // if i tried to compare objects from 2 different classes i'd get a ClassCastException (also not good)
            return false;
        }
        return  this.id == ((Employee) compared).getID()
                && Objects.equals(this.name, ((Employee) compared).getName())
                && Objects.equals(this.firstDay, ((Employee) compared).getFirstDay()); // returns value of && statement
    }

    @Override
    public String toString() {
        return  "Employee #" + id + ": " +
                (this.name == null ? "n/d" : this.name) +
                ". Working since " +
                (this.firstDay == null ? "n/d" : this.firstDay);
    }

    public void printTimeZone() {
        DateTimeFormatter form = DateTimeFormatter.ofPattern("HH:mm, MMMM d");

        System.out.print(this.name + "'s time zone is " + ZoneId.of(this.timeZone));
        System.out.print(". It's " + LocalDateTime.now(ZoneId.of(this.timeZone)).format(form) + " in there.\n");
    }

    public void printWorkYears() {
        LocalDate start = LocalDate.parse(this.firstDay);
        Period period = Period.between(start, LocalDate.now());

        System.out.print(this.name + " has been working with us since " + start + ". That's ");
        if (period.toTotalMonths()>12) {
            System.out.print(period.getYears() + " year(s) and ");
        } if (period.toTotalMonths()>0) {
            System.out.print(period.getMonths() + " month(s)!\n");
        } else {
            System.out.print(period.getDays() + " day(s)!\n");
        }
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(String firstDay) {
        this.firstDay = firstDay;
    }

    public Double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}