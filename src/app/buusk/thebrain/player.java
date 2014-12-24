package app.buusk.thebrain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class player extends Activity{
	EditText edt_name;
	Button btn_regis;
	String str_name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player);
		edt_name=(EditText) findViewById(R.id.edt_name);
		//str_name = edt_name.getText().toString();
		 
		 btn_regis = (Button) findViewById(R.id.btn_start);

		 
		 btn_regis.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent j = new Intent(getApplicationContext(), game.class);
				str_name = edt_name.getText().toString();

		
				j.putExtra("str_name", str_name); 
				startActivity(j);
				
			}
		});
		
	}

}
