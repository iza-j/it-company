package corporatestructure;

public class Committee extends Team {

    public Committee(String name, Employee leader, Employee[] employees) {
        this.name = name;
        this.leader = leader;
        this.employees = employees;
    }

    @Override
    public void printDescription() {
        if ((this.name != null) && (this.leader != null) && (this.employees != null)) {
            System.out.print(new StringBuilder()
                    .append(this.leader.getName())
                    .append(" is the head of ")
                    .append(this.getName())
                    .append(" committee. Other members include "));
            for (int i = 0; i < this.employees.length; i++) {
                if (i != 0) {
                    System.out.print(", ");
                }
                System.out.print(employees[i].getName());
            }
            System.out.print(".\n");
        }
    }
}