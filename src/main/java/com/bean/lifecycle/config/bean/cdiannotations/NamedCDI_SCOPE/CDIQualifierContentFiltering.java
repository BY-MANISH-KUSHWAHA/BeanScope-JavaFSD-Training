package com.bean.lifecycle.config.bean.cdiannotations.NamedCDI_SCOPE;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;




@Named
@Qualifier("CF")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CDIQualifierContentFiltering implements CDIQualifierMovieFilters {
    public static String[] getSpecialRecommandations(String movie){
        return new String[]{"Avengers","Mrs. Marvel","Hulk","Back to the future","Final Destination","Iron Man","Love and Thunder","Spiderman",
                "Amazing Spiderman","Batman","Fast 5"};
    }

    @Override
    public List<String> getRecommandations() {
        List<String> arr = new ArrayList<>();
        for (String movie:
             CDIQualifierContentFiltering.getSpecialRecommandations(" ")) {
            arr.add(movie);
        }
        arr = arr.stream().filter(s -> s.length()<8).collect(Collectors.toList());
        return arr;
    }
}
