package starter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pet {

    public String petId;
    public String petName;
    }