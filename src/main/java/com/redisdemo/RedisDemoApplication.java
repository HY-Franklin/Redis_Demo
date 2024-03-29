package com.redisdemo;

import com.redisdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisDemoApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, User> redisTemplate(){

		RedisTemplate<String,User> redisTemplate=new RedisTemplate<>();
		redisTemplate.setConnectionFactory(new JedisConnectionFactory());
		return redisTemplate;
	}

	public static void main(String[] args) {

		SpringApplication.run(RedisDemoApplication.class, args);
	}

}
