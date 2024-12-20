package projectresources;

import outsideentities.Client;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Project {

    private Client client;
    private int projectNo;
    private Integer personHours;
    private BigDecimal hourlyRate;

    public Project(Client client, int projectNo, Integer personHours, BigDecimal hourlyRate) {
        this.client = client;
        this.projectNo = projectNo;
        this.personHours = personHours;
        this.hourlyRate = hourlyRate;
    }

    public BigDecimal getEarnings() {
        BigDecimal h = new BigDecimal(this.getPersonHours());
        BigDecimal earnings = hourlyRate.multiply(h);
        return earnings.setScale(2, RoundingMode.DOWN);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public Integer getPersonHours() {
        return personHours;
    }

    public void setPersonHours(Integer personHours) {
        this.personHours = personHours;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}