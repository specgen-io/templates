package {{package.value}};

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.*;
import {{package.value}}.json.Json;

public class ObjectMapperConfig {
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		Json.setupObjectMapper(objectMapper);
		return objectMapper;
	}
}
