package it.prova.ebay.model.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import it.prova.ebay.model.Annuncio;
import it.prova.ebay.model.Categoria;

public class AnnuncioDTO {

	private Long id;
	private String testoAnnuncio;
	private String prezzo;
	private String data;
	private String utente;
	private String[] categId;
	private String[] categSelected;
	private Set<Categoria> categorie = new LinkedHashSet<>(); 

	public AnnuncioDTO() {
	}

	public AnnuncioDTO(Long id, String testoAnnuncio, String prezzo, String[] stringsCat, List<Categoria> listAll) {
		this(testoAnnuncio, prezzo, stringsCat, listAll);
		this.id = id;
	}
	
	public AnnuncioDTO(String testoAnnuncio, String prezzo, String[] stringsCat, List<Categoria> listAll) {
		super();
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
//		buildCategorie(stringsCat, listAll);
//	}

//	private void buildCategorie(String[] stringsCat, List<Categoria> listAll) {
		if (stringsCat != null) {
			categId = new String[stringsCat.length];
			categSelected = new String[stringsCat.length];
			int i = -1;
			for (String str : stringsCat) {
				for (Categoria cat : listAll) {
					if (Long.toString(cat.getId()).equals(str) ) {
						i++;
						this.categorie.add(cat);
						this.categId[i] = Long.toString(cat.getId());
						this.categSelected[i] = "1";
					}
				}
			}
		} else {
//			this.categorie = new LinkedHashSet<>(listAll);
			this.categorie = new LinkedHashSet<>(0);
			this.categId = new String[] { "" };
			this.categSelected = new String[] { "" };
		}
	}

	public static AnnuncioDTO buildAnnuncioDTOInstance(Annuncio annuncio) {
		AnnuncioDTO annuncioDTO = new AnnuncioDTO();
		annuncioDTO.setId(annuncio.getId());
		annuncioDTO.setTestoAnnuncio(annuncio.getTestoAnnuncio());
		annuncioDTO.setPrezzo(Double.toString(annuncio.getPrezzo()));
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
		annuncioDTO.setData(dateFormat.format(annuncio.getDataPubblicazione()));
		annuncioDTO.setUtente(annuncio.getUtente().getUsername());
		annuncioDTO.setCategorie(annuncio.getCategorie());
		if (annuncioDTO.getCategorie().size() > 0) {
			String[] catSelected = new String[annuncioDTO.getCategorie().size()];
			String[] catId = new String[annuncioDTO.getCategorie().size()];
			int i = -1;
			for (Categoria cat : annuncioDTO.getCategorie()) {
				i++;
				catId[i] = Long.toString(cat.getId());
				catSelected[i] = "1";
			}
		} else {
			annuncioDTO.setCategId(new String[] { "" });
			annuncioDTO.setCategSelected(new String[] { "" });
//			annuncioDTO.setCategId(null);
//			annuncioDTO.setCategSelected(null);
		}

		return annuncioDTO;
	}

	public Map<String, String> validate() {

		Map<String, String> validazione = new HashMap<String, String>();

		if (StringUtils.isEmpty(this.testoAnnuncio)) {
			validazione.put("testoAnnuncioInput", "Attenzione! Il campo Descrizione è obbligatorio");
		}

		if (StringUtils.isEmpty(this.prezzo)) {
			validazione.put("prezzoInput", "Attenzione! Il campo Prezzo è obbligatorio");
		} else {
			try {
				Double.parseDouble(this.prezzo);
			} catch (Exception e) {
				validazione.put("prezzoInput", "Attenzione! Il campo Prezzo non è valido");
			}
		}

		if ( this.categorie.size() <= 0 ) {
			validazione.put("categoriaInput", "Attenzione! Selezionare almeno una Categoria");
		} 
		
		return validazione;
	}
	
	public static Annuncio buildAnnuncioInstance(AnnuncioDTO annuncioDTO) {
		Annuncio annuncio = new Annuncio();
		try {
			annuncio.setId(annuncioDTO.getId());	
		} catch (Exception e) {
		}
		annuncio.setAperto(true);
		annuncio.setTestoAnnuncio(annuncioDTO.getTestoAnnuncio());
		try {
			annuncio.setPrezzo(Double.parseDouble(annuncioDTO.getPrezzo()));	
		} catch (Exception e) {
			annuncio.setPrezzo(-1);
		}
			annuncio.setCategorie(annuncioDTO.getCategorie());
		return annuncio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTestoAnnuncio() {
		return testoAnnuncio;
	}

	public void setTestoAnnuncio(String testoAnnuncio) {
		this.testoAnnuncio = testoAnnuncio;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

	
	public String[] getCategId() {
		return categId;
	}

	public void setCategId(String[] categId) {
		this.categId = categId;
	}

	public String[] getCategSelected() {
		return categSelected;
	}

	public void setCategSelected(String[] categSelected) {
		this.categSelected = categSelected;
	}

	

}



//package it.prova.ebay.model.dto;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedHashMap;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import it.prova.ebay.model.Annuncio;
//import it.prova.ebay.model.Categoria;
//
//public class AnnuncioDTO {
//
//	private Long id;
//	private String testoAnnuncio;
//	private String prezzo;
//	private String data;
//	private String utente;
////	private String[] categId;
////	private String[] categNome;
////	private String[] categSelected;
//	private Set<Categoria> categorie = new LinkedHashSet<>(); 
//
//	public AnnuncioDTO() {
//	}
//
//	public AnnuncioDTO(String testoAnnuncio, String prezzo, String[] stringsCat, List<Categoria> listAll) {
//		super();
//		this.testoAnnuncio = testoAnnuncio;
//		this.prezzo = prezzo;
//		buildCategorie(stringsCat, listAll);
//	}
//
//	private void buildCategorie(String[] stringsCat, List<Categoria> listAll) {
//		int i = -1;
//		if (stringsCat != null) {
//			categId = new String[stringsCat.length];
//			categNome = new String[stringsCat.length];
//			categSelected = new String[stringsCat.length];
////			int i = -1;
//			for (String str : stringsCat) {
//				for (Categoria cat : listAll) {
//					if (Long.toString(cat.getId()).equals(str) ) {
//						i++;
//						categId[i] = Long.toString(cat.getId());
//						categNome[i] = cat.getDescrizione();
//						categSelected[i] = "1";
//					}
//				}
//			}
//		}else {
//			categId = new String[listAll.size()];
//			for (Categoria cat : listAll) {
//				i++;
//				categId[i] = Long.toString(cat.getId());
//			}
//		}
//			
//	}
//
//	public static AnnuncioDTO buildAnnuncioDTOInstance(Annuncio annuncio) {
//		AnnuncioDTO annuncioDTO = new AnnuncioDTO();
//		annuncioDTO.setId(annuncio.getId());
//		annuncioDTO.setTestoAnnuncio(annuncio.getTestoAnnuncio());
//		annuncioDTO.setPrezzo(Double.toString(annuncio.getPrezzo()));
//		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
//		annuncioDTO.setData(dateFormat.format(annuncio.getDataPubblicazione()));
//		annuncioDTO.setUtente(annuncio.getUtente().getUsername());
//		Set<Categoria> setCateg = annuncio.getCategorie();
//		if (setCateg.size() > 0) {
//			String[] catId = new String[setCateg.size()];
//			String[] catNome = new String[setCateg.size()];
//			String[] catSelected = new String[setCateg.size()];
//			int i = -1;
//			for (Categoria cat : setCateg) {
//				i++;
//				catId[i] = Long.toString(cat.getId());
//				catNome[i] = cat.getDescrizione();
//				catSelected[i] = "1";
//			}
//			annuncioDTO.setCategId(catId);
//			annuncioDTO.setCategNome(catNome);
//			annuncioDTO.setCategSelected(catSelected);
//		} else {
//			annuncioDTO.setCategId(new String[] { "" });
//			annuncioDTO.setCategNome(new String[] { "" });
//			annuncioDTO.setCategSelected(new String[] { "" });
//		}
//
//		return annuncioDTO;
//	}
//
////	private void buildCategorie(Set<Categoria> setCateg) {
////		if (setCateg.size() > 0) {
////			categId = new String[setCateg.size()];
////			categNome = new String[setCateg.size()];
////			categSelected = new String[setCateg.size()];
////			int i = -1;
////			for (Categoria cat : setCateg) {
////				i++;
////				categId[i] = Long.toString(cat.getId());
////				categNome[i] = cat.getDescrizione();
////				categSelected[i] = "1";
////			}
////		}
////	}
//	
//	public static Annuncio buildAnnuncioInstance(AnnuncioDTO annuncioDTO) {
//		Annuncio annuncio = new Annuncio();
//		annuncio.setAperto(true);
//		annuncio.setTestoAnnuncio(annuncioDTO.getTestoAnnuncio());
//		try {
//			annuncio.setPrezzo(Double.parseDouble(annuncioDTO.getPrezzo()));	
//		} catch (Exception e) {
//			annuncio.setPrezzo(-1);
//		}
//		if (annuncioDTO.getCategId() != null) {
//			int i = -1;
//			for (String str : annuncioDTO.getCategId()) {
//				i++;
//				annuncio.getCategorie().add(new Categoria(Long.parseLong(str)));
//			}
//		}
//		return annuncio;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getTestoAnnuncio() {
//		return testoAnnuncio;
//	}
//
//	public void setTestoAnnuncio(String testoAnnuncio) {
//		this.testoAnnuncio = testoAnnuncio;
//	}
//
//	public String getPrezzo() {
//		return prezzo;
//	}
//
//	public void setPrezzo(String prezzo) {
//		this.prezzo = prezzo;
//	}
//
//	
//	public String getData() {
//		return data;
//	}
//
//	public void setData(String data) {
//		this.data = data;
//	}
//
//	public String getUtente() {
//		return utente;
//	}
//
//	public void setUtente(String utente) {
//		this.utente = utente;
//	}
//
//	public String[] getCategId() {
//		return categId;
//	}
//
//	public void setCategId(String[] categId) {
//		this.categId = categId;
//	}
//
//	public String[] getCategNome() {
//		return categNome;
//	}
//
//	public void setCategNome(String[] categNome) {
//		this.categNome = categNome;
//	}
//
//	public String[] getCategSelected() {
//		return categSelected;
//	}
//
//	public void setCategSelected(String[] categSelected) {
//		this.categSelected = categSelected;
//	}
//
//	
////	public Map<String, String> getCategorie() {
////		return categorie;
////	}
////
////	public void setCategorie(Map<String, String> categorie) {
////		this.categorie = categorie;
////	}
//
//}
