package br.com.pucminas.apiproduct.controller;

import br.com.pucminas.apiproduct.domain.Product;
import br.com.pucminas.apiproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/list")
    public Mono<Page<Product>> getProducts(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return productService.findAll(PageRequest.of(page, pageSize));
    }

    @GetMapping("/list/ecommerce")
    public Mono<Page<Product>> getStoreProducts(int clientId, @RequestParam Integer page, @RequestParam Integer pageSize) {
        return productService.findProductsStore(clientId, PageRequest.of(page, pageSize));
    }

    @PostMapping("/save")
    public Mono<Product> save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/update")
    public Mono<Void> update(@RequestBody Product product) {
        return productService.update(product);
    }

    @GetMapping("/list/available")
    public Mono<Page<Product>> listProductsAvailable(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return productService.findProductsAvailable(PageRequest.of(page, pageSize));
    }

    @GetMapping("/list/not-available")
    public Mono<Page<Product>> listProductsNotAvailable(@RequestParam Integer page, @RequestParam Integer pageSize) {
        return productService.findProductsNotAvailable(PageRequest.of(page, pageSize));
    }
}
