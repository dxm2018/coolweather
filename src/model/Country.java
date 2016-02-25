package model;

public class Country {
	
	private int id;
	private String country_name;
	private String country_code;
	private int city_id;
	
	public int getId()
	{
		return id;
	}
	public void  setId(int id)
	{
		this.id=id;
	}
	public String getCountryName()
	{
		return country_name;
	}
	public void setCountryName(String country_name)
	{
		this.country_name=country_name;
	}
	public String getCountryCode()
	{
		return country_code;
	}
	public void setCountryCode(String country_code)
	{
		this.country_code=country_code;
	}
	public int getCityId()
	{
		return city_id;
	}
	public void setCityId(int cityid)
	{
		this.city_id=cityid;
	}

}
