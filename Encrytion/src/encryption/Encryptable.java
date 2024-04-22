/*
 * The Encryptable interface represents an encryption algorithm that can encrypt and decrypt strings.
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */
package encryption;

/**
 * @author mansi
 *
 */
public interface Encryptable {

    
    //  The starting character code used for encryption.
    public static final int START_CHAR = 32;

     //The ending character code used for encryption.
    public static final int END_CHAR = 122;


     //The range of characters available for encryption.
    public static final int RANGE = END_CHAR - START_CHAR + 1;

    /**
     * @param input the string to be encrypted
     * @return the encrypted string
     */
    public abstract String encrypt(String input);

    /**
     * @param input the string to be decrypted
     * @return the decrypted string
     */
    public abstract String decrypt(String input);
}

