package {{package.value}};

import com.squareup.moshi.Moshi;
import org.springframework.context.annotation.*;
import {{package.value}}.json.Json;

@Configuration
public class MoshiConfiguration {
	@Bean
	@Primary
	public Moshi getMoshi() {
		var moshiBuilder = new Moshi.Builder();
		Json.setupMoshiAdapters(moshiBuilder);
		return moshiBuilder.build();
	}
}