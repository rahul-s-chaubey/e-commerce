package com.fitBeat.DTO;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDTO
{
    private Long createTs;

    private Long updateTs;

    private String createdBy;

    private String updatedBy;
}
