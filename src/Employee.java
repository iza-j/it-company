import java.time.*;
import java.time.format.DateTimeFormatter;

public class Employee {

    private String name;
    private String timeZone; // https://mkyong.com/java8/java-display-all-zoneid-and-its-utc-offset/
    private String firstDay;
    private Double hourlyWage;

    public Employee(String name, String timeZone, String firstDay, Double hourlyWage) {
        this.name = name;
        this.timeZone = timeZone;
        this.firstDay = firstDay;
        this.hourlyWage = hourlyWage;
    }

    public void printTimeZone() {

        DateTimeFormatter form = DateTimeFormatter.ofPattern("HH:mm, MMMM d");

        System.out.print(this.name);
        System.out.print("'s time zone is ");
        System.out.print(ZoneId.of(this.timeZone));
        System.out.print(". It's ");
        System.out.print(LocalDateTime.now(ZoneId.of(this.timeZone)).format(form));
        System.out.println(" in there.");
    }

    public void printWorkYears() {

        LocalDate start = LocalDate.parse(this.firstDay);
        Period period = Period.between(start, LocalDate.now());

        System.out.print(this.name);
        System.out.print(" has been working with us since ");
        System.out.print(start);

        System.out.print(". That's ");
        if (period.toTotalMonths()>12) {
            System.out.print(period.getYears());
            System.out.print(" year(s) and ");
        } if (period.toTotalMonths()>0) {
            System.out.print(period.getMonths());
            System.out.println(" month(s)!");
        } else {
            System.out.print(period.getDays());
            System.out.println(" day(s)!");
        }
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