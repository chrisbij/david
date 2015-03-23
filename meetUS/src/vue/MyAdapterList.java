package vue;



import java.util.ArrayList;

import com.example.meetus.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapterList extends BaseAdapter{
	
	Context context;
	ArrayList<String> result = new ArrayList<String>();
	ArrayList<Bitmap> image = new ArrayList<Bitmap>();
	TextView user;
	ImageView img;
	
	
	
	public MyAdapterList(Context a, ArrayList<String> descList, ArrayList<Bitmap> imgList){
		result = descList;
		context = a;
		image = imgList;
	
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return result.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
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
		
		user = (TextView) row.findViewById(R.id.objet);
		Log.e("test", "bonjour");
		img = (ImageView) row.findViewById(R.id.list_image);
		
		user.setText(result.get(position));
		img.setImageBitmap(image.get(position));
		
		return row;
	}

}
