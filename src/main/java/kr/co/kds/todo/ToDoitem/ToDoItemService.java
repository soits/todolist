package kr.co.kds.todo.ToDoitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoItemService {
    @Autowired
    private ToDoItemRepository toDoItemRepository;

    public ToDoItem get(final String id) {
        System.out.println("==================>ToDoItemService get["+ id +"] <===============");

    	return toDoItemRepository.findById(id).orElse(null);
	}

    public ToDoItem create(final ToDoItem toDoItem) {
        if(toDoItem == null) {
            throw new NullPointerException("To Do Item cannot be null.");
        }
        return toDoItemRepository.save(toDoItem);
    }

    public List<ToDoItem> getAll() {
        return toDoItemRepository.findAll();
    }
}
