package kr.co.kds.todo.ToDoUser;

import org.springframework.web.bind.annotation.RestController;

import kr.co.kds.todo.ToDoitem.ToDoItemAdapter;
import kr.co.kds.todo.ToDoitem.ToDoItemRequest;
import kr.co.kds.todo.ToDoitem.ToDoItemResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth")
public class UserController {

    private @Autowired UserService userService;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public @ResponseBody UserResponse login(@RequestBody final UserRequest userReq) {

        List<String> errors = new ArrayList<>();
        User user = null;
        try {
            user = userService.login(user);
        } catch (final Exception e) {
            errors.add(e.getMessage());
        }
        return UserAdapter.userResponse(user, errors, HttpStatus.OK);
    }

    @RequestMapping(value="/join", method = RequestMethod.POST) 
    public @ResponseBody UserResponse join(@RequestBody final UserRequest userReq) {

    	List<String> errors = new ArrayList<>();
        User user = UserAdapter.user(userReq);
        try {
            user = userService.join(userReq);
        } catch (final Exception e) {
            errors.add(e.getMessage());
            e.printStackTrace();
        }
        return UserAdapter.userResponse(user, errors, HttpStatus.CREATED);
    }
    



    
    
    
}
