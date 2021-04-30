package it.riccardo.app.webapprest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@ContextConfiguration
@ComponentScan(basePackages = "it.riccardo")
public class WebAppRestApplicationTestConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(H2)
                .setScriptEncoding(UTF_8.name())
                .ignoreFailedDrops(true)
                .build();
    }
}
