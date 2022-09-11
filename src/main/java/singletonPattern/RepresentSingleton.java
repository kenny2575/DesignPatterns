package singletonPattern;

import com.google.common.base.CharMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RepresentSingleton {
    public static Logger logger = Logger.getInstance();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int listSize = getIntValue("Введите размер списка: ");
        int maxItem = getIntValue("Введите верхнюю границу для значений: ");

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(maxItem));
        }
        logger.log("Случайный список: " + list);

        Filter filter = new Filter(getIntValue("Введите порог для фильтра: "));
        logger.log("Отфильтрованный список: " + filter.filterOut(list));
        logger.log("Завершаем программу");
    }

    private static int getIntValue(String logText) {
        logger.log(logText);
        String line = "";
        while (line.isEmpty()) {
            line = CharMatcher.digit().retainFrom(scanner.nextLine());
            if (line.isEmpty()) {
                logger.log("Неверный формат числа. Повторите ввод");
            }
        }
        return Integer.parseInt(line);
    }

}
