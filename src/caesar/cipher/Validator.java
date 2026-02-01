package caesar.cipher;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public void isValidKey(int key, char[] alphabet) {
        if (alphabet == null || alphabet.length == 0) {
            throw new IllegalArgumentException("Алфавит пустой");
        }

        if (key < 0 || key >= alphabet.length) {
            throw new IllegalArgumentException("Недопустимое значение ключа");

        }
    }


    public void validateFilePath(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new FileValidationException(filePath + ": Путь к файлу пуст");
        }

        Path path = Path.of(filePath);

        if (!Files.exists(path)) {
            throw new FileValidationException(path + ": Файл не существует");
        }

        if (!Files.isRegularFile(path)) {
            throw new FileValidationException(path + ": Путь не является файлом");
        }


    }
}

