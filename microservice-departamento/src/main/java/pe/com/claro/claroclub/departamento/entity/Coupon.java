package pe.com.claro.claroclub.departamento.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
public class Coupon implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private Integer id;
	
	@Column(name = "id_company")
	private Integer id_company;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "first_description")
	private String first_description;
	
	@Column(name = "second_description")
	private String second_description;
	
	@Column(name = "creation_date")
	private Date creation_date;
	
	@Column(name = "activation_date")
	private Date activation_date;
	
	@Column(name = "expiration_date")
	private Date expiration_date;
	
	@Column(name = "image_url")
	private String image_url;
	
	@Column(name = "image_path")
	private String image_path;
	
	@Column(name = "top")
	private Integer top;
	
	@Column(name = "id_console_user")
	private Integer id_console_user;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "image_name")
	private String image_name;
	
	@Column(name = "update_date")
	private Date update_date;
	
	@Column(name = "enabled_label")
	private BigDecimal enabled_label;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "unique_code")
	private BigDecimal unique_code;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "action")
	private String action;
	
	@Column(name = "code_qr")
	private String code_qr;
	
	@Column(name = "stock")
	private Integer stock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_company() {
		return id_company;
	}

	public void setId_company(Integer id_company) {
		this.id_company = id_company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirst_description() {
		return first_description;
	}

	public void setFirst_description(String first_description) {
		this.first_description = first_description;
	}

	public String getSecond_description() {
		return second_description;
	}

	public void setSecond_description(String second_description) {
		this.second_description = second_description;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getActivation_date() {
		return activation_date;
	}

	public void setActivation_date(Date activation_date) {
		this.activation_date = activation_date;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public Integer getId_console_user() {
		return id_console_user;
	}

	public void setId_console_user(Integer id_console_user) {
		this.id_console_user = id_console_user;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public BigDecimal getEnabled_label() {
		return enabled_label;
	}

	public void setEnabled_label(BigDecimal enabled_label) {
		this.enabled_label = enabled_label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BigDecimal getUnique_code() {
		return unique_code;
	}

	public void setUnique_code(BigDecimal unique_code) {
		this.unique_code = unique_code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getCode_qr() {
		return code_qr;
	}

	public void setCode_qr(String code_qr) {
		this.code_qr = code_qr;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
