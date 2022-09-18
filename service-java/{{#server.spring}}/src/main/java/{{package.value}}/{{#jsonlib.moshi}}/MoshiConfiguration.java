package {{package.value}};

import com.squareup.moshi.Moshi;
import org.springframework.context.annotation.*;
import {{package.value}}.json.CustomMoshiAdapters;

@Configuration
public class MoshiConfiguration {
	@Bean
	@Primary
	public Moshi getMoshi() {
		var moshiBuilder = new Moshi.Builder();
		CustomMoshiAdapters.setup(moshiBuilder);
		return moshiBuilder.build();
	}
}