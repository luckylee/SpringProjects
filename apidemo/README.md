# API demo for SpringBoo usage. 
It is the Spring Boot API example aggregator for my study. Most are referenced from

* [SpringBoot Getting-Started Guide](https://spring.io/guides#getting-started-guides)
  * [Build a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
  * [Schedule tasks](https://spring.io/guides/gs/scheduling-tasks/)
  * 
* [SpringBoot topical-guides](https://spring.io/guides#topical-guides)


***
### Task 1: Hello and Greeting Controller and Test
>Add
>* [The basic ApidemoApplication.java](/src/main/java/com/weginlee/apidemo/ApidemoApplication.java)
>* [HelloController.java]
>* [Greeting.java and GreetingController.java]
>* [ApidemoApplicationTests.java](/src/test/java/com/weginlee/apidemo/ApidemoApplicationTests.java)

####Services
@SpringBootApplication launch the Application main 

####Test
SpringBoot default use Junit5 test. It provide the default test environment configuration.  
Use MockMVC to do the mock verify. Need to check out more on test part later. 


***
### Task 2: Schedule the task
TBD <p>
Figure out different between "testimplementation" and "implementation" 'org.awaitility:awaitility'.  
For the case, what is the impact for the 'org.awaitility:awaitility'? 



****
### Task 3: Enable Actuator
>Thought about Actuator components
>
####Service
  management.endpoints.web.exposure.include=*
  management.endpoints.web.exposure.exclude=env,beans



####Test
Add the HelloControllerTest to simulate the real environment and do the integration test.  
Need to check out this part more later. 


****
### Task 4: Serving Web content with Spring MVC
> * [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)

####Services
Create the welcome controller to feed data to the view: welcome.html



