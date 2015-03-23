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
	public String prenom1;
	public String nom1;
	Connexion co = new Connexion();
	public ListView liste; 
	public MyResult toto;
	public InputStream is;
	public Bitmap bm;
	public JSONObject json_data;
	public String srcPic;
	public String url = "http://meetus.noip.me/meetus/connexion.php";

	public ArrayList<String> text = new ArrayList<String>();
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
				nom1 = json_data.getString("nom");
				prenom1 = json_data.getString("prenom");
				srcPic = json_data.getString("img");
					
					is = (InputStream) new URL(srcPic).getContent();
					bm = BitmapFactory.decodeStream(is);
					text.add("Bonjour "+nom1+" "+prenom1);
					image.add(bm);
				 	
					toto = something();
					}
			
		}catch(Exception e){
			Log.e("img", e.toString());
		}
		
		
		return toto ;
	}
	
	protected void onPostExecute(MyResult result){	
		
		
		MyAdapterList adapter = new MyAdapterList(context, toto.getText(), toto.getImages());
		

		Log.e("eco", ""+ liste.getId());
		
		
		liste.setAdapter(adapter);
		Toast titi =Toast.makeText(context, "Salut l'artiste", Toast.LENGTH_SHORT);
		
		titi.show();
		
		
	}
	
	
	public MyResult something(){
		ArrayList<String> textt = text;
		ArrayList<Bitmap> imagee = image;
		
		return new MyResult(textt, imagee);
	}

}
