package outsideentities;

public abstract class Provider { // an abstract class cannot be instantiated on its own

    protected String name;
    protected String phoneNumber;

    public abstract void phoneCall();

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