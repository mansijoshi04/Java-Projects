/*Description of the class: The CaesarCipher class represents a Caesar cipher encryption algorithm that implements the Encryptable interface.
 * It encrypts and decrypts messages by shifting the letters of the alphabet by a certain key.
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
package encryption.ciphers;

import encryption.Encryptable;

public class CaesarCipher implements Encryptable {

    private int key;

    /**
     * @param shift the amount of shift between encrypted and decrypted characters
     */
    public CaesarCipher(int shift) {
        this.key = shift % RANGE;
    }

    /**
     * @param plainText the plain text to be encrypted
     * @return the encrypted cipher text
     */
    @Override
    public String encrypt(String plainText) {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);

            // Skip characters outside the valid range

            int shiftedChar = (plainChar - START_CHAR + key) % RANGE;
            if (shiftedChar < 0) {
                shiftedChar += RANGE;
            }

            char encryptedChar = (char) (shiftedChar + START_CHAR);

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
            
         // Skip characters outside the valid range
            if (cipherChar < START_CHAR || cipherChar > END_CHAR) {
                plainText.append(cipherChar);
                continue;
            }

            int cipherValue = (int) cipherChar - START_CHAR;
            int shiftedValue = (cipherValue - key + RANGE) % RANGE;
            char decryptedChar = (char) (shiftedValue + START_CHAR);

            // Wrap around the range if the shifted value is below the START_CHAR
            if (decryptedChar < START_CHAR) {
                decryptedChar = (char) (decryptedChar + RANGE);
            }

            plainText.append(decryptedChar);
        }

        return plainText.toString();
    }
}

