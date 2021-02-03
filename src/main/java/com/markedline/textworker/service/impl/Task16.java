package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Text;
import com.markedline.textworker.entity.text.Word;
import com.markedline.textworker.parser.Parser;
import com.markedline.textworker.parser.impl.ParserImpl;
import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;
import com.markedline.textworker.entity.result.TextResult;

import java.util.List;

public class Task16 implements TaskService {
    @Override
    public AbstractResult solve(AbstractInputData inputData) {
        Parser parser = new ParserImpl();

        List<Sentence> sentences = parser.getSentences(inputData.getInputText());

        int givenSentenceNumber = inputData.getInputNumber();

        Sentence sentenceToModify = sentences.get(givenSentenceNumber - 1);

        int givenLength = inputData.getInputLength();

        String givenSubstring = inputData.getInputString();

        modifySentence(sentenceToModify, givenLength, givenSubstring);

        Text text = new Text(sentences);

        return new TextResult(text);
    }

    private void modifySentence(Sentence sentence, int wordLength, String substring) {
        for (Word word : sentence.getWords()) {
            if (word.getLength() == wordLength) {
                word.setText(substring);
            }
        }
    }
}
