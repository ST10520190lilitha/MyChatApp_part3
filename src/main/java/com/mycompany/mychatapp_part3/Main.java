/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.mychatapp_part3;


import java.util.Scanner;

/**
 * Main entry point for QuickChat application.
 * Handles registration, login, and the Part 2 message-sending menu.
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login login = new Login();

        String name, surname, username, password, phone;
        boolean registered = false;

        // ================= USER REGISTRATION SECTION =================
        System.out.println("=== USER REGISTRATION ===");
        System.out.print("Enter a name: ");
        name = input.nextLine();
        System.out.print("Enter a surname: ");
        surname = input.nextLine();

        // LOOP until username is valid
        do {
            System.out.print("Enter a username (must contain '_' and be max 5 characters): ");
            username = input.nextLine();
            if (!login.checkUserName(username)) {
                System.out.println("Invalid username. Username must contain '_' and be max 5 characters.");
            }
        } while (!login.checkUserName(username));

        // LOOP until password meets complexity requirements
        do {
            System.out.print("Enter password (8+ chars, capital letter, number, special character): ");
            password = input.nextLine();
            if (!login.checkPasswordComplexity(password)) {
                System.out.println("Invalid password. Must contain: 8 characters, capital letter, number, special character.");
            }
        } while (!login.checkPasswordComplexity(password));

        // LOOP until phone number is valid South African format
        do {
            System.out.print("Enter your South African phone number (+27...): ");
            phone = input.nextLine();
            if (!login.checkPhoneNumber(phone)) {
                System.out.println("Invalid phone number. Must start with +27.");
            }
        } while (!login.checkPhoneNumber(phone));

        // Register the user and display result
        String registrationResult = login.registerUser(username, password, phone);
        System.out.println(registrationResult);
        if (registrationResult.contains("successfully")) {
            registered = true;
        }

        // ================= USER LOGIN SECTION =================
        if (registered) {
            System.out.println("\n=== USER LOGIN ===");
            boolean loggedIn = false;

            // LOOP until login succeeds
            do {
                System.out.print("Enter username: ");
                String loginUsername = input.nextLine();
                System.out.print("Enter password: ");
                String loginPassword = input.nextLine();

                loggedIn = login.loginUser(loginUsername, loginPassword);
                System.out.println(login.returnLoginStatus(loggedIn));

                if (!loggedIn) {
                    System.out.println("Please try again.");
                }
            } while (!loggedIn);

            // ================= PART 2: MAIN MENU SECTION =================
            System.out.println("Welcome to QuickChat.");

            boolean running = true;

            while (running) {
                // Display the three-option numeric menu
                System.out.println("\n--- QuickChat Menu ---");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                System.out.print("Choose an option: ");

                int choice;
                try {
                    choice = Integer.parseInt(input.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        // Ask how many messages to send
                        System.out.print("How many messages would you like to send? ");
                        int numMessages;
                        try {
                            numMessages = Integer.parseInt(input.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number. Returning to menu.");
                            break;
                        }

                        // FOR LOOP: iterate from 0 to numMessages
                        for (int i = 0; i < numMessages; i++) {
                            int messageNumber = i + 1;
                            System.out.println("\n--- Message " + messageNumber + " of " + numMessages + " ---");

                            // Generate a 10-digit random message ID
                            String messageID = Message.generateMessageID();

                            // INNER WHILE LOOP: validate recipient cell number
                            String recipient;
                            while (true) {
                                System.out.print("Enter recipient cell number (+27...): ");
                                recipient = input.nextLine();
                                String RecipientStatus = Message.checkRecipientCellStatus(recipient);
                                if (RecipientStatus.equals("Cell phone number successfully captured.")) {
                                    break;
                                }
                                System.out.println(RecipientStatus);
                            }

                            // INNER WHILE LOOP: validate message text (max 250 characters)
                            String messageText;
                            while (true) {
                                System.out.print("Enter message (max 250 characters): ");
                                messageText = input.nextLine();
                                String lengthStatus = Message.checkMessageText(messageText);
                                if (lengthStatus.equals("Message ready to send.")) {
                                    break;
                                }
                                System.out.println(lengthStatus);
                            }

                            // Create the Message object with the generated ID
                            Message message = new Message(messageID, recipient, messageText);

                            // Set the message number using the loop counter
                            message.setMessageNumber(messageNumber);

                            // 
                        }
                } 
            } 
        } 
    } 
}