package br.com.pucminas.mktvalidator.repository;

import br.com.pucminas.mktvalidator.domain.StoreValidations;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StoreValidationRepository extends ReactiveCrudRepository<StoreValidations, Integer> {


}
