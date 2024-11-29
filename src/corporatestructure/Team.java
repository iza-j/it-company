package corporatestructure;

import exceptions.*;
import projectresources.*;
import static helpers.Formatter.*;
import static helpers.GlobalVariable.*;

import java.util.*;

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
        return  new StringBuilder()
                .append("Team ")
                .append(this.name == null ? "n/d" : this.name)
                .append(", led by ")
                .append(this.leader == null ? "n/d" : this.leader.getName())
                .toString();
    }

    public void printDescription() {
        if ((this.name != null) && (this.leader != null) && (this.employees != null)) {
            System.out.print(new StringBuilder()
                    .append(this.leader.getName())
                    .append(" is in charge of ")
                    .append(this.getName())
                    .append(". "));
            for (int i = 0; i < this.employees.length; i++) {
                if (i != 0) {
                    System.out.print(", ");
                }
                System.out.print(employees[i].getName());
            }
            System.out.print(" work alongside them.\n");
        }
    }

    public void printEmployeesDescription() {
        if (this.getAllEmployees().length == 0) {
            throw new EmptyListException("You can't print employees' description. There are 0 people in this team.");
        } else {
            for (Employee employee : this.getAllEmployees()) {
                employee.printTimeZone();
                employee.printWorkYears();
                System.out.println();
            }
        }
    }

    @Override
    public final Employee[] getAllEmployees() { // final method can't be overridden by a subclass
        ArrayList<Employee> teamEmployees = new ArrayList<>();

        if (this.getLeader() != null) { // if a team leader exists
            teamEmployees.add(this.getLeader());
        }

        if (this.getEmployees() != null) { // if any employees exist
            Collections.addAll(teamEmployees, this.getEmployees());
        }

        Employee[] result = new Employee[teamEmployees.size()]; // convert back to an array type
        teamEmployees.toArray(result);
        return result;
    }

    @Override
    public void finishTask(Task task){
        task.setStatus("finished");

        System.out.println(new StringBuilder()
                .append(ansiColor(cyanFG))
                .append("Task:\n")
                .append(ansiColor(reset))
                .append(task.getDescription())
                .append("\n")
                .append(ansiColor(cyanFG))
                .append("Stakeholders:")
                .append(ansiColor(reset)));
        for (Stakeholder stakeholder : task.getStakeholders()) {
            System.out.println(stakeholder.getName());
        }
        System.out.println(new StringBuilder()
                .append(ansiColor(cyanFG))
                .append("Finished by:\n")
                .append(ansiColor(reset))
                .append(this.getName()));
    }

    @Override
    public void requestSpace() {
        System.out.println(new StringBuilder()
                .append("Your request has been approved! You booked ")
                .append(this.getAllEmployees().length)
                .append(" desk(s) for ")
                .append(this.getName()));
    }

    public void addEmployee(Employee employee) throws ObjectAlreadyIncludedException {
        if (employee.checkAffiliation(this)) {
            throw new ObjectAlreadyIncludedException(employee.getName() + " is already on the team, so you can't add them.");

        } else {
            ArrayList<Employee> newList = new ArrayList<>(); // add everyone to a new ArrayList
            Collections.addAll(newList, this.getEmployees());
            Collections.addAll(newList, employee);

            Employee[] result = new Employee[newList.size()]; // convert back to array and setEmployees
            newList.toArray(result);
            this.setEmployees(result);

            System.out.println(employee.getName() + " added successfully! "); // print success message
            this.printDescription();
        }
    }

    public void removeEmployee(Employee removedEmployee) throws ObjectNotIncludedException {
        if (!removedEmployee.checkAffiliation(this)) {
            throw new ObjectNotIncludedException(removedEmployee.getName() + " is not on the team, so you can't remove them.");

        } else {
            if (removedEmployee == this.getLeader()) {
                this.setLeader(null);

            } else {
                ArrayList<Employee> newList = new ArrayList<>();
                for (Employee oldEmployee : this.getEmployees()) {
                    if (oldEmployee != removedEmployee) {
                        Collections.addAll(newList, oldEmployee);
                    }
                }
                Employee[] result = new Employee[newList.size()]; // convert back to array and setEmployees
                newList.toArray(result);
                this.setEmployees(result);
            }

            System.out.println(removedEmployee.getName() + " removed successfully! "); // print success message
            this.printDescription();
        }
    }

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