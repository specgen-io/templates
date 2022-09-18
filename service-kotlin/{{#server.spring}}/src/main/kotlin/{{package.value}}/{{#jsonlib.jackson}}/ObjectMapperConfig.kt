package {{package.value}}

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.*
import {{package.value}}.json.setupObjectMapper

@Configuration
class ObjectMapperConfig {
    @Bean
    @Primary
    fun objectMapper(): ObjectMapper {
        val objectMapper = jacksonObjectMapper()
        setupObjectMapper(objectMapper)
        return objectMapper
    }
}