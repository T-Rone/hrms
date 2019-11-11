package org.fkit.hrm.domain;

import java.io.Serializable;

public class Sal implements Serializable {
		private Integer id;
		private Integer month;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getMonth() {
			return month;
		}
		public void setMonth(Integer month) {
			this.month = month;
		}
		
		@Override
		public String toString() {
			return "Sal [id=" + id + ", month=" + month + "]";
		}
}
