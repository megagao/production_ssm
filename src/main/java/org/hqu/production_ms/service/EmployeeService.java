package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface EmployeeService {

	//ListKeeper
	EUDataGridResult getListKeeper();
	
	//ListMaintainEmp
	EUDataGridResult getListMaintainEmp();
    
}
