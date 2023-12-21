package org.mmdevelopers.project.speakjokes.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mmdevelopers.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;
import org.mmdevelopers.project.speakjokes.service.ChuckNorrisJokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChuckNorrisControllerSpringTest {

    @Autowired
    private ChuckNorrisController chuckNorrisController;

    @Test
    void randomJoke() {
        //given injected by spring
        //when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisController.randomJoke();
        //then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse, "response is not null");
    }
}