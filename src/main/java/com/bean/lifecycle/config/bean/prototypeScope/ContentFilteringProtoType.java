package com.bean.lifecycle.config.bean.prototypeScope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Default is Singleton
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ContentFilteringProtoType implements Filter {
    @Override
    public List<String> getRecommendedMovie() {
        List<String> movies = new ArrayList<>();
        movies.add("Iron Man");
        movies.add("Iron Man 2");
        movies.add("Iron Man 3");
        return movies;
    }

    @Override
    public String toString() {
        return "ContentFilteringProtoType{ hashCode:" +this.hashCode()+
                " }";
    }
}
