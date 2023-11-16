package org.mmdevelopers.project.speakjokes.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ChuckNorrisJokesServiceTest {

    @Test
    void run() throws IOException {

        //given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService();
        final String url = "https://api.chucknorris.io/jokes/random";

        //when
        String response = chuckNorrisJokesService.run(url);

        //then
        Assertions.assertNotNull(response, "message is not null");

    }
}