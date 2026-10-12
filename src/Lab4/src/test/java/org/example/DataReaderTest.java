package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataReaderTest {

    private final DataReader reader = new DataReader();

    @Test
    public void testReadDataFromValidFile() throws IOException {
        // Создаем временный файл для теста
        File tempFile = File.createTempFile("test_tariffs", ".txt");
        tempFile.deleteOnExit(); // Удалится сам после теста

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("PREPAID, Basic, 10.0, 100, 50\n");
            writer.write("CORPORATE, Pro, 20.0, 50, 0.1\n");
        }

        List<String> lines = reader.readLines(tempFile.getAbsolutePath());

        Assert.assertEquals(lines.size(), 2);
        Assert.assertTrue(lines.get(0).startsWith("PREPAID"));
        Assert.assertTrue(lines.get(1).startsWith("CORPORATE"));
    }

    @Test
    public void testReadDataFromInvalidPathReturnsEmptyList() {
        // Проверяем, что программа не падает при неверном пути, а возвращает пустой список
        List<String> lines = reader.readLines("Z:/invalid_path/file.txt");
        Assert.assertTrue(lines.isEmpty());
    }
}