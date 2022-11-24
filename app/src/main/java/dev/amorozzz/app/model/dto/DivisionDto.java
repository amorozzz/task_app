package dev.amorozzz.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DivisionDto {
    private Long id;
    private String name;
    private Long parentId;
    private List<DivisionDto> children;
    private LocalDateTime dtFrom;
    private LocalDateTime dtTill;
    private int sortPriority;
    private Boolean isSystem;
    private LocalDateTime creationDate;
    private LocalDateTime correctionDate;
}
