package se.isa.a01.task_01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Today {
    public static void print() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        System.out.println("Today's date is: " + now.format(formatter));

    }
}
