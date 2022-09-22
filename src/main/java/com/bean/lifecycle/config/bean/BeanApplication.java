package com.bean.lifecycle.config.bean;

import com.bean.lifecycle.config.bean.PostConstruct.SpringQualifierMovieRecomandation;
import com.mixedScope.ContentFilteringMixed;
import com.mixedScope.MultiFilteringMixed;
import com.bean.lifecycle.config.bean.prototypeScope.ContentFilteringProtoType;
import com.bean.lifecycle.config.bean.proxyMode.ContentFilteringProxy;
import com.bean.lifecycle.config.bean.proxyMode.Movie;
import com.bean.lifecycle.config.bean.singletonScope.ContentFiltering;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.List;

@SpringBootApplication // Without ComponentScan it only includes current and sub package in it scope
// add outside scope package for SpringBootApplication (mixedScope out of scope)
@ComponentScan(basePackages = {"com.bean.lifecycle.config.bean.PostConstruct","com.bean.lifecycle.config.bean.singletonScope", "com.bean.lifecycle.config.bean.scopes", "com.bean.lifecycle.config.bean.proxyMode", "com.bean.lifecycle.config.bean.prototypeScope","com.mixedScope"})
/*
@ComponentScan

=> Scans specific packages

=> Filter Types
	1. Include Filters
		=> Package to Include
	2. Exclude Filters
		=> Package to exclude
1. FilterType.ANNOTATION
2. FilterType.ASPECT
3. FilterType.ASSIGNABLE_TYPE
4. FilterType.REGEX
5. FilterType.CUSTOM

Bean Life Cycle

	Container => Bean Instantiation => Dependency Injection => Post Construct Method=> Bean is Ready

Employee Management System

	1. Prerequisite method before running application => Connecting to Database => Establish a connection => Post Construct

Lot of Methods => Adding an Employee, Update an Employee
Connecto => Wait Time addEmployee (
UndateEmploveel
Container => Method With @PostConstructor => Bean Readv

AddEmplovee(
UpdateEmployee ()
Container => Method with @PreDestroy => Bean Destroyed


 */
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

		System.out.println(" ++++++++++++++++ Single +++++++++++++++++++++++++++++++");
		ContentFilteringMixed obj10 = appContextObj.getBean(ContentFilteringMixed.class);
		ContentFilteringMixed obj11 = appContextObj.getBean(ContentFilteringMixed.class);
		ContentFilteringMixed obj12 = appContextObj.getBean(ContentFilteringMixed.class);
		System.out.println(obj10);
		System.out.println(obj11);
		System.out.println(obj12);

		System.out.println(" ++++++++++++++++ ProtoType +++++++++++++++++++++++++++++++");
		MultiFilteringMixed obj7 = appContextObj.getBean(MultiFilteringMixed.class);
		MultiFilteringMixed obj8 = appContextObj.getBean(MultiFilteringMixed.class);
		MultiFilteringMixed obj9 = appContextObj.getBean(MultiFilteringMixed.class);
		System.out.println(obj7);
		System.out.println(obj8);
		System.out.println(obj9);

		System.out.println();


		System.out.println("------------------------ Proxy Inserting Prototype Bean ------------------------------");
		ContentFilteringProxy filter = appContextObj.getBean(ContentFilteringProxy.class);
		System.out.println("\n Content Filter Bean with Single Scope");
		System.out.println(filter);

		System.out.println("------------------------ Retrive and print prototpye bean from the single bean twice ------------------------------");
		// Retrive and print prototpye bean from the single bean twice
		// Prototype Movie = Singleton filter.getMovie() using Proxy
		Movie m1 = filter.getMovie();
		Movie m2 = filter.getMovie();
		Movie m3 = filter.getMovie();

		System.out.println("\n Movie Bean with prototype scope");
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);

		// Number of Instance
		System.out.println();
		System.out.println("Number of Content Filter instance: "+ContentFilteringProxy.getInstance());
		System.out.println("Number of Movie instance: "+Movie.getInstance());



		System.out.println("---------- Spring Dependency Bean Management by Qualifier (Post Constructor)-------------------------");
		// Selection based on Qualifier Value
		// PostConstruct used as Websocket connection before start an application.
		SpringQualifierMovieRecomandation movieQualifierRecomandationSpring = appContextObj.getBean(SpringQualifierMovieRecomandation.class);
		List<String> finalQalifierResult = movieQualifierRecomandationSpring.recommandMovie("");
		System.out.println("SpringDependencyBeanQualifierManagemnt:"+finalQalifierResult);

	}

}
