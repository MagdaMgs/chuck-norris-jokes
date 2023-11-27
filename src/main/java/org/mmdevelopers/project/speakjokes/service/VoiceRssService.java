package org.mmdevelopers.project.speakjokes.service;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.logging.Logger;

public class VoiceRssService {
    private static final Logger LOGGER = Logger.getLogger(VoiceRssService.class.getName());
    public static final String API_VOICE_RSS = "http://api.voicerss.org/?key=1234567890QWERTY&hl=en-us&src=Hello, world!";
    private OkHttpClient client = new OkHttpClient();

    public void speakJoke(String textToVoice) throws IOException {
        LOGGER.info("speakJoke(" + textToVoice + "): ");

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("api.voicerss.org")
                .addQueryParameter("key", "282e87173f024581943b84402337d7f9")
                .addQueryParameter("hl", "en-us")
                .addQueryParameter("src", textToVoice)
                .build();
        LOGGER.info("speakJoke: " + httpUrl);
        Request request = new Request.Builder().url(httpUrl).build();

        try (Response response = client.newCall(request).execute()) {
            LOGGER.info("response: " + response);
        }

        LOGGER.info("speakJoke(...): ");
    }
}
