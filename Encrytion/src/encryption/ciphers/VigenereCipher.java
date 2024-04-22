/*
 * Description of the class: The VigenereCipher class represents a Vigenere cipher encryption algorithm that implements the Encryptable interface.
 * It encrypts and decrypts messages using a provided key.
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */
package encryption.ciphers;

/**
 * @author mansi
 *
 */
import encryption.Encryptable;

public class VigenereCipher implements Encryptable {

    private String key;
    private int keyLength;

    /**
     * @param key the password used to encrypt and decrypt the text
     */
    public VigenereCipher(String key) {
        this.key = key;
        this.keyLength = key.length();
    }

    /**
     * @param plainText the plain text to be encrypted
     * @return the encrypted cipher text
     */
    @Override
    public String encrypt(String plainText) {
        StringBuilder cipherText = new StringBuilder();
        int textLength = plainText.length();

        for (int i = 0; i < textLength; i++) {
            char plainChar = plainText.charAt(i);
            char keyChar = key.charAt(i % keyLength);

            int plainValue = (int) plainChar - START_CHAR;
            int keyValue = (int) keyChar - START_CHAR;

            int encryptedValue = (plainValue + keyValue) % RANGE;
            char encryptedChar = (char) (encryptedValue + START_CHAR);

            cipherText.append(encryptedChar);
        }

        return cipherText.toString();
    }

    /**
     * @param cipherText the cipher text to be decrypted
     * @return the decrypted plain text
     */
    @Override
    public String decrypt(String cipherText) {
        StringBuilder plainText = new StringBuilder();
        int textLength = cipherText.length();

        for (int i = 0; i < textLength; i++) {
            char cipherChar = cipherText.charAt(i);
            char keyChar = key.charAt(i % keyLength);

            int cipherValue = (int) cipherChar - START_CHAR;
            int keyValue = (int) keyChar - START_CHAR;

            int decryptedValue = (cipherValue - keyValue + RANGE) % RANGE;
            char decryptedChar = (char) (decryptedValue + START_CHAR);

            plainText.append(decryptedChar);
        }

        return plainText.toString();
    }
}
