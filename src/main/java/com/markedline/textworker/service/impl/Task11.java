package com.markedline.textworker.service.impl;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Text;
import com.markedline.textworker.parser.Parser;
import com.markedline.textworker.parser.impl.ParserImpl;
import com.markedline.textworker.service.TaskService;
import com.markedline.textworker.entity.inputdata.AbstractInputData;
import com.markedline.textworker.entity.result.AbstractResult;
import com.markedline.textworker.entity.result.TextResult;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task11 implements TaskService {
    @Override
    public AbstractResult solve(AbstractInputData inputData) {
        Parser parser = new ParserImpl();

        List<Sentence> sentences = parser.getSentences(inputData.getInputText());

        char firstSymbol = inputData.getInputFirstChar();

        char secondSymbol = inputData.getInputSecondChar();

        List<Sentence> cuttedSentences = new ArrayList<>();

        for (Sentence sentence : sentences) {
            cuttedSentences.addAll(parser.getSentences(cutSymbolsBetweenGiven(sentence.toString(), firstSymbol, secondSymbol)));
        }

        Text text = new Text(cuttedSentences);

        return new TextResult(text);
    }

    private String cutSymbolsBetweenGiven(String text, char first, char second) {
        String regexPattern = "(?<=%s).+(?=%s)";

        String regex = String.format(regexPattern, Pattern.quote(String.valueOf(first)),
                Pattern.quote(String.valueOf(second)));

        Matcher matcher = Pattern.compile(regex).matcher(text);

        int maxLength = 0;
        int startIndex = -1;
        int endIndex = -1;

        while (matcher.find()) {
            int length = matcher.end() - matcher.start();
            if (length > maxLength) {
                startIndex = matcher.start();
                endIndex = matcher.end();
            }
        }

        if (startIndex > 0)
            text = text.substring(0, startIndex) + text.substring(endIndex);

        return text;
    }
}
