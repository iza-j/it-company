package techstack;

import corporatestructure.Employee;

public class Tool {

    private String name;
    private Employee[] employees;

    public Tool() {
    }

    public Tool(String name, Employee[] employees) {
        this.name = name;
        this.employees = employees;
    }

    public boolean checkAccess(Employee employee) {
        boolean access = false;
        for (Employee employeeWithAccess : this.employees) {
            if (employee.equals(employeeWithAccess)) {
                access = true;
                break;
            }
        }
        return access;
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