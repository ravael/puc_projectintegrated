package br.com.pucminas.mktvalidator.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageValidationService {

    public boolean existImage(String url){
        URI uri = URI.create(url);
        WebClient webClient = WebClient.create();

        Mono<byte[]> monoContents = webClient
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(byte[].class);
//
//        Files.write(destination, Objects.requireNonNull(monoContents.share().block()),
//                StandardOpenOption.CREATE);

        return monoContents != null;
    }
}
