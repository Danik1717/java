package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static final Logger logger = LogManager.getLogger(DataReader.class);

    public List<String> readLines(String filePath) {
        Path path = Paths.get(filePath);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
            logger.info("Successfully read {} lines from {}", lines.size(), filePath);
        } catch (Exception e) {
            logger.fatal("Failed to read file: {}", filePath, e);
        }
        return lines;
    }
}
