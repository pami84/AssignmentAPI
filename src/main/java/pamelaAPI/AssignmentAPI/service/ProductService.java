package pamelaAPI.AssignmentAPI.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pamelaAPI.AssignmentAPI.model.Product;

import java.util.List;

@Service
public class ProductService {

    private static final String BASE_URL = "https://fakestoreapi.com/";
    private final WebClient webClient;

    public ProductService() {
        this.webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }

    public List<Product> getAllProducts() {

        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList()
                .block();


    }
}