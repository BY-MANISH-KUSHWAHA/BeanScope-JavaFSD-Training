package com.bean.lifecycle.config.bean.proxyMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Single Tone
public class ContentFilteringProxy implements Filter {

    private static int instance;
    @Autowired
    private Movie movie;

    public ContentFilteringProxy() {
        super();
        instance++;

    }

    @Override
    public List<String> getRecommendedMovie() {
        List<String> movies = new ArrayList<>();
        movies.add("Iron Man");
        movies.add("Iron Man 2");
        movies.add("Iron Man 3");
        return movies;
    }

    public Movie getMovie() {
        return movie;
    }

    public static int getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "ContentFilteringMixed{ hashCode:" +this.hashCode()+
                " }";
    }
}
