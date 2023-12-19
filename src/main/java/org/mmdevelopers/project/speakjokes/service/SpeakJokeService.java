package org.mmdevelopers.project.speakjokes.service;

import org.mmdevelopers.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

@Service
public class SpeakJokeService {
    private static final Logger LOGGER = Logger.getLogger(AudioPlayService.class.getName());
    private final ChuckNorrisJokesService chuckNorrisJokesService;
    private final VoiceRssService voiceRssService;

    public SpeakJokeService(ChuckNorrisJokesService chuckNorrisJokesService, VoiceRssService voiceRssService) {
        this.chuckNorrisJokesService = chuckNorrisJokesService;
        this.voiceRssService = voiceRssService;
    }

    public boolean speakJoke() throws IOException {
        LOGGER.info("speakJoke()");
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();
        String joke = chuckNorrisJokesApiResponse.getValue();

        boolean spoken = voiceRssService.speakJoke(joke);
        LOGGER.info("speakJoke()" + spoken);

        return spoken;
    }
}
