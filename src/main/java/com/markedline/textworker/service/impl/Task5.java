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

public class Task5 implements TaskService {
    @Override
    public AbstractResult solve(AbstractInputData inputData) {
        Parser parser = new ParserImpl();

        List<Sentence> sentences = parser.getSentences(inputData.getInputText());

        final int FIRST_WORD_IDX = 0;

        for (Sentence sentence : sentences) {
            final int LAST_WORD_IDX = sentence.getWords().size() - 1;
            Word firstWord = sentence.getWords().get(FIRST_WORD_IDX);
            Word lastWord = sentence.getWords().get(LAST_WORD_IDX);
            String tempWordText = firstWord.getText();
            firstWord.setText(lastWord.getText());
            lastWord.setText(tempWordText);
        }

        Text text = new Text(sentences);

        return new TextResult(text);
    }
}
