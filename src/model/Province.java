package model;

import android.R.string;

public class Province {
	
	private int id;
	private String province_name;
	private String province_code;
	
	public int getID()
	{
		return id;
	}
	public void setID(int id)
	{
		this.id=id;
	}

	public String getProvince_name()
	{
		return province_name;
	}
	public void setProvince_name(String province_name)
	{
		this.province_name=province_name;
	}
	public String getProvince_code()
	{
		return province_code;
	}
	public void setProvince_code(String province_code)
	{
		this.province_code=province_code;
	}
}
