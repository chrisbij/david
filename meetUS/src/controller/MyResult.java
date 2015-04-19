package controller;

import java.util.ArrayList;

import android.graphics.Bitmap;

public final class MyResult {
	
	private ArrayList<String> partyTitre;
	private ArrayList<String> partyLieu;
	private ArrayList<String> partyDate;
	private ArrayList<Bitmap> images;
	
	public MyResult(ArrayList<String> partyTitre, ArrayList<String> partyLieu, ArrayList<String> partyDate, ArrayList<Bitmap> images){
		this.partyTitre = partyTitre;
		this.images = images;
		this.partyLieu = partyLieu;
		this.partyDate = partyDate;
	}
	
	public ArrayList<String> getPartyLieu(){
		return partyLieu;
	}
	
	public ArrayList<Bitmap> getImages(){
		return images;
	}
	
	public ArrayList<String> getPartyTitre(){
		return partyTitre;
	}
	
	public ArrayList<String> getPartyDate(){
		return partyDate;
	}
}
