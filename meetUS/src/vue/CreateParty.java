package vue;

import com.example.meetus.R;

import android.os.Bundle;
import android.widget.EditText;

public class CreateParty extends AccueilVue {

	
	public EditText nameParty;
	public EditText nameOrganizer;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.create_party);
	
	}
	
}
