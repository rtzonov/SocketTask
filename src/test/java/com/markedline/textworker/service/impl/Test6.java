package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.inputdata.TextInputData;
import com.markedline.textworker.service.TaskService;
import org.junit.Assert;
import org.junit.Test;

public class Test6 {

    @Test
    public void testFirstLetterAlphabeticalOrderSort01() {
        String text = "Вот такой вот наш Иван вот ваш.";
        String actual;
        String expected = "Вот вот вот ваш\n\tИван\n\tнаш\n\tтакой";
        TaskService taskService = new Task6();

        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
