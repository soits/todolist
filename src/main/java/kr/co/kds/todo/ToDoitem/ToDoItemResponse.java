package kr.co.kds.todo.ToDoitem;

import lombok.Builder;
import java.util.List;

import kr.co.kds.todo.ApiResponse.ApiResponse;

public class ToDoItemResponse extends ApiResponse<ToDoItem> {

    @Builder
    public ToDoItemResponse(final ToDoItem toDoItem, final List<String> errors) {
        this.setData(toDoItem);
        this.setErrors(errors);
    }
}