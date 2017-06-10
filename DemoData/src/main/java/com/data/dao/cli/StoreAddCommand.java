
package com.data.dao.cli;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

import com.data.dao.api.StoreDao;
import com.data.dao.vo.Store;



@Command(scope = "store", name = "add", description = "Add store")
@Service
public class StoreAddCommand implements Action {

	@Reference
	private StoreDao storeDao;

	public StoreAddCommand() {
	}

	@Argument(index = 0, name = "storeName", description = "store name", required = true, multiValued = false)
	String name = null;

	@Argument(index = 1, name = "storeNumber", description = "store number", required = true, multiValued = false)
	String number = null;

	@Override
	public Object execute() throws Exception {
		Store store = new Store();
		store.setId(1);
		store.setStoreName(name);
		store.setStoreNumber(number);
		Store addedStore = storeDao.addStore(store);

		System.out.println("Added Store =" + addedStore);
		return null;
	}

	public StoreDao getStoreDao() {
		return storeDao;
	}

	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}

}
