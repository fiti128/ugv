package rw.ugv.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="USERIBD",name="STATIONS")
public class Stations implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6013539674613886218L;
	@Id
	@Column(name="STATION_NO")
	private String stationNumber;
	@Column(name="STATION_NAME")
	
	private String stationName;
	public String getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	
}
