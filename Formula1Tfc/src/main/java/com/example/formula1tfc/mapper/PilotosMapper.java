package com.example.formula1tfc.mapper;

import com.example.formula1tfc.dto.PilotosDTO;
import com.example.formula1tfc.models.Pilotos;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PilotosMapper {
    private final ModelMapper mapper;

    public PilotosDTO toDTO(Pilotos pilotos) {
        return mapper.map(pilotos, PilotosDTO.class);
    }

    public Pilotos toModel(PilotosDTO dto) {
        return mapper.map(dto, Pilotos.class);
    }

    public List<PilotosDTO> toDTOList(List<Pilotos> pilotos) {
        return pilotos.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Pilotos> toModelList(List<PilotosDTO> pilotosDTO) {
        return pilotosDTO.stream().map(this::toModel).collect(Collectors.toList());
    }
}
