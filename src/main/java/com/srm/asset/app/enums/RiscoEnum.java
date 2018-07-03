package com.srm.asset.app.enums;

public enum RiscoEnum {
	
	A,
	B,
	C;

	public static RiscoEnum getRisco(String descricao) {
		for (RiscoEnum perfil : RiscoEnum.values()) {
			  if(perfil.name().equals(descricao)) {
				  return perfil;
			  }
			}
		return A;
	}
	
}
