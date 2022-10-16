package br.com.pucminas.mktvalidator.controller;

import br.com.pucminas.mktvalidator.domain.Product;
import br.com.pucminas.mktvalidator.domain.Store;
import br.com.pucminas.mktvalidator.service.ProductValidationService;
import br.com.pucminas.mktvalidator.service.StoreValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("product/validation")
public class ProductValidationController {

    private final ProductValidationService productValidationService;


    @PostMapping
    public Mono<Void> validate(@Valid @RequestBody Product product) {
        return  productValidationService.productValidade(product);
    }


}
