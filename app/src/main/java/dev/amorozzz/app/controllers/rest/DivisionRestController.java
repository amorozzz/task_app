package dev.amorozzz.app.controllers.rest;

import dev.amorozzz.app.model.dto.DivisionDto;
import dev.amorozzz.app.repository.DivisionRepository;
import dev.amorozzz.app.service.DivisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/division")
@RequiredArgsConstructor
public class DivisionRestController {
    private final DivisionService divisionService;
    private final DivisionRepository divisionRepository;

    @GetMapping("/searchByDate")
    public ResponseEntity<?> searchByDate(@RequestParam("date") String date) {
        return ResponseEntity.ok().body(divisionService.searchByDate(LocalDate.parse(date)));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody DivisionDto divisionDto) {
        return ResponseEntity.ok().body(divisionService.add(divisionDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DivisionDto divisionDto) {
        return ResponseEntity.ok().body(divisionService.update(divisionDto));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        divisionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
