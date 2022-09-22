package com.bean.lifecycle.config.bean.PostConstruct_PreDistroy;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.logging.Logger;


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
    //private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    //Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
    private SpringQualifierMovieFilters filter;
    //private logger = LoggerFactory;

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

    @PreDestroy
    public void checkPreDestroy(){
        System.out.println("Inside Movie Pre Destroy from PostConstruct_PreDistroy");
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
