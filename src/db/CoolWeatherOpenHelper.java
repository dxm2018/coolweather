package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View.OnCreateContextMenuListener;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper{
	
	/**
	 * province建表语句
	 */
	public static final String CREATE_PROVINCE="create table Province("
			+"id integer primary key autoincrement"
			+"province_name text"
			+"province_code integer)";
	
	/**
	 * city建表语句
	 */
	
	public static final String CREATE_CITY="create table City"
			+"id integer primary key autoincement"
			+"city_name text"
			+"city_code integer"
			+"city_id integer)";
	
	/**
	 * country建表语句
	 */
   
	public static final String CREATE_COUNTRY="create table Country("
			+"id integer primary key autoincrement"
			+"country_name text"
			+"country_code integer"
			+"country_id interger)";
	//构造函数，初始化
	public CoolWeatherOpenHelper(Context context,String name,CursorFactory factory,int version)
	{
		super(context, name, factory, version);
	}
	public void  onCreate(SQLiteDatabase db)
	{
		db.execSQL(CREATE_PROVINCE);//创建province表
		db.execSQL(CREATE_CITY);    //创建city表
		db.execSQL(CREATE_COUNTRY); //创建country表
	}
	
	//更新
	public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
	{
		
	}
}
