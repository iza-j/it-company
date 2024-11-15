import corporatestructure.*;
import outsideentities.*;
import projectresources.*;
import techstack.*;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        // create employees
        Employee employee1 = new Employee(1, "Karol Zakrętka", "Antarctica/Troll", "2002-01-09", 714.0);
        Employee employee2 = new Employee(2, "Zofia Cętka", "US/Pacific", "2013-12-29", 301.7);
        Employee employee3 = new Employee(3, "Michał Dętka", "Japan", "2017-07-07", 162.0);
        Employee employee4 = new Employee(4, "Izabella Jętka", "Poland", "2024-10-28", 92.93);
        Employee employee5 = new Employee(5, "Jakub Piętka", "Portugal", "2024-04-29", 87.21);
        Employee employee6 = new Employee(6, "Jakub Piętka", "Poland", "2024-04-29", 87.21);

        // create teams
        Employee[] employees = {employee4, employee5};
        Team testAutomation = new Team("Test Automation", employee3, employees);
        Team qualityAssurance = new Team();

        // print some of employees' data
        System.out.println(" ");
        employee1.printTimeZone();
        System.out.println(" ");
        testAutomation.printEmployees();
        employee2.printWorkYears();
        System.out.println(" ");

        //create departments
        Team[] teams = {testAutomation, qualityAssurance};
        Department qaAndTesting = new Department("Quality Assurance and Testing", employee2, teams);
        Department productAndDesign = new Department();

        // create a company
        Department[] departments = {qaAndTesting, productAndDesign};
        ITCompany resolvd = new ITCompany();
        resolvd.setName("Resolvd");
        resolvd.setCeo(employee1);
        resolvd.setDepartments(departments);

        // create a client
        Client google = new Client("Google", "Generała Józefa Bema 2, 50-265 Wrocław, Poland");

        // create a project
        BigDecimal rate = new BigDecimal(2137.9);
        Project boopLoop = new Project(google, 42, 0, rate);

        // create time trackers
        TimeTracker izaBoopLoop = new TimeTracker(employee4, boopLoop, 0);
        TimeTracker jakubBoopLoop = new TimeTracker(employee5, boopLoop, 0);

        // track hours spent on a project
        izaBoopLoop.logHours(39);
        izaBoopLoop.logHours(99);
        jakubBoopLoop.logHours(15);
        System.out.println(boopLoop.getPersonHours());
        System.out.println(izaBoopLoop.getPersonHours());
        System.out.println(jakubBoopLoop.getPersonHours() + "\n");

        // count project earnings
        System.out.println(boopLoop.getEarnings() + "\n");

        // create a tool
        Tool intellij = new Tool("IntelliJ IDEA Ultimate (Enterprise Edition)", new Employee[]{employee3, employee5});

        // check an employee's access to a tool
        System.out.println(intellij.checkAccess(employee3));
        System.out.println(intellij.checkAccess(employee1) + "\n");

        // create a skill
        Employee[] javaProgrammers = {employee1, employee3, employee4, employee5};
        Skill programmingJava = new Skill("Programming in Java", javaProgrammers);

        // check skilled employees' access to a tool
        programmingJava.printAccess(intellij);
        System.out.println(" ");

        // print employees' hash codes
        Employee[] employeeList = {employee1, employee2, employee3, employee4, employee5, employee6};
        for (int i = 0; i < employeeList.length; i++) {
            Employee e = employeeList[i];
            System.out.println(e.hashCode());
        }
        System.out.println(" ");

        // print toString's output for all employees
        for (int i = 0; i < employeeList.length; i++) {
            Employee e = employeeList[i];
            System.out.println(e.toString());
        }
        System.out.println(" ");

        // compare all employees to employee6
        for (int i = 0; i < employeeList.length; i++) {
            Employee e = employeeList[i];
            System.out.println(e.equals(employee6));
        }
        System.out.println(" ");

        // you can find comments about overriding in the Employee class

        // create service providers and call them
        Provider inea = new InternetServiceProvider("Inea", "112", "Poland");
        Provider jetBrains = new SoftwareVendor("JetBrains", "987123654", new Tool[]{intellij});
        inea.phoneCall();
        jetBrains.phoneCall();

        // create a committe & a taskforce, then print their descriptions
        Team dei = new Committee("Diversity Equity and Inclusion", employee2, new Employee[]{employee3, employee4});
        Team christmasParty = new TaskForce("Christmas Party Organizers", employee4, new Employee[]{employee2, employee5});
        dei.printDescription();
        christmasParty.printDescription();
        testAutomation.printDescription();
    }
}