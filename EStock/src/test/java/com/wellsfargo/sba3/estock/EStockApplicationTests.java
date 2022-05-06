package com.wellsfargo.sba3.estock;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wellsfargo.sba3.estock.repository.CompanyDetailsRepo;
import com.wellsfargo.sba3.estock.repository.StockPriceDetailsRepo;
import com.wellsfargo.sba3.estock.service.CompanyServiceImpl;
import com.wellsfargo.sba3.estock.service.StockServiceImpl;

@SpringBootTest
class EStockApplicationTests {

	@Test
	void contextLoads() {
	}

}
