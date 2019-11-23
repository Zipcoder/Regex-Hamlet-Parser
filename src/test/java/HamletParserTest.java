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
    public void testHamParser() {
        Integer actual = hamletText.length();
        Integer expected = 174967;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHamletToLeon() {
        Assert.assertTrue(Replacer.find(hamletText, "Hamlet"));

        String actual = Replacer.replaceHamlet(hamletText);
        Boolean result = Replacer.find(actual, "Hamlet");
        Assert.assertFalse(result);
    }

    @Test
    public void testChangeBoth() {
        String actual = Replacer.replaceHamlet(hamletText);
        actual = Replacer.replaceHoratio(actual);
        Assert.assertEquals("", actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        Assert.assertTrue(Replacer.find(hamletText, "Horatio"));

        String actual = Replacer.replaceHoratio(hamletText);
        Boolean result = Replacer.find(actual, "Horatio");
        Assert.assertFalse(result);
    }

    @Test
    public void testFindHoratio1() {
        Assert.assertTrue(Replacer.find(hamletText, "Horatio"));
    }

    @Test
    public void testFindHoratio2() {
        String text = "Henry heard heavy hippos in the hollow";
        Assert.assertFalse(Replacer.find(text, "Horatio"));
    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(Replacer.find(hamletText, "Hamlet"));
    }
}