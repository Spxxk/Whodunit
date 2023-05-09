package zork.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static String generateHash(String input) throws NoSuchAlgorithmException {
        return convertToHex(MessageDigest.getInstance("MD5").digest(input.getBytes()));
    }

    private static String convertToHex( byte[] messageDigest) {
        BigInteger bigint = new BigInteger(1, messageDigest);
        String hexText = bigint.toString(16);
        while (hexText.length() < 32) {
           hexText = "0".concat(hexText);
        }
        return hexText;
    }
}
