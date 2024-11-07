public class Team {

    private String name;
    private Employee teamLeader;
    private Employee[] employees;

    public Team() {
    }

    public Team(String name, Employee teamLeader, Employee[] employees) {
        this.name = name;
        this.teamLeader = teamLeader;
        this.employees = employees;
    }

    public void printEmployees() {
        teamLeader = this.getTeamLeader();
        teamLeader.printTimeZone();
        teamLeader.printWorkYears();
        System.out.println("");
        for (int i = 0; i < this.getEmployees().length; i++) {
            Employee emp = this.getEmployees()[i];
            emp.printTimeZone();
            emp.printWorkYears();
            System.out.println("");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(Employee teamLeader) {
        this.teamLeader = teamLeader;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
}