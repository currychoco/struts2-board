package com.currychoco.board.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.sql.Connection;
import java.sql.Statement;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            initializeDatabase();
        } catch (Exception e) {
            throw new RuntimeException("Error initializing MyBatis", e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    private static void initializeDatabase() {
        try (SqlSession session = sqlSessionFactory.openSession();
             Connection conn = session.getConnection();
             Statement stmt = conn.createStatement()) {

            // 테이블 생성
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL);");

            // 초기 데이터 삽입 (이미 존재하는 경우 삽입하지 않음)
            stmt.execute("MERGE INTO users KEY(id) VALUES (1, 'Alice'), (2, 'Bob'), (3, 'Charlie');");

            System.out.println("H2 Database Initialized!");

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }
}
