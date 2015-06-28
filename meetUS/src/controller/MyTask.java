package controller;

import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;





import vue.MainVue;
import vue.MyAdapterList;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MyTask extends AsyncTask<String, Void, MyResult> {
	
	Context context;
	public String partyTitre;
	public String partyLieu;
	public String partyDate;
	Connexion co = new Connexion();
	public ListView liste; 
	public MyResult toto;
	public InputStream is;
	public Bitmap bm;
	public JSONObject json_data;
	public String srcPic;
	public String url = "http://meetus.noip.me/meetus/connexion.php";

	public ArrayList<String> titreParty = new ArrayList<String>();
	public ArrayList<String> lieuParty = new ArrayList<String>();
	public ArrayList<String> dateParty = new ArrayList<String>();
	public ArrayList<Bitmap> image = new ArrayList<Bitmap>() ;
	
	
	public MyTask(Context a, ListView view){
		context = a;
		liste = view;
	}
	
	
	
	
	protected void onPreExecute(){
		
	}
	
	
	

	@SuppressLint("SimpleDateFormat")
	@SuppressWarnings("deprecation")
	@Override
	protected MyResult doInBackground(String... params) {
		// TODO Auto-generated method stub
		
		
		try{
			JSONArray jArray = co.getObjFromUrlTest(url, "BIJOU", "Chrislet");
			if(co.go == false){
			super.cancel(true);
			}else{
				for(int i=0;i<jArray.length();i++){
					
					json_data = jArray.getJSONObject(i);
					partyTitre = json_data.getString("PARTY_TITRE");
					partyLieu = json_data.getString("VILLE_LIEU");
					String date = json_data.getString("DATE_PARTY");
					
					SimpleDateFormat dateTransform = new SimpleDateFormat("yyyy-MM-dd");
					Date maDate = dateTransform.parse(date);
					
					
					partyDate = maDate.toLocaleString();
					
					srcPic = "http://meetus.noip.me/meetus/media/images/image1.png";
						
						is = (InputStream) new URL(srcPic).getContent();
						bm = BitmapFactory.decodeStream(is);
						titreParty.add(""+partyTitre);
						lieuParty.add(""+partyLieu);
						dateParty.add(""+partyDate);
						image.add(bm);
					 	
						toto = something();
						}
			}
		}catch(Exception e){
			Log.e("img", e.toString());
		}
		
	//	}
		return toto ;
	}
	
	protected void onPostExecute(MyResult result){	
		
		
		MyAdapterList adapter = new MyAdapterList(context,toto.getPartyTitre(), toto.getPartyLieu(), toto.getPartyDate(), toto.getImages());
		

		Log.e("eco", ""+ liste.getId());
		
		
		liste.setAdapter(adapter);
		
		liste.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Log.e("conio", "msg");
				
				String s = "bonjour";
				
				Toast msg = Toast.makeText(context, s, Toast.LENGTH_LONG);
				msg.show();
			}
		});
		
	}
	
	
	public MyResult something(){
		ArrayList<String> titrePartyy = titreParty;
		ArrayList<String> lieuPartyy = lieuParty;
		ArrayList<String> datePartyy = dateParty;
		ArrayList<Bitmap> imagee = image;
		
		return new MyResult(titrePartyy , lieuPartyy, datePartyy, imagee);
	}
	
	

}
