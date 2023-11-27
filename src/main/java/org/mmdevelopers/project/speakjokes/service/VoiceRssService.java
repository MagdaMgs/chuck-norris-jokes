package org.mmdevelopers.project.speakjokes.service;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

import java.util.logging.Logger;

public class VoiceRssService {
    private static final Logger LOGGER = Logger.getLogger(VoiceRssService.class.getName());
    public static final String API_VOICE_RSS = "http://api.voicerss.org/?key=1234567890QWERTY&hl=en-us&src=Hello, world!";
    private OkHttpClient client = new OkHttpClient();

    public void speakJoke() {
        LOGGER.info("speakJoke(): ");

        HttpUrl httpUrl = new HttpUrl.Builder()
                .host("http")
                .scheme("api.voicerss.org")
                .build();

        LOGGER.info("speakJoke(...): ");
    }
}
