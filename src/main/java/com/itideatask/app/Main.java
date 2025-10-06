package com.itideatask.app;

import com.itideatask.model.Client;
import com.itideatask.model.Project;
import com.itideatask.service.ClientService;
import com.itideatask.service.ProjectService;
import com.itideatask.dao.ProjectDAO;
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

                default:
                    LOGGER.info("Invalid option. Try again.");
            }
        }
    }
}
