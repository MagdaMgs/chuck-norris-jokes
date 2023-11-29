package org.mmdevelopers.project.speakjokes.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudioPlayServiceTest {

    @Test
    void play() {
        //given
        AudioPlayService audioPlayService = new AudioPlayService();
        //when
        audioPlayService.play("hello-joke.wav");
    }
}