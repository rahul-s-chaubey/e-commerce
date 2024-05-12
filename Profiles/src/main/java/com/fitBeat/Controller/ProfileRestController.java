package com.fitBeat.Controller;

import com.fitBeat.Commons.ProfileMSConstants;
import com.fitBeat.Commons.StatusConstants;
import com.fitBeat.DTO.RegistrationRequestDTO;
import com.fitBeat.DTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/core/profiles/"+ ProfileMSConstants.profileMSVersion,
                produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProfileRestController
{

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody RegistrationRequestDTO requestDTO)
    {
        ResponseDTO responseDTO = new ResponseDTO();


            responseDTO.setStatus(StatusConstants.PM_USER_CREATED_CODE);
            responseDTO.setMessage(StatusConstants.PM_USER_CREATED_MSG);


        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return ResponseEntity
                    .status(status)
                    .body(responseDTO);

    }

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getAllUsers()
    {
        ResponseDTO responseDTO = new ResponseDTO();


        responseDTO.setStatus(StatusConstants.PM_USER_CREATED_CODE);
        responseDTO.setMessage(StatusConstants.PM_USER_CREATED_MSG);


        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(status)
                .body(responseDTO);

    }

    @GetMapping("/users/{user-id}")
    public ResponseEntity<ResponseDTO> getUserById
            (@PathVariable(name = "user-id", required = true)Integer userId)
    {
        ResponseDTO responseDTO = new ResponseDTO();


        responseDTO.setStatus(StatusConstants.PM_USER_CREATED_CODE);
        responseDTO.setMessage(StatusConstants.PM_USER_CREATED_MSG);


        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(status)
                .body(responseDTO);

    }

}
