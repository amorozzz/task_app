package dev.amorozzz.app.service;

import dev.amorozzz.app.model.dto.DivisionDto;
import dev.amorozzz.app.model.entity.Division;

import java.time.LocalDate;
import java.util.List;

public interface DivisionService {
    List<Division> searchByDate(LocalDate localDate);
    DivisionDto add(DivisionDto divisionDto);
    DivisionDto update(DivisionDto divisionDto);
    void delete(Long id);
}
