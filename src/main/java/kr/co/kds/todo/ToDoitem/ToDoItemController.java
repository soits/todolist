package kr.co.kds.todo.ToDoitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoItemController {
	
    @Autowired
    private ToDoItemService toDoItemService;

    // 전체조회 
    // GET
    // http://IP:PORT/todo
    // REQ : NONE
    // RES :  [ { "data": { "id": 1, "title": "titile1", "done": false }, "errors": [] }, 
	//			{ "data": { "id": 2, "title": "titile2", "done": false }, "errors": [] } ]
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<ToDoItemResponse> getAll() {

        List<String> errors = new ArrayList<>();
        List<ToDoItem> toDoItems = toDoItemService.getAll();
        List<ToDoItemResponse> toDoItemResponses = new ArrayList<>();
        toDoItems.stream().forEach(toDoItem -> {
            toDoItemResponses.add(ToDoItemAdapter.toToDoItemResponse(toDoItem, errors));
        });
        return toDoItemResponses;
    }
    
    // 단건(id)조회
    // GET
    // http://IP:PORT/todo/id
    // REQ : NONE
    // RES : { "data": { "id": 8, "title": "b9", "done": false }, "errors": [] }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody ToDoItemResponse get(@PathVariable(value="id") Integer id) {

    	List<String> errors = new ArrayList<>();
        ToDoItem toDoItem = null;
        try {
            toDoItem = toDoItemService.get(id);
        } catch (final Exception e) {
            errors.add(e.getMessage());
        }
        return ToDoItemAdapter.toToDoItemResponse(toDoItem, errors);
    }

    // 등록
    // POST
    // http://IP:PORT/todo/
	// REQ : { "title" : "20201218 오늘의 할일" }
    // RES : { "data": { "id": 11, "title": "20201218 오늘의 할일", "done": false }, "errors": [] }
    @RequestMapping(method = RequestMethod.POST) 
    public @ResponseBody ToDoItemResponse create(@RequestBody final ToDoItemRequest toDoItemRequest) {

    	List<String> errors = new ArrayList<>();
        ToDoItem toDoItem = ToDoItemAdapter.toToDoItem(toDoItemRequest);
        
        try {
            toDoItem = toDoItemService.create(toDoItem);
        } catch (final Exception e) {
            errors.add(e.getMessage());
            e.printStackTrace();
        }
        return ToDoItemAdapter.toToDoItemResponse(toDoItem, errors);
    }
    
    // 수정
    // PUT
    // http://IP:PORT/todo/
    // REQ : { "id" : 13, "title" : "20201218-NEW오늘의 할일", "done" : true }
    // RES : { "data": { "id": 13, "title": "20201218-NEW오늘의 할일", "done": true }, "errors": [] }
    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody ToDoItemResponse update(@RequestBody final ToDoItemRequest toDoItemRequest) {
    	
    	List<String> errors = new ArrayList<>();
    	ToDoItem toDoItem = ToDoItemAdapter.toToDoItem(toDoItemRequest);
    	
	    try {
	    	toDoItem = toDoItemService.update(toDoItem);
	    } catch (final Exception e) {
		    errors.add(e.getMessage());
		    e.printStackTrace();
	    }
	    
	    return ToDoItemAdapter.toToDoItemResponse(toDoItem, errors);
    }

}
