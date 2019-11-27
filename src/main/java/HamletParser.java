import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public Boolean findPattern (String textToSearch, String pattern){
        Pattern pattern1 = Pattern.compile(pattern);

        return pattern1.matcher(textToSearch).find();
    }

    public String replaceString(String textToSearch, String pattern, String newWord){
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(textToSearch);

        String result = matcher.replaceAll(newWord);

        return result;
    }

}
