package ru.netology;

import ru.netology.filter.Filter;
import ru.netology.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        String instruction;
        int listLength = 0;
        int listMaxElement = 0;
        int threshold = 0;
        boolean flag;

        logger.log("Program is started");

        // List length input
        logger.log("Offer user to input list length");
        flag = true;
        instruction = "Input list length or input \"0\" to quit -> ";
        while (flag) {
            listLength = getUserInput(instruction);
            if (listLength == 0) {
                logger.log("User have finished program");
                return;
            } else if (listLength < 0) {
                logger.log("User have input incorrect list length");
                logger.log("Offer user to input list length again");
                System.out.println("Incorrect input");
            } else {
                logger.log("Input list length is " + listLength);
                flag = false;
            }
        }

        // Maximum list element input
        logger.log("Offer user to input list maximum element");
        flag = true;
        instruction = "Input list maximum element or input \"0\" to quit -> ";
        while (flag) {
            listMaxElement = getUserInput(instruction);
            if (listMaxElement == 0) {
                logger.log("User have finished program");
                return;
            } else if (listMaxElement < 0) {
                logger.log("User have input incorrect list maximum element");
                logger.log("Offer user to input list maximum element again");
                System.out.println("Incorrect input");
            } else {
                logger.log("Input list maximum element is " + listMaxElement);
                flag = false;
            }
        }

        // List creation and fulfillment
        logger.log("List creation and fulfillment");
        Random random = new Random();
        List<Integer> source = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            source.add(random.nextInt(listMaxElement));
        }
        System.out.println("Input random list is " + source);

        // Threshold input
        logger.log("Offer user to input threshold");
        flag = true;
        instruction = "Input threshold or input \"0\" to quit -> ";
        while (flag) {
            threshold = getUserInput(instruction);
            if (threshold == 0) {
                logger.log("User have finished program");
                return;
            } else if (threshold < 0) {
                logger.log("User have input incorrect threshold");
                logger.log("Offer user to input threshold again");
                System.out.println("Incorrect input");
            } else {
                logger.log("Input threshold is " + threshold);
                flag = false;
            }
        }

        // List filtration
        logger.log("List filtration");
        Filter filter = new Filter(threshold);
        List<Integer> result = filter.filterOut(source);

        logger.log("Filtration is finished");
        logger.log("Result list will be displayed");
        System.out.println("Filtered random list is " + result);

        // Program finish
        logger.log("Program finished");
    }

    public static int getUserInput(String instruction) {
        Scanner in = new Scanner(System.in);

        System.out.print(instruction);
        String stringInput = in.nextLine();
        int integerInput;
        try {
            integerInput = Integer.parseInt(stringInput);
        } catch (NumberFormatException nfe) {
            integerInput = -1;
        }
        return integerInput;
    }
}