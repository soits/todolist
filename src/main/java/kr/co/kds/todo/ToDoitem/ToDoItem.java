package kr.co.kds.todo.ToDoitem;

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
public class ToDoItem { 
	
	/*
	CREATE TABLE `to_do_item` (
		`id` INT(11) NOT NULL AUTO_INCREMENT,
		`title` VARCHAR(255) NOT NULL COLLATE 'utf8_general_ci',
		`done` TINYINT(4) NOT NULL DEFAULT '0',
		PRIMARY KEY (`id`) USING BTREE
	)
	*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
	private String title;
    
	private boolean done;
}