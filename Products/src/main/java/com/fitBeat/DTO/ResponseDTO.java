package com.fitBeat.DTO;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
@Data
public class ResponseDTO  implements Serializable {
    private Integer status;
    private String message;
    private String data;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

   // private HttpStatus httpStatus;


}
