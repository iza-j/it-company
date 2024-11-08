public class Skill {

    private String name;
    private Employee[] employees;

    public Skill(String name, Employee[] employees) {
        this.name = name;
        this.employees = employees;
    }

    public void checkAccess(Tool tool) {
        System.out.print("Employees skilled at ");
        System.out.print(this.name);
        System.out.print(", but without access to ");
        System.out.print(tool.getName());
        System.out.println(":");

        for (int i = 0; i < this.employees.length; i++) {
            boolean access = false;
            for (int j = 0; j < tool.getUsers().length; j++) {
                if (this.employees[i] == tool.getUsers()[j]) {
                    access = true;
                }
            }
            if (access == false) {
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