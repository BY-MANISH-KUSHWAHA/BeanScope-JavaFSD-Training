package com.bean.lifecycle.config.bean.lifeCyclePrototypeBeans;


import com.bean.lifecycle.config.bean.proxyMode.Movie;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MoviePB {
    private int id;
    private String fname;
    private String gender;
    private String director;

    public MoviePB(){
        super();
        System.out.println("In MoviePB Constructor Method");
    }

    @PostConstruct
    private void checkPostConstruct(){
        System.out.println("In Movie Post Constructor Method");
    }

    @PreDestroy
    private void checkPreDestroy(){
        // Never Executed (Stop Beans before it )
        System.out.println("In Movie Pre Destroy Method");
    }


    public double movieSimilarity(MoviePB m1, MoviePB m2){
        double similar = 0;
        return similar;
    }

    @Override
    public String toString() {
        return "MoviePB" +
                "{\n" +
                "\thashCode=" + this.hashCode() +"\n"+
                '}';
    }
}
