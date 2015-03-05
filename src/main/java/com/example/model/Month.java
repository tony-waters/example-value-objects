package com.example.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.example.exception.DomainException;

@Embeddable
public class Month implements Comparable {
	
	@Column(name="MONTH", length=6)
	private final String value;

	public Month(String value) {
		if(!isValid(value)) {
			throw new DomainException("Not a valid month " + value);
		}
		this.value = value;
	}

	public static boolean isValid(String value) {
		if (value == null || !isInteger(value) || !(value.length() == 6)) {
			return false;
		}
		return true;
	}
	
	public String getMonthAsString() {
		return value;
	}

	private static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Object o) {
		if(o == null) {
			throw new NullPointerException();
		}
		Month other = (Month)o;
		Integer thisMonth = Integer.valueOf(this.value);
		Integer otherMonth = Integer.valueOf(other.getMonthAsString());
		if(thisMonth > otherMonth) {
			return 1;
		} else if(thisMonth < otherMonth) {
			return -1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Month other = (Month) obj;
		if (value == null) {
			if (other.value != null) return false;
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}
}
