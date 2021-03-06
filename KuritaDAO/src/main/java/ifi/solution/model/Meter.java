package ifi.solution.model;
// Generated Mar 30, 2018 9:17:26 AM by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.*;

/**
 * Meter generated by hbm2java
 */
@Entity
@Table(name = "meter", catalog = "kurita")
public class Meter implements java.io.Serializable {

	private Integer id;
	private String type;
	private String parameter;
	private Set<Value> values = new HashSet<Value>(0);

	public Meter() {
	}

	public Meter(String type, String parameter) {
		this.type = type;
		this.parameter = parameter;
	}

	public Meter(String type, String parameter, Set<Value> values) {
		this.type = type;
		this.parameter = parameter;
		this.values = values;
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

	@Column(name = "type", nullable = false, length = 55)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "parameter", nullable = false, length = 45)
	public String getParameter() {
		return this.parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "meter")
	@JsonIgnore
	public Set<Value> getValues() {
		return this.values;
	}

	public void setValues(Set<Value> values) {
		this.values = values;
	}

}
