import java.util.Scanner;

// Tracking System class
public class IssueTrackingSystem {
    private static final int MAX_ISSUES = 100;
    private Issue[] issues;
    private static int count;
    
    // Constructor - Initialize the issues array with a maximum size of 100
    public IssueTrackingSystem() {  
        issues = new Issue[MAX_ISSUES]; 
        count = 0;
    }
    
    // add Issues by inpuitting the type of issue
    public void addIssue(Issue issue) {
        if (count < MAX_ISSUES) {
            issues[count++] = issue;
            System.out.println("Issue added successfully.");
        } else {
            System.out.println("Maximum number of issues reached. Cannot add more issues."); 
        }
    }

    // View all the issues
    public void viewIssues() {
        System.out.println("\n **Issue Records:** \n");

        for (int i = 0; i < count; i++) {
            System.out.println("Issue " + (i + 1) + ":");
            issues[i].displayInfo();
            System.out.println();
        }
    }

    // Search for an issue by title
    public void searchIssue(String title) {
        boolean found = false;
        System.out.println("\n ** Search Results for '" + title + "': **");
        for (int i = 0; i < count; i++) {
            if (issues[i].title.equalsIgnoreCase(title)) {
                System.out.println("\nIssue " + (i + 1) + ":");
                issues[i].displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No issue found with title '" + title + "'.");
        }
    }

    // Edit an issue by ID
    public void editIssue(String id) {
        boolean found = false;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            if (issues[i].id.equals(id)) {
                System.out.println("Enter new title for issue with ID '" + id + "':");
                issues[i].title = scanner.nextLine();
                System.out.println("Enter new description for issue with ID '" + id + "':");
                issues[i].description = scanner.nextLine();
                System.out.println("Enter new status for issue with ID '" + id + "':");
                issues[i].status = scanner.nextLine();
                System.out.println("Enter new assigned person for issue with ID '" + id + "':");
                issues[i].assignedTo = scanner.nextLine();

                if (issues[i] instanceof Bug) {
                    Bug bug = (Bug) issues[i];
                    System.out.println("Enter new severity for issue with ID '" + id + "':");
                    bug.severity = scanner.nextLine();
                } else if (issues[i] instanceof FeatureRequest) {
                    FeatureRequest featureRequest = (FeatureRequest) issues[i];
                    System.out.println("Enter new priority for issue with ID '" + id + "':");
                    featureRequest.priority = scanner.nextLine();
                }
                System.out.println("Issue with ID '" + id + "' has been updated.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No issue found with ID '" + id + "'.");
        }
    }

    // Delete an issue by ID
    public void deleteIssue(String id) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (issues[i].id.equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    issues[j] = issues[j + 1];
                }
                count--;
                System.out.println("Issue with ID '" + id + "' deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No issue found with ID '" + id + "'.");
        }
    }
}
