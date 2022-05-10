package com.example.formula1tfc.mapper;

import com.example.formula1tfc.dto.ClasificacionDTO;
import com.example.formula1tfc.dto.PilotosDTO;
import com.example.formula1tfc.models.Clasificacion;
import com.example.formula1tfc.models.Pilotos;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClasificacionMapper {
    private final ModelMapper mapper;

    public ClasificacionDTO toDTO(Clasificacion clasificacion) {
        return mapper.map(clasificacion, ClasificacionDTO.class);
    }

    public Clasificacion toModel(ClasificacionDTO dto) {
        return mapper.map(dto, Clasificacion.class);
    }

    public List<ClasificacionDTO> toDTOList(List<Clasificacion> clasificacions) {
        return clasificacions.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Clasificacion> toModelList(List<ClasificacionDTO> clasificacionDTOS) {
        return clasificacionDTOS.stream().map(this::toModel).collect(Collectors.toList());
    }
}
