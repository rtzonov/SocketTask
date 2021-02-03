package com.markedline.textworker.parser.impl;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Sign;
import com.markedline.textworker.entity.text.Word;
import com.markedline.textworker.parser.Parser;

import java.io.FilterInputStream;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {

    private static final String REGEX_MULTIPLE_WHITESPACE_OR_TABS_FOR_REPLACEMENT = "[ |\\t]+";
    private static final String REGEX_WHITESPACE_REPLACEMENT = " ";
    private static final String REGEX_SPLIT_SENTENCE_INTO_PARTS_BY = " ";

    @Override
    public List<Sentence> getSentences(String text) {
        List<Sentence> sentences = new ArrayList<>();

        BreakIterator iterator = BreakIterator.getSentenceInstance();
        iterator.setText(text);
        int index = 0;
        while (iterator.next() != BreakIterator.DONE) {
            Sentence sentence = new Sentence();
            String sentenceText = text.substring(index, iterator.current()).trim();
            sentence.setWords(getWordsFromText(sentenceText));
            sentence.setDelimiter(sentenceText.substring(sentenceText.length() - 1));
            sentences.add(sentence);
            index = iterator.current();
        }

        return sentences;
    }

    @Override
    public List<Word> getWordsFromText(String text) {
        List<Word> words = new ArrayList<>();

        String processedText = text.trim().
                replaceAll(REGEX_MULTIPLE_WHITESPACE_OR_TABS_FOR_REPLACEMENT, REGEX_WHITESPACE_REPLACEMENT);
        String[] sentenceParts = processedText.split(REGEX_SPLIT_SENTENCE_INTO_PARTS_BY);

        int firstLetterIndex, lastLetterIndex;

        for (String sentencePart : sentenceParts) {
            if (sentencePart.length() > 0) {
                Word word = new Word();
                firstLetterIndex = getIndexOfFirstLetter(sentencePart);
                lastLetterIndex = getIndexOfLastLetter(sentencePart);
                for (int i = 0; i < firstLetterIndex; i++) {
                    word.getPrecedingSigns().add(new Sign(sentencePart.substring(i, i + 1)));
                }
                word.setText(sentencePart.substring(firstLetterIndex, lastLetterIndex + 1));
                for (int i = lastLetterIndex + 1; i < sentencePart.length(); i++) {
                    word.getFollowingSigns().add(new Sign(sentencePart.substring(i, i + 1)));
                }
                words.add(word);
            }
        }
        return words;
    }

    @Override
    public List<Word> getWordsFromSentences(List<Sentence> sentences) {
        List<Word> words = new ArrayList<>();
        for (Sentence sentence : sentences) {
            words.addAll(sentence.getWords());
        }
        return words;
    }

    private int getIndexOfFirstLetter(String sentencePart) {
        for (int i = 0; i < sentencePart.length(); i++) {
            if (Character.isLetterOrDigit(sentencePart.charAt(i))) {
                return i;
            }
        }
        return 0;
    }

    private int getIndexOfLastLetter(String sentencePart) {
        for (int i = sentencePart.length() - 1; i >= 0; i--) {
            if (Character.isLetterOrDigit(sentencePart.charAt(i))) {
                return i;
            }
        }
        return sentencePart.length() - 1;
    }
}
