package com.markedline.textworker.service.impl;

import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.TextInputData;
import org.junit.Assert;
import org.junit.Test;

public class Test14 {

    @Test
    public void testLongestPalindrome01() {
        String text = "Ешьнемытоготыменьше.";
        String actual;
        String expected = "Ешьнемытоготыменьше";
        TaskService taskService = new Task14();

        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
