package br.com.pucminas.apilojista.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Component
public class CustomAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        Throwable throwable = getError(webRequest);

        if(throwable instanceof ResponseStatusException){
            ResponseStatusException ex = (ResponseStatusException) throwable;
            errorAttributes.put("message", ex.getMessage());
            errorAttributes.put("developerMessage", "Mensagem para o dev");
        }

        return errorAttributes;
    }
}
