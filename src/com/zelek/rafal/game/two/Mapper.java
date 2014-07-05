package com.zelek.rafal.game.two;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
	protected Map<Class<? extends Cell>, String> cellsMap = new HashMap<Class<? extends Cell>, String>();
	
	public Mapper(Map<Class<? extends Cell>, String> hashMap){
		this.cellsMap = hashMap;
	}
	
	protected Mapper(){
	}


	public String map(Class<? extends Cell> cellType){
		return cellsMap.get(cellType);
	}
}
