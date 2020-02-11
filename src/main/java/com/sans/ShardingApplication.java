package com.sans;

import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sans.dao.*")
public class ShardingApplication {

    private static SnowflakeShardingKeyGenerator snowflakeShardingKeyGenerator;

    static {
        snowflakeShardingKeyGenerator = new SnowflakeShardingKeyGenerator();
    }

    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class, args);
    }

    /**
     * 用于自定义主键的生成。可以获取主键，sharding-jdbc的雪花生成主键就是这么获取的
     * @return
     */
    public static long snowflakeShardingKeyGenerator() {
        return (Long) snowflakeShardingKeyGenerator.generateKey();
    }
}
