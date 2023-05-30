package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrelloBoardDtoTest {

    @Test
    void testTrelloBoardDto() {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto();
        trelloBoardDto.setId("1");
        trelloBoardDto.setName("Test");
        trelloBoardDto.setLists(new ArrayList<>());

        //When
        String id = trelloBoardDto.getId();
        String name = trelloBoardDto.getName();
        List<TrelloListDto> trelloListDtos = trelloBoardDto.getLists();

        //Then
        assertEquals("1", id);
        assertEquals("Test", name);
        assertTrue(trelloListDtos.isEmpty());
    }

}