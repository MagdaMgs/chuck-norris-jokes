package org.mmdevelopers.project.speakjokes.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
public class VoiceRssService {
    private static final Logger LOGGER = Logger.getLogger(VoiceRssService.class.getName());
    private OkHttpClient client;

    private final AudioPlayService audioPlayService;

    public VoiceRssService(AudioPlayService audioPlayService) {
        this.client = new OkHttpClient.Builder()
                .callTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        this.audioPlayService = audioPlayService;
    }

    public boolean speakJoke(String textToVoice) throws IOException {
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
            if (response != null) {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    InputStream inputStream = new ByteArrayInputStream(responseBody.bytes());
                    if (inputStream != null) {
                        audioPlayService.play(inputStream);
                        return true;
                    }
                }
            }
        }

        LOGGER.info("speakJoke(...): ");
        return false;
    }
}
