package com.training.jokeservice.joke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class JokeRetrieverImpl implements JokeRetriever {

    private final Logger logger = LoggerFactory.getLogger(JokeRetrieverImpl.class);

    private final RestTemplate restTemplate;
    private static String url = "http://api.icndb.com/jokes/random";


    public JokeRetrieverImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public JokeImportDTO getJoke() {
        logger.debug("JOKE QUERY");
        ResponseEntity<JokeImportDTO> result = restTemplate.getForEntity(url, JokeImportDTO.class);
        logger.debug("HAVE A ANSWER: {}", Objects.requireNonNull(result.getBody()).value.joke);
        return result.getBody();
    }
}
