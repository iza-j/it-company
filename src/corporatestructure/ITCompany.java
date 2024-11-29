package corporatestructure;

import java.util.ArrayList;
import java.util.Collections;

public class ITCompany implements CorporateUnit {

    private String name;
    private Employee ceo;
    private Department[] departments;

    @Override
    public Employee[] getAllEmployees() {
        ArrayList<Employee> companyEmployees = new ArrayList<>();

        if (this.getCeo() != null) { // if a ceo exists
            companyEmployees.add(this.getCeo());
        }

        if (this.getDepartments() != null) { // if any departments exist in the company
            for (Department department : this.getDepartments()) {
                Collections.addAll(companyEmployees, department.getAllEmployees());
            }
        }

        Employee[] result = new Employee[companyEmployees.size()]; // convert back to an array type
        companyEmployees.toArray(result);
        return result;
    }

    @Override
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