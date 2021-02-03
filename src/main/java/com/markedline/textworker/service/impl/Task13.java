package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Word;
import com.markedline.textworker.entity.text.comparator.DescendingLetterAmountOrderComparator;
import com.markedline.textworker.parser.Parser;
import com.markedline.textworker.parser.impl.ParserImpl;
import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;
import com.markedline.textworker.entity.result.WordlistResult;

import java.util.List;

public class Task13 implements TaskService {
    @Override
    public AbstractResult solve(AbstractInputData inputData) {
        Parser parser = new ParserImpl();

        List<Sentence> sentences = parser.getSentences(inputData.getInputText());

        char givenLetter = inputData.getInputFirstChar();

        List<Word> words = parser.getWordsFromSentences(sentences);

        words.sort(new DescendingLetterAmountOrderComparator(givenLetter));

        return new WordlistResult(words);
    }
}
