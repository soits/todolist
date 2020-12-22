package kr.co.kds.todo.ToDoitem;

import java.util.List;

import org.springframework.http.HttpStatus;

import kr.co.kds.todo.ApiResponse.ApiResponse;
import lombok.Builder;

public class ToDoItemResponse extends ApiResponse<ToDoItem> {

    @Builder
    public ToDoItemResponse(final ToDoItem toDoItem, final List<String> errors, final HttpStatus status) {
        this.setData(toDoItem);
        this.setStatus(status);
        this.setErrors(errors);
    }
}