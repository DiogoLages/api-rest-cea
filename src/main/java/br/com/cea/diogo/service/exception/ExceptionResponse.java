package br.com.cea.diogo.service.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 3756909302459161078L;
	
	private Integer status;
	private String message;
	private LocalDateTime dateTime;
	
}
