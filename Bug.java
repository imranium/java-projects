// Subclass of Issue - Bug
public class Bug extends Issue {
    String severity;

    public Bug(String title, String description, String id, String status, String assignedTo, String severity) {
        super(title, description, id, status, assignedTo);
        this.severity = severity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Issue type: Bug");
        super.displayInfo();
        System.out.println("Severity: " + severity);
    }
}