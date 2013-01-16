package com.practica.as.Adapters;

public enum Factoria {
	// SINGLETON
	INSTANCE;
	private AdaptadorAutoritza adaptadorAutoritza = new AdaptadorAutoritza();
	
	public AdaptadorAutoritza getAdaptadorAutoritza() {
		return adaptadorAutoritza;
	}
}
