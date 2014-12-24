package app.buusk.thebrain;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
//import app.buusk.resume_55410336.R;
//import app.buusk.resume_55410336.ShowActivity;
//import app.buusk.resume_55410336.myDBClass;

public class showScore extends Activity {
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		
		brainDB brainDB = new brainDB(this);
		ArrayList<HashMap<String, String>> ScoreList = brainDB.SelectAllData();
		ListView listview = (ListView) findViewById(R.id.listView1);
		
		SimpleAdapter sAdap;
		sAdap = new SimpleAdapter(showScore.this, ScoreList, R.layout.show_item, 
				new String[] {"ScoreID", "Name", "Score"}, new int[] {R.id.colplayerID,
				R.id.colname, R.id.colscore});
		listview.setAdapter(sAdap);
	}

}
