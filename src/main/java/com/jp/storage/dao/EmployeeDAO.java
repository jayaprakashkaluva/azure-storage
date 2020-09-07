package com.jp.storage.dao;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.jp.storage.constants.StorageConstants;
import com.jp.storage.entity.Employee;
import com.jp.storage.util.EmployeeUtil;
import com.jp.storage.vo.EmployeeVO;
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.table.*;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class EmployeeDAO {

	@Value("${connectionString}")
	private String ConnectionString;

	public void insert(EmployeeVO vo) {
		try {
			// Retrieve storage account from connection-string.
			Employee employee = EmployeeUtil.toEntity(vo);
			CloudTable cloudTable = getTable(StorageConstants.EMPLOYEE_MASTER);
			// Create an operation to add the new employee to the employee table.
			employee.setRowKey(UUID.randomUUID().toString());
			employee.setPartitionKey(vo.getDept());
			TableOperation insertCustomer1 = TableOperation.insertOrReplace(employee);
			// Submit the operation to the table service.
			cloudTable.execute(insertCustomer1);
		} catch (Exception e) {
			log.error("unable to persist employee", e);
		}
	}

	private CloudTable getTable(String tableName) throws InvalidKeyException, URISyntaxException, StorageException {
		CloudStorageAccount storageAccount = CloudStorageAccount.parse(ConnectionString);
		// Create the table client.
		CloudTableClient tableClient = storageAccount.createCloudTableClient();
		// Create a cloud table object for the table.
		return tableClient.getTableReference(tableName);
	}
}
