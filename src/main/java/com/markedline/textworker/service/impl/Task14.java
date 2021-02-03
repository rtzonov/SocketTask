package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Text;
import com.markedline.textworker.parser.Parser;
import com.markedline.textworker.parser.impl.ParserImpl;
import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;
import com.markedline.textworker.entity.result.StringResult;
import com.markedline.textworker.util.PalindromeFinder;

import java.util.List;

public class Task14 implements TaskService {
    @Override
    public AbstractResult solve(AbstractInputData inputData) {
        Parser parser = new ParserImpl();

        List<Sentence> sentences = parser.getSentences(inputData.getInputText());

        Text text = new Text(sentences);

        PalindromeFinder palindromeFinder = new PalindromeFinder();

        String longestPalindrome = palindromeFinder.findLongestPalindrome(text.toString());

        return new StringResult(longestPalindrome);
    }
}
