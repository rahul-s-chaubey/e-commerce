package com.fitBeat.CommonServices;

import com.fitBeat.DTO.RegistrationRequestDTO;
import com.fitBeat.DTO.RegistrationResponseDTO;
import com.fitBeat.Database.ProfileEntity;

import java.util.Date;

public interface CommonService
{
    public ProfileEntity DtoToEntity(RegistrationRequestDTO dto);

    public RegistrationResponseDTO EntityToDTO(ProfileEntity entity);

    public Long getTimestamp(Date date);

}
