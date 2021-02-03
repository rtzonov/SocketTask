package com.markedline.textworker.util;

import com.markedline.textworker.entity.text.Sentence;
import com.markedline.textworker.entity.text.Word;

public class TextBuilder {

    private String text = "";

    public TextBuilder(String text) {
        this.text = text;
    }

    public TextBuilder(Word word) {
        this.text = word.getText();
    }

    public TextBuilder() {}

    public TextBuilder append(String text) {
        this.text += text;
        return this;
    }

    public TextBuilder append(Sentence sentence) {
        text += sentence + " ";
        return this;
    }

    public TextBuilder append(Word word) {
        text += word.getText() + " ";
        return this;
    }

    @Override
    public String toString() {
        return text.trim();
    }
}
