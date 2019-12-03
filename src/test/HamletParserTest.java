import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

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
    public void testChangeHamletToLeon() throws FileNotFoundException {
        String toreplaceText = "Hamlet";
        String tobereplacedbyText = "Leon";
        hamletText = hamletParser.replace(toreplaceText,tobereplacedbyText);
        hamletParser.writeFile(hamletText);

        Assert.assertTrue(hamletText.contains("Leon"));
        Assert.assertFalse(hamletText.contains("Hamlet"));
    }

    @Test
    public void testChangeHoratioToTariq() throws FileNotFoundException {
        String toreplaceText = "Horatio";
        String tobereplacedbyText = "Tariq";
        hamletText = hamletParser.replace(toreplaceText,tobereplacedbyText);
        hamletParser.writeFile(hamletText);

        Assert.assertTrue(hamletText.contains("Tariq"));
        Assert.assertFalse(hamletText.contains("Horatio"));
    }

    @Test
    public void testFindHoratio() {
        Assert.assertTrue(hamletParser.findString("Horatio"));

    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(hamletParser.findString("Hamlet"));
    }
}