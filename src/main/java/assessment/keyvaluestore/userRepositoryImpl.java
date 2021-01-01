package assessment.keyvaluestore;

import assessment.keyvaluestore.model.User;
import assessment.keyvaluestore.userRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class userRepositoryImpl implements userRepository {
    private RedisTemplate<String, User>redisTemplate;
    private HashOperations hashOperations;

    public userRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations= redisTemplate.opsForHash();
    }


    @Override
    public void save(User user) {
    hashOperations.put("USER", user.getKey(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public User findByKey(String key) {
        return (User) hashOperations.get("USER", key);
    }

    @Override
    public void delete(String key) {
    hashOperations.delete("USER", key);
    }
}
