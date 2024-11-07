import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        // create employees
        Employee employee1 = new Employee("Karol Zakrętka", "Antarctica/Troll", "2002-01-09", 714.0);
        Employee employee2 = new Employee("Zofia Cętka", "US/Pacific", "2013-12-29", 301.7);
        Employee employee3 = new Employee("Michał Dętka", "Japan", "2017-07-07", 162.0);
        Employee employee4 = new Employee("Izabella Jętka", "Poland", "2024-10-28", 92.93);
        Employee employee5 = new Employee("Jakub Piętka", "Portugal", "2024-04-29", 87.21);

        // create teams
        Employee[] employees = {employee4, employee5};
        Team test_automation = new Team("Test Automation Team", employee3, employees);
        Team quality_assurance = new Team();

        // print some of employees' data
        System.out.println("");
        employee1.printTimeZone();
        System.out.println("");
        test_automation.printEmployees();
        employee2.printWorkYears();
        System.out.println("");

        //create departments
        Team[] teams = {test_automation, quality_assurance};
        Department qa_and_testing = new Department("Quality Assurance and Testing", employee2, teams);
        Department product_and_design = new Department();

        // create a company
        Department[] departments = {qa_and_testing, product_and_design};
        ITCompany resolvd = new ITCompany();
        resolvd.setName("Resolvd");
        resolvd.setCeo(employee1);
        resolvd.setDepartments(departments);

        // create a client
        Client google = new Client("Google", "Generała Józefa Bema 2, 50-265 Wrocław, Poland");

        // create a project
        BigDecimal rate = new BigDecimal(2137.9);
        Project booploop = new Project(google, 42, 0, rate);

        // create time trackers
        TimeTracker iza_booploop = new TimeTracker(employee4, booploop, 0);
        TimeTracker jakub_booploop = new TimeTracker(employee5, booploop, 0);

        // track hours spent on a project
        iza_booploop.logHours(39);
        iza_booploop.logHours(99);
        jakub_booploop.logHours(15);
        System.out.println(booploop.getPersonHours());
        System.out.println(iza_booploop.getPersonHours());
        System.out.println(jakub_booploop.getPersonHours());
        System.out.println("");

        // count project earnings
        System.out.println(booploop.getEarnings());
        System.out.println("");

        // create a tool
        Employee[] users = {employee3, employee5};
        Tool intellij = new Tool("IntelliJ IDEA Ultimate (Enterprise Edition)", users);

        // check an employee's access to a tool
        System.out.println(intellij.checkAccess(employee3));
        System.out.println(intellij.checkAccess(employee1));
        System.out.println("");

        // create a skill
        Employee[] programmers_java = {employee1, employee3, employee4, employee5};
        Skill programming_java = new Skill("Programming in Java", programmers_java);

        // check skilled employees' access to a tool
        programming_java.checkAccess(intellij);
        System.out.println("");
    }
}