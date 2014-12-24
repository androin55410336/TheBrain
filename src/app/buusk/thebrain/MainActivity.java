package app.buusk.thebrain;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
Button btn_fruit,btn_score,btn_rule;
TextView txt1,txtr1,txtr2,txtr3,txtr4,txtr5,txtr6,txtr7;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Typeface fontthai = Typeface.createFromAsset(getAssets(),"13-National-Fonts/DRjoyful.ttf");
		
				
		
		txt1=(TextView) findViewById(R.id.txt_cat);
		txt1.setTypeface(fontthai);
		
		btn_fruit = (Button) findViewById(R.id.btn_fruit);
		btn_fruit.setTypeface(fontthai);
		btn_fruit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent j = new Intent(getApplicationContext(), player.class);
				startActivity(j);
				
			}
		});
		
		btn_rule = (Button) findViewById(R.id.btn_rule);
		btn_rule.setTypeface(fontthai);
		btn_rule.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
	
				
				setContentView(R.layout.rule);
				
			}
		});
		btn_score= (Button) findViewById(R.id.btn_score);
		btn_score.setTypeface(fontthai);
		btn_score.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent m = new Intent(getApplicationContext(), showScore.class);
				startActivity(m);
				
				
			}
		});
		
		
		
		
	}
	
	
	
}
