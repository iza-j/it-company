package techstack;

import corporatestructure.Employee;

public class Tool {

    private String name;
    private Employee[] users;

    public Tool(String name, Employee[] users) {
        this.name = name;
        this.users = users;
    }

    public boolean checkAccess(Employee employee) {
        boolean access = false;
        for (int i = 0; i < this.users.length; i++) {
            if (employee == this.users[i]) {
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

    public Employee[] getUsers() {
        return users;
    }

    public void setUsers(Employee[] users) {
        this.users = users;
    }
}