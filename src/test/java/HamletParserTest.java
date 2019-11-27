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
        String hamletReplaced = FindAndReplaceClass.replaceHamlet(hamletText);
        Assert.assertFalse(FindAndReplaceClass.findHamlet(hamletReplaced));
        Assert.assertTrue(FindAndReplaceClass.findLeon(hamletReplaced));
    }

    @Test
    public void testChangeHoratioToTariq() {
        String hamletReplaced = FindAndReplaceClass.replaceHoratio(hamletText);
        Assert.assertFalse(FindAndReplaceClass.findHoratio(hamletReplaced));
        Assert.assertTrue(FindAndReplaceClass.findTariq(hamletReplaced));
    }

    @Test
    public void testFindHoratio() {
        String checkThis = "Horatia Horton Hotatio Hamnet";
        Assert.assertFalse(FindAndReplaceClass.findHoratio(checkThis));

        String checkThis2 = "Horatia Horatio Hora";
        Assert.assertTrue(FindAndReplaceClass.findHoratio(checkThis2));
    }

    @Test
    public void testFindHamlet() {
        String checkThis = "Horatia Horton Hotatio Hamnet";
        Assert.assertFalse(FindAndReplaceClass.findHamlet(checkThis));

        String checkThis2 = "Horatia Horatio Hamlet";
        Assert.assertTrue(FindAndReplaceClass.findHamlet(checkThis2));

    }

    @Test
    public void testFindLeon() {
        String checkThis = "noeL Leo Leo n Leos Lon Lwon eon";
        Assert.assertFalse(FindAndReplaceClass.findLeon(checkThis));

        String checkThis2 = "noeL Leo Leo n eon Lon Lwon Leon";
        Assert.assertTrue(FindAndReplaceClass.findLeon(checkThis2));
    }

    @Test
    public void testFindTariq() {
        String checkThis = "Ta riq Tar iq TaIq Toriq";
        Assert.assertFalse(FindAndReplaceClass.findTariq(checkThis));

        String checkThis2 = "Ta riq Tar iq TarIg Tariq";
        Assert.assertTrue(FindAndReplaceClass.findTariq(checkThis2));
    }
}