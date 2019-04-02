package entity;

public class Posts {

	public int id;
    void setId(int id)
    {
        this.id = id;
    }
    
    public int userId;
    void setUserId(int userId)
    {
        this.userId = userId;
    }
    
    public String title;
    void setTitle(String title)
    {
        this.title = title;
    }
    
    public String body;    
    void setBody(String body)
    {
        this.body = body;
    }
   
    public Posts() {
    }
    
    public Posts(int id, int userId, String title, String body) {
    	this.id = id;
    	this.userId = userId;
    	this.title = title;
    	this.body = body;
    }
}
