package app.buusk.thebrain;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class game extends Activity {
	EditText edt_result;
	Button btn_ok;

	String str_result, str_name;

	String str1 = "banana";
	String str2 = "banana,coconut";

	boolean boo_result;

	int score = 1;
	String str_score;
	brainDB myDB = new brainDB(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		Typeface fontthai = Typeface.createFromAsset(getAssets(),"13-National-Fonts/DRjoyful.ttf");

		str_name = getIntent().getStringExtra("str_name");

		edt_result = (EditText) findViewById(R.id.edt_result);
		edt_result.setTypeface(fontthai);

		btn_ok = (Button) findViewById(R.id.btn_ok);
		btn_ok.setTypeface(fontthai);

		Toast.makeText(getApplicationContext(), str1,// banana
				Toast.LENGTH_LONG).show();

		// Part 1

		btn_ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				str_result = edt_result.getText().toString();

				if (boo_result = str1.equals(str_result)) {

					// total = total + score;
					Toast.makeText(getApplicationContext(),
							"Good your score is" + score, Toast.LENGTH_LONG)
							.show();

					Toast.makeText(getApplicationContext(), str2,
							Toast.LENGTH_LONG).show();

					Intent j = new Intent(getApplicationContext(), game2.class);
					str_score = String.valueOf(score);
					j.putExtra("str_score", str_score);
					j.putExtra("str_name", str_name);
					startActivity(j);

				}

				else {
					str_score = "0";
					Toast.makeText(getApplicationContext(), "Sorry You Lose",
							Toast.LENGTH_SHORT).show();
					
					long savedata = myDB.InsertData(str_name, str_score);

					Intent m = new Intent(getApplicationContext(),
							showScore.class);
					startActivity(m);
					
				}

			}

		});
		

		

	}

}
