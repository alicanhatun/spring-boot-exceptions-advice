package com.alican.exceptions.advice;

import com.alican.exceptions.dto.Delivery;
import com.alican.exceptions.exception.DeliveryNotFoundException;
import com.alican.exceptions.exception.DeliverySaveException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.Serializable;

@RestControllerAdvice
public class ResponseBodyAdviceImpl implements ResponseBodyAdvice<Serializable> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        Class<?> returnClass = methodParameter.getParameterType();
        return Serializable.class.isAssignableFrom(returnClass);
    }

    @Override
    public Serializable beforeBodyWrite(Serializable returnObject, MethodParameter methodParameter, MediaType mediaType,
                                        Class<? extends HttpMessageConverter<?>> aClass,
                                        ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Delivery result;
        if (returnObject instanceof Delivery) {
            result = (Delivery) returnObject;
            result.setStatus("Delivery saved");
            return result;
        }
        return returnObject;
    }

    @ExceptionHandler({DeliveryNotFoundException.class})
    public String deliveryNotFound() {
        return "Delivery not found";
    }

    @ExceptionHandler({DeliverySaveException.class})
    public String saveException() {
        return "Delivery can not save";
    }
}
