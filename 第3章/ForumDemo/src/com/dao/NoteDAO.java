package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.domain.Note;

public class NoteDAO {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/forumDemo", "root", "123456");
		return connection;
	}

	public List<Note> findAll() throws Exception {
		Connection con = getConnection();
		String sql = "select id,title,content,author,create_time from notes";
		Statement sta = con.createStatement();
		ResultSet rs = sta.executeQuery(sql);
		List<Note> notes = new ArrayList<Note>();
		while (rs.next()) {
			Note tn = new Note();
			tn.setId(rs.getInt("id"));
			tn.setTitle(rs.getString("title"));
			tn.setContent(rs.getString("content"));
			tn.setAuthor(rs.getString("author"));
			tn.setCreateTime(rs.getTimestamp("create_time"));
			notes.add(tn);
		}
		con.close();
		return notes;
	}

}
