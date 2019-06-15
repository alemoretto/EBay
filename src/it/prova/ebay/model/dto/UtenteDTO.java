package it.prova.ebay.model.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import it.prova.ebay.model.Ruolo;
import it.prova.ebay.model.Utente;

public class UtenteDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String credito;
	private String dataRegistrazione;
	private Set<Ruolo> ruoli = new LinkedHashSet<>();

	public UtenteDTO(Long id, String nome, String cognome, String username, String password, String credito) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.credito = credito;
	}

	public UtenteDTO(String nome, String cognome, String username, String password, String credito,
			String[] ruoliString, List<Ruolo> listAll) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.credito = credito;
		if (ruoliString != null && ruoliString.length > 0) {
			for (String str : ruoliString) {
				for (Ruolo ruolo : listAll) {
					if (ruolo.getId() == Long.parseLong(str))
						this.ruoli.add(ruolo);
				}
			}
		}
	}

	public UtenteDTO(Long id, String nome, String cognome, String username, String password, String credito,
			String[] ruoliString, List<Ruolo> listAll) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.credito = credito;
		if (ruoliString != null && ruoliString.length > 0) {
			for (String str : ruoliString) {
				for (Ruolo ruolo : listAll) {
					if (ruolo.getId() == Long.parseLong(str))
						this.ruoli.add(ruolo);
				}
			}
		}
	}

	public UtenteDTO(String nome, String cognome, String username, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}

	public Map<String, String> fieldsNames() {
		Map<String, String> listaCampi = new LinkedHashMap<String, String>();
		listaCampi.put("Nome", "nomeInput");
		listaCampi.put("Cognome", "cognomeInput");
		listaCampi.put("Username", "usernameInput");
		listaCampi.put("Password", "passwordInput");
		listaCampi.put("Credito", "creditoInput");
		return listaCampi;
	}

	public static Utente buildUtenteInstance(UtenteDTO utenteDTO) {
		Utente utente = new Utente(utenteDTO.getNome(), utenteDTO.getCognome(), utenteDTO.getUsername(),
				utenteDTO.getPassword());
		try {
			utente.setId(utenteDTO.getId());
		} catch (Exception e) {
		}
		try {
			utente.setCredito(Double.parseDouble(utenteDTO.getCredito()));
		} catch (Exception e) {
		}
		try {
			utente.setRuoli(utenteDTO.getRuoli());
		} catch (Exception e) {
		}

		return utente;
	}

	public static UtenteDTO buildUtenteDTOInstance(Utente utente) {
		UtenteDTO utenteDTO = new UtenteDTO(utente.getNome(), utente.getCognome(), utente.getUsername(),
				utente.getPassword());

		try {
			utenteDTO.setId(utente.getId());
		} catch (Exception e) {
		}
		try {
			utenteDTO.setCredito(Double.toString(utente.getCredito()));
		} catch (Exception e) {
		}
		try {
			utenteDTO.setCredito(Double.toString(utente.getCredito()));
		} catch (Exception e) {
		}
		if (utente.getRuoli().size() > 0) {
			utenteDTO.setRuoli(utente.getRuoli());
		}
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			utenteDTO.setDataRegistrazione(dateFormat.format(utente.getDataRegistrazione()));
		} catch (Exception e) {
		}
		return utenteDTO;
	}

	public UtenteDTO() {
	}

	public Map<String, String> validate() {

		Map<String, String> validazione = new HashMap<String, String>();

		if (StringUtils.isEmpty(this.nome)) {
			validazione.put("nomeInput", "Attenzione! Il campo Nome è obbligatorio");
		}

		if (StringUtils.isEmpty(this.cognome)) {
			validazione.put("cognomeInput", "Attenzione! Il campo Cognome è obbligatorio");
		}

		if (StringUtils.isEmpty(this.username)) {
			validazione.put("usernameInput", "Attenzione! Il campo Username è obbligatorio");
		}

		if (StringUtils.isEmpty(this.password)) {
			validazione.put("passwordInput", "Attenzione! Il campo Password è obbligatorio");
		}

		if (StringUtils.isEmpty(this.credito)) {
			validazione.put("creditoInput", "Attenzione! Il campo Credito è obbligatorio");
		} else {
			try {
				Double.parseDouble(this.credito);
			} catch (Exception e) {
				validazione.put("creditoInput", "Attenzione! Il campo Credito non è valido");
			}
		}

		if (this.ruoli.size() <= 0) {
			validazione.put("ruoloInput", "Attenzione! Selezionare almeno un ruolo");
		}

		return validazione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCredito() {
		return credito;
	}

	public void setCredito(String credito) {
		this.credito = credito;
	}

	public String getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(String dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

}
