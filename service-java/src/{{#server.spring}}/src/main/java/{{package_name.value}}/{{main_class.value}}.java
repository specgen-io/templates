package {{package_name.value}};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
{{#swagger.value}}
import springfox.documentation.swagger2.annotations.EnableSwagger2;
{{/swagger.value}}

{{#swagger.value}}
@EnableSwagger2
{{/swagger.value}}
@SpringBootApplication
public class {{main_class.value}} {

	public static void main(String[] args) {
		SpringApplication.run({{main_class.value}}.class, args);
	}
}
