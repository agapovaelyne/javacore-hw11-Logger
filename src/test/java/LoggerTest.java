import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoggerTest {
    Logger logger = Logger.getLogger();

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    protected Date dateTimeNow = new Date();
    protected SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    Pattern loglinePattern = Pattern.compile("\\[(.+) (.+)\\] (.+)");

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    void getLogger_test1() {
        Assert.assertNotEquals(logger, null);
    }

    @Test
    void getLogger_test2() {
        Logger logger2 = Logger.getLogger();
        Assert.assertEquals(logger, logger2);
    }

    @Test
    public void getLoggerOutput_test1() {
        String testString = "Hello!";
        provideInput(testString);
        logger.log(testString);
        Matcher matcher = loglinePattern.matcher(getOutput());
        Assert.assertTrue(matcher.find());
        Assert.assertEquals(testString, matcher.group(3));
        Assert.assertEquals(String.valueOf(logger.counter-1), matcher.group(2));
        Assert.assertEquals(formatForDateNow.format(dateTimeNow), matcher.group(1));
    }

    @Test
    public void getLoggerOutput_test2() {
        String testString = "Hello!";
        provideInput(testString);
        String expected = String.valueOf(logger.counter);
        logger.log(testString);
        logger.log(testString);
        Assert.assertEquals(expected.charAt(0), getOutput().charAt(21));
    }
}
