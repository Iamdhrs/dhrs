package com.dhrs.base.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAttributeFinder {
    private static final String FILE_PATH = "E:/临时/file.txt";
    private static final String TARGET_ATTRIBUTE = "num";
    private static final int TARGET_VALUE = 43; // 你要找的数字

    public static void main(String[] args) {
        Long l1 = System.currentTimeMillis();
        Optional<String> result = findJsonValue(FILE_PATH, TARGET_ATTRIBUTE, TARGET_VALUE);
        Long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);
        if (result.isPresent()) {
            System.out.println("找到了! JSON字符串: " + result.get());
        } else {
            System.out.println("未找到符合条件的JSON字符串.");
        }
    }

    private static Optional<String> findJsonValue(String filePath, String targetAttribute, int targetValue) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                JsonNode jsonNode = objectMapper.readTree(line);
                if (jsonNode.has(targetAttribute) && jsonNode.get(targetAttribute).intValue() == targetValue) {
                    return Optional.of(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}