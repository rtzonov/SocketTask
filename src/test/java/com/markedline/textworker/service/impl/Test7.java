package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.inputdata.TextInputData;
import com.markedline.textworker.service.TaskService;
import org.junit.Assert;
import org.junit.Test;

public class Test7 {

    @Test
    public void testVowelsWeightSort01() {
        String text = "Вот такой вот наш Иван.";
        String actual;
        String expected = "Вот вот наш такой Иван";
        TaskService taskService = new Task7();

        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testVowelsWeightSort02() {
        String text = "Иван родил девчонку, велел тащить пелёнки. О!";
        String actual;
        String expected = "тащить девчонку родил велел пелёнки Иван О";
        TaskService taskService = new Task7();

        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
