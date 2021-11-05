package com.atguigu.springcloud.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class RedisHelper {

	@SuppressWarnings("rawtypes")
	@Resource
	private RedisTemplate redisTemplate;

	/**
	 * 删除缓存<br>
	 *
	 * @param key
	 */
	@SuppressWarnings("unchecked")
	public void del(String... key) {
		if (key != null && key.length > 0) {
			if (key.length == 1) {
				redisTemplate.delete(key[0]);
			} else {
				redisTemplate.delete(CollectionUtils.arrayToList(key));
			}
		}
	}

	public void delFuzzy (List<String> keys) {
		for(String key : keys){
			Set keysTemp = redisTemplate.keys("*" + key + "*");
			redisTemplate.delete(keysTemp);
		}
	}

	/**
	 * 获取缓存<br>
	 *
	 * @param key
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String key, Class<T> clazz) {
		return (T) redisTemplate.opsForValue().get(key);
	}



	/**
	 * 将value对象写入缓存
	 *
	 * @param key
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public void set(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 将value对象写入缓存
	 *
	 * @param key
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public void set(String key, Object value,long time) {
		redisTemplate.opsForValue().set(key, value,time,TimeUnit.SECONDS);
	}


	/**
	 * 指定缓存的失效时间
	 *
	 * @param key
	 *            缓存KEY
	 * @param time
	 *            失效时间(秒)
	 */
	@SuppressWarnings("unchecked")
	public void expire(String key, long time) {
		if (time > 0) {
			redisTemplate.expire(key, time, TimeUnit.SECONDS);
		}
	}

	@SuppressWarnings("unchecked")
	public boolean hasKey(String key){
		return redisTemplate.hasKey(key);
	}

	/**
	 * 递 增、减
	 * @param key  key
	 * @param time 时间 0
	 * @param gradation  类型
	 * @param <T>
	 * @return
	 */
	public <T>  Long gradationSet(String key, Long time, Gradation gradation){
		Long data = (Long) redisTemplate.execute((RedisCallback<Long>) connection -> {
			Long res;
			if (Gradation.INCR == gradation) {
				res = connection.incrBy(key.getBytes(), 1L);
			} else {
				res = connection.decrBy(key.getBytes(), 1L);
			}
			if (time >= 0) {
				connection.expire(key.getBytes(), time);
			}
			return res;
		});
		return data;
	}

	public <T> Long gradationGet(String key, Class<T> clazz){
		return (Long) redisTemplate.execute((RedisCallback<Long>) connection -> {
			byte[] bytes = connection.get(key.getBytes());
			String s = new String(bytes);
			return Long.valueOf(s);
		});
	}


	@SuppressWarnings("unchecked")
	public long getExpire(String key){
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void opsForHashPutAll(String key,Map map){
		redisTemplate.opsForHash().putAll(key, map);
	}



	@SuppressWarnings("unchecked")
	public void opsForHashPut(String key,String hashKey,Object value){
		redisTemplate.opsForHash().put(key, hashKey, value);
	}

	@SuppressWarnings({ "unchecked" })
	public Object opsForHashGet(String key,String hashKey){
		if(redisTemplate.opsForHash().hasKey(key, hashKey)){
			return redisTemplate.opsForHash().get(key, hashKey);
		}else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public <T,H> Map<T,H> opsForHashGetAll(String key){
		return redisTemplate.opsForHash().entries(key);
	}

	public void opsForListLpush(String key,String value){
		redisTemplate.opsForList().leftPush(key, value);
	}

	public Object rightPopAndLeftPush(String key1,String key2){
		Object o = redisTemplate.opsForList().rightPopAndLeftPush(key1, key2,10, TimeUnit.SECONDS);
		return o;
	}
	public Object rightPop(String key){
		Object o = redisTemplate.opsForList().rightPop(key, 10, TimeUnit.SECONDS);
		return o;
	}

	public void opsForListRemove(String key,String value){
		redisTemplate.opsForList().remove(key, 0, value);
	}



	public Long opsForListSize(String key){
		Long size = redisTemplate.opsForList().size(key);
		return size;
	}
}
