package beyondMedicine.com.backend.adapter.data.jpa.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Primary

@ConfigurationProperties(
    prefix = "spring.datasource",
    ignoreUnknownFields = false,
    ignoreInvalidFields = true,
)
@Primary
data class DatabaseProperties(
    val master: DataSourceProperty
) {
    data class DataSourceProperty(
        val driverClassName: String,
        val jdbcUrl: String,
        val username: String,
        val password: String,
    )
}
