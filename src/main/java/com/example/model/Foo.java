package com.example.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="FOO")
public class Foo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long entityId;
	
	@Version
	@Column(name="VERSION")
	private Integer version;

	@Column(name="BAA")
	private String baa;
	
	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name = "value", column = @Column(name = "BIRTH_MONTH")),
//	})
	private Month birthMonth;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "start.value", column = @Column(name = "CURRENT_START_MONTH")),
		@AttributeOverride(name = "end.value", column = @Column(name = "CURRENT_END_MONTH")),
	})
	private MonthRange currentMonthRange;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "start.value", column = @Column(name = "PREVIOUS_START_MONTH")),
		@AttributeOverride(name = "end.value", column = @Column(name = "PREVIOUS_END_MONTH")),
	})
	private MonthRange previousMonthRange;
}
