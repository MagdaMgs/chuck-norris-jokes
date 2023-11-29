package org.mmdevelopers.project.speakjokes.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class VoiceRssServiceTest {

    @Test
    void speakJoke() throws IOException {
        //given
        AudioPlayService audioPlayService = new AudioPlayService();
        VoiceRssService voiceRssService = new VoiceRssService(audioPlayService);
        //when
        boolean speakJoke = voiceRssService.speakJoke("Hello Joke!");
        //then
        Assertions.assertTrue(speakJoke,"not spoken");
    }
}