import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {
//TODO Beginning with tests, you are to program all the steps it will take to complete that process.
// Some tests have been stubbed out for you but these will not cover
// all the methods you should have in your project.


//TODO Make a project that will go through the hamlet file provided and using regex replace every instance
// of "Hamlet" with "Leon" and every instance of Horatio with "Tariq".
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

            //scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String replaceToLeon(String content) {

        Pattern p = Pattern.compile("HAMLET", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(content);


        return m.replaceAll("Leon");


    }

    public String replaceToTariq(String content) {

        Pattern p = Pattern.compile("HORATIO", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(content);


        return m.replaceAll("Tariq");

    }




}
