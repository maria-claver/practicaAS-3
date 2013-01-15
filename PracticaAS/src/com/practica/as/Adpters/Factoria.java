package com.practica.as.Adpters;

public enum Factoria {
	// SINGLETON
	INSTANCE;
	private AdaptadorAutoritza adaptadorAutoritza = new AdaptadorAutoritza();
	
	public AdaptadorAutoritza getAdaptadorAutoritza() {
		return adaptadorAutoritza;
	}
}
