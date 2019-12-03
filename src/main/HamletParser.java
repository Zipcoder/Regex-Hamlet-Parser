import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {

        return hamletData;
    }

    public String replace(String name, String replaceName){
        Pattern pattern = Pattern.compile(name);
        Matcher matcher = pattern.matcher(hamletData);
        return matcher.replaceAll(replaceName);
    }

    public void writeFile(String hamletText) throws FileNotFoundException {
        String fileName = "hamlet.txt";
        FileOutputStream outputStream = new FileOutputStream(fileName);
        Formatter formatter = new Formatter(outputStream);
        formatter.format(hamletText);
        formatter.flush();
    }

    public Boolean findString(String value) {
        Pattern pattern = Pattern.compile(value);
        Matcher matcher = pattern.matcher(hamletData);
        return matcher.find();
    }



//    public void writeFile(String hamletText) throws FileNotFoundException {
//        String fileName = "hamlet.txt";
//        FileOutputStream outputStream = new FileOutputStream(fileName);
//        Formatter formatter = new Formatter(outputStream);
//        formatter.format(hamletText);
//        formatter.flush();
//    }


}
