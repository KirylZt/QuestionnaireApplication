package by.tms.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {
    @Id
    private long id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    private String text;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Variable> variables;
    @OneToOne
    private Variable answer;
    private int price;
}
