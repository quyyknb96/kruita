package ifi.solution.model;
// Generated Mar 30, 2018 9:17:26 AM by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Event generated by hbm2java
 */
@Entity
@Table(name = "event", catalog = "kurita")
public class Event implements java.io.Serializable {

	private Integer id;
	private Author author;
	private Value value;
	private String type;
	private String comment;

	public Event() {
	}

	public Event(Author author, Value value, String type) {
		this.author = author;
		this.value = value;
		this.type = type;
	}

	public Event(Author author, Value value, String type, String comment) {
		this.author = author;
		this.value = value;
		this.type = type;
		this.comment = comment;
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
	@JoinColumn(name = "authorId", nullable = false)
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "valueId", nullable = false)
	public Value getValue() {
		return this.value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	@Column(name = "type", nullable = false, length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "comment")
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
