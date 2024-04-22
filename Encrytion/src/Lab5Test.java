/*
 *  The Lab5Test class represents testing program for encryption classes.
 * It allows the user to encrypt and decrypt text using Caesar and Vigenere ciphers.
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */

/**
 * @author mansi
 *
 */
import encryption.Encryptable;
import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Lab5Test {
    private Scanner input;
    private ArrayList<String> encryptedText;

    /**
     * Gets the list of encrypted texts.
     *
     * @return the list of encrypted texts
     */
    public ArrayList<String> getEncryptedText() {
        return encryptedText;
    }

    /**
     * Sets the list of encrypted texts.
     *
     * @param encryptedText the list of encrypted texts
     */
    public void setEncryptedText(ArrayList<String> encryptedText) {
        this.encryptedText = encryptedText;
    }

    /**
     * Constructs a Lab5Test object.
     */
    public Lab5Test() {
        input = new Scanner(System.in);
        setEncryptedText(new ArrayList<>());
    }

    /*
     * Reads and validates the user's menu choice.
     *
     * @param options the menu options
     * @return the selected menu choice
     */
    private int getMenuItem(String... options) {
        int choice = -1;
        while (choice <= 0 || choice > options.length) {
            for (int i = 0; i < options.length; i++) {
                System.out.println("\t" + (i + 1) + " - " + options[i]);
            }
            System.out.print("Select action: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); 
                if (choice <= 0 || choice > options.length) {
                    System.out.println("\nPlease select a number in the range");
                }
            } else {
                input.nextLine(); 
                System.out.println("\nPlease enter an integer");
            }
        }

        return choice;
    }
    /**
     * Reads a string from the user.
     *
     * @param prompt the prompt message
     * @return the user input as a string
     */
    private String getString(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    /**
     * Reads and validates an integer from the user.
     *
     * @param prompt the prompt message
     * @return the user input as an integer
     */
    private int getInt(String prompt) {
        int number = -1;

        while (number < 0) {
            System.out.print(prompt);

            if (input.hasNextInt()) {
                number = input.nextInt();
                input.nextLine(); 
            } else {
                input.nextLine(); 
                System.out.println("\nPlease enter an integer\n");
            }
        }

        return number;
    }

    /**
     * The main method that runs the encryption lab program.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<String> encryptedText = new ArrayList<>();
        Lab5Test lab = new Lab5Test();
        
        System.out.println("Encryption Tester\n");
        int choice;
        do {
            choice = lab.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list", "Exit");

            switch (choice) {
                case 1:
                    String textToEncrypt = lab.getString("Please enter text to be encrypted: ");
                    System.out.println("Encryption Method");
                    int encryptionMethodChoice = lab.getMenuItem("Caesar", "Vigenere");
                    Encryptable encryptionMethod = null;

                    if (encryptionMethodChoice == 1) {
                        int shift = lab.getInt("Shift value: ");
                        encryptionMethod = new CaesarCipher(shift);
                    } else if (encryptionMethodChoice == 2) {
                        String password = lab.getString("Password: ");
                        encryptionMethod = new VigenereCipher(password);
                    }

                    if (encryptionMethod != null) {
                        String encrypted = encryptionMethod.encrypt(textToEncrypt);
                        encryptedText.add(encrypted);
                        System.out.println("Encrypted value #" + encryptedText.size() + " is: " + encrypted);
                    }
                    break;
                case 2:
                    if (encryptedText.isEmpty()) {
                        System.out.println("Nothing to decrypt");
                    }else {
                        System.out.println();
                        if (!encryptedText.isEmpty()) {
                            System.out.println("Encrypted Messages:");
                            for (int i = 0; i < encryptedText.size(); i++) {
                                System.out.println("#" + (i + 1) + ": " + encryptedText.get(i));
                            }
//                           else{
                        System.out.println();
                        int messageNumber = lab.getInt("Message number you want to decrypt: ");
                        if (messageNumber >= 1 && messageNumber <= encryptedText.size()) {
                            encryptionMethodChoice = lab.getMenuItem("Caesar", "Vigenere");
                            Encryptable decryptionMethod = null;

                            if (encryptionMethodChoice == 1) {
                                int shift = lab.getInt("Shift value: ");
                                decryptionMethod = new CaesarCipher(shift);
                            } else if (encryptionMethodChoice == 2) {
                                String password = lab.getString("Password: ");
                                decryptionMethod = new VigenereCipher(password);
                            }

                            if (decryptionMethod != null) {
                                String encryptedMessage = encryptedText.get(messageNumber - 1);
                                String decrypted = decryptionMethod.decrypt(encryptedMessage);
                                System.out.println("Decrypted value #" + messageNumber + " is: " + decrypted);
                            }
                        } else {
                            System.out.println("\nPlease select a number in the range\n");
                        }
                    }
                    }
                    break;
                case 3:
                    if (encryptedText.isEmpty()) {
                        System.out.println("Nothing to display");
                    } else {
                        for (int i = 0; i < encryptedText.size(); i++) {
                            System.out.println("#" + (i + 1) + ": " + encryptedText.get(i));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Good bye");
                    System.out.println("Program by Mansi Joshi");
                    break;
                default:
                    System.out.println("\nPlease select a number in the range\n");
                    break;
            }

        } while (choice != 4);
    }
}
