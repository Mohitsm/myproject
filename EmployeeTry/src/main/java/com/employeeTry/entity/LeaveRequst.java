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
public class LeaveRequst {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lRId;
	private String leaveType;
	private String remark;
	private String leaveFrom;
	private String leaveTo;
	

}
