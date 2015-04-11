package controller;

import java.util.ArrayList;

import android.graphics.Bitmap;

public final class MyResult {
	
	private ArrayList<String> partyTitre;
	private ArrayList<String> texte;
	private ArrayList<Bitmap> images;
	
	public MyResult(ArrayList<String> partyTitre, ArrayList<String> texte, ArrayList<Bitmap> images){
		this.partyTitre = partyTitre;
		this.images = images;
		this.texte = texte;
	}
	
	public ArrayList<String> getText(){
		return texte;
	}
	
	public ArrayList<Bitmap> getImages(){
		return images;
	}
	
	public ArrayList<String> getPartyTitre(){
		return partyTitre;
	}
	
}
