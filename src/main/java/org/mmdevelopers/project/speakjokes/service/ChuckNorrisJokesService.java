package org.mmdevelopers.project.speakjokes.service;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.mmdevelopers.project.speakjokes.api.chucknorrisjokes.ChuckNorrisJokesApiResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChuckNorrisJokesService {
    private static final Logger LOGGER = Logger.getLogger(ChuckNorrisJokesService.class.getName());
    public static final String API_CHUCKNORRIS_IO_JOKES_RANDOM = "https://api.chucknorris.io/jokes/random";
    private OkHttpClient client = new OkHttpClient();

    public ChuckNorrisJokesApiResponse randomJoke() {
        LOGGER.info("randomJoke(): ");
        try {
            String responseBody = getResponse(API_CHUCKNORRIS_IO_JOKES_RANDOM); //ctr+shift+c dodaje stałą
            ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = converter(responseBody);
            return chuckNorrisJokesApiResponse;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Unable to connect with Norris Jokes", e);
        }
        LOGGER.info("randomJoke(...): ");

        return null;
    }

    public String getResponse(String url) throws IOException {
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

    public ChuckNorrisJokesApiResponse converter(String responseBody) {
        LOGGER.info("converter(): " + responseBody);
        Gson gson = new Gson();
        ChuckNorrisJokesApiResponse chuckNorrisJokesApiResponse = gson.fromJson(responseBody, ChuckNorrisJokesApiResponse.class);
        return chuckNorrisJokesApiResponse;
    }
}
