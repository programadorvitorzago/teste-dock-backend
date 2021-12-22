package com.example.DockApi.Controlador;

import com.example.DockApi.DockApiApplication;
import com.example.DockApi.Helper.StringHelper;
import com.example.DockApi.Repositorio.RepositorioDockApi;
import com.example.DockApi.Repositorio.Objeto.Terminal;
import com.example.DockApi.Util.CSVAdapter;

public class ControladorTerminal {

	public static Terminal insert(RepositorioDockApi rep, Terminal terminalToInsert)
	{
			
		// Persistindo
		return rep.save(terminalToInsert);
	}
	
	public static Terminal update(RepositorioDockApi rep, Terminal original, Terminal terminalToEdit)
	{
		/* 01 */ original.setLogic(terminalToEdit.getLogic());
		/* 02 */ original.setSerial(terminalToEdit.getSerial());
		/* 03 */ original.setModel(terminalToEdit.getModel());
		/* 04 */ original.setSam(terminalToEdit.getSam());
		/* 05 */ original.setPtid(terminalToEdit.getPtid());
		/* 06 */ original.setPlat(terminalToEdit.getPlat());
		/* 07 */ original.setVersion(terminalToEdit.getVersion());
		/* 08 */ original.setMxr(terminalToEdit.getMxr());
		/* 09 */ original.setMxf(terminalToEdit.getMxf());
		/* 10 */ original.setPVERFM(terminalToEdit.getPVERFM());
		
		// Persistindo
		return rep.save(original);
	}
	
	public static void delete(RepositorioDockApi rep, Terminal terminalToDelete)
	{
		// Persistindo
		rep.delete(terminalToDelete);
	}
	
	public static void ValidarTerminalDeCSV(CSVAdapter csv)
	{
		csv.Validar();
		
		if(csv.getLength() != 10)
		{
			throw new RuntimeException("Entrada em estrutura CSV deve conter 10 células.");
		}
		
		// Fazer a Validação Dinâmica Item 3.e
		if(!StringHelper.isInt(csv.get(0)))
		{
			throw new RuntimeException("Atributo LOGIC deve ser um inteiro.");
		}
		
		if(StringHelper.isNullOrEmpty(csv.get(1)))
		{
			throw new RuntimeException("Atributo SERIAL não pode ser vazio.");
		}
		
		if(StringHelper.isNullOrEmpty(csv.get(2)))
		{
			throw new RuntimeException("Atributo MODEL não pode ser vazio.");
		}
		
		if(!StringHelper.isNullableInt(csv.get(3)))
		{
			throw new RuntimeException("Atributo SAM deve ser nulo ou inteiro.");
		}
		else
		{
			// Se chegou até aqui é um inteiro anulável o valor de SAM
			if(StringHelper.isInt(csv.get(3)))
			{
				int valorSam = StringHelper.getInt(csv.get(3));
				if(valorSam < 0)
				{
					throw new RuntimeException("O valor de SAM deve ser no mínimo 0.");
				}
			}
		}
		
//		if(!StringHelper.isNullableInt(csv.get(4)))
//		{
//			throw new RuntimeException("Atributo PTID deve ser nulo ou inteiro.");
//		}
		
		if(!StringHelper.isNullableInt(csv.get(5)))
		{
			throw new RuntimeException("Atributo PLAT deve ser nulo ou inteiro.");
		}
		
		if(StringHelper.isNullOrEmpty(csv.get(6)))
		{
			throw new RuntimeException("Atributo VERSION não pode ser vazio.");
		}
		
		if(!StringHelper.isNullableInt(csv.get(7)))
		{
			throw new RuntimeException("Atributo MXR deve ser nulo ou inteiro.");
		}
		
		if(!StringHelper.isNullableInt(csv.get(8)))
		{
			throw new RuntimeException("Atributo MXF deve ser nulo ou inteiro.");
		}
		
	}
	
	public static Terminal getTerminalDeCSV(CSVAdapter csv)
	{
		Terminal t;
		
		t = new Terminal();
		/* 01 */ t.setLogic(StringHelper.getInt(csv.get(0)));
		/* 02 */ t.setSerial(csv.get(1));
		/* 03 */ t.setModel(csv.get(2));
		/* 04 */ t.setSam(StringHelper.getNullableInt(csv.get(3)));
		/* 05 */ t.setPtid(csv.get(4));
		/* 06 */ t.setPlat(StringHelper.getNullableInt(csv.get(5)));
		/* 07 */ t.setVersion(csv.get(6));
		/* 08 */ t.setMxr(StringHelper.getNullableInt(csv.get(7)));
		/* 09 */ t.setMxf(StringHelper.getNullableInt(csv.get(8)));
		/* 10 */ t.setPVERFM(csv.get(9));
		
		return t;
	}
}
