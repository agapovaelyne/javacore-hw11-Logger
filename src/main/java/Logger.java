import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger logger;

    protected int counter = 1;
    protected Date dateTimeNow = new Date();
    protected SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    private Logger() {}

    public static Logger getLogger() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    public void log(String msg){
        System.out.println(String.format("[%s %s] %s", formatForDateNow.format(dateTimeNow), counter, msg));
        counter += 1;
    };
}
