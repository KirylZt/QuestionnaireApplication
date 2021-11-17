package by.tms.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "variables")
public class Variable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private char key;
    @NotNull
    @NotEmpty
    @NotBlank
    private String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return key == variable.key && text.equals(variable.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, text);
    }

    @Override
    public String toString() {
        return "Variable{" +
                "key=" + key +
                ", text='" + text + '\'' +
                '}';
    }
}
