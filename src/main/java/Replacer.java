import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacer {
    public static String replace(String str, String replaceStr, String value){
        Pattern replacePattern = Pattern.compile("(?i:" + str + ")"); //for case insensitivity in the original string given (str)
        Matcher matcher = replacePattern.matcher(value);
        return matcher.replaceAll(replaceStr);
    }

    public static String replaceHamlet(String value){
        return replace("Hamlet", "Leon", value);
    }

    public static String replaceHoratio(String value){
        return replace("Horatio", "Tariq", value);
    }
}
