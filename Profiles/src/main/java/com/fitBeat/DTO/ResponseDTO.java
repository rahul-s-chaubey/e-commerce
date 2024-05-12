package com.fitBeat.DTO;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
@Data
public class ResponseDTO  implements Serializable {
    private Integer status;
    private String message;
    private String data;

   // private HttpStatus httpStatus;


}
