package com.itideatask.app;

import com.itideatask.model.*;
import com.itideatask.service.*;
import com.itideatask.service.Impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ClientService clientService = new ClientServiceImpl();
        ProjectService projectService = new ProjectServiceImpl();

        projectService.getAllProjects();

        CloudConfigService cloudConfigService = new CloudConfigService();

        cloudConfigService.validateAwsConfig();
        cloudConfigService.validateAzureConfig();

        JsonCloudService jsonCloudService = new JsonCloudService();

        String awsPath = "src/main/resources/json/aws_cloud.json";
        String azurePath = "src/main/resources/json/azure_cloud.json";

        LOGGER.info("=== AWS Cloud Data from JSON ===");
        jsonCloudService.getAwsClouds(awsPath).forEach(a -> LOGGER.info(a.toString()));

        LOGGER.info("=== Azure Cloud Data from JSON ===");
        jsonCloudService.getAzureClouds(azurePath).forEach(a -> LOGGER.info(a.toString()));

        String jsonPath = "src/main/resources/json/azure_cloud.json";
        JsonCloudService jsonService = new JsonCloudService();

        List<AzureCloud> azureClouds = jsonService.getAzureClouds(jsonPath);

        LOGGER.info("=== Azure Cloud Data from JSON ===");
        if (azureClouds != null) {
            azureClouds.forEach(c -> LOGGER.info(c.toString()));
        }

        AzureCloud newCloud = new AzureCloud(110, 8);
        azureClouds.add(newCloud);

        jsonService.exportAzureClouds("src/main/resources/json/azure_clouds_exported.json", azureClouds);

        JaxbService jaxbService = new JaxbService();
        String xmlPath = "src/main/resources/xml/javaProjects.xml";
        String xsdPath = "src/main/resources/xsd/java_projects.xsd";

        JavaProjects javaProjects = jaxbService.getJavaProjectsFromXml(xmlPath, xsdPath);

        jaxbService.exportJavaProjectsToXml(javaProjects);

        if (javaProjects != null) {
            for (var project : javaProjects.getProjects()) {
                LOGGER.info(project.toString());
            }
        }

        Scanner scanner = new Scanner(System.in);

        String clientEmailToGet=null;
        LOGGER.info("Please, write the e mail of the cliente you want to search");
        clientEmailToGet=scanner.nextLine();

        ClientService clientService2 = new ClientServiceMyBatisImpl();
        Client client2 = clientService2.getClient(clientEmailToGet);
        if (client2 != null) {
            LOGGER.info("Client found: " + client2.toString());
        } else {
            LOGGER.warn(" No client found with email: " + clientEmailToGet);
        }

        int projectCodeToGet= 0;
        LOGGER.info("Please, write the project_code");
        projectCodeToGet=scanner.nextInt();

        ProjectService projectService2 = new ProjectServiceMyBatisImpl();
        Project project2 = projectService2.getProject(projectCodeToGet);
        if (project2 != null) {
            LOGGER.info("Client found: " + project2.toString());
        } else {
            LOGGER.warn("No project found with project code " + projectCodeToGet);
        }
        projectService2.getAllProjects();

        SaxServiceImpl saxService= new SaxServiceImpl();

        String timeInvestedPath = "src/main/resources/xml/timeInvested.xml";

        List times = saxService.getTimeInvestedFromXml(timeInvestedPath);
        LOGGER.info("Time invested from XML:");
        for (Object t : times) {
            LOGGER.info(t.toString());
        }

        while (true) {
            LOGGER.info("\n=== Client Menu ===");
            LOGGER.info("1. Insert new client");
            LOGGER.info("2. Find client by email");
            LOGGER.info("3. Update client password");
            LOGGER.info("4. Delete client");
            LOGGER.info("5. Exit");
            LOGGER.info("6. Additional options from projects");
            LOGGER.info("7. Export XML from DB");
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
                                LOGGER.info("Insert developer employee code:");
                                int insertEmployeeCode = scanner.nextInt();

                                DeveloperService developerService = new DeveloperServiceImpl();
                                Developer developer = developerService.getDeveloper(insertEmployeeCode);

                                if (developer != null) {
                                    LOGGER.info("Developer found -> " + developer.toString());
                                } else {
                                    LOGGER.info("No developer found with employee code = " + insertEmployeeCode);
                                }
                                break;

                            case 2:
                                LOGGER.info("Insert manager employee code:");
                                insertEmployeeCode = scanner.nextInt();

                                ManagerService managerService = new ManagerServiceImpl();

                                Manager manager = managerService.getManager(insertEmployeeCode);
                                if (manager != null) {
                                    LOGGER.info("Manager found -> " + manager.toString());
                                } else {
                                    LOGGER.info("No manager found with employee code = " + insertEmployeeCode);
                                }
                                break;

                            case 3:

                                LOGGER.info("Insert monitoring code");
                                int  insertMonitorCode = scanner.nextInt();

                                MonitoringService monitoringService = new MonitoringServiceImpl();

                                Monitoring monitoring = monitoringService.getMonitor( insertMonitorCode);

                                if (monitoring != null) {
                                    LOGGER.info("monitoring found -> " + monitoring.toString());
                                } else {
                                    LOGGER.info("No monitoring found with code = " +  insertMonitorCode);
                                }
                                break;

                            case 4:
                                LOGGER.info("Insert project code");
                                int insertTheProjectCode = scanner.nextInt();

                                ProjectService projectService1 = new ProjectServiceImpl();

                                Project project= projectService1.getProject(insertTheProjectCode);

                                if (project != null) {
                                    LOGGER.info("Project found -> " + project.toString());
                                } else {
                                    LOGGER.info("No project found with employee code = " + insertTheProjectCode);
                                }
                                break;

                            case 5:
                                LOGGER.info("Exiting program.");
                                return;

                            default:
                                LOGGER.info("Invalid option. Try again.");
                        }
                    }


                case 7:
                    LOGGER.info("Exporting data from database to XML...");
                    com.itideatask.util.DbToXmlExporter exporter = new com.itideatask.util.DbToXmlExporter();
                    exporter.exportAll();
                    LOGGER.info(" Export complete! Files saved under src/main/resources/xml/");
                    break;

                default:
                    LOGGER.info("Invalid option. Try again.");
            }

        }
    }
}
