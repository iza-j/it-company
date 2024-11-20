package corporatestructure;

import java.util.ArrayList;

public class ITCompany implements CorporateUnit {

    private String name;
    private Employee ceo;
    private Department[] departments;

    public Employee[] getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<Employee>();

        if (this.getCeo() != null) { // if a ceo exists
            employees.add(this.getCeo());
        }

        if (this.getDepartments() != null) { // if any departments exist in the company
            for (int i = 0; i < this.getDepartments().length; i++) {
                if (this.getDepartments()[i].getAllEmployees() != null) { // if any employees exist in each department
                    for (int j = 0; j < this.getDepartments()[i].getAllEmployees().length; j++) {
                        employees.add(this.getDepartments()[i].getAllEmployees()[j]);
                    }
                }
            }
        }

        Employee[] result = new Employee[employees.size()]; // convert back to an array type
        employees.toArray(result);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public Employee getCeo() {
        return ceo;
    }

    public void setCeo(Employee ceo) {
        this.ceo = ceo;
    }
}