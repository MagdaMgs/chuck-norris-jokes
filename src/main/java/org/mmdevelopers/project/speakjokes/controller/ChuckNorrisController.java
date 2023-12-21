package org.mmdevelopers.project.speakjokes.controller;

import org.mmdevelopers.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;
import org.mmdevelopers.project.speakjokes.service.ChuckNorrisJokesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/jokes")
public class ChuckNorrisController {
    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisController.class.getName());
    private final ChuckNorrisJokesService chuckNorrisJokesService;

    public ChuckNorrisController(ChuckNorrisJokesService chuckNorrisJokesService) {
        this.chuckNorrisJokesService = chuckNorrisJokesService;
    }

    public String jokeView(){

    }

    public ChuckNorrisJokesApiResponse randomJoke() {
        LOGGER.info("run(): ");
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();
        LOGGER.info("run(...): " + chuckNorrisJokesApiResponse);

        return chuckNorrisJokesApiResponse;
    }
}
