package it.prova.ebay.model.dto;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import it.prova.ebay.model.Categoria;

public class CategoriaDTO {

	private Long id;
	private String descrizione;
	private String codice;
	private String numeroAnnunciAssociati;
	
	public CategoriaDTO() {
	}

	public CategoriaDTO(Long id, String descrizione, String codice) {
		this( descrizione, codice);
		this.id = id;
	}

	public CategoriaDTO(String descrizione, String codice) {
		super();
		this.descrizione = descrizione;
		this.codice = codice.toUpperCase();
	}
	
	public Map<String, String> validate() {

		Map<String, String> validazione = new HashMap<String, String>();

		if (StringUtils.isEmpty(this.descrizione)) {
			validazione.put("descrizioneInput", "Attenzione! Il campo Descrizione è obbligatorio");
		}
		if (StringUtils.isEmpty(this.codice)) {
			validazione.put("codiceInput", "Attenzione! Il campo Codice è obbligatorio");
		}
		
		return validazione;
	}
	
	public static Categoria buildCategoriaInstance(CategoriaDTO categoriaDTO) {
		return new Categoria(categoriaDTO.getId(),categoriaDTO.getDescrizione(),categoriaDTO.getCodice());
	}
	
	public static CategoriaDTO buildCategoriaDTOInstance(Categoria categoria) {
		CategoriaDTO categoriaDTO = new CategoriaDTO(categoria.getId(),categoria.getDescrizione(),categoria.getCodice());
		try {
			categoriaDTO.numeroAnnunciAssociati = Integer.toString(categoria.getAnnunci().size());
		} catch (Exception e) {
		}
		
		return categoriaDTO;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNumeroAnnunciAssociati() {
		return numeroAnnunciAssociati;
	}

	public void setNumeroAnnunciAssociati(String numeroAnnunciAssociati) {
		this.numeroAnnunciAssociati = numeroAnnunciAssociati;
	}

}
