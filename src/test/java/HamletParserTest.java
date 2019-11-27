import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        String result = hamletParser.replaceString(hamletText,"Hamlet","Leon");
        Boolean actual  = hamletParser.findPattern(result,"Hamlet");
        Assert.assertFalse(actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String result = hamletParser.replaceString(hamletText,"Horatio","Tariq");
        Boolean actual  = hamletParser.findPattern(result,"Horatio");
        Assert.assertFalse(actual);
    }

    @Test
    public void testFindHoratio() {
        Boolean actual  = hamletParser.findPattern(this.hamletText,"Horatio");

        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {
        Boolean actual  = hamletParser.findPattern(this.hamletText,"Hamlet");

        Assert.assertTrue(actual);
    }
}