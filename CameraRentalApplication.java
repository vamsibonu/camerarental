package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Camera {
    String brand;
    String model;
    double rentalAmount;
    boolean available;

    public Camera(String brand, String model, double rentalAmount) {
        this.brand = brand;
        this.model = model;
        this.rentalAmount = rentalAmount;
        this.available = true;
    }
}

class User {
    String username;
    double walletAmount;

    public User(String username, double walletAmount) {
        this.username = username;
        this.walletAmount = walletAmount;
    }
}

public class CameraRentalApplication {
    static ArrayList<Camera> cameras = new ArrayList<>();
    static User currentUser;

    public static void main(String[] args) {
        initializeCameras();
        showWelcomeScreen();

        // Simulate user login
        login("exampleuser", 150.0);

        // Simulate user interaction
        int choice;
        do {
            displayOptions();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    listCameras();
                    break;
                case 2:
                    rentCamera();
                    break;
                case 3:
                    viewWallet();
                    break;
                case 4:
                    addMoneyToWallet();
                    break;
                case 5:
                    // Implement navigation to the main context
                	displayOptions();
                    break;
                case 6:
                    addCamera();
                    break;
                case 7:
                    removeCamera();
                    break;
                case 8:
                    failedTransaction();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);
    }

    private static void initializeCameras() {
        cameras.add(new Camera("Canon", "EOS R5", 28.0));
        cameras.add(new Camera("Nikon", "D850", 17.0));
        cameras.add(new Camera("Sony", "A7 III", 14.0));

        // Sorting cameras by brand for listing
        Collections.sort(cameras, Comparator.comparing(camera -> camera.brand));
    }

    private static void showWelcomeScreen() {
        System.out.println("Welcome to the Camera Rental Application");
        System.out.println("Developer: Your Name\n");
    }

    private static void displayOptions() {
        System.out.println("Options:");
        System.out.println("1. List Cameras");
        System.out.println("2. Rent a Camera");
        System.out.println("3. View Wallet");
        System.out.println("4. Add Money to Wallet");
        System.out.println("5. Navigate to Main Context");
        System.out.println("6. Add Camera");
        System.out.println("7. Remove Camera");
        System.out.println("8. Failed Transaction\n");
    }

    private static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private static void listCameras() {
        System.out.println("\nAvailable Cameras:");
        for (Camera camera : cameras) {
            System.out.println("Brand: " + camera.brand + ", Model: " + camera.model +
                    ", Rental Amount: $" + camera.rentalAmount + "/day" +
                    ", Availability: " + (camera.available ? "Available" : "Rented"));
        }
    }

    private static void rentCamera() {
        listCameras();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the brand of the camera to rent: ");
        String brandToRent = scanner.nextLine();

        for (Camera camera : cameras) {
            if (camera.brand.equalsIgnoreCase(brandToRent) && camera.available) {
                // Camera is available, proceed with renting
                System.out.println("Renting " + camera.brand + " " + camera.model + " for $" + camera.rentalAmount + "/day");
                camera.available = false;
                currentUser.walletAmount -= camera.rentalAmount; // Deduct rental amount from wallet
                System.out.println("Rent successful. Wallet balance: $" + currentUser.walletAmount);
                return;
            }
        }

        // If the loop completes, the camera was not found or is not available
        System.out.println("Camera not found or not available for rent.");
    }

    private static void viewWallet() {
        System.out.println("Wallet Amount: $" + currentUser.walletAmount);
    }

    private static void addMoneyToWallet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to add to your wallet: $");
        double amountToAdd = scanner.nextDouble();

        if (amountToAdd > 0) {
            currentUser.walletAmount += amountToAdd;
            System.out.println("Money added successfully. Updated wallet balance: $" + currentUser.walletAmount);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    private static void addCamera() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAdding a new camera:");

        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter; model: ");
        String model = scanner.nextLine();

        System.out.print("Enter rental amount per day: $");
        double rentalAmount = scanner.nextDouble();

        Camera newCamera = new Camera(brand, model, rentalAmount);
        cameras.add(newCamera);

        // Sorting cameras by brand after adding a new one
        Collections.sort(cameras, Comparator.comparing(camera -> camera.brand));

        System.out.println("Camera added successfully!");
    }

    private static void removeCamera() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRemoving a camera:");

        listCameras();

        System.out.print("Enter the brand of the camera to remove: ");
        String brandToRemove = scanner.nextLine();

        // Using an Iterator to safely remove the camera from the list
        cameras.removeIf(camera -> camera.brand.equalsIgnoreCase(brandToRemove));

        System.out.println("Camera removed successfully!");
    }

    private static void failedTransaction() {
        System.out.println("Transaction failed. Please check your payment details and try again.");
    }

    private static void login(String username, double initialWalletAmount) {
        currentUser = new User(username, initialWalletAmount);
        System.out.println("Logged in as: " + currentUser.username);
    }
}
