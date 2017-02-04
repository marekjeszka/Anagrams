import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Anagrams {
    public static void main(String[] args) throws IOException {
        char[] input = "marek".toLowerCase().toCharArray();
        Arrays.sort(input);
        final Stream<String> lines = Files.lines(Paths.get("polish.all"), Charset.forName("ISO-8859-1"));
        lines.filter(s -> s.length() == input.length)
             .filter(s -> isAnagram(s, input))
             .forEach(System.out::println);
    }

    private static boolean isAnagram(String s, char[] base) {
        char[] s1AsChar = s.toLowerCase().toCharArray();
        Arrays.sort(s1AsChar);
        return Arrays.equals(s1AsChar, base);
    }
}
