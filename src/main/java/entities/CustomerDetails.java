package entities;

import lombok.*;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDetails {


    private String name;
    private String description;
    private boolean archived;



}
