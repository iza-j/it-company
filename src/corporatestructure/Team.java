package corporatestructure;

public class Team {

    protected String name;
    protected Employee leader;
    protected Employee[] employees;

    public Team() {
    }

    public Team(String name, Employee leader, Employee[] employees) {
        this.name = name;
        this.leader = leader;
        this.employees = employees;
    }

    public void printDescription() {
        if ((this.name != null) && (this.leader != null) && (this.employees != null)) {
            System.out.print(this.leader.getName() + " is in charge of " + this.getName() + ". ");
            for (int i = 0; i < this.employees.length; i++) {
                if (i != 0) {
                    System.out.print(", ");
                }
                System.out.print(employees[i].getName());
            }
        }
        System.out.print(" work alongside her.\n");
    }

    public void printEmployees() {
        leader = this.getLeader();
        leader.printTimeZone();
        leader.printWorkYears();
        System.out.println(" ");
        for (int i = 0; i < this.getEmployees().length; i++) {
            Employee emp = this.getEmployees()[i];
            emp.printTimeZone();
            emp.printWorkYears();
            System.out.println(" ");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
}