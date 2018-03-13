package com.company.dungeon.save;

import java.util.List;

public interface SaveRepository {
	
	boolean persist(Save save);
	List<Save> list();
}
