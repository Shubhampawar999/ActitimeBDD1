package pojo;

public class Customer{
    private String name;

    private String description;

    private String archived;

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

  public void setArchive(String archived){
        this.archived=archived;
  }
  public String getArchived(){
        return archived;
  }

}
