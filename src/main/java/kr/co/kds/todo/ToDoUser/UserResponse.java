package kr.co.kds.todo.ToDoUser;

import java.util.List;

import org.springframework.http.HttpStatus;

import kr.co.kds.todo.ApiResponse.ApiResponse;
import lombok.Builder;

public class UserResponse extends ApiResponse<User> {
 
    @Builder
    public UserResponse(final User user, final List<String> errors, final HttpStatus status) {
        this.setData(user);
        this.setStatus(status);
        this.setErrors(errors);
    }
}
