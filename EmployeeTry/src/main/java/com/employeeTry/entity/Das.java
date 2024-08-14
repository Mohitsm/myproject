package com.employeeTry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Das {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dasId;
	private String name;
	private String age;
	

}
