package br.com.pucminas.apiproduct.service;

import br.com.pucminas.apiproduct.domain.Product;
import br.com.pucminas.apiproduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Mono<Page<Product>> findAll(PageRequest pageable) {
        return productRepository.findAllBy(pageable)
                .collectList()
                .zipWith(productRepository.count())
                .map(t -> new PageImpl<>(t.getT1(), pageable, t.getT2()));
    }

    public Mono<Page<Product>> findProductsStore(int ecommerceid, PageRequest pageable) {
        return productRepository.findAllByEcommerceId(ecommerceid, pageable)
                .collectList()
                .zipWith(productRepository.count())
                .map(t -> new PageImpl<>(t.getT1(), pageable, t.getT2()));
    }

    public Mono<Product> save(Product product) {
        return productRepository.save(product);
    }

    public Mono<Page<Product>> findProductsAvailable(PageRequest of) {
        return productRepository.findAllByAvailableIsTrue(of)
                .collectList()
                .zipWith(productRepository.count())
                .map(t -> new PageImpl<>(t.getT1(), of, t.getT2()));
    }

    public Mono<Page<Product>> findProductsNotAvailable(PageRequest of) {
        return productRepository.findProductsByAvailableIsFalse(of)
                .collectList()
                .zipWith(productRepository.count())
                .map(t -> new PageImpl<>(t.getT1(), of, t.getT2()));
    }

    public Mono<Void> update(Product product) {
        return productRepository.findByIdAndEcommerceId(product.getId(), product.getEcommerceId())
                .flatMap(productRepository::save)
                .then();
    }
}
