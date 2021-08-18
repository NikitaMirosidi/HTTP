package Petstore.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Animal {

    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;
}