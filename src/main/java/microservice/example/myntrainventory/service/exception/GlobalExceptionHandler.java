package microservice.example.myntrainventory.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyntraException.class)
    public ResponseEntity myntraExceptionHandler(MyntraException exp, WebRequest request) {
        CommonExceptionResponseVo response = new CommonExceptionResponseVo();
        response.setTimestamp(System.currentTimeMillis());
        response.setErrorCode(exp.getErrorCode());
        response.setMessage(exp.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
