package {{package.value}};

import com.squareup.moshi.Moshi;
import io.micronaut.context.annotation.*;
import jakarta.inject.Singleton;
import {{package.value}}.json.CustomMoshiAdapters;

@Factory
public class MoshiFactory {
    @Singleton
    public Moshi getMoshi() {
        var moshiBuilder = new Moshi.Builder();
		CustomMoshiAdapters.setup(moshiBuilder);
        return moshiBuilder.build();
    }
}