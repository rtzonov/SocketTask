package com.markedline.textworker.service.impl;

import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.TextInputData;
import org.junit.Assert;
import org.junit.Test;

public class Test15 {

    @Test
    public void testWordsTransform01() {
        String text = "Клубника очьень вкусная. Ммм, вкусная клубника. Обожаю её.";
        String actual;
        String expected = "Клубниа очень вкусная Мм вкусная клубниа Обжаю её";
        TaskService taskService = new Task15();

        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
