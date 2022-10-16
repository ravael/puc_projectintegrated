package br.com.pucminas.mktvalidator.service;

import br.com.pucminas.mktvalidator.domain.Store;
import br.com.pucminas.mktvalidator.domain.StoreValidations;
import br.com.pucminas.mktvalidator.repository.StoreValidationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoreValidationService {


    private final StoreValidationRepository storeValidationRepository;

    public Mono<Void> storeValidade(Store store) {
        return storeValidationRepository.findAll()
                .flatMap(storeValidations -> validate(storeValidations, store))
                .onErrorResume(throwable -> {
                    log.info(throwable.getMessage());
                    return Mono.error(throwable);
                })
                .doOnComplete(() -> save(Mono.just(store)))
                .then();

    }

    private Mono<Store> validate(StoreValidations storeValidations, Store store) {
        if(storeValidations.getForbiddenName().equals(store.getName())){
           return Mono.error(Exception::new);
        }
        return Mono.just(store);
    }

    private Mono<Store> save(Mono<Store> store){
        log.info("Salvando");

        URI uri = URI.create("http://localhost:8081/store");
        WebClient webClient = WebClient.create();

        Mono<Store> storeMono = webClient.post()
                .uri(uri)
                .body(store, Store.class)
                .retrieve()
                .bodyToMono(Store.class);

        storeMono.subscribe();
        return storeMono;
    }

}
