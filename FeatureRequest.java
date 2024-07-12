// Subclass of Issue - Feature Request
public class FeatureRequest extends Issue {
    String priority;

    public FeatureRequest(String title, String description, String id, String status, String assignedTo, String priority) {
        super(title, description, id, status, assignedTo);
        this.priority = priority;
    }

    @Override
    public void displayInfo() {
        System.out.println("Issue type: Feature Request");
        super.displayInfo();
        System.out.println("Priority: " + priority);
    }
}
 