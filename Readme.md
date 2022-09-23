

BEAN SCOPES —————————— Singleton, Prototype, Request, Session, Application, WebSocket

Singleton Scope

ContentFiltering obj1 = appContextObj.getBean(ContentFiltering.class); com.bean.lifecycle.config.beanlifecycle.singleton.com.scope.ContentFiltering@2fb68ec6 ContentFiltering obj2 = appContextObj.getBean(ContentFiltering.class); SPRING CONTAINER => CREATES ONE SHARED INSTANCE => CACHED MEMORY com.bean.lifecycle.config.beanlifecycle.singleton.com.scope.ContentFiltering@2fb68ec6 ContentFiltering obj3 = appContextObj.getBean(ContentFiltering.class); com.bean.lifecycle.config.beanlifecycle.singleton.com.scope.ContentFiltering@2fb68ec6

Prototype Scope

ContentFiltering obj1 = appContextObj.getBean(ContentFiltering.class); com.bean.lifecycle.config.beanlifecycle.singleton.com.scope.ContentFiltering@117632cf ContentFiltering obj2 = appContextObj.getBean(ContentFiltering.class); SPRING CONTAINER => CREATES NEW BEAN INSTANCES com.bean.lifecycle.config.beanlifecycle.singleton.com.scope.ContentFiltering@2fb68ec6 ContentFiltering obj3 = appContextObj.getBean(ContentFiltering.class); com.bean.lifecycle.config.beanlifecycle.singleton.com.scope.ContentFiltering@d71adc2

Mixed Scope

SPRING CONTAINER => SINGELTON SCOPE => MULTI FILTERING => WHEN CONTENT FILTERING IS REQUESTED => PROTOTYPE BEAN

Arjun => Requesting Trailer => USA Server => Content would be retrieved => Proxy Server => Client => Arjun Manish =>Request USA Server Regional Cache => Proxy Send him back the response Requesting Trailer => Proxy Server => Client => Manish

Singleton => Proxy Mode => Prototype By Injecting into Singleton

@ComponentScan

=> Scans specific packages

=> Filter Types

    Include Filters => Package to Include
        Exclude Filters => Package to exclude

    FilterType.ANNOTATION

    FilterType.ASPECTJ

    FilterType.ASSIGNABLE_TYPE

    FilterType.REGEX

    FilterType.CUSTOM

Bean Life Cycle

Container => Bean Instantiation => Dependency Injection => Post Constructor Method=> Bean is Ready => Pre Destroy Method

Employee Management System

    Prerequisite method before running application => Connecting to Database => Establish a connection => Post Construct

Lot of Methods => Adding an Employee, Update an Employee

Connect() => Wait Time addEmployee() UpdateEmployee()

Container => Method With @PostConstructor => Bean Ready AddEmployee() UpdateEmployee() Container => Method with @PreDestroy => Bean Destroyed

Prototypes Scoped Beans

Singleton => Container => Insantiates Beans => PostConstructor => All Beans get ready => PreDestroy ConnectDatabase() => PostConstructor obj1.AddEmployee() obj1.DeleteEmployee() obj2.updateEmployee() obj2.findEmployee() DisconnectDatabase() => PreDestroy

Prototype =>Container => Instantiates Beans => Obj1 Beans Ready => Post Constructors => PreDestroy => Obj2 Beans Ready => Post Constructors => PreDestroy

ConnectDatabase() => PostConstructor obj1.AddEmployee() obj1.DeleteEmployee() DisconnectDatabase() => PreDestroy

ConnectDatabase() => PostConstructor obj2.updateEmployee() obj2.findEmployee() DisconnectDatabase() => PreDestroy
