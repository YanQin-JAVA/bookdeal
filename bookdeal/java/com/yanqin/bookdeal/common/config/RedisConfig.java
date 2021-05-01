//package com.yanqin.bookdeal.common.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericToStringSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @author Administrator
// * @create 2020-11-30
// **/
//@Configuration
//public class RedisConfig {
//
//	/**
//	 * RedisTemplate配置
//	 */
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
//
//		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//
//		RedisTemplate<String, Object> template = new RedisTemplate<>();
//		template.setConnectionFactory(redisConnectionFactory);
//		template.setKeySerializer(stringRedisSerializer);
//		template.setValueSerializer(new GenericToStringSerializer(Object.class));
//		template.setHashKeySerializer(stringRedisSerializer);
//		template.setHashValueSerializer(new GenericToStringSerializer(Object.class));
//
//		return template;
//	}
//}
