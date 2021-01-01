package assessment.keyvaluestore;

import assessment.keyvaluestore.model.User;


import java.util.Map;

public interface userRepository {
    void save(User user);
    Map<String, User> findAll();
    User findByKey(String key);
    void delete(String key);
}
