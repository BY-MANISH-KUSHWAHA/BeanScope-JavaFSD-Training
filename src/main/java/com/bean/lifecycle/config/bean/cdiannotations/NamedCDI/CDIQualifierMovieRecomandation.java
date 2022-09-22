package com.bean.lifecycle.config.bean.cdiannotations.NamedCDI;


import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


/*
@Component
public class SpringQualifierMovieRecomandation {
    @Autowired
    @Qualifier("MF")
    private SpringQualifierMovieFilters filter;

    //public SpringQualifierMovieRecomandation(@Qualifier("MF") SpringQualifierMovieFilters filter) {
    //    super();
    //    this.filter = filter;
    //}

    public List<String> recommandMovie(String movie){
        // suppose based on rating all movies are sorted.
        return filter.getRecommandations();

    }


}

 */

@Named
public class CDIQualifierMovieRecomandation {
    //private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    //Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
    private CDIQualifierMovieFilters filter;
    //private logger = LoggerFactory;

    @Inject
    // must-have @Primary for Autowired or we can skip @Autowired or without primary we need to used Qualifier with Autowired
    @Qualifier("CF")
    public void setFilter(CDIQualifierMovieFilters filter){this.filter = filter;}

    public CDIQualifierMovieFilters getFilter() {
        return filter;
    }

    public List<String> recommandMovie(String movie){
        // suppose based on rating all movies are sorted.
        return filter.getRecommandations();
    }


}
