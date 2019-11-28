package treinamento.exception;

import java.util.Date;

public class CategoriaRestCostimizado {
	private Date data;
	private String mensagem;
	private String descricao;

	public CategoriaRestCostimizado(Date data, String mensagem, String descricao) {
		this.setData(data);
		this.setMensagem(mensagem);
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return this.descricao;

	}
	
	public void setDescricao(String description) {
		this.descricao = description;

	}

	public Date getData() {
		return data;
	}

	public void setData(Date date) {
		this.data = date;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String message) {
		this.mensagem = message;
	}

}
