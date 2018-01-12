package org.arkanum.services;


public class GameCharacterService {
	
	 
	private static GameCharacterService _service = null;
	
	private GameCharacterService() {}
	
	
	
	public static GameCharacterService get()
	{
		if(_service == null) _service = new GameCharacterService();
		return _service;
	}

}
