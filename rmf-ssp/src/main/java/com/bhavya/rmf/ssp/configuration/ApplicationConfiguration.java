package com.bhavya.rmf.ssp.configuration;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class ApplicationConfiguration {

  @Value("${jasypt.encryptor.password}")
  private String jasyptEncryptorPassword;

  /**
   * Conf.
   */
  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    PropertySourcesPlaceholderConfigurer
        propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
    propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
    return propertySourcesPlaceholderConfigurer;
  }

  /**
   * String Encryption.
   *
   * @return StringEncryptor
   */
  @Bean(name = "jasyptStringEncryptor")
  public StringEncryptor stringEncryptor() {
    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
    EnvironmentPBEConfig config = new EnvironmentPBEConfig();
    encryptor.setConfig(config);
    config.setAlgorithm("PBEWithMD5AndDES");
    config.setKeyObtentionIterations("1000");
    config.setPoolSize("1");
    config.setProviderName("SunJCE");
    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
    return encryptor;
  }


}
