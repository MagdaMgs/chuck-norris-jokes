package org.mmdevelopers.project.speakjokes.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mmdevelopers.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;

import java.io.IOException;

class ChuckNorrisJokesServiceTest {

    @Test
    void run() throws IOException {

        //given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService();
        final String url = "https://api.chucknorris.io/jokes/random";

        //when
        String response = chuckNorrisJokesService.getResponse(url);

        //then
        Assertions.assertNotNull(response, "message is not null");

    }

    @Test
    void converter() {
        //given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService();
        //when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.converter("{\n" +
                "\"icon_url\" : \"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\n" +
                "\"id\" : \"Vx6RIQrsTK-8X6IYLx1wZg\",\n" +
                "\"url\" : \"\",\n" +
                "\"value\" : \"Villagers used to tremble with fear when they heard Atilla the Hun was coming. Atilla the Hun shit his pants when he heard Chuck Norris was coming!\"\n" +
                "}");
        //then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse, "response is not null");
    }

    @Test
    void randomJoke() {
        //given
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService();
        //when
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();
        //then
        Assertions.assertNotNull(chuckNorrisJokesApiResponse, "response is not null");
    }
}