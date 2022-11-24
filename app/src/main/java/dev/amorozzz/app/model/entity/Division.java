package dev.amorozzz.app.model.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @ManyToOne
    private Division parent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private List<Division> children;
    @NotNull
    private LocalDateTime dtFrom;
    private LocalDateTime dtTill;
    private int sortPriority;
    private Boolean isSystem;
    @NotNull
    private LocalDateTime creationDate;
    private LocalDateTime correctionDate;
}
