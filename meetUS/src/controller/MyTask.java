package controller;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


import vue.MyAdapterList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
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

	@Override
	protected MyResult doInBackground(String... params) {
		// TODO Auto-generated method stub
		try{
			JSONArray jArray = co.getObjFromUrlTest(url, "BIJOU", "Chrislet");
			for(int i=0;i<jArray.length();i++){
				json_data = jArray.getJSONObject(i);
				partyTitre = json_data.getString("PARTY_TITRE");
				partyLieu = json_data.getString("VILLE_LIEU");
				partyDate = json_data.getString("DATE_PARTY");
				srcPic = "http://meetus.noip.me/meetus/media/images/image1.png";
					
					is = (InputStream) new URL(srcPic).getContent();
					bm = BitmapFactory.decodeStream(is);
					titreParty.add(""+partyTitre);
					lieuParty.add(""+partyLieu);
					dateParty.add(""+partyDate);
					image.add(bm);
				 	
					toto = something();
					}
			
		}catch(Exception e){
			Log.e("img", e.toString());
		}
		
		
		return toto ;
	}
	
	protected void onPostExecute(MyResult result){	
		
		
		MyAdapterList adapter = new MyAdapterList(context,toto.getPartyTitre(), toto.getPartyLieu(), toto.getPartyDate(), toto.getImages());
		

		Log.e("eco", ""+ liste.getId());
		
		
		liste.setAdapter(adapter);
		Toast titi =Toast.makeText(context, "Salut l'artiste", Toast.LENGTH_SHORT);
		
		titi.show();
		
		
	}
	
	
	public MyResult something(){
		ArrayList<String> titrePartyy = titreParty;
		ArrayList<String> lieuPartyy = lieuParty;
		ArrayList<String> datePartyy = dateParty;
		ArrayList<Bitmap> imagee = image;
		
		return new MyResult(titrePartyy , lieuPartyy, datePartyy, imagee);
	}

}
