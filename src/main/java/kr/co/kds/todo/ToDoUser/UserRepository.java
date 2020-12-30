package kr.co.kds.todo.ToDoUser;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByNameAndPasswordAndDeptNo(String name, String password, String deptNo);
}
