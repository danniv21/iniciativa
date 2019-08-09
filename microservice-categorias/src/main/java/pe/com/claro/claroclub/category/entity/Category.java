package pe.com.claro.claroclub.category.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    private Long id;
	
    @Column(name = "name")
    private String name;
    
    @Column(name = "order_cat")
    private int order_cat;
    
    @Column(name = "enabled")
    private int enable;
    
    @Column(name = "start_date")
    private Date start_date;
    
    @Column(name = "end_date")
    private Date end_date;
    
    @Column(name = "url_image")
    private String url_image;
    
    @Column(name = "url_image_selected")
    private String url_image_selected;
    
    @Column(name = "color_image")
    private String color_image;
    
	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public String getColor_image() {
		return color_image;
	}

	public void setColor_image(String color_image) {
		this.color_image = color_image;
	}

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

	public int getOrder_cat() {
		return order_cat;
	}

	public void setOrder_cat(int order_cat) {
		this.order_cat = order_cat;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getUrl_image_selected() {
		return url_image_selected;
	}

	public void setUrl_image_selected(String url_image_selected) {
		this.url_image_selected = url_image_selected;
	}
}
