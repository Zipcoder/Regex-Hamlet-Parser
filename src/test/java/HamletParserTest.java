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

        String original = "Hamlet gets up in the morning";
        String expected = "Leon gets up in the morning";
        String actual = hamletParser.changeHamletToLeon(original);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {

        String original = "Horatio gets up in the morning";
        String expected = "Tariq gets up in the morning";
        String actual = hamletParser.changeHoratioToTariq(original);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {

        boolean actual = hamletParser.findHamlet(hamletText);

        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHoratio2() {

        boolean actual = hamletParser.findHamlet(hamletParser.changeHamletToLeon(hamletText));

        Assert.assertFalse(actual);
    }

    @Test
    public void testFindHamlet() {

        boolean actual = hamletParser.findHoratio(hamletText);

        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet2() {

        boolean actual = hamletParser.findHoratio(hamletParser.changeHoratioToTariq(hamletText));

        Assert.assertFalse(actual);
    }
}