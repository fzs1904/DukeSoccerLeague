package duke.soccer.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import duke.soccer.model.League;

public class LeagueRowMapper implements RowMapper<League>{

	public League mapRow(ResultSet rs, int rowNum) throws SQLException {
		League league = new League();
		league.setYear(rs.getInt("year"));
		league.setSeason(rs.getString("season"));
		league.setTitle(rs.getString("title"));
		return league;
	}

}