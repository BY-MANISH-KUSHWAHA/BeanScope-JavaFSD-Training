package com.bean.lifecycle.config.bean.proxyMode;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)

public class Movie {
    private static int instance;
    private int id;
    private String fname;
    private String gender;
    private String director;

    public Movie() {
        super();
        instance++;
        System.out.println("\n Movie Constructor Called, Instance count: "+instance);
    }

    public static int getInstance() {
        return instance;
    }

    public double movieSimilarity(Movie m1,Movie m2){
        double similar = 0;
        return similar;
    }

    @Override
    public String toString() {
        return "Movie" +
                "{\n" +
                "\tinstance=" + instance +",\n"+
                "\thashCode=" + this.hashCode() +"\n"+
                '}';
    }


}
