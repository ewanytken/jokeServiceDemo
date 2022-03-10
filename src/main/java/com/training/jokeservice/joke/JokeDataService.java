package com.training.jokeservice.joke;

import java.util.List;

public interface JokeDataService {

    void save(String joke);
    List<String> showAll();
}
