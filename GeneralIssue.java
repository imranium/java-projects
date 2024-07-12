// Subclass of Issue - General Issue
public class GeneralIssue extends Issue {

    public GeneralIssue(String title, String description, String id, String status, String assignedTo) {
        super(title, description, id, status, assignedTo);
    }

    @Override
    public void displayInfo() {
        System.out.println("Issue type: General Issue");
        super.displayInfo();
    }
}