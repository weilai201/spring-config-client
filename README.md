### Spring cloud 配置中心客户端（Demo）

本工程为Spring-config-client demo工程。

### 如何使用Spring cloud 配置中心的sdk？

1. pom.xml中需要引入如下依赖配置 
  
    <dependency>
	   <groupId>org.springframework.cloud</groupId>
	   <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
 
2. 配置 bootstrap.properties

在/src/main/resources中放入 bootstrap.properties 配置文件。启动程序时，应用或自动根据bootstrap配置文件中的地址去远程服务端获取配置。但是，这对程序员是无感知的。
    
3. 注入配置值

和获取本地配置文件一样，使用@Value("${key}")注入配置值。
例如本例中获取属性bar的值。
    
    @SpringBootApplication
    @RestController
    public class ConfigClientApplication {
	  @Value("${bar}")
	  private String configValue;
	
      @RequestMapping("/")
      public String home() {
        return "Hello World!--"+configValue;
      }
      ......
 
4. 运行程序

在IDE中，直接编译运行ConfigClientApplication.java文件，启动该程序。启动后，访问：http://localhost:8080/访问程序。
该程序或输出“Hello World! The bar value=foo” bar为远程服务端配置的属性。     