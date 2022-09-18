package {{package.value}};

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.*;
import {{package.value}}.json.CustomObjectMapper;

@Configuration
public class ObjectMapperConfig {
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		CustomObjectMapper.setup(objectMapper);
		return objectMapper;
	}
}
