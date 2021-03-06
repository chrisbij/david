package vue;



import java.util.ArrayList;
import android.content.Intent;

import com.example.meetus.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapterList extends BaseAdapter{
	
	Context context;
	ArrayList<String> idPartyResult = new ArrayList<String>();
	ArrayList<String> titrePartyResult = new ArrayList<String>();
	ArrayList<String> partyLieuResult = new ArrayList<String>();
	ArrayList<String> partyDateResult = new ArrayList<String>();
	ArrayList<Bitmap> image = new ArrayList<Bitmap>();
	
	public TextView idParty;
	public TextView lieuParty;
	TextView partyTitre;
	TextView dateParty;
	ImageView img;
//	public Button infoParty;
	
	
	
	public MyAdapterList(Context a, ArrayList<String> idPartyList, ArrayList<String> titrePartyList, ArrayList<String> partyLieu, ArrayList<String> partyDate, ArrayList<Bitmap> imgList){
		idPartyResult = idPartyList;
		titrePartyResult = titrePartyList;
		partyLieuResult = partyLieu;
		partyDateResult = partyDate;
		context = a;
		image = imgList;
	
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return partyLieuResult.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return idPartyResult.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View row; 
		
		row = inflater.inflate(R.layout.list_row, parent, false);
		
		idParty = (TextView) row.findViewById(R.id.idParty);
		partyTitre = (TextView) row.findViewById(R.id.textView1);
		lieuParty = (TextView) row.findViewById(R.id.objet);
		dateParty = (TextView) row.findViewById(R.id.TextView01);
	//	infoParty = (Button)row.findViewById(R.id.infoButton);
		
	//	infoParty.setOnClickListener(affichInfo);
		
		Log.e("test", "bonjour");
		img = (ImageView) row.findViewById(R.id.list_image);

		idParty.setText(idPartyResult.get(position));
		partyTitre.setText(titrePartyResult.get(position));
		lieuParty.setText("� "+partyLieuResult.get(position));
		dateParty.setText("Le "+partyDateResult.get(position));
		img.setImageBitmap(image.get(position));
		
		return row;
	}
	
	
	
	public OnClickListener affichInfo = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(context, InfoPary.class);
			
			context.startActivity(intent);
		
		}
	};
	

}
