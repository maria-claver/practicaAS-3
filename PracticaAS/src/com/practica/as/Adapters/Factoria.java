package com.practica.as.Adapters;

/**
 * Factoria dels adaptadors de serveis externs
 * 
 * @author Aida Albalate, Maria Claver, Borja Gonz�lez, Oriac P�rez, Joan Subirats
 *
 */
public enum Factoria {
	// SINGLETON
	INSTANCE;
	private AdaptadorAutoritza adaptadorAutoritza = new AdaptadorAutoritza();
	
	public AdaptadorAutoritza getAdaptadorAutoritza() {
		return adaptadorAutoritza;
	}
}
