package com.bean.lifecycle.config.bean.lifeCyclePrototypeBeans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class ContentFilterPB implements FilterPB{
    public ContentFilterPB(){
        super();
        System.out.println("In Content Filter constructor method");
    }

    @PostConstruct
    private void checkingPostConstructor(){
        System.out.println("In Content Filter Post Constructor Method");
    }

    @PreDestroy
    private void checkingPreDestroy(){
        System.out.println("In Content Filter Pre Destory Method");
    }


    @Override
    public List<String> getRecommededMovie() {
        return null;
    }
}
