import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String input = "Hamlet loves you. Hamlet wants the best for you!";
        String actual = Replacer.replaceHamlet(input);
        String expected = "Leon loves you. Leon wants the best for you!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String input = "Horatio wants the best for you because Horatio loves you.";
        String actual = Replacer.replaceHoratio(input);
        String expected = "Tariq wants the best for you because Tariq loves you.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        String value = hamletText;
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(value);
        Assert.assertTrue(matcher.find());
    }

    @Test
    public void testFindHamlet() {
        String value = hamletText;
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(value);
        Assert.assertTrue(matcher.find());
    }
}