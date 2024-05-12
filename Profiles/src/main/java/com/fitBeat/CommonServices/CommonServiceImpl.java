package com.fitBeat.CommonServices;

import com.fitBeat.DTO.RegistrationRequestDTO;
import com.fitBeat.DTO.RegistrationResponseDTO;
import com.fitBeat.Database.ProfileEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class CommonServiceImpl implements CommonService
{


    @Override
    public ProfileEntity DtoToEntity(RegistrationRequestDTO dto) {
        return null;
    }

    @Override
    public RegistrationResponseDTO EntityToDTO(ProfileEntity entity) {
        return null;
    }

    @Override
    public Long getTimestamp(Date date) {
        return null;
    }
}
