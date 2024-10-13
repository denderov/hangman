package ru.fedorov.hangman.controller;

import java.util.Scanner;
import java.util.logging.Logger;

public class GameController {
    private final Scanner in = new Scanner(System.in);
    private final WordController wordController = new WordController();
    private final GibbetController gibbetController = new GibbetController();
    final Logger logger = Logger.getLogger(GameController.class.getName());

    public GameController() {
        logger.info("Riddle word - %s".formatted(wordController.getRiddleWorld()));
    }

    public void handleLetter() {
        System.out.println("Word mask: ");
        System.out.println(wordController.getWorldMask());
        System.out.println("Enter letter:");
        String letter = in.nextLine();

        if (wordController.getUsedLetters().contains(letter)) {
            System.out.printf("Letter %s already used%n", letter);
        } else {
            wordController.addLetter(letter);
        }

        if (!wordController.isGuessedLetterCorrect(letter)) {
            gibbetController.boost();
            System.out.printf("Letter %s absent in riddle word%n", letter);
            System.out.println(gibbetController.getCurrentGibbet());
        }
    }

    public boolean isGameOver() {
        return gibbetController.isAssembled();
    }

    public boolean isWin() {
        return wordController.getRiddleWorld().equals(wordController.getWorldMask());
    }
}
