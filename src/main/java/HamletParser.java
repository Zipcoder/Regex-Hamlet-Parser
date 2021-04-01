import com.sun.xml.internal.rngom.digested.DPattern;

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

    public String changeHamletToLeon(){
        Pattern pattern = Pattern.compile("(Hamlet)",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        boolean matchFound = matcher.find();
        String newString = hamletData;

        if(matchFound){
            newString = matcher.replaceAll("Leon");
        }
        return newString;
    }

    public String changeHoratioToTariq(){
        Pattern pattern = Pattern.compile("(Horatio)",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        boolean matchFound = matcher.find();
        String newString = hamletData;

        if(matchFound){
            newString = matcher.replaceAll("Tariq");
        }
        return newString;
    }
    public boolean findHoratio(){
        Pattern pattern = Pattern.compile("(Horatio)",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        boolean matchFound = matcher.find();
        if(matchFound){
            return true;
        }
        return false;
    }
    public boolean findHamlet(){
        Pattern pattern = Pattern.compile("(Hamlet)",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        boolean matchFound = matcher.find();
        if(matchFound){
            return true;
        }
        return false;
    }

}
