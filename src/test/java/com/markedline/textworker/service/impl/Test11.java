package com.markedline.textworker.service.impl;

import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.TextAndTwoSymbolsInputData;
import org.junit.Assert;
import org.junit.Test;

public class Test11 {

    @Test
    public void testSentencesCutting01() {
        String text = "Клубника очень вкусная. Ммм, вкусная клубникая. Обожаю её её её.";
        char firstSymbol = 'а';
        char secondSymbol = 'я';
        String actual;
        String expected = "Клубникая. Ммм, вкусная. Обожаю её её её.";
        TaskService taskService = new Task11();

        actual = taskService.solve(new TextAndTwoSymbolsInputData(text, firstSymbol, secondSymbol)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
