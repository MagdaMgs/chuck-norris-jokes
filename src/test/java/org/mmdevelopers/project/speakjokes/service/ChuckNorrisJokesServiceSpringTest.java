package org.mmdevelopers.project.speakjokes.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChuckNorrisJokesServiceSpringTest {

    @Autowired
    private ChuckNorrisJokesService chuckNorrisJokesService;

    @Test
    void randomJoke() throws IOException {
        //given - injected by Spring - autowired
        final String url = "https://api.chucknorris.io/jokes/random";
        //when
        String response = chuckNorrisJokesService.getResponse(url);

        //then
        Assertions.assertNotNull(response, "message is not null");
    }
}