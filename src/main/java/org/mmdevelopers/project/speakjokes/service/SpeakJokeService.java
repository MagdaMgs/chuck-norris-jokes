package org.mmdevelopers.project.speakjokes.service;

import org.mmdevelopers.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;

import java.util.logging.Logger;

public class SpeakJokeService {
    private static final Logger LOGGER = Logger.getLogger(AudioPlayService.class.getName());
    private final ChuckNorrisJokesService chuckNorrisJokesService;
    private final VoiceRssService voiceRssService;

    public SpeakJokeService(ChuckNorrisJokesService chuckNorrisJokesService, VoiceRssService voiceRssService) {
        this.chuckNorrisJokesService = chuckNorrisJokesService;
        this.voiceRssService = voiceRssService;
    }

    public void speakJoke(){
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = chuckNorrisJokesService.randomJoke();
        
    }
}
