package rw.obd.beans;

import javax.validation.constraints.Pattern;

public class SqlQuery {
	@Pattern(regexp=".*^((?!drop).)*$.*")
	private String sql;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	
}
