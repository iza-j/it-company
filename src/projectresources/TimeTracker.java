package projectresources;

import corporatestructure.Employee;
import static helpers.GlobalVariable.*;

import java.util.Objects;

public class TimeTracker {

    private Employee employee;
    private Project project;
    private Integer personHours;

    public TimeTracker(Employee employee, Project project, Integer personHours) {
        this.employee = employee;
        this.project = project;
        this.personHours = personHours;
    }

    @Override
    public int hashCode() {
        int code = multiplicand;
        code = code * multiplier + (employee != null ? employee.hashCode() : 0);
        code = code * multiplier + (project != null ? project.hashCode() : 0);
        return code;
    }

    @Override
    public boolean equals(Object compared) {
        if (compared == this) {
            return true;
        }
        if (compared == null) {
            return false;
        }
        if (this.getClass() != compared.getClass()) {
            return false;
        }
        return  Objects.equals(this.employee, ((TimeTracker) compared).getEmployee()) &&
                Objects.equals(this.project, ((TimeTracker) compared).getProject());
    }

    @Override
    public String toString() {
        return  "Time tracker of " + (this.employee == null ? "n/d" : this.employee.getName()) +
                ". Project #" + (this.project == null ? "n/d" : this.project.getProjectNo()) +
                " for " + (this.project == null ? "n/d" : this.project.getClient().getName());
    }

    public void logHours(Integer hours) {
        this.project.setPersonHours(this.project.getPersonHours() + hours);
        this.setPersonHours(this.getPersonHours() + hours);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getPersonHours() {
        return personHours;
    }

    public void setPersonHours(Integer personHours) {
        this.personHours = personHours;
    }
}