package techstack;

import corporatestructure.Employee;

public class Skill {

    private String name;
    private Employee[] employees;

    public Skill(String name, Employee[] employees) {
        this.name = name;
        this.employees = employees;
    }

    public void printAccess(Tool tool) {
        System.out.print(new StringBuilder()
                .append("Employees skilled at ")
                .append(this.name)
                .append(", but without access to ")
                .append(tool.getName())
                .append(":\n"));

        for (Employee employee : this.getEmployees()) {
            boolean access = false;
            for (Employee toolUser : tool.getEmployees()) {
                if (employee.equals(toolUser)) {
                    access = true;
                    break;
                }
            }
            if (!access) {
                System.out.println(employee.getName());
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
}