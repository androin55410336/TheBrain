package app.buusk.thebrain;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class brainDB extends SQLiteOpenHelper{
	public brainDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}


	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "brainDB";
	private static final String TABLE_SCORE = "score"; 
	
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TABLE_SCORE+ 
				"(ScoreID INTEGER PRIMARY KEY AUTOINCREMENT," +
				" Name TEXT(100)," +
				" Score TEXT(100));");
		
	Log.d("CREATE TABLE", "Create Table Sucsessfully.");
		
	}
	
	public long InsertData(String strName, String strScore){
		try
		{
			SQLiteDatabase db;
			db = this.getWritableDatabase();
			
			ContentValues Val = new ContentValues();
			
			Val.put("Name", strName);
			Val.put("Score", strScore);
			
			
			long row = db.insert(TABLE_SCORE, null, Val);
			db.close();
			return row;
		}catch (Exception e) {
			return -1;
		}
	}
	
	public String [] SelectData(String ScoreID){
		try
		{
			String arrData[] = null;
			SQLiteDatabase db;
			db = this.getReadableDatabase();
			
			Cursor cursor = db.query(TABLE_SCORE, new String[] { "*" }, "ScoreID=?", 
					new String[] { String.valueOf(ScoreID) }, null, null, null, null);
			if (cursor != null)
			{
				if(cursor.moveToFirst())
				{
					arrData = new String[cursor.getColumnCount()];
					
					arrData[0] = cursor.getString(0);
					arrData[1] = cursor.getString(1);
					arrData[2] = cursor.getString(2);
					
				}
			}
			cursor.close();
			db.close();
			return arrData;
			}catch (Exception e) {
				return null;
			}
	}
	
	public ArrayList<HashMap<String, String>> SelectAllData()
	{
		try
		{
			ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map;
			
			SQLiteDatabase db;
			db = this.getReadableDatabase();
			
			String strSQL = "SELECT * FROM " + TABLE_SCORE;
			Cursor cursor = db.rawQuery(strSQL, null);
			if (cursor != null)
			{
				if (cursor.moveToFirst()){
					do{
						map = new HashMap<String, String>();
						map.put("ScoreID", cursor.getString(0));
						map.put("Name", cursor.getString(1));
						map.put("Score", cursor.getString(2));
						
						MyArrList.add(map);
					} while (cursor.moveToNext());
				}
				
			}
			cursor.close();
			db.close();
			return MyArrList;
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
			
			
		
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP_TABLE IF EXISTS " + TABLE_SCORE);
		onCreate(db);
		// TODO Auto-generated method stub
		
	}

}
