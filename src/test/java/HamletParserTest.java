import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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
    public void getHamletData() {
        String actual = hamletParser.getHamletData();
        String expected = hamletText;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHamletToLeon() {
        String tester = hamletParser.changeHamlet(hamletText);
        Assert.assertFalse(hamletParser.findHamlet(tester));

    }

    @Test
    public void testChangeHoratioToTariq() {
        String tester = hamletParser.changeHoratio(hamletText);
        Assert.assertFalse(hamletParser.findHoratio(tester));

    }

    @Test
    public void testFindHoratio() {
        Assert.assertTrue(hamletParser.findHoratio(hamletText));
        Assert.assertFalse(hamletParser.findHoratio("Hopatio is a dude of some sort"));
    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(hamletParser.findHamlet(hamletText));
        Assert.assertFalse(hamletParser.findHamlet("Hamjet is a dude of some sort"));
    }
}