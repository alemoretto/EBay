package it.prova.ebay.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.prova.ebay.model.Acquisto;

public class AcquistoDTO {

	private String descrizione;
	private String prezzo;
	private String anno;
	
	public AcquistoDTO(String descrizione, String prezzo, String anno) {
		super();
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.anno = anno;
	}
	
	public static List<AcquistoDTO> buildListaAcquistiDTO(Set<Acquisto> storicoAcquisti) {
		List<AcquistoDTO> storicoAcquistiDTO = new ArrayList<>(0);
		if (storicoAcquisti.size() > 0) {
			for (Acquisto acq : storicoAcquisti) {
				storicoAcquistiDTO.add(new AcquistoDTO(acq.getDescrizione(), Double.toString(acq.getPrezzo()),
						Integer.toString(acq.getAnno())));
			}
		}
		
		return storicoAcquistiDTO;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}
	
}
