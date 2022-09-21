package com.bean.lifecycle.config.bean.singletonScope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class MovieRecommenderSystem {
    private Filter filter;

    public List<String> RecommendedMovieByFilter(){
        return filter.getRecommendedMovie();
    }

    public static void main(String[] args) {
        // Spring Based Automanaging Dependecies
        ApplicationContext appContextObj = SpringApplication.run(MovieRecommenderSystem.class,args);

        // Singleton Bean
        ContentFiltering obj1 = appContextObj.getBean(ContentFiltering.class);
        ContentFiltering obj2 = appContextObj.getBean(ContentFiltering.class);
        ContentFiltering obj3 = appContextObj.getBean(ContentFiltering.class);

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);

    }
}

