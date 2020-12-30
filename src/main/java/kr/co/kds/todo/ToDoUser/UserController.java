package kr.co.kds.todo.ToDoUser;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/auth")
public class UserController {

    private @Autowired UserService userService;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public @ResponseBody UserResponse login( @RequestParam(value="name") String name
                                            , @RequestParam(value="pwd") String pwd
                                            , @RequestParam(value="deptNo") String deptNo) {

        List<String> errors = new ArrayList<>();
        User user = new User();
        try {
            user.setName(name);
            user.setPassword(pwd);
            user.setDeptNo(deptNo);
            user = userService.login(user);

        } catch (final Exception e) {
            errors.add(e.getMessage());
        }
        return UserAdapter.userResponse(user, errors, HttpStatus.OK);
    }

    @RequestMapping(value="/join", method = RequestMethod.POST) 
    public @ResponseBody UserResponse join(@RequestBody final UserRequest userReq) {

        System.out.println(">>>>>" + userReq);        
    	List<String> errors = new ArrayList<>();
        User user = UserAdapter.user(userReq);
        try {
            user = userService.join(user);
        } catch (final Exception e) {
            errors.add(e.getMessage());
            e.printStackTrace();
        }
        return UserAdapter.userResponse(user, errors, HttpStatus.CREATED);        
    }
    



    
    
    
}
