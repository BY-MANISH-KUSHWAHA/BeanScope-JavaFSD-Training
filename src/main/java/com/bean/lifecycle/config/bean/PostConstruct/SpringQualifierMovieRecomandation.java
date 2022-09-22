package com.bean.lifecycle.config.bean.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


/*
@Component
public class SpringQualifierMovieRecomandation {
    @Autowired
    @Qualifier("MF")
    private SpringQualifierMovieFilters filter;

    //public SpringQualifierMovieRecomandation(@Qualifier("MF") SpringQualifierMovieFilters filter) {
    //    super();
    //    this.filter = filter;
    //}

    public List<String> recommandMovie(String movie){
        // suppose based on rating all movies are sorted.
        return filter.getRecommandations();

    }


}

 */

@Component
public class SpringQualifierMovieRecomandation {
    private SpringQualifierMovieFilters filter;

    @Autowired // must-have @Primary for Autowired or we can skip @Autowired or without primary we need to used Qualifier with Autowired
    @Qualifier("CF")
    public void setFilter(SpringQualifierMovieFilters filter){this.filter = filter;}

    @PostConstruct
    public void databaseConnection(){
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("Running this method first before any bean methods in MongoDB");
        // add logger for developer use only
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

    }
    //private SpringQualifierMovieFilters filter;

    //public SpringQualifierMovieRecomandation(@Qualifier("MF") SpringQualifierMovieFilters filter) {
    //    System.out.println("Using Constructor Qualifier");
    //    this.filter = filter;
    //}

    public List<String> recommandMovie(String movie){
        // suppose based on rating all movies are sorted.
        return filter.getRecommandations();
    }


}
