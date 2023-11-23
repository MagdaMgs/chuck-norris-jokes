package org.mmdevelopers.project.speakjokes.controller;

import org.mmdevelopers.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;
import org.mmdevelopers.project.speakjokes.service.ChuckNorrisJokesService;

import java.util.logging.Logger;

public class ChuckNorrisController {
    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisController.class.getName());
    private final ChuckNorrisJokesService chuckNorrisJokesService;

    public ChuckNorrisController(ChuckNorrisJokesService chuckNorrisJokesService) {
        this.chuckNorrisJokesService = chuckNorrisJokesService;
    }

    public ChuckNorrisJokesApiResponse randomJoke() {
        LOGGER.info("run(): ");
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();
        LOGGER.info("run(...): " + chuckNorrisJokesApiResponse);

        return chuckNorrisJokesApiResponse;
    }
}
