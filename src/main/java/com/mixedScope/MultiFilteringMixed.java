package com.mixedScope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MultiFilteringMixed implements Filter {
    @Override
    public List<String> getRecommendedMovie() {
        List<String> movies = new ArrayList<>();
        movies.add("Back to the future");
        movies.add("Back to the future 2");
        movies.add("Back to the future 3");
        return movies;
    }

    @Override
    public String toString() {
        return "MultiFilteringMixed{ hashCode:" +this.hashCode()+
                " }";
    }
}
