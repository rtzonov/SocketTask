package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Word;
import com.markedline.textworker.parser.Parser;
import com.markedline.textworker.parser.impl.ParserImpl;
import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;
import com.markedline.textworker.entity.result.WordlistResult;

import java.util.List;

public class Task15 implements TaskService {
    @Override
    public AbstractResult solve(AbstractInputData inputData) {
        Parser parser = new ParserImpl();

        List<Sentence> sentences = parser.getSentences(inputData.getInputText());

        List<Word> words = parser.getWordsFromSentences(sentences);

        for (Word word : words) {
            transformWord(word);
        }

        return new WordlistResult(words);
    }

    private void transformWord(Word word) {
        String currentText = word.getText();
        StringBuilder newText = new StringBuilder();

        if (currentText.length() == 1) {
            return;
        }

        char firstLetter = currentText.charAt(0);
        char lastLetter = currentText.charAt(currentText.length() - 1);

        newText.append(firstLetter);

        for (int i = 1; i < currentText.length() - 1; i++) {
            char tmpLetter = currentText.charAt(i);
            if (tmpLetter != Character.toLowerCase(firstLetter) && tmpLetter != lastLetter) {
                newText.append(tmpLetter);
            }
        }

        newText.append(lastLetter);

        word.setText(newText.toString());
    }
}
