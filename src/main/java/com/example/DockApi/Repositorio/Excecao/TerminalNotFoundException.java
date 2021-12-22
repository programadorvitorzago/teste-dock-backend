package com.example.DockApi.Repositorio.Excecao;

public class TerminalNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TerminalNotFoundException (Integer logic) {
	    super("Não encontrado terminal com logic=" + logic);
	}
}
