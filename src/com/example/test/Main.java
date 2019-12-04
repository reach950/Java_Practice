package com.example.test;


import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.io.*;
import java.math.BigInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class Main {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGen.generateKey();
        // 打印随机生成的key:
        byte[] skey = key.getEncoded();
        System.out.println(new BigInteger(1, skey).toString(16));
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = mac.doFinal();
        System.out.println(new BigInteger(1, result).toString(16));
    }

    private static void readZip() throws IOException {
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream("data_structure_and_algorithm.zip"))) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                String name = entry.getName();
                System.out.println(name);
                if (!entry.isDirectory()) {
                    int n;
                    while ((n = zip.read()) != -1) {
                        System.out.println(n);
                    }
                }
            }
        }
    }

    private static void writeZip() throws IOException {
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("data_structure_and_algorithm.zip"))) {
            File[] files = {new File("H:\\data_structure_and_algorithm.html"), new File("H:\\abc.js")};
            for (File file : files) {
                zip.putNextEntry(new ZipEntry(file.getName()));
                zip.write(getFileDataAsBytes(file));
                zip.closeEntry();
            }
        }
    }

    private static byte[] getFileDataAsBytes(File file) throws IOException {
        byte[] data = new byte[1024];
        try (InputStream ins = new FileInputStream(file);
             ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            int n;
            while ((n = ins.read(data)) != -1) {
                output.write(data, 0, n);
            }
            return output.toByteArray();
        }
    }

}
