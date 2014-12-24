package app.buusk.thebrain;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class game3 extends Activity{
	EditText edt_result3;
	Button btn_ok3;
	String str_result3, str_score, str_name, str_total;
	int int_total=1, score;

	String str3 = "banana,coconut,melon";
	//String str4 = "banana,coconut,melon,strawberry";
	Boolean boo_result3;
	
	brainDB myDB = new brainDB(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game3);
		
		Typeface fontthai = Typeface.createFromAsset(getAssets(),"13-National-Fonts/DRjoyful.ttf");
		
		str_name = getIntent().getStringExtra("str_name");
		str_score = getIntent().getStringExtra("str_score");
		score = Integer.valueOf(str_score);
		

		edt_result3 = (EditText) findViewById(R.id.edt_result3);
		edt_result3.setTypeface(fontthai);

		btn_ok3 = (Button) findViewById(R.id.btn_ok3);
		btn_ok3.setTypeface(fontthai);
		btn_ok3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// part2
				str_result3 = edt_result3.getText().toString();
				if (boo_result3 = str3.equals(str_result3)) {
					
					int_total = int_total + score;
					str_score = String.valueOf(int_total);
					//str_total = String.valueOf(int_total);
					Toast.makeText(getApplicationContext(),
							"Perfect You win : your score is" + int_total, Toast.LENGTH_LONG)
							.show();
					//Toast.makeText(getApplicationContext(), str4,
							//Toast.LENGTH_LONG).show();
					//Intent j = new Intent(getApplicationContext(), game4.class);
					//str_score = String.valueOf(int_total);
					//j.putExtra("str_score", str_score);
					//j.putExtra("str_name", str_name);
					//startActivity(j);
					long savedata = myDB.InsertData(str_name,str_score);
					Intent m = new Intent(getApplicationContext(), showScore.class);
					startActivity(m);
				}
				else {
					Toast.makeText(getApplicationContext(), "Sorry You Lose",
							Toast.LENGTH_SHORT).show();
					long savedata = myDB.InsertData(str_name,str_score);
					Intent m = new Intent(getApplicationContext(), showScore.class);
					startActivity(m);
				}

			}
		});
		
			
	}
	
	
	
	

}
