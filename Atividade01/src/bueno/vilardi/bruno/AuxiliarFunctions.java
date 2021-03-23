package bueno.vilardi.bruno;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class AuxiliarFunctions {
    //=================================Hashing======================================================
    public static String hashString(String string){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[]encodedhash = digest.digest(string.getBytes(StandardCharsets.UTF_8));
        return(AuxiliarFunctions.bytesToHex(encodedhash));
    }
    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    //Source: https://www.baeldung.com/sha-256-hashing-java
    //======================================================================================
    public static int getRandomNumberInRange(int min, int max) {
            Random r = new Random();
            return r.nextInt((max - min) + 1) + min;
    }

}