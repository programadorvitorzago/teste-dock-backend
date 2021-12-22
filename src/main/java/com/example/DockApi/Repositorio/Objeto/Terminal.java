package com.example.DockApi.Repositorio.Objeto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.example.DockApi.Repositorio.Objeto.Base.Terminal__Base;

@Entity
@Table(name = "tblTerminal")
public class Terminal extends Terminal__Base {

	@Override
	public String toString() {
		return "Terminal [logic=" + getLogic() + ", serial=" + getSerial() + ", model=" + getModel() + "]";
	}

}
