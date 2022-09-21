package com.bean.lifecycle.config.bean.prototypeScope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class MovieRecommenderSystemProtoType {
    private Filter filter;

    public List<String> RecommendedMovieByFilter(){
        return filter.getRecommendedMovie();
    }

    public static void main(String[] args) {
        // Spring Based Automanaging Dependecies
        ApplicationContext appContextObj = SpringApplication.run(MovieRecommenderSystemProtoType.class,args);

        // Singleton Bean
        ContentFilteringProtoType obj1 = appContextObj.getBean(ContentFilteringProtoType.class);
        ContentFilteringProtoType obj2 = appContextObj.getBean(ContentFilteringProtoType.class);
        ContentFilteringProtoType obj3 = appContextObj.getBean(ContentFilteringProtoType.class);

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);

    }
}

