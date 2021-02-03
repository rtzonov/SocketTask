package com.markedline.textworker.service.impl;

import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.TextAndLengthInputData;
import org.junit.Assert;
import org.junit.Test;

public class Test12 {

    @Test
    public void testRemovingWords01() {
        String text = "Клубника очень вкуснаяя. Ммм, вкуснаяя клубника. Обожаю сильно её её её.";
        String actual;
        String expected = "очень Ммм Обожаю сильно её её её";
        TaskService taskService = new Task12();

        actual = taskService.solve(new TextAndLengthInputData(text, 8)).getResult();

        Assert.assertEquals(expected, actual);
    }
}
