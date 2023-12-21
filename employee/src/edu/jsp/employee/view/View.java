package edu.jsp.employee.view;

import java.util.Scanner;
import edu.jsp.employee.controller.Controller;
import edu.jsp.employee.model.Employee;

public class View {
    boolean status = true;
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();

    public static void main(String[] args) {
        View view = new View();
        while (view.status) {
            view.displayView();
        }
        view.scanner.close();
    }

    public void displayView() {
        System.out.println("");
        System.out.println("------WELCOME------");
        System.out.println("Enter Your Choice");
        System.out.println("1.Save Employee");
        System.out.println("2.List Of Employee");
        System.out.println("3.Search An Employee");
        System.out.println("4.Delete Employee");
        System.out.println("5.Update Employee");
        System.out.println("6.Exit");
        System.out.println("-------------------");

        byte userInput = scanner.nextByte();

        switch (userInput) {
            case 1: {
                saveEmployee();
                break;
            }
            case 2: {
                getAllEmp();
                break;
            }
            case 3: {
                getEmpById();
                break;
            }
            case 4: {
                deleteEmp();
                break;
            }
            case 5: {
                updateEmp();
                break;
            }
            case 6: {
                this.status = false;
                System.out.println("Thank You");
                break;
            }
            default: {
                System.out.println("Invalid Choice Please Try Again.");
            }
        }
    }

    public void saveEmployee() {
        System.out.println("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Name of Employee: ");
        String name = scanner.next();
        scanner.nextLine();

        System.out.println("Enter Employee Salary: ");
        double sal = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter Contact of Employee: ");
        long contact = scanner.nextLong();
        scanner.nextLine();

        Employee empData = new Employee(id, name, sal, contact);

        if (controller.saveEmployee(empData) != null) {
            System.out.println("Employee Saved");
        } else {
            System.out.println("Employee Not Saved");
        }
    }

    public void getAllEmp() {
        if (controller.getAllEmp().isEmpty()) {
            System.out.println("No employees are present");
            return;
        }

        for (Employee emp : controller.getAllEmp()) {
            System.out.println("Emp id: " + emp.getId());
            System.out.println("Emp name: " + emp.getName());
            System.out.println("Emp salary: " + emp.getSal());
            System.out.println("Emp contact: " + emp.getContact());
        }
    }

    public void getEmpById() {
        System.out.println("Enter Employee id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee employee;

        if ((employee = controller.getEmp(id)) != null) {
            System.out.println("Emp id: " + employee.getId());
            System.out.println("Emp name: " + employee.getName());
            System.out.println("Emp salary: " + employee.getSal());
            System.out.println("Emp contact: " + employee.getContact());
        } else {
            System.out.println("Emp not Found");
        }
    }

    public void deleteEmp() {
        getAllEmp();

        System.out.println("Enter Employee id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Employee Salary: ");
        double sal = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter Employee contact: ");
        long contact = scanner.nextLong();
        scanner.nextLine();

        Employee employee = new Employee(id, name, sal, contact);

        for (Employee employee1 : controller.getAllEmp()) {
            if (employee1.equals(employee)) {
                controller.deleteEmployee(employee);
                System.out.println("Employee deleted");
                return;
            }
        }

        System.out.println("Employee not found");
    }

    public void updateEmp() {
        getAllEmp();
        System.out.println("=======================");
        System.out.println("Enter the id to update");
        System.out.println("=========================");

        System.out.println("Enter Employee id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Employee employee : controller.getAllEmp()) {
            if (employee.getId() == id) {
                System.out.println(
                        "Selection option to perform\n" +
                                "1. Id\n" +
                                "2. Name\n" +
                                "3. Salary\n" +
                                "4. Contact\n" +
                                "5. Update All\n" +
                                "Choose an option: "
                );
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: {
                        System.out.println("Enter new Employee id: ");
                        int newId = scanner.nextInt();
                        scanner.nextLine();
                        employee.setId(newId);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter new Employee Name: ");
                        String newName = scanner.nextLine();
                        employee.setName(newName);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter new Employee Salary: ");
                        double newSal = scanner.nextDouble();
                        scanner.nextLine();
                        employee.setSal(newSal);
                        break;
                    }
                    case 4: {
                        System.out.println("Enter new Employee contact: ");
                        long newContact = scanner.nextLong();
                        scanner.nextLine();
                        employee.setContact(newContact);
                        break;
                    }
                    case 5: {
                        System.out.println("Enter new Employee id: ");
                        int newId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter new Employee Name: ");
                        String newName = scanner.nextLine();
                        System.out.println("Enter new Employee Salary: ");
                        double newSal = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Enter new Employee contact: ");
                        long newContact = scanner.nextLong();
                        scanner.nextLine();
                        employee.setId(newId);
                        employee.setName(newName);
                        employee.setSal(newSal);
                        employee.setContact(newContact);
                        break;
                    }
                    default:
                        System.out.println("Invalid option");
                }
                System.out.println("Employee updated");
                return;
            }
        }
        System.out.println("Employee not found");
    }
}
