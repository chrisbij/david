package vue;



import java.util.ArrayList;



import com.example.meetus.R;

import controller.MyTask;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;

public class MainVue extends AccueilVue {

	
	public String srcPic;
	ImageView test;
	public Bitmap bm; 
	public Drawable dra;
	ImageView picProfil;
	Button datePick;
	public int annee;
	public ListView list;
	public int jour;
	public ArrayList<String> text = new ArrayList<String>();
	public ArrayList<Bitmap> image = new ArrayList<Bitmap>() ;
	public int mois;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		datePick = (Button)findViewById(R.id.dteSortie);
		datePick.setOnClickListener(choixJour);
		test = (ImageView)findViewById(R.id.objet);
		list = (ListView)findViewById(R.id.lvListe);
			
		picProfil = (ImageView)findViewById(R.id.list_image);
	
		new MyTask(MainVue.this, list).execute("");
		
	}
	
	
	public OnClickListener choixJour = new OnClickListener() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			showDialog(0);
		}
	};
	
	public Dialog onCreateDialog(int id){
		switch (id) {
		case 0:
			return new DatePickerDialog(this, maDatePicker, annee, mois, jour);
		}
		
		return null;
	}

	
	
	public DatePickerDialog.OnDateSetListener maDatePicker = new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			annee=year;
			mois=monthOfYear;
			jour=dayOfMonth;
		}
	};
	
}
