// import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Scanner;
// import org.junit.jupiter.api.Test;

public class Main {
    
  public static void main(String[] args) {
      System.out.println("** Software Enhancement, Governance and Knowledgebase II(SEGAK 2.0) **");
      Scanner scanner = new Scanner(System.in);
      IssueTrackingSystem system = new IssueTrackingSystem();
      char choice;
      do {

          System.out.println("\nSEGAK 2.0 System Menu:");
          System.out.println("1. Add Issue");
          System.out.println("2. View Issues");
          System.out.println("3. Search Issue");
          System.out.println("4. Edit Issue");
          System.out.println("5. Delete Issue");
          System.out.println("6. Exit");
          System.out.print("Enter your choice: ");
          choice = scanner.next().charAt(0);
          scanner.nextLine(); // consume newline

          switch (choice) {
              case '1':
                  System.out.println("1. Bug");
                  System.out.println("2. Feature Request");
                  System.out.println("3. General Issue");
                  System.out.print("Enter issue type: ");
                  char typeChoice = scanner.next().charAt(0);
                  scanner.nextLine(); // consume newline

                  System.out.print("Enter issue title: ");
                  String title = scanner.nextLine();
                  System.out.print("Enter issue description: ");
                  String description = scanner.nextLine();
                  System.out.print("Enter issue ID: ");  
                  String id = scanner.nextLine();
                  System.out.print("Enter issue status: ");
                  String status = scanner.nextLine();
                  System.out.print("Enter assigned person: ");
                  String assignedTo = scanner.nextLine();

                  switch (typeChoice) {
                      case '1':
                          System.out.print("Enter severity: ");
                          String severity = scanner.nextLine();
                          system.addIssue(new Bug(title, description, id, status, assignedTo, severity));
                          break;
                      case '2':
                          System.out.print("Enter priority: ");
                          String priority = scanner.nextLine();
                          system.addIssue(new FeatureRequest(title, description, id, status, assignedTo, priority));
                          break;
                      case '3':
                          system.addIssue(new GeneralIssue(title, description, id, status, assignedTo));
                          break;
                      default:
                          System.out.println("Invalid issue type choice. Please try again.");
                  }
                  break;
              case '2':
                  system.viewIssues();
                  break;
              case '3':
                  System.out.println("Enter issue title to search: ");
                  String searchTitle = scanner.nextLine();
                  system.searchIssue(searchTitle);
                  break;
              case '4':
                  System.out.println("Enter issue ID to edit: ");
                  String editId = scanner.nextLine();
                  system.editIssue(editId);
                  break;
              case '5':
                  System.out.println("Enter issue ID to delete: ");
                  String deleteId = scanner.nextLine();
                  system.deleteIssue(deleteId);
                  break;
              case '6':
                  System.out.println("Exiting program.");
                  break;
              default:
                  System.out.println("Invalid choice. Please try again.");
          }
      } while (choice != '6');

      scanner.close();
  }