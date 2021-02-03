package com.markedline.textworker.service.impl;

import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.TextInputData;
import org.junit.Assert;
import org.junit.Test;

public class Test1 {

    @Test
    public void testWordsSequence01() {
        String text = "Я Марк. Привет, я Аркадий. Аркадий, привет. Привет, Марк. Привет!";
        String actual;
        String expected = "3";
        TaskService taskService = new Task1();

        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
