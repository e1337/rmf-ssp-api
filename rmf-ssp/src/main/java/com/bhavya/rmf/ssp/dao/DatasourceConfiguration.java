package com.bhavya.rmf.ssp.dao;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DatasourceConfiguration {

  /**
   * Create the h2 datasource.
   *
   * @return DataSource
   */
  @Bean
  @Primary
  public DataSource dataSource() {
    return (new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .setName("rmf-sspi;MV_STORE=FALSE;MVCC=FALSE")
        .addScript("classpath:db/ReCreate.sql")
        .addScript("classpath:db/LoadData.sql")
    ).build();
  }

  /**
   * Start WebServer, access http://localhost:8082 .
   */

  @Bean(initMethod = "start", destroyMethod = "stop")
  public Server startDbManager() throws SQLException {
    return Server.createWebServer();
  }

  //@Bean
  //public DataSource h2DataSource() {
  //    DriverManagerDataSource dataSource = new DriverManagerDataSource();
  //    dataSource.setDriverClassName(driver);
  //    dataSource.setUrl(url);
  //    dataSource.setUsername(username);
  //    dataSource.setPassword(password);
  //    return dataSource;
  //}
  //
  //driver: org.h2.Driver
  //url: jdbc:h2:file:${java.io.tmpdir}/database/db_name;AUTO_SERVER=TRUE
  //username: user
  //password: pass
}
