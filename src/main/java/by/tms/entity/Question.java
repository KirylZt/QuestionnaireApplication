package by.tms.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private long id;
    private String name;
    private String description;
    private String answer;
    private int price;
}
