import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Scanner;

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
        //GIVEN
        String actual = hamletParser.getHamletData();

        //WHEN
        hamletText = hamletParser.replaceToLeon(hamletText);


        Assert.assertNotEquals(hamletText, actual);

    }

    @Test
    public void testChangeHoratioToTariq() {
        //GIVEN
        String actual = hamletParser.getHamletData();

        //WHEN
        hamletText = hamletParser.replaceToTariq(hamletText);


        Assert.assertNotEquals(hamletText, actual);

    }

    @Test
    public void testFindHoratio() {

        hamletText = hamletParser.replaceToTariq(hamletText);
        Boolean check = hamletText.contains("HORATIO");

        Assert.assertFalse(check);
    }

    @Test
    public void testFindHamlet() {

        hamletText = hamletParser.replaceToLeon(hamletText);
        Boolean check = hamletText.contains("HAMLET");

        Assert.assertFalse(check);
    }
    }
