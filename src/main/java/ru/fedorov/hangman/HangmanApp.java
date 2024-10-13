package ru.fedorov.hangman;

import ru.fedorov.hangman.controller.GameController;

public class HangmanApp {

    public static void main(String[] args) {
        GameController gameController = new GameController();

        while (!gameController.isGameOver() && !gameController.isWin()) {
            gameController.handleLetter();
        }

        if (gameController.isGameOver()) {
            System.out.println("Game over!");
        }

        if (gameController.isWin()) {
            System.out.println("Congrats!");
        }
    }
}
