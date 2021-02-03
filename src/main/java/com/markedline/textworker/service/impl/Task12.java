package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Word;
import com.markedline.textworker.parser.Parser;
import com.markedline.textworker.parser.impl.ParserImpl;
import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;
import com.markedline.textworker.entity.result.WordlistResult;

import java.util.Arrays;
import java.util.List;

public class Task12 implements TaskService {

    private final List<Character> consonants = Arrays.asList(
            'б', 'в', 'г', 'д',
            'ж', 'з', 'й', 'к',
            'л', 'м', 'н', 'п',
            'р', 'с', 'т', 'ф',
            'х', 'ц', 'ч', 'ш',
            'щ', 'b', 'c', 'd',
            'f', 'g', 'h', 'j',
            'k', 'l', 'm', 'n',
            'p', 'q', 'r', 's',
            't', 'v', 'w', 'x',
            'z'
    );

    @Override
    public AbstractResult solve(AbstractInputData inputData) {
        Parser parser = new ParserImpl();

        List<Sentence> sentences = parser.getSentences(inputData.getInputText());

        int givenLength = inputData.getInputLength();

        List<Word> words = parser.getWordsFromSentences(sentences);

        removeWordsWithFirstConsonantAndGivenLength(words, givenLength);

        return new WordlistResult(words);
    }

    private void removeWordsWithFirstConsonantAndGivenLength(List<Word> words, int length) {
        words.removeIf(word -> consonants.contains(Character.toLowerCase(word.getText().charAt(0))) &&
                word.getLength() == length);
    }
}
