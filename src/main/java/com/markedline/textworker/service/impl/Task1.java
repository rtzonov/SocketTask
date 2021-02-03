package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Word;
import com.markedline.textworker.parser.Parser;
import com.markedline.textworker.parser.impl.ParserImpl;
import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;
import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.result.IntegerResult;

import java.util.*;

public class Task1 implements TaskService {
    @Override
    public AbstractResult solve(AbstractInputData inputData) {
        Parser parser = new ParserImpl();

        List<Sentence> sentences = parser.getSentences(inputData.getInputText());

        List<Word> words = parser.getWordsFromSentences(sentences);

        Set<Word> uniqueWords = getUniqueWordsSet(words);

        Map<Word, Integer> wordAmountMap = new LinkedHashMap<>();

        for (Word word : uniqueWords) {
            wordAmountMap.put(word, 0);
        }

        for (Sentence sentence : sentences) {
            for (Word word : uniqueWords) {
                if (sentence.getWords().contains(word)) {
                    Integer amount = wordAmountMap.get(word);
                    wordAmountMap.put(word, amount + 1);
                }
            }
        }

        return new IntegerResult(getMapMaxValue(wordAmountMap));
    }

    private Set<Word> getUniqueWordsSet(List<Word> words) {
        return new LinkedHashSet<>(words);
    }

    private <K, V extends Comparable<V>> V getMapMaxValue(Map<K, V> map) {
        Map.Entry<K, V> maxEntry = Collections.max(map.entrySet(), Map.Entry.comparingByValue());
        return maxEntry.getValue();
    }
}
