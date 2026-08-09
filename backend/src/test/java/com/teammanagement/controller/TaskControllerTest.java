package com.teammanagement.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskRepository taskRepo;

    @InjectMocks
    private TaskController controller;

    @WithMockUser(roles = "ADMIN")
    @Test
    public void testGetAllTasks() throws Exception {
        when(taskRepo.findAll()).thenReturn(List.of());
        mockMvc.perform(get("/api/tasks"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()", 0));
    }

    @WithMockUser(roles = "ADMIN")
    @Test
    public void testCreateTask() throws Exception {
        Task task = new Task();
        when(taskRepo.save(any(Task.class))).thenReturn(task);
        mockMvc.perform(post("/api/tasks")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"title\":\"test\"}")")
            .andExpect(status().isOk());
    }
}
