package vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.meetus.MainActivity;
import com.example.meetus.R;

public class AccueilVue extends MainActivity {

	
	public Button createParty;
	public Button accessParty;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.accueil_user);
		
		accessParty = (Button)findViewById(R.id.accessParty);
		createParty = (Button)findViewById(R.id.createParty);
		
		accessParty.setOnClickListener(accessPartyListener);
		createParty.setOnClickListener(createPartyListener);
		
	}
	
	
	
	
	
	public OnClickListener accessPartyListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
				
					try{
						
							runOnUiThread(new Runnable() {
								
								@Override
								public void run() {
									Intent intent = new Intent(getApplicationContext(), MainVue.class);
									
									startActivity(intent);
								}
							});
						
					}catch(Exception e){
						
					}
					
				}
			}).start();
				
			}			
		};
	
	
	
	public OnClickListener createPartyListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
				
					try{
						
							runOnUiThread(new Runnable() {
								
								@Override
								public void run() {
									Intent intent = new Intent(getApplicationContext(), CreateParty.class);
									
									startActivity(intent);
								}
							});
						
					}catch(Exception e){
						
					}
					
				}
			}).start();
		}
	};
	
}
