package outsideentities;

import static helpers.Formatter.*;

public abstract class Provider implements PayableEntity { // an abstract class cannot be instantiated on its own

    protected String name;
    protected String phoneNumber;

    public abstract void phoneCall();

    public void pay(double amount){
        System.out.println(ansiYellowFG + "*ka-ching!*" + ansiColorReset + " You pay " + this.name + " " + amount + " pln for their services.");
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}