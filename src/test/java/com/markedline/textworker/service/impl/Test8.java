package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.inputdata.TextInputData;
import com.markedline.textworker.service.TaskService;
import org.junit.Assert;
import org.junit.Test;

public class Test8 {

    @Test
    public void testComplicatedSort01() {
        String text = "Клубника очень вкусная. Ммм, вкусная клубника. Обожаю её.";
        String actual;
        String expected = "её Обожаю очень";
        TaskService taskService = new Task8();

        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testComplicatedSort02() {
        String text = "Оболонь очень обожаю.";
        String actual;
        String expected = "Оболонь обожаю очень";
        TaskService taskService = new Task8();

        actual = taskService.solve(new TextInputData(text)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
