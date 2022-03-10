package com.training.jokeservice.joke;

import com.training.jokeservice.JokeserviceApplication;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JokeserviceApplication.class,
                properties = {
                    InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
                        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
                })

public class JokeRetrieverImplTest {

    @Autowired
    JokeRetriever jokeRetriever;
    @Test
    public void getJoke() {
        JokeImportDTO result = jokeRetriever.getJoke();
        System.out.println(result.value.joke);
        Assert.assertTrue(result.value.joke.contains("Chuck Norris"));
        System.out.println(result);
    }
}