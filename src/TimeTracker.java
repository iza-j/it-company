public class TimeTracker {

    private Employee employee;
    private Project project;
    private Integer personHours;

    public TimeTracker(Employee employee, Project project, Integer personHours) {
        this.employee = employee;
        this.project = project;
        this.personHours = personHours;
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