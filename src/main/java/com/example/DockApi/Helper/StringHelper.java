package com.example.DockApi.Helper;

public class StringHelper {

	public static boolean isNullOrEmpty(String valor)
	{
		if(valor != null)
		{
			return valor.isEmpty();
		}
		return true;
	}
	
	/**
	 * Função bem básica para teste de inteiro
	 * @param valor
	 * @return
	 */
	public static boolean isInt(String valor)
	{
		try
		{
			Integer.parseInt(valor);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static int getInt(String valor)
	{
		return Integer.parseInt(valor);
	}
	
	/**
	 * Função bem básica para teste de inteiro
	 * @param valor
	 * @return
	 */
	public static boolean isNullableInt(String valor)
	{
		if(!isNullOrEmpty(valor))
		{
			try
			{
				Integer.parseInt(valor);
				return true;
			}
			catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}
	
	public static Integer getNullableInt(String valor)
	{
		if(!isNullOrEmpty(valor))
		{
			return Integer.parseInt(valor);
		}
		return null;
	}
	
	
}
