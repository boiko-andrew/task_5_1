package ru.netology.logger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    protected int num = 1;

    public void log(String msg) {
        String datePattern = "dd.MM.yyyy";
        LocalDate localDate = LocalDate.now();
        String date = localDate.format(DateTimeFormatter.ofPattern(datePattern));

        String timePattern = "HH:mm:ss.SSS";
        LocalTime localTime = LocalTime.now();
        String time = localTime.format(DateTimeFormatter.ofPattern(timePattern));

        String strNum;
        strNum = String.format("%02d", num);
        num++;

        String outputMessage = "[" + date + " " + time + " "
                + strNum + "] " + msg;
        System.out.println(outputMessage);
    }
}