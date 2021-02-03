package com.markedline.textworker.service.impl;

import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.TextAndWordlistInputData;
import org.junit.Assert;
import org.junit.Test;

public class Test10 {

    @Test
    public void testComplicatedSort01() {
        String text = "Клубника очень вкусная. Ммм, вкусная клубника. Обожаю её её её.";
        String wordlist = "Марк её клубника hi";
        String actual;
        String expected = "её клубника Марк hi";
        TaskService taskService = new Task10();

        actual = taskService.solve(new TextAndWordlistInputData(text, wordlist)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
