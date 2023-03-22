package kr.or.connect.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.dto.TodoDto;


public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	
	public int addTodo(TodoDto todo) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(" INSERT INTO todo");
		builder.append("   (title, name, sequence)");
		builder.append("   VALUES");
		builder.append("   (?, ?, ?)");
		String sql = builder.toString();
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql);){
			
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());
			
			insertCount = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return insertCount;
	}
	
	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT id,");
		builder.append("   title,");
		builder.append("   name,");
		builder.append("   sequence,");
		builder.append("   type,");
		builder.append("   regdate");
		builder.append(" FROM todo");
		builder.append(" ORDER BY regdate desc");
		String sql = builder.toString();
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			try (ResultSet rs = ps.executeQuery()) {
				
				while(rs.next()) {
					long id = rs.getLong("id");
					String title = rs.getString("title");
					String name = rs.getString("name");
					int sequence = rs.getInt("sequence");
					String type = rs.getString("type");
					String regDate = rs.getString("regdate");
					TodoDto todo = new TodoDto(id, name, regDate, sequence, title, type);
					list.add(todo);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int updateTodo(TodoDto todo) {
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "UPDATE todo SET type = ? where id = ?";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, todo.getType());
			ps.setLong(2, todo.getId());
			
			updateCount = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return updateCount;
	}
}
