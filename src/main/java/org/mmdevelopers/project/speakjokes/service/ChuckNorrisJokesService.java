package org.mmdevelopers.project.speakjokes.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.logging.Logger;

public class ChuckNorrisJokesService {
    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisJokesService.class.getName());
    private OkHttpClient client = new OkHttpClient();

    public String run(String url) throws IOException {
        LOGGER.info("run(): " + url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            LOGGER.info("run: " + responseBody);
            return responseBody;
        }
    }

}
