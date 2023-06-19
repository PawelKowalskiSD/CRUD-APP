package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Badges;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService simpleEmailService;

    @Mock
    private AdminConfig adminConfig;

    @Test
    void fetchTrelloBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtoList = List.of(new TrelloBoardDto("1", "new board", new ArrayList<>()));
        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtoList);

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloService.fetchTrelloBoards();

        //Then
        verify(trelloClient).getTrelloBoards();

        assertEquals(trelloBoardDtoList, trelloBoardDtos);
    }

    @Test
    void createdTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("task", "Test task", "22", "1");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "test", "test", new Badges());
        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto);
        when(adminConfig.getAdminMail()).thenReturn("pa@on.com");

        //When
        CreatedTrelloCardDto createdTrelloCard = trelloService.createdTrelloCard(trelloCardDto);

        //Then
        verify(trelloClient).createNewCard(trelloCardDto);

        assertEquals(createdTrelloCardDto, createdTrelloCard);
    }
}