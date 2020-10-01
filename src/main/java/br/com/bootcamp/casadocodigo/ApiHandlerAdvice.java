package br.com.bootcamp.casadocodigo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class ApiHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    //1
    public ResponseEntity<ErrorMessage> handle(MethodArgumentNotValidException methodArgumentNotValidException){
        Collection<String> mensagens = new ArrayList<>();
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            String message = String.format("%s", fieldError.getDefaultMessage());
            if (!mensagens.contains(message))
                mensagens.add(message);
        });

        ErrorMessage errorMessage = new ErrorMessage(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorMessage> handleResponseStatusException(ResponseStatusException responseStatusException) {
        Collection<String> mensagens = new ArrayList<>();
        mensagens.add(responseStatusException.getReason());

        ErrorMessage errorMessage = new ErrorMessage(mensagens);
        return ResponseEntity.status(responseStatusException.getStatus()).body(errorMessage);
    }
}
