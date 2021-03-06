package src;

import java.util.Date;

public class Pagament {

	public boolean pagar(String dni, String numT, float importTotal, Date dataCad, Date dataAvui) {
		return validarDni(dni) && validarImport(importTotal) && validarData(dataCad, dataAvui) && validarNumT(numT);
	}
	
	private boolean validarDni(String dni) {
		dni = dni.toUpperCase();
		if (dni.length() == 9) {
			char letra = dni.charAt(dni.length()-1);
			if (letra >= 'A' && letra <= 'Z') {
				dni = dni.substring(0, dni.length()-1);
				try {
					Integer dniNumber = Integer.parseInt(dni);
					String letras = "TRWAGMYFPDXBNJZSQVHLCKET";
					if (letra == letras.charAt(dniNumber%23)) {
						return true;
					}
				} catch (Exception e) {
					return false;
				}
			}
		}
		return false;
	}
	
	private boolean validarNumT(String numT) {
		try {
			Long.parseLong(numT);
			return numT.length() == 16; 
		} catch (Exception e) {
			return false;
		}
	}
	
	private boolean validarImport(float importTotal) {
		return importTotal > 0;
	}
	
	private boolean validarData(Date dataCad, Date dataAvui) {
		return dataCad.after(dataAvui);
	}
	
}
