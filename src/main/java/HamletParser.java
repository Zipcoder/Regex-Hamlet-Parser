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



    public HamletParser() {
        this.hamletData = loadFile();
    }

    public String changeHoratio(String stringToParse) {
        String regex1 = "Horatio";
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcherHam = pattern.matcher(stringToParse);
        String newStory = matcherHam.replaceAll("Tariq");


        return newStory;
    }

    public String changeHamlet(String stringToParse) {
        String regex = "Hamlet";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherHam = pattern.matcher(stringToParse);
        String newStory = matcherHam.replaceAll("Leon");
        return newStory;

    }

    public Boolean findHamlet(String stringToParse){
        String regex = "Hamlet";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherHam = pattern.matcher(stringToParse);
        return matcherHam.find();
    }
    public Boolean findHoratio(String stingToParse){
        String regex2 = "Horatio";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcherHor = pattern2.matcher(stingToParse);
        return matcherHor.find();
    }

    private String loadFile() {
        //ClassLoader classLoader = getClass().getClassLoader();
        File file = new File("/Users/brian/dev/Week 6/Maven.Regex-Hamlet-Parser/src/main/resources/hamlet.txt");
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

}
