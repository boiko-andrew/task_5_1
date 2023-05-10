package ru.netology.filter;

import ru.netology.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        String inputMessage;

        for (Integer element : source) {
            if (element <= threshold) {
                inputMessage = "Element \"" + element + "\" is not passed";
            } else {
                inputMessage = "Element \"" + element + "\" is passed";
                result.add(element);
            }
            logger.log(inputMessage);
        }

        return result;
    }
}