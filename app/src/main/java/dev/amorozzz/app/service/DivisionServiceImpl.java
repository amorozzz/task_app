package dev.amorozzz.app.service;

import dev.amorozzz.app.model.dto.DivisionDto;
import dev.amorozzz.app.model.entity.Division;
import dev.amorozzz.app.repository.DivisionRepository;
import dev.amorozzz.app.utils.mapper.DivisionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DivisionServiceImpl implements DivisionService {
    private final DivisionRepository divisionRepository;
    private final DivisionMapper divisionMapper;

    @Override
    public List<Division> searchByDate(LocalDate localDate) {
        return divisionRepository
                .findAll()
                .stream()
                .filter(d ->
                        d.getCreationDate().toLocalDate().equals(localDate)
                                || d.getDtFrom().toLocalDate().equals(localDate)
                                || d.getDtTill().toLocalDate().equals(localDate)
                                || d.getCorrectionDate().toLocalDate().equals(localDate))
                .collect(Collectors.toList());
    }

    @Override
    public DivisionDto add(DivisionDto divisionDto) {
        Division division = divisionMapper.toModel(divisionDto);

        if (divisionDto.getParentId() != null) {
            division.setParent(divisionRepository.getReferenceById(divisionDto.getParentId()));
            division.setIsSystem(false);
        } else {
            division.setParent(null);
            division.setIsSystem(true);
        }
        divisionRepository.save(division);
        divisionDto.setId(division.getId());
        return divisionDto;
    }

    @Override
    public DivisionDto update(DivisionDto divisionDto) {
        Division oldDivision = divisionRepository.getReferenceById(divisionDto.getId());
        oldDivision.setDtTill(LocalDateTime.now());
        oldDivision.setChildren(Collections.emptyList());
        divisionRepository.save(oldDivision);

        divisionDto.setCorrectionDate(LocalDateTime.now());
        divisionDto.setId(null);
        divisionDto.setId(add(divisionDto).getId());
        return add(divisionDto);
    }

    @Override
    public void delete(Long id) {
        Division division = divisionRepository.getReferenceById(id);
        if (division.getChildren().size() == 0) {
            divisionRepository.delete(division);
        }
    }
}