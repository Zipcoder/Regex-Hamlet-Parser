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
        String actual = hamletParser.getHamletData();
        hamletText = hamletParser.changeHamletToLeon(hamletText);
        Assert.assertNotEquals(hamletText, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String actual = hamletParser.getHamletData();
        hamletText = hamletParser.changeHoratioToTariq(hamletText);
        Assert.assertNotEquals(hamletText, actual);
    }

    @Test
    public void testFindHoratio() {
        hamletText = hamletParser.changeHoratioToTariq(hamletText);
        Boolean checker = hamletText.contains("HORATIO");
        Assert.assertFalse(checker);
    }

    @Test
    public void testFindHamlet() {
        hamletText = hamletParser.changeHamletToLeon(hamletText);
        Boolean checker = hamletText.contains("HAMLET");
        Assert.assertFalse(checker);
    }
}