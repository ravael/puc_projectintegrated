package br.com.pucminas.mktvalidator.service;

import br.com.pucminas.mktvalidator.domain.Product;
import br.com.pucminas.mktvalidator.domain.ProductValidations;
import br.com.pucminas.mktvalidator.repository.ProductValidationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductValidationService {

    private final ProductValidationRepository productValidationRepository;

    private final ImageValidationService imageValidationService;

    public Mono<Void> productValidade(Product product) {
        return productValidationRepository.findAll()
                .flatMap(storeValidations -> validate(storeValidations, product))
                .onErrorResume(throwable -> {
                    log.info(throwable.getMessage());
                    return Mono.error(throwable);
                })
                .doOnComplete(() -> save(Mono.just(product)))
                .then();
    }

    private Mono<Product> validate(ProductValidations productValidations, Product product) {
        if(productValidations.getForbiddenName().equals(product.getCategory())){
            return Mono.error(Exception::new);
        }
//        if(!imageValidationService.existImage(product.getImage())){
//            return Mono.error(Exception::new);
//        }
        return Mono.just(product);
    }

    private Mono<Product> save(Mono<Product> product){
        log.info("Salvando");

        URI uri = URI.create("http://localhost:8082/product/save");
        WebClient webClient = WebClient.create();

        Mono<Product> productMono = webClient.post()
                .uri(uri)
                .body(product, Product.class)
                .retrieve()
                .bodyToMono(Product.class);

        productMono.subscribe();
        return productMono;
    }
}
