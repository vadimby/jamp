package by.epam.jamp.vvd.testapp.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestData {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String key;

	@Column(nullable = false)
	private String value;

	protected TestData() {
	}

	public TestData(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
