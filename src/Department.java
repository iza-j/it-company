public class Department {

    private String name;
    private Employee headOfDpt;
    private Team[] teams;

    public Department() {
        this.name = name;
        this.headOfDpt = headOfDpt;
        this.teams = teams;
    }

    public Department(String name, Employee headOfDpt, Team[] teams) {
        this.name = name;
        this.headOfDpt = headOfDpt;
        this.teams = teams;
    }

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    public Employee getHeadOfDpt() {
        return headOfDpt;
    }

    public void setHeadOfDpt(Employee headOfDpt) {
        this.headOfDpt = headOfDpt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}