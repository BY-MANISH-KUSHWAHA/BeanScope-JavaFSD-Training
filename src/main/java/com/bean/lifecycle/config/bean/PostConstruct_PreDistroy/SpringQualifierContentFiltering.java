package com.bean.lifecycle.config.bean.PostConstruct_PreDistroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Qualifier("CF")
@Primary
public class SpringQualifierContentFiltering implements SpringQualifierMovieFilters {
    public static String[] getSpecialRecommandations(String movie){
        return new String[]{"Avengers","Mrs. Marvel","Hulk","Back to the future","Final Destination","Iron Man","Love and Thunder","Spiderman",
                "Amazing Spiderman","Batman","Fast 5"};
    }

    @Override
    public List<String> getRecommandations() {
        List<String> arr = new ArrayList<>();
        for (String movie:
             SpringQualifierContentFiltering.getSpecialRecommandations(" ")) {
            arr.add(movie);
        }
        arr = arr.stream().filter(s -> s.length()<8).collect(Collectors.toList());
        return arr;
    }
}
