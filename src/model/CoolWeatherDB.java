package model;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSInput;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.AutoCompleteTextView.Validator;
import db.CoolWeatherOpenHelper;

public class CoolWeatherDB {
	
	/**
	 * 数据库名称 //为啥这样定义
	 */
	private static final String DB_NAME="cool_weather";
	
	/**
	 * 数据库版本 //为啥这样定义
	 */
	private static final int VERSION=1;
	
	private static CoolWeatherDB coolWeatherDB;
	private SQLiteDatabase db;
	
	/**
	 * 构造方法私有化  ??context?
	 */
	private CoolWeatherDB(Context context)
	{
		CoolWeatherOpenHelper dbHelper=new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
		db=dbHelper.getWritableDatabase();
	}
	/**
	 * 获取CoolWeatherDB实例  ？？
	 */
	public synchronized static CoolWeatherDB getInstance(Context context)
	{
		if(coolWeatherDB==null)
		{
			coolWeatherDB=new CoolWeatherDB(context);
		}
		return coolWeatherDB;
	}
	/**
	 *保存province实例
	 */
	public void saveProvince(Province province)
	{
		if(province!=null)
		{
			ContentValues values=new ContentValues();
			values.put("province_name", province.getProvince_name());
			values.put("province_code", province.getProvince_code());
			db.insert("Province", null, values);
		}
	}
	/**
	 *从数据库读取全国所有省份信息
	 *List<Province>创建泛型数组
	 */
	public List<Province> loadProvinces()
	{
		List<Province> list=new ArrayList<Province>();//创建泛型数组
		Cursor cursor=db.query("Province", null, null, null, null, null, null);
		if(cursor.moveToFirst())
		{
			do
			{
				Province province=new Province();
				province.setID(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvince_name(cursor.getString(cursor.getColumnIndex("province_name")));
				province.setProvince_code(cursor.getString(cursor.getColumnIndex("province_code")));
				list.add(province);
			}
			while(cursor.moveToNext());
		}
		return list;
	}
	
	/**
	 * 存储city实例
	 */
	public void saveCity(City city)
	{
		if(city!=null)
		{
			ContentValues values=new ContentValues();
			values.put("city_name", city.getCityName());
			values.put("city_code", city.getCityCode());
			values.put("province_id", city.getProvinceId());
			db.insert("City", null, values);
		}
	}
	/**
	 * 从数据库读取某省的下所有的城市信息
	 */
	public List<City> loadCity(int province_id)
	{
		List<City> list=new ArrayList<City>();
		Cursor cursor=db.query("City", null, "province_id=?", new String[] {String.valueOf(province_id)}, null, null, null);
		if(cursor.moveToFirst())
		{
			do{
			City city=new City();
			city.setID(cursor.getInt(cursor.getColumnIndex("id")));
			city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
			city.setCityCode(cursor.getString(cursor.getColumnIndex("code_code")));
			city.setProvinceId(province_id);
			list.add(city);
			}
			while(cursor.moveToNext());
		}
		return list;
	}
	
	/**
	 *country存储实例
	 */
	public void saveCountry(Country country)
	{
		if(country!=null)
		{
			ContentValues values=new ContentValues();
			values.put("country_name",country.getCountryName() );
			values.put("country_code", country.getCountryCode());
			values.put("city_id", country.getCityId());
			db.insert("City", null, values);
		}
	}
	/**
	 * 从某市下面获取相关的信息
	 */
	public List<Country> loadCountry(int city_id)
	{
		List<Country> list=new ArrayList<Country>();
		Cursor cursor=db.query("Country", null, "city_id=?", new String[] {String.valueOf(city_id)}, null, null, null);
		if(cursor.moveToFirst())
		{
			do{
				Country country=new Country();
				country.setCityId(cursor.getInt(cursor.getColumnIndex("id")));
				country.setCountryName(cursor.getString(cursor.getColumnIndex("country_name")));
				country.setCountryCode(cursor.getString(cursor.getColumnIndex("country_code")));
				country.setCityId(city_id);
				list.add(country);
			}
			while(cursor.moveToNext());
			
		}
		
		return list;
	}
}
