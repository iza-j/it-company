package corporatestructure;

import projectresources.*;
import static helpers.Formatter.*;
import static helpers.GlobalVariable.*;

import java.util.ArrayList;
import java.util.Objects;

public class Team implements CorporateUnit, TaskOwner, Stakeholder, SpaceRequester {

    protected String name;
    protected Employee leader;
    protected Employee[] employees;

    public Team() {
    }

    public Team(String name, Employee leader, Employee[] employees) {
        this.name = name;
        this.leader = leader;
        this.employees = employees;
    }

    @Override
    public int hashCode() {
        int code = MULTIPLICAND;
        code = code * MULTIPLIER + (name != null ? name.hashCode() : 0);
        code = code * MULTIPLIER + (leader != null ? leader.hashCode() : 0);
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
        return  Objects.equals(this.name, ((Team) compared).getName()) &&
                Objects.equals(this.leader, ((Team) compared).getLeader());
    }

    @Override
    public String toString() {
        return  "Team " + (this.name == null ? "n/d" : this.name) +
                ", led by " + (this.leader == null ? "n/d" : this.leader.getName());
    }

    public void printDescription() {
        if ((this.name != null) && (this.leader != null) && (this.employees != null)) {
            System.out.print(this.leader.getName() + " is in charge of " + this.getName() + ". ");
            for (int i = 0; i < this.employees.length; i++) {
                if (i != 0) {
                    System.out.print(", ");
                }
                System.out.print(employees[i].getName());
            }
        }
        System.out.print(" work alongside them.\n");
    }

    public void printEmployees() {
        leader = this.getLeader();
        leader.printTimeZone();
        leader.printWorkYears();
        System.out.println(" ");
        for (int i = 0; i < this.getEmployees().length; i++) {
            Employee emp = this.getEmployees()[i];
            emp.printTimeZone();
            emp.printWorkYears();
            System.out.println(" ");
        }
    }

    @Override
    public final Employee[] getAllEmployees() { // final method can't be overridden by a subclass
        ArrayList<Employee> employees = new ArrayList<Employee>();

        if (this.getLeader() != null) { // if a team leader exists
            employees.add(this.getLeader());
        }

        if (this.getEmployees() != null) { // if any employees exist
            for (int i = 0; i < this.getEmployees().length; i++) {
                employees.add(this.getEmployees()[i] );
            }
        }

        Employee[] result = new Employee[employees.size()]; // convert back to an array type
        employees.toArray(result);
        return result;
    }

    @Override
    public void finishTask(Task task){
        task.setStatus("finished");

        System.out.println(ansiColor(cyanFG) + "Task:\n" + ansiColor(reset) + task.getDescription());
        System.out.println(ansiColor(cyanFG) + "Stakeholders:" + ansiColor(reset));
        for (Stakeholder stakeholder : task.getStakeholders()) {
            System.out.println(stakeholder.getName());
        }
        System.out.println(ansiColor(cyanFG) + "Finished by:\n" + ansiColor(reset) + this.getName());
    }

    @Override
    public void requestSpace() {
        System.out.println("Your request has been approved! You booked " + this.getAllEmployees().length + " desk(s) for " + this.getName());
    };

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
}