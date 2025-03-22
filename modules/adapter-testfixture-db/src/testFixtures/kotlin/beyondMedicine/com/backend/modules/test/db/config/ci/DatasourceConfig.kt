package beyondMedicine.com.backend.modules.test.db.config.ci

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
import javax.sql.DataSource

@Configuration
@EnableConfigurationProperties(
    value = [DatabaseProperties::class],
)
class DatasourceConfig(
    private val dbProps: DatabaseProperties,
) {
    companion object {
        const val MASTER_DATASOURCE = "masterDataSource"
    }

    @Bean(MASTER_DATASOURCE)
    @Primary
    fun masterDataSource(): DataSource {
        return DriverManagerDataSource().apply {
            setDriverClassName(dbProps.master.driverClassName)
            url = dbProps.master.jdbcUrl
            username = dbProps.master.username
            password = dbProps.master.password
        }
    }

    @Bean
    @DependsOn(MASTER_DATASOURCE)
    fun dataSource(dataSource: DataSource?): LazyConnectionDataSourceProxy {
        return LazyConnectionDataSourceProxy(dataSource!!)
    }
}
