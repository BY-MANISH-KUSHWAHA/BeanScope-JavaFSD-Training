package com.bean.lifecycle.config.bean.singletonScope;

import java.util.ArrayList;
import java.util.List;

public class MultiFiltering implements Filter{
    @Override
    public List<String> getRecommendedMovie() {
        List<String> movies = new ArrayList<>();
        movies.add("Back to the future");
        movies.add("Back to the future 2");
        movies.add("Back to the future 3");
        return movies;
    }
}
