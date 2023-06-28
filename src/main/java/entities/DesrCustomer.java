package entities;


import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DesrCustomer {

    private int id;
    private String name;
    private boolean archived;
    private long created;
    private Map<String,Object> allowedActions;
    private String description;

}
