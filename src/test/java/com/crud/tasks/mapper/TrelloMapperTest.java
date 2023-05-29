package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
@DisplayName("Trello mapper test")
class TrelloMapperTest {

    @Nested
    @DisplayName("Test mapper board")
    class TestMapperBoard {
        @Test
        @DisplayName("Should map to Boards")
        void shouldMapToBoards() {
            //Given
            List<TrelloBoardDto> trelloBoardDto = List.of(new TrelloBoardDto("1", "test", new ArrayList<>()));
            TrelloMapper trelloMapper = new TrelloMapper();

            //When
            List<TrelloBoard> result = trelloMapper.mapToBoards(trelloBoardDto);

            //Then
            assertEquals(1, result.size());
            assertNotEquals(2, result.size());
        }

        @Test
        @DisplayName("Should map to boards Dto")
        void shouldMapToBoardsDto() {
            List<TrelloBoard> trelloBoard = List.of(new TrelloBoard("1", "test", new ArrayList<>()));
            TrelloMapper trelloMapper = new TrelloMapper();

            //When
            List<TrelloBoardDto> result = trelloMapper.mapToBoardsDto(trelloBoard);

            //Then
            assertEquals(1, result.size());
            assertNotEquals(2, result.size());
        }
    }

    @Nested
    @DisplayName("Test mapper list")
    class TestMapperList {
        @Test
        @DisplayName("Should map to list")
        void ShouldMapToList() {
            //Given
            List<TrelloListDto> TrelloListDto = List.of(new TrelloListDto("id", "test", true));
            TrelloMapper trelloMapper = new TrelloMapper();

            //When
            List<TrelloList> result = trelloMapper.mapToList(TrelloListDto);

            //Then
            assertEquals(1, result.size());
            assertNotEquals(2, result.size());
        }

        @Test
        @DisplayName("Should map to list Dto")
        void ShouldMapToListDto() {
            //Given
            List<TrelloList> trelloLists = List.of(new TrelloList("1", "test", true));
            TrelloMapper trelloMapper = new TrelloMapper();

            //When
            List<TrelloListDto> result = trelloMapper.mapToListDto(trelloLists);

            //Then
            assertEquals(1, result.size());
            assertNotEquals(2, result.size());
        }
    }

    @Nested
    @DisplayName("Test mapper card")
    class TestMapperCard {

        @Test
        @DisplayName("Should map to card")
        void ShouldMapToCard() {
            //Given
            TrelloCardDto trelloCardDtos = new TrelloCardDto("test", "test test", "2", "1");
            TrelloMapper trelloMapper = new TrelloMapper();

            //When
            TrelloCard result = trelloMapper.mapToCard(trelloCardDtos);

            //Then
            assertEquals("test", result.getName());
            assertEquals("test test", result.getDescription());
            assertEquals("2", result.getPos());
            assertEquals("1", result.getListId());
        }

        @Test
        @DisplayName("Should map to cart Dto")
        void ShouldMapToCardDto() {
            //Given
            TrelloCard trelloCard = new TrelloCard("test", "test test", "2", "1");
            TrelloMapper trelloMapper = new TrelloMapper();

            //When
            TrelloCardDto result = trelloMapper.mapToCardDto(trelloCard);

            //Then
            assertEquals("test", result.getName());
            assertEquals("test test", result.getDescription());
            assertEquals("2", result.getPos());
            assertEquals("1", result.getListId());
        }
    }
}