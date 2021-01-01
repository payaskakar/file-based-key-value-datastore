package assessment.keyvaluestore;

import assessment.keyvaluestore.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserResource {
    private userRepository userRepository;
    public UserResource(userRepository userRepository){
        this.userRepository=userRepository;
    }
    @GetMapping("/add/{key}/{name}")
    public User add(@PathVariable("key") final String key, @PathVariable("name") final String name){
        userRepository.save(new User(key, name, 20000L));
        return userRepository.findByKey(key);
    }
    @GetMapping("/all")
    public Map<String, User>all(){
    return userRepository.findAll();
    }
    @GetMapping("/delete/{key}")
    public Map<String, User> delete(@PathVariable("key") final String key){
        userRepository.delete(key);
        return all();
    }
}
