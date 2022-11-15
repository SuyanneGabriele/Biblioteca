package classes;

public class Acervo {

	private int id;
	private String tipoItem;
	private int idItem;

	public Acervo(int id, String tipoItem, int idItem) {
		super();
		this.id = id;
		this.tipoItem = tipoItem;
		this.idItem = idItem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

}
