package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Word;
import com.markedline.textworker.entity.text.comparator.FirstConsonantLetterAlphabeticalOrderComparator;
import com.markedline.textworker.parser.Parser;
import com.markedline.textworker.parser.impl.ParserImpl;
import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;
import com.markedline.textworker.entity.result.WordlistResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task8 implements TaskService {

    private final List<Character> vowels = Arrays.asList(
            'а', 'е', 'ё', 'и',
            'о', 'у', 'ы', 'э',
            'ю', 'я', 'a', 'e',
            'i', 'o', 'u', 'y'
    );

    @Override
    public AbstractResult solve(AbstractInputData inputData) {
        Parser parser = new ParserImpl();

        List<Sentence> sentences = parser.getSentences(inputData.getInputText());

        List<Word> words = parser.getWordsFromSentences(sentences);

        List<Word> wordsWithFirstVowel = filterWordsWithFirstVowel(words);

        wordsWithFirstVowel.sort(new FirstConsonantLetterAlphabeticalOrderComparator());

        return new WordlistResult(wordsWithFirstVowel);
    }

    private List<Word> filterWordsWithFirstVowel(List<Word> words) {
        return words.stream().filter(word -> vowels.contains(Character.toLowerCase(word.getText().charAt(0)))).
                collect(Collectors.toList());
    }
}
