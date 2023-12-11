package org.mmdevelopers.project.speakjokes.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SpeakJokeServiceTest {

    @Test
    void speakJoke() throws IOException {
        //given
        AudioPlayService audioPlayService = new AudioPlayService();
        VoiceRssService voiceRssService = new VoiceRssService(audioPlayService);
        ChuckNorrisJokesService chuckNorrisJokesService = new ChuckNorrisJokesService();
        SpeakJokeService speakJokeService = new SpeakJokeService(chuckNorrisJokesService, voiceRssService);
        //when
        boolean spoken = speakJokeService.speakJoke();
        //then
        Assertions.assertTrue(spoken, "Joke not spoken");
    }
}