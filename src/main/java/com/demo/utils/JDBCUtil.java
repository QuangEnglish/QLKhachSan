package com.demo.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCUtil {

  private static final Logger log = LoggerFactory.getLogger(JDBCUtil.class);
  private static volatile HikariDataSource dataSource;

  public static HikariDataSource getDataSource() {
    if (dataSource == null) {
      synchronized (JDBCUtil.class) {
        if (dataSource == null) {
          HikariConfig config = new HikariConfig();
          config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
          config.setUsername("root");
          config.setPassword("123456");

          config.setMinimumIdle(10); // Số lượng kết nối min trong pool
          config.setMaximumPoolSize(50); // Số lượng kết nối tối đa trong pool
          config.setConnectionTimeout(30000); // Thời gian chờ tối đa khi lấy kết nối từ pool
          config.setDriverClassName("com.mysql.cj.jdbc.Driver");
          config.addDataSourceProperty("cachePrepStmts", "true");
          config.addDataSourceProperty("prepStmtCacheSize", "250");
          config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
          dataSource = new HikariDataSource(config);
        }
      }
    }
    return dataSource;
  }

  public static Connection getConnection() throws SQLException {
    return getDataSource().getConnection();
  }

  public static void close(Connection conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        log.error(e.getMessage(), e);
      }
    }
  }

  public static void close(Statement conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        log.error(e.getMessage(), e);
      }
    }
  }

  public static void close(ResultSet conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        log.error(e.getMessage(), e);
      }
    }
  }
}
