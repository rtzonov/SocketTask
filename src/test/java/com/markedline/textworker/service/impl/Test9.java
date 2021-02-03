package com.markedline.textworker.service.impl;

import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.TextAndSymbolInputData;
import org.junit.Assert;
import org.junit.Test;

public class Test9 {

    @Test
    public void testComplicatedSort01() {
        String text = "Клубника очень вкусная. Ммм, вкусная клубника. Обожаю её.";
        String actual;
        String expected = "её Ммм очень вкусная вкусная Клубника клубника Обожаю";
        TaskService taskService = new Task9();

        actual = taskService.solve(new TextAndSymbolInputData(text, 'а')).getResult();

        Assert.assertEquals(expected, actual);
    }
}
