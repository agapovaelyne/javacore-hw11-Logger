import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FilterTest {
    protected int TesttresholdF = 2;
    public static List<Integer> list = new ArrayList<>(Arrays.asList(0,1,2,3,4));

    @Test
    void filterOut_test1(){
        Logger logger = Logger.getLogger();
        Filter filter = new Filter(TesttresholdF);
        List<Integer> result = filter.filterOut(list);
        Assert.assertEquals(3, result.size());
    }

    @Test
    void filterOut_test2(){
        Logger logger = Logger.getLogger();
        Filter filter = new Filter(TesttresholdF);
        List<Integer> result = filter.filterOut(list);
        boolean hasBug = false;
        for (Integer element: result) {
            if (element < 2) {
                hasBug = true;
            }
        }
        Assert.assertFalse(hasBug);
    }
}
