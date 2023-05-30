package com.crud.tasks.mapper;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Task Mapper Test")
class TaskMapperTest {

    @Test
    @DisplayName("Should map to task")
    void shouldMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test", "Test task");
        TaskMapper taskMapper = new TaskMapper();

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(1L, task.getId());
        assertEquals("Test", task.getTitle());
        assertEquals("Test task", task.getContent());
        assertNotEquals(2L, task.getId());
        assertNotEquals("test", task.getTitle());
        assertNotEquals("Test Task", task.getContent());
    }


    @Test
    @DisplayName("Should map to task Dto")
    void shouldMapToTaskDto() {
        //Given
        Task task = new Task(1L, "Test", "Test task");
        TaskMapper taskMapper = new TaskMapper();

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, taskDto.getId());
        assertEquals("Test", taskDto.getTitle());
        assertEquals("Test task", taskDto.getContent());
        assertNotEquals(2L, taskDto.getId());
        assertNotEquals("test", taskDto.getTitle());
        assertNotEquals("test Task", taskDto.getContent());
    }

    @Test
    @DisplayName("Should map to task Dto list")
    void shouldMapToTaskDtoList() {
        //Given
        List<Task> taskList = List.of(new Task(1L, "Test", "Test task"));
        TaskMapper taskMapper = new TaskMapper();

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(1, taskDtoList.size());
        assertNotEquals(2, taskDtoList.size());
        assertEquals(1L, taskDtoList.get(0).getId());
        assertEquals("Test", taskDtoList.get(0).getTitle());
        assertEquals("Test task", taskDtoList.get(0).getContent());
    }
}