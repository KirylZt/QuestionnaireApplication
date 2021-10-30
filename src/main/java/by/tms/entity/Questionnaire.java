package by.tms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {
    private long id;
    private String name;
    private String description;
    private List<Question> questions;
    private String key;
}
