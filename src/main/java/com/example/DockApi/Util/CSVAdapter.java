package com.example.DockApi.Util;

/**
 * Classe que representa um CSV e pode ser utilizada para
 *   validar e preparar conversões para objetos.
 *   
 *   Deve-se chamar o método de validar para configuração interna
 * @author Vitor
 *
 */
public class CSVAdapter {

	private String entrada;
	
	private String[] arrayColuna;
	private int numColuna;
	
	public CSVAdapter(String _entrada)
	{
		this.entrada = _entrada;
	}
	
	public int getLength()
	{
		return this.numColuna;
	}
	
	public void Validar()
	{
		this.arrayColuna = entrada.split(";");
		this.numColuna = arrayColuna.length;
	}
	
	public String get(int indexColuna)
	{
		return this.arrayColuna[indexColuna];
	}
	
}
