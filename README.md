# DispatcherServlet request processing workflow

* bootstrap
	* DispatcherServlet static initialization block
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/DispatcherServlet.java#L273

	* DispatcherServlet.properties
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/resources/org/springframework/web/servlet/DispatcherServlet.properties

	* HttpServletBean.init()
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/HttpServletBean.java#L116

	* FrameworkServlet.initServletBean()
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/FrameworkServlet.java#L485

	* FrameworkServlet.initWebApplicationContext()
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/FrameworkServlet.java#L521

	* @MVC
		* AnnotationDrivenBeanDefinitionParser: <mvc: annotation-driven />
			- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/config/AnnotationDrivenBeanDefinitionParser.java

		* WebMvcConfigurationSupport: @EnableWebMvc
			- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/config/annotation/WebMvcConfigurationSupport.java	

	* FrameworkServlet.configureAndRefreshWebApplicationContext()
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/FrameworkServlet.java#L638

	* DispatcherServlet.onRefresh() -> DispatcherServlet.initStrategies()
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/DispatcherServlet.java#L478

	* for each strategies ...

* 요청 선처리 작업
	* FrameworkServlet.service() -> HttpServlet.doGet()/doPost()/... -> FrameworkServlet.processRequest()
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/FrameworkServlet.java#L838

	* FrameworkServlet.processRequest()
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/FrameworkServlet.java#L952

	* DispatcherSevlet.doService()
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/DispatcherServlet.java#L858

* HandlerExecutionChain 결정 및 실행
	* DispatcherServlet.doDispatch()
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/DispatcherServlet.java#L916

	* Controller 실행

* 뷰 렌더링 / 예외 처리
	* DispatcherServlet.processDispatchResult()
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/DispatcherServlet.java#L1008

	* DispatcherServlet.processHandlerException()
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/DispatcherServlet.java#L1177

	* DispatcherServlet.render()
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/DispatcherServlet.java#L1216

* 요청 처리 종료
	* DispatcherServlet.processRequest().finally
		- https://github.com/spring-projects/spring-framework/blob/master/spring-webmvc/src/main/java/org/springframework/web/servlet/FrameworkServlet.java#L986
