package labjb.jfpersonalapi.shared.errors.handlerexception.handlers;

import jakarta.servlet.http.HttpServletRequest;
import labjb.jfpersonalapi.domain.dto.out.ExceptionDefaultDto;
import labjb.jfpersonalapi.shared.errors.exception.RegraNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class RegraNegocioHadlerException implements ExceptionHandlerStrategy {
    @Override
    public boolean isExceptionSuportada(Exception exception) {
        return exception instanceof RegraNegocioException;
    }

    @Override
    public ResponseEntity<ExceptionDefaultDto> processarException(Exception exception, HttpServletRequest httpServletRequest) {
        RegraNegocioException regraNegocioException = (RegraNegocioException) exception;

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ExceptionDefaultDto
                    .builder()
                    .erros(Arrays.asList(exception.getMessage()))
                    .path(httpServletRequest.getRequestURI())
                    .mensagem(exception.getMessage())
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build()
                );
    }
}
