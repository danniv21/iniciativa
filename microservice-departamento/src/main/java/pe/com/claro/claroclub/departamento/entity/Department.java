package pe.com.claro.claroclub.departamento.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
	@OrderBy
    private Long id;
	
    @Column(name = "name")
    private String name;
    
    @Column(name = "creation_date")
    private Date creation_date;
    
    @Column(name = "modification_date")
    private Date modification_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getModification_date() {
		return modification_date;
	}

	public void setModification_date(Date modification_date) {
		this.modification_date = modification_date;
	}
	
}
