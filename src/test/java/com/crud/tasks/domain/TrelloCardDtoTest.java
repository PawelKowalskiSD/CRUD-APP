package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloCardDtoTest {

    @Test
    void testTrelloCardDto() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto();
        trelloCardDto.setName("Test");
        trelloCardDto.setDescription("Test Task");
        trelloCardDto.setPos("22");
        trelloCardDto.setListId("1");

        //When
        String name = trelloCardDto.getName();
        String description = trelloCardDto.getDescription();
        String pos = trelloCardDto.getPos();
        String listId = trelloCardDto.getListId();

        //Then
        assertEquals("Test", name);
        assertEquals("Test Task", description);
        assertEquals("22", pos);
        assertEquals("1", listId);

    }

}