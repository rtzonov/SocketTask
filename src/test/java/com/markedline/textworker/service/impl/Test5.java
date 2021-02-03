package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.inputdata.TextInputData;
import com.markedline.textworker.service.TaskService;
import org.junit.Assert;
import org.junit.Test;

public class Test5 {

    @Test
    public void testFirstAndLastWordsSwap01() {
        String text = "Клубника очень вкусная. Ммм, вкусная клубника. Обожаю её.";
        String actual;
        String expected = "вкусная очень Клубника. клубника, вкусная Ммм. её Обожаю.";
        TaskService taskService = new Task5();

        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
