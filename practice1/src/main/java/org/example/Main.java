package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private final static String[] messageDigestAlgorithms = {"SHA-256", "SHA-1", "MD5"};
    private final static String[] secureRandomAlgorithms = {"DRBG", "SHA1PRNG", "Windows-PRNG"};

    public static void main(String[] args) throws Exception {
        String testInput = "What's up broskiii?";

        System.out.println("Task - 1: ");
        FileWriter writer = new FileWriter("MessageDigest_hashes.txt");
        for (String alg : messageDigestAlgorithms) {
            hashResultsMessageDigest(alg, testInput, writer);
        }
        writer.close();

        System.out.println("\nTask - 2: ");
        writer = new FileWriter("SecureRandom_hashes.txt");
        for (String alg : secureRandomAlgorithms) {
            hashResultsSecureRandom(alg, testInput, writer);
        }
        writer.close();
        System.out.println("\nTask - 3: ");
        checkClasses();
    }

    // Task 3) Two own classes
    private static void checkClasses() throws Exception {
        Car c1 = new Car("Ford", 2022);
        Car c2 = new Car("Renault", 2013);
        Car c3 = new Car("Ford", 2022);
        Map<Car, Integer> map = new HashMap<>();
        map.put(c1, 1);
        map.put(c2, 2);
        map.put(c3, 3);
        FileWriter writer = new FileWriter("TwoClasses_hashes.txt");
        for (Map.Entry<Car, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            String hash = entry.getKey().hashCode() + "";
            writer.append(hash+"\n");
        }
        System.out.println(map.get(new Car("Ford", 2022)));

        BrokenCar bc1 = new BrokenCar("Ford", 2022);
        BrokenCar bc2 = new BrokenCar("Renault", 2013);
        BrokenCar bc3 = new BrokenCar("Ford", 2022);
        writer.append("\n");
        Map<BrokenCar, Integer> map2 = new HashMap<>();
        map2.put(bc1, 1);
        map2.put(bc2, 2);
        map2.put(bc3, 3);
        for (Map.Entry<BrokenCar, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            String hash = entry.getKey().hashCode() + "";
            writer.append(hash+"\n");
        }
        writer.close();
        System.out.println(map2.get(new BrokenCar("Ford", 2022)));
    }

    // Task 2) SecureRandom
    private static void hashResultsSecureRandom(String alg, String input, FileWriter writer) throws Exception {
        SecureRandom sr = SecureRandom.getInstance(alg);
        sr.nextBytes(input.getBytes());
        long number = sr.nextLong();
        writer.append(number+"\n");
        System.out.println(number);
    }

    // Task 1) MessageDigest
    private static void hashResultsMessageDigest(String alg, String input, FileWriter writer) throws Exception {
        MessageDigest md = MessageDigest.getInstance(alg);
        String hashed = bytesToHex(md.digest(input.getBytes()));
        writer.append(hashed+"\n");
        System.out.println("Hash res: " + hashed);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}