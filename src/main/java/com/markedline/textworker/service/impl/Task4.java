package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.text.Delimiter;
import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Word;
import com.markedline.textworker.parser.Parser;
import com.markedline.textworker.parser.impl.ParserImpl;
import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;
import com.markedline.textworker.entity.result.StringResult;
import com.markedline.textworker.entity.result.WordlistResult;

import java.util.ArrayList;
import java.util.List;

public class Task4 implements TaskService {
    @Override
    public AbstractResult solve(AbstractInputData inputData) {
        Parser parser = new ParserImpl();

        List<Sentence> sentences = parser.getSentences(inputData.getInputText());

        int givenLength = inputData.getInputLength();

        List<Word> wordsWithGivenLength = new ArrayList<>();

        for (Sentence sentence : sentences) {
            if (sentence.getDelimiter().equals(Delimiter.QUESTION)) {
                for (Word word : sentence.getWords()) {
                    if (word.getLength() == givenLength && !wordsWithGivenLength.contains(word)) {
                        wordsWithGivenLength.add(word);
                    }
                }
            }
        }

        if (wordsWithGivenLength.isEmpty()) {
            final String WORDS_WITH_GIVEN_LENGTH_ABSENT_MESSAGE = "Слова с заданной длиной" +
                    " в вопросительных предложениях отсутствуют!";
            return new StringResult(WORDS_WITH_GIVEN_LENGTH_ABSENT_MESSAGE);
        }

        return new WordlistResult(wordsWithGivenLength);
    }
}
