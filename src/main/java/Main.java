import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        logger.log("Запускаем программу");

        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int listSize = scanner.nextInt();
        System.out.print("Введите верхнюю границу для значений: ");
        int maxValue = scanner.nextInt();

        logger.log("Создаём и наполняем список");
        System.out.print("Вот случайный список:");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listSize ; i ++) {
            Integer element = random.nextInt(maxValue);
            list.add(element);
            System.out.print(" " + element);
        }
        System.out.println();
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int tresholdF = scanner.nextInt();
        Filter filter = new Filter(tresholdF);
        List<Integer> result = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список:");
        for (Integer element:result) {
            System.out.print(" " + element);
        }
        System.out.println();

        scanner.close();
        logger.log("Завершаем программу");
    }
}
