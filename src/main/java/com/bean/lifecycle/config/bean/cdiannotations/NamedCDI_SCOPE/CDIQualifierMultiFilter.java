package com.bean.lifecycle.config.bean.cdiannotations.NamedCDI_SCOPE;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Qualifier("MF")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CDIQualifierMultiFilter implements CDIQualifierMovieFilters {

    @Override
    public List<String> getRecommandations() {
        List<String> arr = new ArrayList<>();
        for (String movie:
                CDIQualifierContentFiltering.getSpecialRecommandations(" ")) {
            arr.add(movie);
        }
        arr = arr.stream().filter(s -> s.length()<10).collect(Collectors.toList());
        return arr;
    }


}
