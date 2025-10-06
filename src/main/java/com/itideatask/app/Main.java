package com.itideatask.app;

import com.itideatask.model.*;
import com.itideatask.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        ProjectService projectService = new ProjectService();

        projectService.getAllProjects();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            LOGGER.info("\n=== Client Menu ===");
            LOGGER.info("1. Insert new client");
            LOGGER.info("2. Find client by email");
            LOGGER.info("3. Update client password");
            LOGGER.info("4. Delete client");
            LOGGER.info("5. Exit");
            LOGGER.info("6. Additional options");
            LOGGER.info("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    LOGGER.info("Insert email:");
                    String insertEmail = scanner.nextLine();

                    LOGGER.info("Insert username:");
                    String insertUsername = scanner.nextLine();

                    LOGGER.info("Insert password:");
                    String insertPassword = scanner.nextLine();

                    LOGGER.info("Insert project code:");
                    int insertProjectCode = scanner.nextInt();
                    scanner.nextLine();

                    Client newClient = new Client(insertUsername, insertEmail, insertPassword, insertProjectCode);
                    boolean insertSuccess = clientService.insertClient(newClient);
                    LOGGER.info("Insert success? " + insertSuccess);
                    break;

                case 2:
                    LOGGER.info("Enter email to search:");
                    String searchEmail = scanner.nextLine();
                    Client foundClient = clientService.getClient(searchEmail);
                    if (foundClient != null) {
                        LOGGER.info("Found client: " + foundClient);
                    } else {
                        LOGGER.info("Client not found.");
                    }
                    break;

                case 3:
                    LOGGER.info("Enter email of client to update password:");
                    String updateEmail = scanner.nextLine();
                    LOGGER.info("Enter new password:");
                    String newPassword = scanner.nextLine();
                    boolean updateSuccess = clientService.updatePassword(updateEmail, newPassword);
                    LOGGER.info("Update success? " + updateSuccess);
                    break;

                case 4:
                    LOGGER.info("Enter email of client to delete:");
                    String deleteEmail = scanner.nextLine();
                    boolean deleteSuccess = clientService.deleteClient(deleteEmail);
                    LOGGER.info("Delete success? " + deleteSuccess);
                    break;

                case 5:
                    LOGGER.info("Exiting program.");
                    return;

                case 6:
                    while (true) {
                        LOGGER.info("\n=== Additional info ===");
                        LOGGER.info("1. Consult Developer by id");
                        LOGGER.info("2. Consult Manager by id");
                        LOGGER.info("3. Consult monitoring");
                        LOGGER.info("3. Consult project");
                        LOGGER.info("5.. Exit");
                        LOGGER.info("Choose option: ");

                        int additionalchoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (additionalchoice) {
                            case 1:
                                LOGGER.info("Insert developer employee_code:");
                                int insert_employee_code = scanner.nextInt();

                                DeveloperService developerService = new DeveloperService();
                                Developer developer = developerService.getDeveloper(insert_employee_code);

                                if (developer != null) {
                                    LOGGER.info("Developer found -> " + developer.toString());
                                } else {
                                    LOGGER.info("No developer found with employee_code = " + insert_employee_code);
                                }
                                break;

                            case 2:
                                LOGGER.info("Insert manager employee_code:");
                                insert_employee_code = scanner.nextInt();

                                ManagerService managerService = new ManagerService();

                                Manager manager = managerService.getManager(insert_employee_code);
                                if (manager != null) {
                                    LOGGER.info("Manager found -> " + manager.toString());
                                } else {
                                    LOGGER.info("No manager found with employee_code = " + insert_employee_code);
                                }
                                break;

                            case 3:

                                LOGGER.info("Insert monitoring code");
                                int insert_monitor_code = scanner.nextInt();

                                MonitoringService monitoringService = new MonitoringService();

                                Monitoring monitoring = monitoringService.getMonitor(insert_monitor_code);

                                if (monitoring != null) {
                                    LOGGER.info("monitoring found -> " + monitoring.toString());
                                } else {
                                    LOGGER.info("No monitoring found with code = " + insert_monitor_code);
                                }
                                break;

                            case 4:
                                LOGGER.info("Insert project code");
                                int insert_project_code = scanner.nextInt();

                                ProjectService projectService1 = new ProjectService();

                                Project project= projectService1.getProject(insert_project_code);

                                if (project != null) {
                                    LOGGER.info("Project found -> " + project.toString());
                                } else {
                                    LOGGER.info("No project found with employee_code = " + insert_project_code);
                                }
                                break;

                            case 5:
                                LOGGER.info("Exiting program.");
                                return;

                            default:
                                LOGGER.info("Invalid option. Try again.");
                        }
                    }

                default:
                    LOGGER.info("Invalid option. Try again.");
            }

        }
    }
}
