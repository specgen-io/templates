package {{package_name.value}};

import io.micronaut.runtime.Micronaut;
{{#swagger.value}}
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
{{/swagger.value}}

{{#swagger.value}}
@OpenAPIDefinition(
	info = @Info(
		title = "{{project_name.value}}",
		version = "1"
	)
)
{{/swagger.value}}
public class {{main_class.value}} {

	public static void main(String[] args) {
		Micronaut.run({{main_class.value}}.class, args);
	}
}
