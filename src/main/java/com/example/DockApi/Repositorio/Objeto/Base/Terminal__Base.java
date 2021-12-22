package com.example.DockApi.Repositorio.Objeto.Base;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
@Table(name = "tblTerminal")
public abstract class Terminal__Base implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private @Id Integer logic;
	private String serial;
	private String model;
	private Integer sam;
	private String ptid;
	private Integer plat;
	private String version;
	private Integer mxr;
	private Integer mxf;
	private String PVERFM;

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logic == null) ? 0 : logic.hashCode());
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
		Terminal__Base other = (Terminal__Base) obj;
		if (logic == null) {
			if (other.logic != null)
				return false;
		} else if (!logic.equals(other.logic))
			return false;
		return true;
	}
	
	// GS
	public Integer getLogic() {
		return logic;
	}
	public void setLogic(Integer logic) {
		this.logic = logic;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getSam() {
		return sam;
	}
	public void setSam(Integer sam) {
		this.sam = sam;
	}
	
	public String getPtid() {
		return ptid;
	}
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}
	public Integer getPlat() {
		return plat;
	}
	public void setPlat(Integer plat) {
		this.plat = plat;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Integer getMxr() {
		return mxr;
	}
	public void setMxr(Integer mxr) {
		this.mxr = mxr;
	}
	public Integer getMxf() {
		return mxf;
	}
	public void setMxf(Integer mxf) {
		this.mxf = mxf;
	}
	public String getPVERFM() {
		return PVERFM;
	}
	public void setPVERFM(String pVERFM) {
		PVERFM = pVERFM;
	}
}
