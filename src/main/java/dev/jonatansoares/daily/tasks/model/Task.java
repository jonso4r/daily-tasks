package dev.jonatansoares.daily.tasks.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OrderBy;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy(clause = "id ASC")
	private Long id;

	@Column(name = "date", nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "O campo data de atividade é obrigatório")
	private Date date;

	@Size(min = 10, max = 130, message = "O campo descrição deve conter entre 10 e 130 caracteres")
	private String description;

	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "quantity_hours", nullable = false)
	@Temporal(TemporalType.TIME)
	@NotNull(message = "O campo quantidade de horas é obrigatório")
	private Date quantityHours;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getQuantityHours() {
		return quantityHours;
	}

	public void setQuantityHours(Date quantityHours) {
		this.quantityHours = quantityHours;
	}
}
