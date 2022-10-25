package starter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pet {

    public Integer petId;
    public String petName;
    }