package com.example.formula1tfc.mapper;

import com.example.formula1tfc.dto.CircuitoDTO;
import com.example.formula1tfc.dto.PilotosDTO;
import com.example.formula1tfc.models.Circuito;
import com.example.formula1tfc.models.Pilotos;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CircuitoMapper {
    private final ModelMapper mapper;

    public CircuitoDTO toDTO(Circuito circuito) {
        return mapper.map(circuito, CircuitoDTO.class);
    }

    public Circuito toModel(CircuitoDTO dto) {
        return mapper.map(dto, Circuito.class);
    }

    public List<CircuitoDTO> toDTOList(List<Circuito> circuitos) {
        return circuitos.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Circuito> toModelList(List<CircuitoDTO> circuitoDTO) {
        return circuitoDTO.stream().map(this::toModel).collect(Collectors.toList());
    }
}
