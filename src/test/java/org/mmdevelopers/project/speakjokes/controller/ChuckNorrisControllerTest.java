package org.mmdevelopers.project.speakjokes.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mmdevelopers.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;
import org.mmdevelopers.project.speakjokes.service.ChuckNorrisJokesService;

import static org.junit.jupiter.api.Assertions.*;

class ChuckNorrisControllerTest {

    @Test
    void randomJoke() {
        //given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService();
        ChuckNorrisController chuckNorrisController = new ChuckNorrisController(chuckNorrisJokesService);
        //when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisController.randomJoke();
        //then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse, "response is not null");
    }
}