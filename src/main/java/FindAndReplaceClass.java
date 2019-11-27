import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAndReplaceClass {

    public static Boolean findString(String findThis, String fullText){
        Pattern r = Pattern.compile("(?i:" + findThis + ")");
        Matcher m = r.matcher(fullText);
        return m.find();
    }

    public static Boolean findHamlet(String fullText){
        return findString("Hamlet", fullText);
    }

    public static Boolean findHoratio(String fullText){
        return findString("Horatio", fullText);
    }

    public static Boolean findLeon(String fullText){
        return findString("Leon", fullText);
    }
    public static Boolean findTariq(String fullText){
        return findString("Tariq", fullText);
    }


    public static String replace(String fullText, String findThis, String replaceWithThis){
        Pattern pattern = Pattern.compile("(?i:" + findThis + ")");
        Matcher matcher = pattern.matcher(fullText);
        return matcher.replaceAll(replaceWithThis);
    }

    public static String replaceHamlet(String fullText){
        return replace(fullText, "Hamlet", "Leon");
    }

    public static String replaceHoratio(String fullText){
        return replace(fullText, "Horatio","Tariq");
    }
}
