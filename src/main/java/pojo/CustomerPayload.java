package pojo;

import java.util.Map;

public class CustomerPayload {
    private String name;


    private String description;

    private boolean archived;

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }

    public void setArchive(boolean archived){
        this.archived=archived;
    }
    public boolean getArchived(){
        return archived;
    }


}
