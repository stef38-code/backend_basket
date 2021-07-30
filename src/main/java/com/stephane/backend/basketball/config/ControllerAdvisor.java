package com.stephane.backend.basketball.config;

import com.stephane.backend.basketball.exception.AdresseNotFoundException;
import com.stephane.backend.basketball.exception.IPersonnalNotFoundException;
import com.stephane.backend.basketball.exception.PersonneNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
  @ExceptionHandler(PersonneNotFoundException.class)
  public ResponseEntity<Object> handlePersonneNotFoundException(
      PersonneNotFoundException ex, WebRequest request) {
    Map<String, Object> body = getBody("La personne spécifiée est introuvable", ex, request);
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(AdresseNotFoundException.class)
  public ResponseEntity<Object> handleAdresseNotFoundException(
      AdresseNotFoundException ex, WebRequest request) {
    Map<String, Object> body = getBody("L'adresse spécifiée est introuvable", ex, request);
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }
  /**
   * Getter du body de la reponse
   *
   * @param message le message
   * @param ex l'erreur
   * @param request WebRequest
   * @return Map<String, Object>
   */
  private Map<String, Object> getBody(
      String message, IPersonnalNotFoundException ex, WebRequest request) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message", message);
    log.error("message erreur:{}", ex.getMessage());
    log.error("Type:{}", ex.getCode().toString());
    log.error("url:{}", getPath((ServletWebRequest) request));
    return body;
  }

  private String getPath(ServletWebRequest request) {
    HttpServletRequest httpServletRequest = request.getRequest();
    return new UrlPathHelper().getPathWithinApplication(httpServletRequest);
  }
}
