import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacer {
    public static String replace(String input, String original, String replace) {
        Pattern pattern = Pattern.compile("(?i:" + original + ")");
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll(replace);
    }


    public static String replaceHamlet(String input) {
        return replace(input, "Hamlet", "Leon");
    }

    public static String replaceHoratio(String input) {
        return replace(input, "Horatio", "Tariq");
    }

    public static Boolean find(String input, String value) {
        Pattern pattern = Pattern.compile("(?i:" + value + ")");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
