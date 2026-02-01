package caesar.cipher;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Validator validator = new Validator();
        FileManager fileManager = new FileManager();
        Cipher cipher = new Cipher(Alphabet.RUS_ALPHABET);

        int choice;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1 - Зашифровать текст");
            System.out.println("2 - Расшифровать текст");
            System.out.println("0 - Выход");

            choice = console.nextInt();
            console.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введите путь к исходному файлу:");
                    String pathRead = console.nextLine();
                    System.out.println("Введите путь к файлу для записи:");
                    String pathWrite = console.nextLine();
                    System.out.println("Введите клююч для шифровки (сдвиг символа):");
                    int shift = console.nextInt();
                    console.nextLine();

                    try {
                        validator.validateFilePath(pathRead);
                        validator.validateFilePath(pathWrite);
                        validator.isValidKey(shift, Alphabet.RUS_ALPHABET);
                        String text = fileManager.readFile(pathRead);
                        String encrypted = cipher.encrypt(text, shift);
                        fileManager.writeFile(encrypted, pathWrite);
                        System.out.println("Файл успешно зашифрован");

                    } catch (Exception e) {
                        System.out.println("Ошибка - " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Введите путь к зашифрованному файлу:");
                    String pathReadDecrypt = console.nextLine();
                    System.out.println("Введите путь к файлу для записи:");
                    String pathWriteDecrypt = console.nextLine();
                    System.out.println("Введите известный ключ для расшифровки (сдвиг символа):");
                    int shiftDecrypt = console.nextInt();
                    console.nextLine();

                    try {
                        validator.validateFilePath(pathReadDecrypt);
                        validator.validateFilePath(pathWriteDecrypt);
                        validator.isValidKey(shiftDecrypt, Alphabet.RUS_ALPHABET);

                        String text = fileManager.readFile(pathReadDecrypt);
                        String decrypted = cipher.decrypt(text, shiftDecrypt);
                        fileManager.writeFile(decrypted, pathWriteDecrypt);
                        System.out.println("Файл успешно расшифрован");
                    } catch (Exception e) {
                        System.out.println("Ошибка - " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Выход из программы");
                    break;

                default:
                    System.out.println("Неверный пункт меню");
            }
            System.out.println();

        } while (choice != 0);

        console.close();


    }
}

