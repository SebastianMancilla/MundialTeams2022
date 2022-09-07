package com.smg.mundialteams.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smg.mundialteams.domain.Team;
import com.smg.mundialteams.repository.TeamRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
class TestTeamRestController {

    private final String URL = "/team";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamRepository teamRepository;

    @Test
    void getAllTeams() throws Exception {
        Team team = new Team();
        team.setId(1L);
        team.setName("Guatemala Federation");
        team.setCountry("Guatemala");

        Mockito.when(teamRepository.findAll()).thenReturn(List.of(team));
        RequestBuilder builder = MockMvcRequestBuilders
                .get(URL + "/all")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        Assertions.assertEquals(200, response.getStatus());

    }

    @Test
    void getAllTeamsNoContent() throws Exception
    {

        List<Team> teams = new ArrayList<>();

        Mockito.when(teamRepository.findAll()).thenReturn(teams);
        RequestBuilder builder = MockMvcRequestBuilders
                .get(URL + "/all")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        Assertions.assertEquals(204, response.getStatus());

    }

    @Test
    void getTeamById() throws Exception
    {
        Team team = new Team();
        team.setId(1L);
        team.setName("Guatemala Federation");
        team.setCountry("Guatemala");

        Mockito.when(teamRepository.findById(Mockito.any())).thenReturn(Optional.of(team));
        RequestBuilder builder = MockMvcRequestBuilders
                .get(URL + "/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        Assertions.assertEquals(200, response.getStatus());
    }
    @Test
    void getTeamByIdNoContent() throws Exception
    {

        Mockito.when(teamRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        RequestBuilder builder = MockMvcRequestBuilders
                .get(URL + "/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        Assertions.assertEquals(204, response.getStatus());
    }

    @Test
    void postNewTeam() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        Team team = new Team();
        team.setId(1L);
        team.setName("Guatemala Federation");
        team.setCountry("Guatemala");

        Mockito.when(teamRepository.save(Mockito.any())).thenReturn(team);
        RequestBuilder builder = MockMvcRequestBuilders
                .post(URL + "/")
                .content(mapper.writeValueAsString(team))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        Assertions.assertEquals(201, response.getStatus());
    }

    //TODO: Crear test para bad request del POST

    @Test
    void putTeam() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();

        Team team = new Team();
        team.setId(1L);
        team.setName("Guatemala Federation");
        team.setCountry("Guatemala");

        Mockito.when(teamRepository.findById(Mockito.any())).thenReturn(Optional.of(team));
        RequestBuilder builder = MockMvcRequestBuilders
                .put(URL + "/put/1")
                .content(mapper.writeValueAsString(team))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        Assertions.assertEquals(201, response.getStatus());
    }

    @Test
    void putTeamFindNoContent() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();



        Mockito.when(teamRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        RequestBuilder builder = MockMvcRequestBuilders
                .put(URL + "/put/1")
                .content(mapper.writeValueAsString(new Team()))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        Assertions.assertEquals(204, response.getStatus());
    }

    @Test
    void deleteTeam() throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();

        Team team = new Team();
        team.setId(1L);
        team.setName("Guatemala Federation");
        team.setCountry("Guatemala");

        Mockito.when(teamRepository.findById(Mockito.any())).thenReturn(Optional.of(team));
        RequestBuilder builder = MockMvcRequestBuilders
                .delete(URL + "/delete/1")
                .content(mapper.writeValueAsString(team))
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        Assertions.assertEquals(204, response.getStatus());
    }
}
