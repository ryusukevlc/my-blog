package model.article;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
	
    private int id;
    private String title;
	private String content;
	private Date created_at;
	private Date updated_at;
	
	public Article() {
		
	}
	
	public Article(String title, String content, Date addDate, Date updateDate) {
		this.title = title;
		this.content = content;
		this.created_at = addDate;
		this.updated_at = updateDate;
	}
	
    public int getId() {
	    return id;
	}

	public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	
	

}
