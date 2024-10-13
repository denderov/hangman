package ru.fedorov.hangman.tests;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.fedorov.hangman.controller.WordController;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {
    @Test
    void isWordControllerReturnsRiddleWord() {
        String riddleWord = "test";
        WordController wordController = new WordController();
        wordController.setRiddleWord(riddleWord);
        assertEquals(riddleWord, wordController.getRiddleWorld());
    }

    @SneakyThrows
    @Test
    void isWorldControllerInitWordFromTxtFile() {
        WordController wordController = new WordController();
        wordController.init();
        assertNotNull(wordController.getRiddleWorld());
    }
}
