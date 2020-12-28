package kr.co.kds.todo.ToDoUser;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_no;
    private String dept_no;    
    private String name;    
    private String password;    
	

}
