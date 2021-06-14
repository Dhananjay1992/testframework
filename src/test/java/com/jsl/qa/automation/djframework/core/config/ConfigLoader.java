package com.jsl.qa.automation.djframework.core.config;


import com.jsl.qa.automation.djframework.core.errors.ImproperTestPropertiesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Configuration
public class ConfigLoader {
    public Properties testConfigProperties = new Properties();
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigLoader.class);
    private Path path = Paths.get("src", "test", "resources", "test-config.properties");


    public ConfigLoader() throws ImproperTestPropertiesException {
        try (FileReader fileReader = new FileReader(path.toFile())) {
            testConfigProperties.load(fileReader);
            LOGGER.info("Test config properties successfully loaded...");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new ImproperTestPropertiesException();
        }
    }

    public Properties getTestConfigProperties() {
        return testConfigProperties;
    }
    @Bean
    public ConfigLoader getConfigLoader() throws ImproperTestPropertiesException {
        return this;
    }
}
