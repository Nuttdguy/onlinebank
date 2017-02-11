
Creating Spring Project:
1) New Maven project
2) Add Dependencies 
	| Spring-Beans
	| Spring-Context
	| Spring-Core
3) Add Model and New Spring Configuration File
4) Add New beans.xml file > create beans for desired classes
5) Configure/add application context to App class

Creating Spring-Boot Project:
1) Create New Maven Project
2) Add dependecies
	| Spring-boot-starter-parent
	| Spring-boot-starter-web
	| Spring-boot-starter-tomcat
3) Create App Class (main entry point)
	| SpringApplication.run(App.class, args)
	| @EnableAutoConfiguration
	| @RestController
	| @RequestMapping
	| @Component
4) Create classes
	| @Component (enables class for DI)
	| @Autowired (injects the class)


Process for building a layered maven project and MVC application

=================================================================
Creating Maven Project:
=================================================================

1) Create New Maven Project
	| Packaging POM
2) Create Maven Modules (Simple)
3) Add Maven-war-plugin
	| configuration > failOnMissingWebXml == false
4) Add primary dependencies to Maven Aggregator Project POM

5) Add dependencies to web/controller-layer
	| spring-boot-starter-parent
	| spring-boot-starter-tomcat (configuration scope == provided)
	| spring-boot-starter-web
	| add ui-layer
6) Add spring-boot-maven-plugin & maven-war-plugin
	| configuration executable == true
	| configuration failOnMissingWebXml == false
	| add property java.version
7) Create SpringBootApplication Class
	| extend w/ SpringBootServletInitializer
	| override SpringApplicationBuilder configure() { return application.sources( ) }
	| @Configuration
	| @EnableAutoConfiguration
	| @ComponentScan( {" package name " } )

	| @EnableJpaRepositories -- review 
	| @EntityScan( { "package name" } )  -- review
8) Create Controllers
	| add home controller
	| @Controller
	| @RequestMapping("/")

9) Add dependencies to UI-layer
	| spring-boot-starter-thymeleaf
	| add model-layer
	| add business-layer
10) Create templates for ui/presentation-layer
	| add resources/static folders
	| add resources/templates folder 
	| add html files
	| add css files
	| add javascript files
	| add other client-side files

11) Add dependencies to Model-layer (revisit)
	| spring-boot-starter-data-jpa
12) create domain classes
	| add models for domains

13) Add dependencies to Repository-layer
	| mysql-connector-java
	| spring-boot-starter-data-jpa
	| add model-layer
	| spring-boot-starter-jdbc

14) Add dependencies to Service-layer
	| java.servlet-api
	| add business-layer
	| add repository-layer
	| spring-boot-starter-security
	| spring-boot-core
15) Configure authentication
	| config > RequestFilter
	| config > SecurityConfig
	| resource > UserResource (api endpoint)
	| security > Authority
    config package
	| add SecurityConfig class extends WebSecurityConfigurerAdapter
		| Environment (autowire)
		| UserSecurityService (autowire)
		| static final field SALT = "salt"
		| BCryptPasswordEncoder()
		| static final String[] PUBLIC_MATCHERS field;
		| configure(HttpSecurity)  [override]
		| configureGlobal(AutheticationManagerBuilder) [autowired]
	| add RequestFilter class implements Filter
		| doFilter()
		| init()
		| destroy()

16) Configure Maven Build run configuration in Eclipse
	| use primary POM as base directory
	| define Maven Goal ... e.g. package or clean package

17) Configure database connection (required default placement in ui-layer /resources/ )
	| add application.properties file
	| add spring.datasource.url = jdbc:mysql://localhost:3306/OnlineBanking?useSSL=false
	| add spring.datasource.username
	| add spring.datasource.password 
	| spring.datasource.testWhileIdle = true
	| spring.datasource.validationQuery = SELECT 1
	| spring.jpa.show-sql = true
	| spring.jpa.hibernate.ddl-auto = update
	| spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

18) Create database
	| add mysql to system enviroment path
	| Login to MySql -u username -p
	| create database nameofdatabase;
	| use database;
19) Create database user
	| Create user 'newuser'@'localhost' identified by 'password'
	| Grant all privileges on *.* to 'newuser'@'localhost';
	| Flush privileges;










































