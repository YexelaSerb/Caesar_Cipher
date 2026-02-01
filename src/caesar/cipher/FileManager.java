package caesar.cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public String readFile(String filePath) {
        try {
            Path read = Path.of(filePath);
            byte[] buffer = Files.readAllBytes(read);
            return new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
           throw new FileValidationException("Не удалось прочитать файл: " + e.getMessage());
        }

    }

    public void writeFile(String content, String filePath) {
        try {
            Path pathOfWrite = Path.of(filePath);
            Files.write(pathOfWrite, content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println("Не удалось записать файл" + e.getMessage());
        }
    }
}
