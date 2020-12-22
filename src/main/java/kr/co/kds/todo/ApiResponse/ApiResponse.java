package kr.co.kds.todo.ApiResponse;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public abstract class ApiResponse<T> {
    private T data;
    private HttpStatus status;
    private List<String> errors; 
}
