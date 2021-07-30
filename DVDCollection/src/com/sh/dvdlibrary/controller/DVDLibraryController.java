package com.sh.dvdlibrary.controller;

import java.util.List;

import com.sh.dvdlibrary.dao.DVDLibraryDao;
import com.sh.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sh.dvdlibrary.dto.DVD;
import com.sh.dvdlibrary.ui.DVDLibraryView;
import com.sh.dvdlibrary.ui.UserIO;
import com.sh.dvdlibrary.ui.UserIOConsoleImpl;

/**
 * In this assessment, you will create a program that stores information about a DVD collection. 
 * The program must do the following:
 * Allow the user to add a DVD to the collection
 * Allow the user to remove a DVD from the collection
 * Allow the user to edit the information for an existing DVD in the collection
 * Allow the user to list the DVDs in the collection
 * Allow the user to display the information for a particular DVD
 * Allow the user to search for a DVD by title
 * Load the DVD library from a file
 * Save the DVD library back to the file when the program completes
 * Allow the user to add, edit, or delete many DVDs in one session
 * @author sarahhansen
 */

public class DVDLibraryController {
	
	private DVDLibraryView view = new DVDLibraryView();
	private DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
	private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
        	
        	menuSelection = getMenuSelection();
 
            switch (menuSelection) {
                case 1:
                    listDVDs();
                    break;
                case 2:
                    createDVD();
                    break;
                case 3:
                    io.print("EDIT DVDS");
                    break;
                case 4:
                    removeDVD();
                    break;
                case 5:
                	viewDVD();
                	break;
                case 6:
                	io.print("LOAD DVDS FROM FILE");
                	break;
                case 7:
                	io.print("SAVE DVDS TO FILE");
                	break;
                case 8:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }

	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}
	
	private void createDVD() {
		view.displayAddDVDBanner();
		DVD newDVD = view.getNewDVDInfo();
		dao.addDVD(newDVD.getTitle(), newDVD);
		view.displayAddSuccessBanner();
	}
	
	private void listDVDs() {
		view.displayDisplayAllBanner();
		List<DVD> dvdList = dao.getAllDVDs();
		view.displayDVDList(dvdList);
	}
	
	private void viewDVD() {
		view.displayDisplayDVDBanner();
		String dvdTitle = view.getDVDTitleChoice();
		DVD dvd = dao.getDVD(dvdTitle);
		view.displayDVD(dvd);
	}
	
	private void removeDVD() {
		view.displayRemoveDVDBanner();
		String dvdTitle = view.getDVDTitleChoice();
		DVD removedDVD = dao.removeDVD(dvdTitle);
		view.displayRemoveResult(removedDVD);
	}
	
}
