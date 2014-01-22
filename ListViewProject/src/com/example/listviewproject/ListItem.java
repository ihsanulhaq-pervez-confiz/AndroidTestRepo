package com.example.listviewproject;

public class ListItem 
{
	private String description;
	private int imageId;

	public ListItem(String description, int imageId)
	{
		this.description = description;
		this.imageId = imageId;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public int getImageId() 
	{
		return imageId;
	}
	public void setImageId(int imageId) 
	{
		this.imageId = imageId;
	}
}
