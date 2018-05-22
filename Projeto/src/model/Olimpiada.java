package model;

public class Olimpiada {
	private int id;
	private int idModalidade;
	private String nomeModalidade;
	private int idAno;
	private int idPais;
	private int ouro, prata, bronze;

	public Olimpiada() {

	}

	public Olimpiada(int id, int idModalidade, int idAno, int idPais, int ouro, int prata, int bronze) {
		setId(id);
		setIdModalidade(idModalidade);
		setIdAno(idAno);
		setIdPais(idPais);
		setOuro(ouro);
		setPrata(prata);
		setBronze(bronze);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdModalidade() {
		return idModalidade;
	}

	public void setIdModalidade(int idModalidade) {
		this.idModalidade = idModalidade;
	}

	public int getIdAno() {
		return idAno;
	}

	public void setIdAno(int idAno) {
		this.idAno = idAno;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public int getOuro() {
		return ouro;
	}

	public void setOuro(int ouro) {
		this.ouro = ouro;
	}

	public int getPrata() {
		return prata;
	}

	public void setPrata(int prata) {
		this.prata = prata;
	}

	public int getBronze() {
		return bronze;
	}

	public void setBronze(int bronze) {
		this.bronze = bronze;
	}
	public String getNomeModalidade() {
		return nomeModalidade;
	}

	public void setNomeModalidade(String nomeModalidade) {
		this.nomeModalidade = nomeModalidade;
	}

	@Override
	public String toString() {
		return "Olimpiada [id=" + id + ", idModalidade=" + idModalidade + ", nomeModalidade=" + nomeModalidade
				+ ", idAno=" + idAno + ", idPais=" + idPais + ", ouro=" + ouro + ", prata=" + prata + ", bronze="
				+ bronze + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bronze;
		result = prime * result + id;
		result = prime * result + idAno;
		result = prime * result + idModalidade;
		result = prime * result + idPais;
		result = prime * result + ((nomeModalidade == null) ? 0 : nomeModalidade.hashCode());
		result = prime * result + ouro;
		result = prime * result + prata;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Olimpiada other = (Olimpiada) obj;
		if (bronze != other.bronze)
			return false;
		if (id != other.id)
			return false;
		if (idAno != other.idAno)
			return false;
		if (idModalidade != other.idModalidade)
			return false;
		if (idPais != other.idPais)
			return false;
		if (nomeModalidade == null) {
			if (other.nomeModalidade != null)
				return false;
		} else if (!nomeModalidade.equals(other.nomeModalidade))
			return false;
		if (ouro != other.ouro)
			return false;
		if (prata != other.prata)
			return false;
		return true;
	}

	
	

	
}
