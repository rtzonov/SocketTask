package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.inputdata.TextAndLengthInputData;
import com.markedline.textworker.service.TaskService;
import org.junit.Assert;
import org.junit.Test;

public class Test4 {

    @Test
    public void testGettingWordsWithDemandedLength01() {
        String text = "Иван родил девчонку, велел тащить пелёнки? Вот такой вот наш Иван?";
        String actual;
        String expected = "родил велел такой";
        TaskService taskService = new Task4();

        actual = taskService.solve(new TextAndLengthInputData(text, 5)).getResult();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGettingWordsWithDemandedLength02() {
        String text = "Иван родил девчонку, велел тащить пелёнки? Вот такой вот наш Иван?";
        String actual;
        String expected = "Иван";
        TaskService taskService = new Task4();

        actual = taskService.solve(new TextAndLengthInputData(text, 4)).getResult();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGettingWordsWithDemandedLength03() {
        String text = "Иван родил девчонку, велел тащить пелёнки. Вот такой вот наш Иван.";
        String actual;
        String expected = "Слова с заданной длиной в вопросительных предложениях отсутствуют!";
        TaskService taskService = new Task4();

        actual = taskService.solve(new TextAndLengthInputData(text, 5)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
