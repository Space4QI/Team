package ru.zulvit.teamentropy.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class LicenseKeyGenerator {

    public String generateLicenseKey(String flowStoneString, String productName) {
        String[] blocks = flowStoneString.split("-");
        try {
            // Первый блок протянуть через MD5
            String generatedKey = hash(blocks[0], "MD5") +
                    // Второй блок протянуть через SHA1
                    hash(blocks[1], "SHA-1") +
                    // Третий блок протянуть через MD5, затем через SHA1
                    hash(hash(blocks[2], "MD5"), "SHA-1") +
                    // Четвертый блок протянуть через SHA1, затем через MD5
                    hash(hash(blocks[3], "SHA-1"), "MD5") +
                    // Пятый блок протянуть через SHA1, потом через MD5, и наконец проятнуть через SHA1
                    hash(hash(hash(blocks[4], "SHA-1"), "MD5"), "SHA-1");
            // Соеденить все блоки в одну большую строку (ВНИМАНИЕ - ВСЕ В UPCASE)
            String fullKey = generatedKey.toUpperCase();
            // Добавить имя продукта из FlowStone по примеру SN-PRODUCTNAME
            return "SN-" + productName + "-" + fullKey;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] hashedBytes = md.digest(input.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02X", b));
        }

        return sb.toString();
    }
}
