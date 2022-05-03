package me.zhengjie.flywayMigration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
public class DatabaseMigrationService {

    private static final String MIGRATION_PATH = "sql/";

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void migrate() {

        final Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations(MIGRATION_PATH);
        flyway.setOutOfOrder(false);
        flyway.setIgnoreFutureMigrations(true);
        flyway.setValidateOnMigrate(false);
        flyway.setBaselineOnMigrate(false);
        flyway.migrate();
    }
}
