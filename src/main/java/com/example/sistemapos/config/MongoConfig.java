package com.example.sistemapos.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    // Lee la variable desde tu application.properties
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    // Lee el nombre de la BD desde tu application.properties
    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Override
    protected String getDatabaseName() {
        // Obliga a Spring Boot a usar este nombre sí o sí
        return databaseName;
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        if (mongoUri == null || mongoUri.trim().isEmpty()) {
            throw new IllegalArgumentException("La URI de MongoDB no está configurada.");
        }

        // Aplica la conexión leyendo tu URI
        builder.applyConnectionString(new ConnectionString(mongoUri));
    }
}