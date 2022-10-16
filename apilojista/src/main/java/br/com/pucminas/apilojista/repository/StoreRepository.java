package br.com.pucminas.apilojista.repository;

import br.com.pucminas.apilojista.domain.Store;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StoreRepository extends ReactiveCrudRepository<Store, Integer> {

}
