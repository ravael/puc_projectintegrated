package br.com.pucminas.apiproduct.repository;

import br.com.pucminas.apiproduct.domain.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {

    Mono<Product> findByIdAndEcommerceId(int id, int ecommerceid);

    Flux<Product> findAllBy(PageRequest pageable);

    Flux<Product> findAllByEcommerceId(int ecommerceid, PageRequest pageable);

    Flux<Product> findAllByAvailableIsTrue(PageRequest pageable);

    Flux<Product> findProductsByAvailableIsFalse(PageRequest pageable);
}
