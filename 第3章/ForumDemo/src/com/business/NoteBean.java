package com.business;

import java.util.List;
import com.dao.NoteDAO;

public class NoteBean {
	
	public List findAllNotes() {
		try {
			NoteDAO noteDAO = new NoteDAO();
			return noteDAO.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
