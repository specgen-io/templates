package {{package.value}}

import com.squareup.moshi.Moshi
import org.springframework.context.annotation.*
import {{package.value}}.json.setupMoshiAdapters

@Configuration
open class MoshiConfiguration {
    @Bean
    @Primary
    fun getMoshi(): Moshi {
        val moshiBuilder = Moshi.Builder()
        setupMoshiAdapters(moshiBuilder)
        return moshiBuilder.build()
    }
}