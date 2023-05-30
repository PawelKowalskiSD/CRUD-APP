package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrelloListDtoTest {

    @Test
    void testTrelloListDto() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto();
        trelloListDto.setId("1");
        trelloListDto.setName("Test");
        trelloListDto.setClosed(true);

        //When
        String id = trelloListDto.getId();
        String name = trelloListDto.getName();
        boolean closed = trelloListDto.isClosed();

        //Then
        assertEquals("1", id);
        assertEquals("Test", name);
        assertTrue(closed);

    }

}