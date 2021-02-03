package com.markedline.textworker.service.impl;

import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.TextAndNumberAndLengthAndStringInputData;
import org.junit.Assert;
import org.junit.Test;

public class Test16 {

    @Test
    public void testSentenceTransform01() {
        String text = "Клубника очьеньь вкусная. Ммм, вкусная клубника. Обожаю её.";
        String substring = "@#^";
        int length = 7;
        int sentenceNumber = 1;
        String actual;
        String expected = "Клубника @#^ @#^. Ммм, вкусная клубника. Обожаю её.";
        TaskService taskService = new Task16();

        actual = taskService.solve(new TextAndNumberAndLengthAndStringInputData(text, sentenceNumber, length, substring)).getResult();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSentenceTransform02() {
        String text = "Клубника очьеньь вкусная. Ммм, вкусная клубника. Обожаю её её её.";
        String substring = "@#^";
        int length = 2;
        int sentenceNumber = 3;
        String actual;
        String expected = "Клубника очьеньь вкусная. Ммм, вкусная клубника. Обожаю @#^ @#^ @#^.";
        TaskService taskService = new Task16();

        actual = taskService.solve(new TextAndNumberAndLengthAndStringInputData(text, sentenceNumber, length, substring)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
