package singletonPattern;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold){
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию!");
        List<Integer> result = new ArrayList<>();
        for (int amount : source) {
            if (amount < threshold) {
                logger.log("Элемент \"" + amount + "\" не подходит!");
            } else {
                result.add(amount);
                logger.log("Элемент \"" + amount + "\" проходит!");
            }
        }
        logger.log("Прошло фильтр " + result.size() + " элемента из " + source.size());
        return result;
    }

}
