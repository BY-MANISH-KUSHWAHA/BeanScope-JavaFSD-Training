package com.bean.lifecycle.config.bean;

import com.bean.lifecycle.config.bean.mixedScope.ContentFilteringMixed;
import com.bean.lifecycle.config.bean.mixedScope.MultiFilteringMixed;
import com.bean.lifecycle.config.bean.prototypeScope.ContentFilteringProtoType;
import com.bean.lifecycle.config.bean.singletonScope.ContentFiltering;
import com.bean.lifecycle.config.bean.singletonScope.MovieRecommenderSystem;
import com.bean.lifecycle.config.bean.singletonScope.MultiFiltering;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeanApplication {

	public static void main(String[] args) {

		ApplicationContext appContextObj = SpringApplication.run(BeanApplication.class,args);

		System.out.println("------------------------ Singleton Scope ------------------------------");
		// Singleton Bean
		ContentFiltering obj1 = appContextObj.getBean(ContentFiltering.class);
		ContentFiltering obj2 = appContextObj.getBean(ContentFiltering.class);
		ContentFiltering obj3 = appContextObj.getBean(ContentFiltering.class);

		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println();

		System.out.println("------------------------ Protyoe Scope ------------------------------");
		// Prototype Bean
		ContentFilteringProtoType obj4 = appContextObj.getBean(ContentFilteringProtoType.class);
		ContentFilteringProtoType obj5 = appContextObj.getBean(ContentFilteringProtoType.class);
		ContentFilteringProtoType obj6 = appContextObj.getBean(ContentFilteringProtoType.class);

		System.out.println(obj4);
		System.out.println(obj5);
		System.out.println(obj6);
		System.out.println();

		System.out.println("------------------------ Mixed Scope ------------------------------");
		System.out.println(" ++++++++++++++++ ProtoType +++++++++++++++++++++++++++++++");
		MultiFilteringMixed obj7 = appContextObj.getBean(MultiFilteringMixed.class);
		MultiFilteringMixed obj8 = appContextObj.getBean(MultiFilteringMixed.class);
		MultiFilteringMixed obj9 = appContextObj.getBean(MultiFilteringMixed.class);
		System.out.println(obj7);
		System.out.println(obj8);
		System.out.println(obj9);


		System.out.println(" ++++++++++++++++ Single +++++++++++++++++++++++++++++++");
		ContentFilteringMixed obj10 = appContextObj.getBean(ContentFilteringMixed.class);
		ContentFilteringMixed obj11 = appContextObj.getBean(ContentFilteringMixed.class);
		ContentFilteringMixed obj12 = appContextObj.getBean(ContentFilteringMixed.class);
		System.out.println(obj10);
		System.out.println(obj11);
		System.out.println(obj12);





	}

}
