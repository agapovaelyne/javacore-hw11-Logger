import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int tresholdF;

    public Filter(int treshold) {
        this.tresholdF = treshold;
    }

    public List<Integer> filterOut(List<Integer> list) {
        Logger logger = Logger.getLogger();
        List<Integer> result = new ArrayList<>();
        logger.log("Запускаем фильтрацию");

        for (Integer element:list) {
            if (element >= tresholdF) {
                result.add(element);
                logger.log(String.format("Элемент \"%d\" проходит" , element));
            } else {
                logger.log(String.format("Элемент \"%d\" не проходит" , element));
            }
        }
        logger.log(String.format("Прошло фильтр %d элемента из %d" , result.size(), list.size()));
        return result;
    }

}
