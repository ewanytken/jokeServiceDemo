package com.training.jokeservice.cli;

import com.training.jokeservice.joke.JokeDataService;
import com.training.jokeservice.joke.JokeRetriever;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
public class ShellCommands {

    private final JokeRetriever jokeRetriever;
    private final JokeDataService jokeDataService;

    public ShellCommands(JokeRetriever jokeRetriever, JokeDataService jokeDataService) {
        this.jokeRetriever = jokeRetriever;
        this.jokeDataService = jokeDataService;
    }
    private String lastJoke;
    @ShellMethod("Расскажи шутку")
    public String joke(){
        lastJoke = jokeRetriever.getJoke().value.joke;
        return lastJoke;
    }
    @ShellMethod("Сохрани последнюю шутку")
    public String save(){
        if(lastJoke != null) {
            jokeDataService.save(lastJoke);
            return "Сохранено";
        } else {
            return "Сначала загрузите шутку";
        }
    }

    @ShellMethod("Покажи все шутку")
    public String show() {
        return jokeDataService.showAll().stream().collect(Collectors.joining(System.lineSeparator()));
    }
}
