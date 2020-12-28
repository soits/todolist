package kr.co.kds.todo.ToDoUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query("select name from User where name =: name and password =: password and deaprt =: depart")
    User findUser(String name, String password, String depart);

}
