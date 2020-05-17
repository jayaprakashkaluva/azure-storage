package com.jp.storage.entity;

import com.microsoft.azure.storage.table.TableServiceEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends TableServiceEntity{

	private String name;
	private String dept;
}
