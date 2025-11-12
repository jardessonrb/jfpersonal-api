package labjb.jfpersonalapi.shared.errors.handlerexception.handlers;

import jakarta.servlet.http.HttpServletRequest;
import labjb.jfpersonalapi.domain.dto.out.ExceptionDefaultDto;
import org.springframework.http.ResponseEntity;

public interface ExceptionHandlerStrategy {
    boolean isExceptionSuportada(Exception exception);
    ResponseEntity<ExceptionDefaultDto> processarException(Exception exception, HttpServletRequest httpServletRequest);
}
