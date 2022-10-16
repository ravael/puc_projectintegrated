package br.com.pucminas.mktvalidator.service;

import br.com.pucminas.mktvalidator.domain.Store;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;


class StoreValidationServiceTest {

    WebClient client = WebClient.create();

    public void teste(){
        Store build = Store.builder().name("").address("").city("").build();

        try {
            client.post()
                    .uri(new URI("http://localhost:8081/store"))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .body(build, Store.class)
                    .retrieve()
                    .bodyToMono(Store.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}