package projectresources;

public class Task {

    private String description;
    private TaskOwner owner;
    private Stakeholder[] stakeholders;
    private String status;

    public Task(String description, TaskOwner owner, Stakeholder[] stakeholders, String status) {
        this.description = description;
        this.owner = owner;
        this.stakeholders = stakeholders;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskOwner getOwner() {
        return owner;
    }

    public void setOwner(TaskOwner owner) {
        this.owner = owner;
    }

    public Stakeholder[] getStakeholders() {
        return stakeholders;
    }

    public void setStakeholders(Stakeholder[] stakeholders) {
        this.stakeholders = stakeholders;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}