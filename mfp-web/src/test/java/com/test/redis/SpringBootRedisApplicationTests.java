package com.test.redis;


import com.wyc.web.WebMainApp;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = WebMainApp.class)
@RunWith(SpringRunner.class)
public class SpringBootRedisApplicationTests {
    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void redisConnectionTest() throws InterruptedException {
        redisTemplate.getConnectionFactory().getConnection().getClientList().forEach(e ->
                System.out.println(e.getAddressPort())
        );
    }

    @Test
    public void zookeeperTest() {
        String connectionInfo = "192.168.1.109:2181,192.168.1.109:2182,192.168.1.109:2183";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client =
                CuratorFrameworkFactory.builder()
                        .connectString(connectionInfo)
                        .sessionTimeoutMs(5000)
                        .connectionTimeoutMs(5000)
                        .retryPolicy(retryPolicy)
                        .build();
        System.out.println(client);

    }


}
