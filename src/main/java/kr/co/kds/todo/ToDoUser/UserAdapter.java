package kr.co.kds.todo.ToDoUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

public class UserAdapter {

    public static User user(final UserRequest userReq){
        if(userReq == null) return null;

        return User.builder()
                .user_no(userReq.getUser_no())
                .name(userReq.getName())
                .password(userReq.getPassword())
                .dept_no(userReq.getDept_no())
                .build(); 
    }

    public static UserResponse userResponse(final User user, final List<String> errors, final HttpStatus status ){
        return UserResponse.builder().user(user).status(status).errors(Optional.ofNullable(errors).orElse(new ArrayList<>())).build();
    }
    
}
