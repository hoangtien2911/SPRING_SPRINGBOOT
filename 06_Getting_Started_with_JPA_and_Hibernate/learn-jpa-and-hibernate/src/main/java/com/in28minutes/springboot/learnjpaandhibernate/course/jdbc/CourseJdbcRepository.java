package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	
	class CourseRowMapper implements RowMapper<Course> {

		@Override
		public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
			Course course = new Course();
			course.setId(rs.getLong("id"));
			course.setName(rs.getString("name"));
			course.setAuthor(rs.getString("author"));
			return null;
		}
	}
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	// """ text block
	
	private static String SELECT_QUERY =
			"""
			SELECT id, name, author FROM COURSE WHERE ID = ?	
			""";
	private static String INSERT_QUERY =
			"""
			INSERT INTO COURSE (id, name, author)
			VALUES (?, ?, ?);
			""";
	private static String DELETE_QUERY =
			"""
			DELETE FROM COURSE WHERE ID = ?		
			""";
	public Course findById(long id) {		
		//ResultSet -> Bean => Row Mapper => 
//		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new CourseRowMapper(), id);
	}
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY,
				course.getId(), course.getName(), course.getAuthor());
	}
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
}
