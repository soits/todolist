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

    /*
	CREATE TABLE `USER` (
		`id` INT(11) NOT NULL AUTO_INCREMENT,
		`user_no` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
        `dept_no` VARCHAR(3) NOT NULL COLLATE 'utf8_general_ci',
        `name` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
        `password` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
		PRIMARY KEY (`id`) USING BTREE
	)
    */
    
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
