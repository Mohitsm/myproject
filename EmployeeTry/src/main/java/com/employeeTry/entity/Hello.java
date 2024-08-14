package com.employeeTry.entity;

import java.time.LocalDateTime;

import com.employeeTry.config.CustomLocalDateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
public class Hello {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long employeeId;
	    private String employeeName;

	    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
	    private LocalDateTime punchIn;
	    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
	    private LocalDateTime punchOut;
	    private String status;

}
