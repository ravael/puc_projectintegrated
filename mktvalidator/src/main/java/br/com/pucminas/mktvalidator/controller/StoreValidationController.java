package br.com.pucminas.mktvalidator.controller;

import br.com.pucminas.mktvalidator.domain.Store;
import br.com.pucminas.mktvalidator.service.StoreValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("store/validation")
public class StoreValidationController {

    private final StoreValidationService storeService;


    @PostMapping
    public Mono<Void> validate(@Valid @RequestBody Store store) {
        return  storeService.storeValidade(store);
    }


}
