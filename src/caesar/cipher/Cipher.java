package caesar.cipher;

public class Cipher {

    private final char[] alphabet;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

        // Сдвиг символа
        private char shiftChar(char ch, int shift) {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == ch) {
                    int newIndex = (i + shift) % alphabet.length;

                    if (newIndex < 0) {
                        newIndex += alphabet.length;
                    }

                    return alphabet[newIndex];
                }
            }
            // если символ не найден в алфавите — символ не меняем
            return ch;
        }

        // Шифрование
        public String encrypt(String text, int shift) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < text.length(); i++) {
                char originalChar = text.charAt(i);
                char encryptedChar = shiftChar(originalChar, shift);
                result.append(encryptedChar);
            }

            return result.toString();
        }

        // Расшифровка
        public String decrypt(String encryptedText, int shift) {
            int decryptShift = alphabet.length - shift;
            return encrypt(encryptedText, decryptShift);
        }

    }



