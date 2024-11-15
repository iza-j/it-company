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
        System.out.print("Employees skilled at " + this.name + ", but without access to " + tool.getName() + ":\n");

        for (int i = 0; i < this.employees.length; i++) {
            boolean access = false;
            for (int j = 0; j < tool.getUsers().length; j++) {
                if (this.employees[i].equals(tool.getUsers()[j])) {
                    access = true;
                    break;
                }
            }
            if (!access) {
                System.out.println(this.employees[i].getName());
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