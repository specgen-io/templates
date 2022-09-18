package {{package.value}};

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.annotation.*;
import io.micronaut.jackson.ObjectMapperFactory;
import jakarta.inject.Singleton;
import {{package.value}}.json.CustomObjectMapper;

@Factory
@Replaces(ObjectMapperFactory.class)
public class ObjectMapperConfig {

	@Singleton
	@Replaces(ObjectMapper.class)
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		CustomObjectMapper.setup(objectMapper);
		return objectMapper;
	}
}
