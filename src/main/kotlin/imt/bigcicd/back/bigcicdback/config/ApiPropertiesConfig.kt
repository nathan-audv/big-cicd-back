package imt.bigcicd.back.bigcicdback.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:api.properties")
class ApiPropertiesConfig {
    /*    @Value("classpath:api.properties")
        lateinit var apiProperties: Resource

        @Bean
        fun apiProperties(): Properties {
            return Properties().apply {
                load(apiProperties.inputStream)
            }
        }*/
}