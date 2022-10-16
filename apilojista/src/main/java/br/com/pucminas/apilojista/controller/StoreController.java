package br.com.pucminas.apilojista.controller;

import br.com.pucminas.apilojista.domain.Store;
import br.com.pucminas.apilojista.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("store")
public class StoreController {

    private final StoreService storeService;


    @GetMapping
    public Flux<Store> listAll(){
        return storeService.findAll();
    }

    @GetMapping(path = "{id}")
    public Mono<Store> findById(@PathVariable int id){
        return storeService.findById(id)
                .switchIfEmpty(storeNotFoundException());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Store> save(@Valid @RequestBody Store store) {
        return storeService.save(store);
    }

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> update(@PathVariable int id, @Valid @RequestBody Store store) {
        return storeService.update(store.withId(id));
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable int id) {
        return storeService.delete(id);
    }

    private <T> Mono<T> storeNotFoundException() {
        return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Store not found"));
    }

}
