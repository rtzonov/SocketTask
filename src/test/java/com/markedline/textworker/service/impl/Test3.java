package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.inputdata.TextInputData;
import com.markedline.textworker.service.TaskService;
import org.junit.Assert;
import org.junit.Test;

public class Test3 {

    @Test
    public void testDuplicatesPresence01() {
        String text = "Клубника очень вкусная. Ммм, вкусная клубника. Обожаю её.";
        String actual;
        String expected = "очень";
        TaskService taskService = new Task3();

        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDuplicatesPresence02() {
        String text = "The Good, the Bad and the Ugly.  /*!@*! Michael the. bad. Good. Bad.";
        String actual;
        String expected = "and";
        TaskService taskService = new Task3();
        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDuplicatesPresence03() {
        String text = "Hi, I am Mark. I am 19 years old. Hi, Mark!";
        String actual;
        String expected = "Все слова первого предложения повторяются в других приложениях.";
        TaskService taskService = new Task3();
        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
