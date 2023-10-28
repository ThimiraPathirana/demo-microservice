package io.javabrains.moviecatalogservice.resources;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Rating;
import io.javabrains.moviecatalogservice.model.TvSeries;
import io.javabrains.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class TvCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;
    @RequestMapping("/test")
    public String getCatalog(){
        return "test";
    }

    @CircuitBreaker(name = "call catalog")
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        UserRating ratingList = restTemplate.getForObject("http://localhost:8083/rating/users/" + userId, UserRating.class);

        return ratingList.getRatings().stream().map( rating -> {
                    TvSeries tvSeries = restTemplate.getForObject("http://localhost:8082/tvSeries/" + rating.getId(), TvSeries.class);

//                    TvSeries tvSeries = webClientBuilder.build()
//                            .get()
//                            .uri("http://localhost:8082/tvSeries/" + rating.getId())
//                            .retrieve()
//                            .bodyToMono(TvSeries.class)
//                            .block();
                    return new CatalogItem(tvSeries.getName(), "Top rated tv series", rating.getRating());
                }).collect(Collectors.toList());

//        return Collections.singletonList(new CatalogItem("Game of thrones", "Top rated tv series", 8.5));
    }

    public String fallbackGetCatalog(Throwable throwable){
        return "test";
    }

}
