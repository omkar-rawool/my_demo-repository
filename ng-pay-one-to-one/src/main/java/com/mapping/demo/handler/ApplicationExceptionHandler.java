//package com.mappingdemo.mapping.handler;
//
//
//import com.mappingdemo.mapping.exception.PersonNotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//public class ApplicationExceptionHandler {
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler
//   public Map<String,String> invalidExceptionHandler(MethodArgumentNotValidException ex)
//   {
//
//       Map<String,String> errorMap = new HashMap<>();
//       ex.getBindingResult().getFieldErrors().forEach(error->
//       {
//           errorMap.put(error.getField(), error.getDefaultMessage());
//       }
//       );
//
//       return errorMap;
//   }
//
//
///*
//    @ExceptionHandler(PersonNotFoundException.class)
//    public Map<String,String> invalidExceptionHandler(MethodArgumentNotValidException ex)
//    {
//
//        Map<String,String> errorMap = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error->
//                {
//                    errorMap.put(error.getField(), error.getDefaultMessage());
//                }
//        );
//
//        return errorMap;
//    }
//
//
// */
//
//}
