package starter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    public String userId;
    public String userFirstName;    
    public String userLastName;
    public String userBirthDayName;
    }