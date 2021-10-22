package com.dojo.chucknorris.service;

import com.dojo.chucknorris.models.Joke;
import com.dojo.chucknorris.repository.JokeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class JokeService {

    private JokeRepository jokeRepository;

    public JokeService(@Autowired JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    public Joke getJoke() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.chucknorris.io/jokes/random")
                .get()
                .addHeader("accept", "application/json")
                .build();

        ResponseBody responseBody = client.newCall(request).execute().body();

        return objectMapper.readValue(responseBody.string(), Joke.class);
    }

    public void saveJoke(Joke joke) {
        jokeRepository.save(joke);
    }

    public List<Joke> getAllJokes() {
        return jokeRepository.findAll();
    }
}
