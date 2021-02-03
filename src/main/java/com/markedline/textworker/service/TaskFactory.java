package com.markedline.textworker.service;

import com.markedline.textworker.service.impl.*;

public final class TaskFactory {

    public static TaskService createTask(String command) {
        return switch (command) {
            case "2" -> new Task2();
            case "3" -> new Task3();
            case "4" -> new Task4();
            case "5" -> new Task5();
            case "6" -> new Task6();
            case "7" -> new Task7();
            case "8" -> new Task8();
            case "9" -> new Task9();
            case "10" -> new Task10();
            case "11" -> new Task11();
            case "12" -> new Task12();
            case "13" -> new Task13();
            case "14" -> new Task14();
            case "15" -> new  Task15();
            case "16" -> new Task16();
            default -> new Task1();
        };
    }
}
