package {{package.value}};

import com.squareup.moshi.Moshi
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton
import {{package.value}}.json.setupMoshiAdapters

@Factory
class MoshiFactory {
    @Singleton
    fun getMoshi(): Moshi {
        val moshiBuilder = Moshi.Builder()
        setupMoshiAdapters(moshiBuilder)
        return moshiBuilder.build()
    }
}