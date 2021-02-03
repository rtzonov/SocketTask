package com.markedline.textworker.parser;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Word;

import java.util.List;

public interface Parser {

    List<Sentence> getSentences(String text);

    List<Word> getWordsFromText(String text);

    List<Word> getWordsFromSentences(List<Sentence> sentences);
}
