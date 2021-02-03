package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.comparator.FirstLetterAlphabeticalOrderComparator;
import com.markedline.textworker.entity.text.Word;
import com.markedline.textworker.parser.Parser;
import com.markedline.textworker.parser.impl.ParserImpl;
import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;
import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.result.StringResult;

import java.util.List;

public class Task6 implements TaskService {
    @Override
    public AbstractResult solve(AbstractInputData inputData) {
        Parser parser = new ParserImpl();

        List<Sentence> sentences = parser.getSentences(inputData.getInputText());

        List<Word> words = parser.getWordsFromSentences(sentences);

        words.sort(new FirstLetterAlphabeticalOrderComparator());

        StringBuilder sortedWords = new StringBuilder();

        String prevWordFirstLetter = null;
        for (Word word : words) {
            String currentWordFirstLetter = word.getText().substring(0, 1).toLowerCase();
            if (!currentWordFirstLetter.equals(prevWordFirstLetter)) {
                sortedWords.append("\n\t");
            } else {
                sortedWords.append(" ");
            }
            sortedWords.append(word.getText());
            prevWordFirstLetter = word.getText().substring(0, 1).toLowerCase();
        }
        return new StringResult(sortedWords.toString().trim());
    }
}
