package cn.zwl.springboot.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientApplication {
	@Value("${bar}")
	private String configValue;
	
	@RequestMapping("/")
    public String home() {
        return "Hello World! The bar value="+configValue;
    }
	
  public static void main(String[] args) {
    SpringApplication.run(ConfigClientApplication.class, args);
  }
}
