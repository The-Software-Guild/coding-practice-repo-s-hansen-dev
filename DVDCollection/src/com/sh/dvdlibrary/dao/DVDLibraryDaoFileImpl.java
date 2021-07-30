package com.sh.dvdlibrary.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sh.dvdlibrary.dto.DVD;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao{

	private Map<String, DVD> collection = new HashMap<>();
	
	@Override
	public DVD addDVD(String dvdTitle, DVD dvd) {
		DVD prevDVD = collection.put(dvdTitle, dvd);
		return prevDVD;
	}

	@Override
	public List<DVD> getAllDVDs() {
		return new ArrayList<DVD>(collection.values());
	}

	@Override
	public DVD getDVD(String dvdTitle) {
		return collection.get(dvdTitle);
	}

	@Override
	public DVD removeDVD(String dvdTitle) {
		DVD removedDVD = collection.remove(dvdTitle);
		return removedDVD;
	}
	
	@Override
	public boolean searchCollection(String dvdTitle) {
		return collection.containsKey(dvdTitle);
	}

}
