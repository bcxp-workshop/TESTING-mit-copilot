import java.util.Set;

public class VowelEncoder {

    private static final Set<Character> VOWELS = Set.of(
                    'a', 'e', 'i', 'o', 'u', 'ä', 'ö', 'ü'
    );

    public static void main(String[] args) {
        String input = "Hello World!";
        String encodedWord = encode(input);
        System.out.println(encodedWord);
    }

    public static String encode(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (isVowel(c)) {
                result.append(c).append("lew").append(c);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static boolean isVowel(char c) {
        return VOWELS.contains(Character.toLowerCase(c));
    }
}