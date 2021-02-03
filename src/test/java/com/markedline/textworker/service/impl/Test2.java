package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.inputdata.TextInputData;
import com.markedline.textworker.service.TaskService;
import org.junit.Assert;
import org.junit.Test;

public class Test2 {

    @Test
    public void testWordsSequence01() {
        String text = "Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них. Найти наибольшее количество предложений текста, в которых есть одинаковые слова. Привет, Марк!";
        String actual;
        String expected = "Привет, Марк! Найти наибольшее количество предложений текста, в которых есть одинаковые слова. Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.";
        TaskService taskService = new Task2();

        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWordsSequence02() {
        String text = "Oh hi Mark. Wow K. von Mark. Mark.";
        String actual;
        String expected = "Mark. Oh hi Mark. Wow K. von Mark.";
        TaskService taskService = new Task2();

        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
