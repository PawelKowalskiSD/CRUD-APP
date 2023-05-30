package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloTest {

    @Test
    void testTrelloBoard() {
        //Given
        Trello trello = new Trello();
        trello.setBoard(1);
        trello.setCard(2);

        //When
        int board = trello.getBoard();
        int card = trello.getCard();

        //Then
        assertEquals(1, board);
        assertEquals(2, card);

    }

}