package kr.co.kds.todo.ToDoitem;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ToDoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;
    private boolean done;
}