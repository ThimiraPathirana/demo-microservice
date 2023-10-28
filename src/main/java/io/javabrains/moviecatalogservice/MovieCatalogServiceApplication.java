package io.javabrains.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import io.javabrains.moviecatalogservice.resources.TvCatalogResource;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MovieCatalogServiceApplication {
    //	static List<String> places = new ArrayList<>();
//	public static List getPlaces(){
//
//		// add places and country to the list
//		places.add("Nepal, Kathmandu");
//		places.add("Nepal, Pokhara");
//		places.add("India, Delhi");
//		places.add("USA, New York");
//		places.add("Africa, Nigeria");
//
//		return places;
//	}
    @Bean
    public RestTemplate RestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogServiceApplication.class, args);
//		List<String> myPlaces = getPlaces();
//		System.out.println("Places from Nepal:");
//
//		// Filter places from Nepal
//		List<String> list = myPlaces.stream()
//				.filter((p) -> p.startsWith("Nepal"))
//				.map((p) -> p.toUpperCase())
//				.sorted().collect(Collectors.toList());
////				.forEach((p) -> System.out.println(p));
//
//		System.out.println(list);
    }

}
//@FunctionalInterface
//interface GenericInterface<T> {
//
//	// generic method
//	T func(T t);
//}