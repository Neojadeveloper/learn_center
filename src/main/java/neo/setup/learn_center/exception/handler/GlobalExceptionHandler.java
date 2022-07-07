package neo.setup.learn_center.exception.handler;

import neo.setup.learn_center.exception.exception.BadRequestException;
import neo.setup.learn_center.exception.exception.ForbiddenException;
import neo.setup.learn_center.exception.exception.InvalidValidationException;
import neo.setup.learn_center.exception.exception.NotFoundException;
import neo.setup.learn_center.response.ApplicationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidValidationException.class)
    public ResponseEntity<ApplicationError> InvalidExceptionHandler(InvalidValidationException exception, WebRequest webRequest) {
        ApplicationError applicationError = new ApplicationError();
        applicationError.setCode("InvalidException");
        applicationError.setMessage(exception.getMessage());
        applicationError.setStatus(400);
        applicationError.setTime(LocalDateTime.now());
        return new ResponseEntity<>(applicationError, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApplicationError> BadRequestException(InvalidValidationException exception, WebRequest webRequest) {
        ApplicationError applicationError = new ApplicationError();
        applicationError.setCode("BadRequestException");
        applicationError.setMessage(exception.getMessage());
        applicationError.setStatus(400);
        applicationError.setTime(LocalDateTime.now());
        return new ResponseEntity<>(applicationError, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ApplicationError> ForbiddenException(InvalidValidationException exception, WebRequest webRequest) {
        ApplicationError applicationError = new ApplicationError();
        applicationError.setCode("ForbiddenException");
        applicationError.setMessage(exception.getMessage());
        applicationError.setStatus(403);
        applicationError.setTime(LocalDateTime.now());
        return new ResponseEntity<>(applicationError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApplicationError> NotFoundExceptionHandler(NotFoundException exception, WebRequest request) {
        ApplicationError applicationError = new ApplicationError();
        applicationError.setCode("NotFoundException");
        applicationError.setMessage(exception.getMessage());
        applicationError.setStatus(404);
        applicationError.setTime(LocalDateTime.now());
        return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
    }
}
