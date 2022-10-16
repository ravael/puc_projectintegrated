package br.com.pucminas.apilojista.service;

import br.com.pucminas.apilojista.domain.Store;
import br.com.pucminas.apilojista.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public Flux<Store> findAll() {
        return storeRepository.findAll();
    }

    public Mono<Store> findById(int id){
        return storeRepository.findById(id);
    }

    public Mono<Store> save(Store store) {
        return storeRepository.save(store);
    }

    public Mono<Void> update(Store store){
        return findById(store.getId())
                .flatMap(storeRepository::save)
                .then();
    }

    public Mono<Void> delete(int id) {
        return findById(id)
                .flatMap(storeRepository::delete);
    }

}
