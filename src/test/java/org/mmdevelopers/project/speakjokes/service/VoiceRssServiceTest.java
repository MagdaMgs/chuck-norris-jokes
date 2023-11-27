package org.mmdevelopers.project.speakjokes.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class VoiceRssServiceTest {

    @Test
    void speakJoke() throws IOException {
        //given
        VoiceRssService voiceRssService = new VoiceRssService();
        //when
        voiceRssService.speakJoke("Hello Joke!");
        //then

    }
}