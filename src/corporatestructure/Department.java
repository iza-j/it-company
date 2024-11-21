package corporatestructure;

import java.util.ArrayList;

public class Department implements CorporateUnit {

    private String name;
    private Employee headOfDpt;
    private Team[] teams;

    public Department() {
    }

    public Department(String name, Employee headOfDpt, Team[] teams) {
        this.name = name;
        this.headOfDpt = headOfDpt;
        this.teams = teams;
    }

    @Override
    public Employee[] getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<Employee>();

        if (this.getHeadOfDpt() != null) { // if a head of department exists
            employees.add(this.getHeadOfDpt());
        }

        if (this.getTeams() != null) { // if any teams exist in the department
            for (int i = 0; i < this.getTeams().length; i++) {
                if (this.getTeams()[i].getAllEmployees() != null) { // if any employees exist in each team
                    for (int j = 0; j < this.getTeams()[i].getAllEmployees().length; j++) {
                        employees.add(this.getTeams()[i].getAllEmployees()[j]);
                    }
                }
            }
        }

        Employee[] result = new Employee[employees.size()]; // convert back to an array type
        employees.toArray(result);
        return result;
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

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}