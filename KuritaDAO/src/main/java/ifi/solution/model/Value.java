package ifi.solution.model;
// Generated Mar 30, 2018 9:17:26 AM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Value generated by hbm2java
 */
@Entity
@Table(name = "value", catalog = "kurita")
public class Value implements java.io.Serializable {

	private Integer id;
	private Meter meter;
	private double min;
	private double aver;
	private double max;
	private double stDev;
	private Date date;
	private Set<Event> events = new HashSet<Event>(0);

	public Value() {
	}

	public Value(Meter meter, double min, double aver, double max, double stDev, Date date) {
		this.meter = meter;
		this.min = min;
		this.aver = aver;
		this.max = max;
		this.stDev = stDev;
		this.date = date;
	}

	public Value(Meter meter, double min, double aver, double max, double stDev, Date date, Set<Event> events) {
		this.meter = meter;
		this.min = min;
		this.aver = aver;
		this.max = max;
		this.stDev = stDev;
		this.date = date;
		this.events = events;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "meterId", nullable = false)
	public Meter getMeter() {
		return this.meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}

	@Column(name = "min", nullable = false, precision = 22, scale = 0)
	public double getMin() {
		return this.min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	@Column(name = "aver", nullable = false, precision = 22, scale = 0)
	public double getAver() {
		return this.aver;
	}

	public void setAver(double aver) {
		this.aver = aver;
	}

	@Column(name = "max", nullable = false, precision = 22, scale = 0)
	public double getMax() {
		return this.max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	@Column(name = "stDev", nullable = false, precision = 22, scale = 0)
	public double getStDev() {
		return this.stDev;
	}

	public void setStDev(double stDev) {
		this.stDev = stDev;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "value")
	public Set<Event> getEvents() {
		return this.events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

}
