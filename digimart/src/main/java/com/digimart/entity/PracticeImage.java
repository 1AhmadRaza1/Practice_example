package com.digimart.entity;

public class PracticeImage {

	  
	private int imageid;
	private String name;
	private String image;
	/**
	 * @return the imageid
	 */
	public int getImageid() {
		return imageid;
	}
	/**
	 * @param imageid the imageid to set
	 */
	public void setImageid(int imageid) {
		this.imageid = imageid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "PracticeImage [imageid=" + imageid + ", name=" + name + ", image=" + image + "]";
	}
	
 }
