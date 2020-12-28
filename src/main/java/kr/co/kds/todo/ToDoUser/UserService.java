package kr.co.kds.todo.ToDoUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private @Autowired UserRepository userRepo;

    public User join(final User user) {        
    	if(user == null) {
    		throw new NullPointerException("User info cannot be null.");
    	}    	
    	return userRepo.save(user);
    }

    public User login(final User user){
        if(user == null) {
    		throw new NullPointerException("User info cannot be null.");
    	}
        return userRepo.findUser(user.getName(), user.getPassword(), user.getDeaprtment());
    }
}
