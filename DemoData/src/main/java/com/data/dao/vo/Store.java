/**
 * 
 */
package com.data.dao.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class Store implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "store_name")
	private String storeName;

	@Column(name = "store_num")
	private String storeNumber;

	@Id
	@Column(name = "id")
	private long id;

	public Store() {

	}

	public Store(String storeName, String storeNumber, long id) {
		this.storeName = storeName;
		this.storeNumber = storeNumber;
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Store{");
		sb.append("; storeName='").append(storeName).append('\'');
		sb.append("; storeNumber='").append(storeNumber).append('\'');
		sb.append("; id='").append(id).append('\'');
		sb.append('}');
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Store store = (Store) o;

		return storeName.equals(store.storeName);
	}

	@Override
	public int hashCode() {
		return storeName.hashCode();
	}
}
