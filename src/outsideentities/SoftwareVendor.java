package outsideentities;

import techstack.Tool;

public class SoftwareVendor extends Provider {

    private Tool[] tools;

    public SoftwareVendor(String name, String phoneNumber, Tool[] tools) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.tools = tools;
    }

    @Override
    public void phoneCall() {
        System.out.println("Calling...\n.\n.\n.\n" + this.name + "'s customer service is temporarily unavailable. Please message us on BoopLoop.\n");
    }

    public Tool[] getTools() {
        return tools;
    }

    public void setTools(Tool[] tools) {
        this.tools = tools;
    }
}