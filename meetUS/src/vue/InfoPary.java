package vue;

import org.json.JSONArray;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.meetus.R;

import controller.Connexion;


public class InfoPary extends Activity {
	
	final String url = "http://meetus.noip.me/meetus/connexion.php";
	Connexion getPartyInfo = new Connexion();
	public String IDParty; 
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.party_homepage);
		
		Intent intent = getIntent();
		
		if(intent != null){
			Toast msg = Toast.makeText(this, intent.getStringExtra("ID_PARTY"), Toast.LENGTH_LONG);
			msg.show();
		
			IDParty = intent.getStringExtra("ID_PARTY");
		}
	}

	
	
	public void afficheInfoParty(){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					JSONArray jArray = getPartyInfo.getPartyFromUrl(url, IDParty);
				}
				catch(Exception e){
					
				}
				
			}
		}).start();
	}
	
}
