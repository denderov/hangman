package ru.fedorov.hangman.controller;

import java.util.List;

public class GibbetController {
    private int boostCount;
    private final List<String> gibbetSteps = List.of("""
                      +---+
                      |   |
                          |
                          |
                          |
                          |
                    =========""",
            """
                      +---+
                      |   |
                      O   |
                          |
                          |
                          |
                    =========""",
            """
                      +---+
                      |   |
                      O   |
                      |   |
                          |
                          |
                    =========""",
            """
                      +---+
                      |   |
                      O   |
                     /|   |
                          |
                          |
                    =========""",
            """
                      +---+
                      |   |
                      O   |
                     /|\\  |
                          |
                          |
                    =========""",
            """
                      +---+
                      |   |
                      O   |
                     /|\\  |
                     /    |
                          |
                    =========""",
            """
                      +---+
                      |   |
                      O   |
                     /|\\  |
                     / \\  |
                          |
                    =========""");

    public boolean isAssembled() {
        return boostCount >= getGibbetSteps();
    }

    public void boost() {
        boostCount++;
    }

    public int getGibbetSteps() {
        return gibbetSteps.size();
    }

    public String getCurrentGibbet() {
        return gibbetSteps.get(boostCount - 1);
    }
}
