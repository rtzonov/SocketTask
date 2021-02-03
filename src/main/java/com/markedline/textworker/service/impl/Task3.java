package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Word;
import com.markedline.textworker.parser.Parser;
import com.markedline.textworker.parser.impl.ParserImpl;
import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;
import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.result.StringResult;
import com.markedline.textworker.entity.result.WordResult;

import java.util.ArrayList;
import java.util.List;

public class Task3 implements TaskService {
    @Override
    public AbstractResult solve(AbstractInputData inputData) {
        Parser parser = new ParserImpl();

        List<Sentence> sentences = parser.getSentences(inputData.getInputText());

        final int FIRST_SENTENCE_IDX = 0;
        Sentence firstSentence = sentences.get(FIRST_SENTENCE_IDX);

        List<Word> wordsOfFirstSentence = firstSentence.getWords();

        List<Word> wordsOfOtherSentences = new ArrayList<>();

        for (int i = 1; i < sentences.size(); i++) {
            wordsOfOtherSentences.addAll(sentences.get(i).getWords());
        }

        for (Word word : wordsOfFirstSentence) {
            if (!wordsOfOtherSentences.contains(new Word(word.getText().toLowerCase())) && !wordsOfOtherSentences.contains(word))
                return new WordResult(word);
        }

        final String ALL_WORDS_REPEAT_MESSAGE = "Все слова первого предложения повторяются в других приложениях.";

        return new StringResult(ALL_WORDS_REPEAT_MESSAGE);
    }
}
