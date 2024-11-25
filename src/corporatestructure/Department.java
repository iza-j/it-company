package corporatestructure;

import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<Employee> departmentEmployees = new ArrayList<Employee>();

        if (this.getHeadOfDpt() != null) { // if a head of department exists
            departmentEmployees.add(this.getHeadOfDpt());
        }

        if (this.getTeams() != null) { // if any teams exist in the department
            for (Team team : this.getTeams()) {
                Collections.addAll(departmentEmployees, team.getAllEmployees());
            }
        }

        Employee[] result = new Employee[departmentEmployees.size()]; // convert back to an array type
        departmentEmployees.toArray(result);
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