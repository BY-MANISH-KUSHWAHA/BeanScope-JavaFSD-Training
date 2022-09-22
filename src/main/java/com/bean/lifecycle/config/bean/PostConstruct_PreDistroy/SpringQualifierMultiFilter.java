package com.bean.lifecycle.config.bean.PostConstruct_PreDistroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Qualifier("MF")
public class SpringQualifierMultiFilter implements SpringQualifierMovieFilters {

    @Override
    public List<String> getRecommandations() {
        List<String> arr = new ArrayList<>();
        for (String movie:
                SpringQualifierContentFiltering.getSpecialRecommandations(" ")) {
            arr.add(movie);
        }
        arr = arr.stream().filter(s -> s.length()<10).collect(Collectors.toList());
        return arr;
    }
}
