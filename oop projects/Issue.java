
//Base class for all issues
public class Issue {
    protected String title;
    protected String description;
    protected String id;
    protected String status;
    protected String assignedTo;

    public Issue(String title, String description, String id, String status, String assignedTo) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("ID: " + id);
        System.out.println("Status: " + status);
        System.out.println("Assigned To: " + assignedTo);
    }
}