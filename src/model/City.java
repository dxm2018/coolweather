package model;

import android.R.string;

public class City {
	
	private int id; //?
	private String city_name;
	private String city_code;
	private int privince_id;
	
	public int getID()
	{
		return id;
	}
	public void setID(int id)
	{
		this.id=id;
	}
	public String getCityName()
	{
		return city_name;
	}
    public void setCityName(String city_name)
    {
    	this.city_name=city_name;
    }
    public String getCityCode()
    {
    	return city_code;
    }
    public void setCityCode(String city_code)
    {
    	this.city_code=city_code;
    }
    public int getProvinceId()
    {
    	return privince_id;
    }
    public void setProvinceId(int province_id)
    {
    	this.privince_id=province_id;
    }
    
}
