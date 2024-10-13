package ru.fedorov.hangman.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.ClassLoader.*;
import static java.nio.charset.StandardCharsets.UTF_8;

public class WordController {
    private String riddleWord;
    private final List<String> usedLetters = new ArrayList<>();
    Random random = new Random();

    public WordController() {
        init();
    }

    public void init() {
        Scanner in = new Scanner(getSystemResourceAsStream("words.txt"), UTF_8);
        List<String> words = new ArrayList<>();
        while (in.hasNext()) {
            words.add(in.next());
        }
        in.close();
        int wordPosition = random.nextInt(0, words.size()-1);
        setRiddleWord(words.get(wordPosition));
    }

    public void setRiddleWord(String riddleWord) {
        this.riddleWord = riddleWord.toLowerCase();
    }

    public String getRiddleWorld() {
      return this.riddleWord;
    }

    public List<String> getUsedLetters() {
        return usedLetters;
    }

    public void addLetter(String letter) {
        usedLetters.add(letter);
    }

    public boolean isGuessedLetterCorrect(String letter) {
        return getRiddleWorld().contains(letter);
    }

    public String getWorldMask() {
        return Pattern.compile("")
                .splitAsStream(getRiddleWorld())
                .map(c -> usedLetters.contains(c) ? c : "*")
                .collect(Collectors.joining());
    }


}
