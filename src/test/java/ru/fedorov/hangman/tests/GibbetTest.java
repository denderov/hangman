package ru.fedorov.hangman.tests;

import org.junit.jupiter.api.Test;
import ru.fedorov.hangman.controller.GibbetController;

import static org.junit.jupiter.api.Assertions.*;

class GibbetTest {
    @Test
    void isGibbetAssembling() {
        GibbetController gibbetController = new GibbetController();

        int assemblingIterations = gibbetController.getGibbetSteps();
        for (int i = 0; i < assemblingIterations; i++) {
            assertFalse(gibbetController.isAssembled());
            gibbetController.boost();
        }

        assertTrue(gibbetController.isAssembled());
    }
}
