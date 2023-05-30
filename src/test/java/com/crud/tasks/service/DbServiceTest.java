package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DbServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private DbService dbService;

    @Test
    void getAllTasks() {
        //Given
        List<Task> taskList = List.of(new Task(1L, "doDo", "test"));
        when(dbService.getAllTasks()).thenReturn(taskList);

        //When
        List<Task> tasks = taskRepository.findAll();

        //Then
        assertEquals(1, tasks.size());
        assertNotEquals(2, tasks.size());
        assertEquals("doDo", tasks.get(0).getTitle());
        assertEquals(1L, tasks.get(0).getId());
        assertEquals("test", tasks.get(0).getContent());

    }

    @Test
    void getTask() throws TaskNotFoundException {
        //Given
        Task task = new Task(1L, "doDo", "test");
        Long id = task.getId();
        when(taskRepository.findById(id)).thenReturn(Optional.of(task));

        //When
        Task task1 = dbService.getTask(id);

        //Then
        verify(taskRepository).findById(id);
        assertEquals(task, task1);

    }

    @Test
    void saveTask() {
        //Given
        Task task = new Task(1L, "doDo", "test");
        Long id = task.getId();

        //When
        dbService.saveTask(task);

        //Then
        assertEquals(1, task.getId());

        //CleanUp
        dbService.deleteTask(id);
    }
}