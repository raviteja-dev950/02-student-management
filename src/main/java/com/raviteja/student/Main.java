package com.raviteja.student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        System.out.println("=== RaviTeja's Student Management | Project 2 ===");

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Find Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Total Students Count");
            System.out.println("q. Quit");
            System.out.print("Choose option: ");

            String choice = sc.nextLine().trim();

            try {
                if (choice.equalsIgnoreCase("q")) {
                    System.out.println("Bye Bye! Project 2 Done.");
                    break;
                }

                switch (choice) {
                    case "1":
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Course (Java/Python/MERN): ");
                        String course = sc.nextLine();
                        Student added = service.addStudent(name, age, course);
                        System.out.println("✅ Added: " + added);
                        break;

                    case "2":
                        System.out.println("\n--- All Students ---");
                        if (service.getAllStudents().isEmpty()) {
                            System.out.println("No students yet! Add one.");
                        } else {
                            service.getAllStudents().forEach(System.out::println);
                        }
                        break;

                    case "3":
                        System.out.print("Enter ID to search: ");
                        int searchId = Integer.parseInt(sc.nextLine());
                        Student found = service.findById(searchId);
                        System.out.println("🔍 Found: " + found);
                        break;

                    case "4":
                        System.out.print("Enter ID to delete: ");
                        int delId = Integer.parseInt(sc.nextLine());
                        service.deleteById(delId);
                        System.out.println("🗑️ Deleted student with ID: " + delId);
                        break;

                    case "5":
                        System.out.println("📊 Total Students: " + service.getTotalCount());
                        break;

                    default:
                        System.out.println("Invalid choice! Try 1-5 or q");
                }
            } catch (StudentNotFoundException e) {
                System.out.println("❌ Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter valid number!");
            }
        }
        sc.close();
    }
}