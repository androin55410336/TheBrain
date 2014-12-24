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

public class game2 extends Activity {
	EditText edt_result1;
	Button btn_ok1;
	String str_result1, str_score, str_name;
	int int_total = 1, score;

	String str2 = "banana,coconut";
	String str3 = "banana,coconut,melon";
	Boolean boo_result1;
	brainDB myDB = new brainDB(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game2);
		Typeface fontthai = Typeface.createFromAsset(getAssets(),"13-National-Fonts/DRjoyful.ttf");
		
		str_name = getIntent().getStringExtra("str_name");
		str_score = getIntent().getStringExtra("str_score");
		score = Integer.valueOf(str_score);

		edt_result1 = (EditText) findViewById(R.id.edt_result1);
		edt_result1.setTypeface(fontthai);
		
		btn_ok1 = (Button) findViewById(R.id.btn_ok1);
		btn_ok1.setTypeface(fontthai);
		btn_ok1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// part2
				str_result1 = edt_result1.getText().toString();
				if (boo_result1 = str2.equals(str_result1)) {

					int_total = int_total + score;
					Toast.makeText(getApplicationContext(),
							"Good your score is" + int_total, Toast.LENGTH_LONG)
							.show();
					Toast.makeText(getApplicationContext(), str3,
							Toast.LENGTH_LONG).show();

					Intent j = new Intent(getApplicationContext(), game3.class);
					str_score = String.valueOf(int_total);
					j.putExtra("str_score", str_score);
					j.putExtra("str_name", str_name);
					
					startActivity(j);
					

				} else {
					
					
					Toast.makeText(getApplicationContext(), "Sorry You Lose",
							Toast.LENGTH_SHORT).show();
					
					long savedata = myDB.InsertData(str_name,str_score);

					Intent m = new Intent(getApplicationContext(),
							showScore.class);
					startActivity(m);
					
				}

			}
		});
		
		
		
		

	}

}
