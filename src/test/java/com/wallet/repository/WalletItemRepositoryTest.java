package com.wallet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wallet.model.Wallet;
import com.wallet.model.WalletItem;
import com.wallet.util.enums.TypeEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class WalletItemRepositoryTest {
	
	private static final Date DATE = new Date();
	private static final TypeEnum TYPE = TypeEnum.EN;
	private static final String DESCRIPTION = "Conta de Luz";
	private static final BigDecimal VALUE = BigDecimal.valueOf(65);
	
	@Autowired
	WalletItemRepository repository;
	@Autowired
	WalletRepository walletRepository;
	
	@Test
	public void testSave() {
		
		Wallet w = new Wallet();
		w.setName("Carteira 1");
		w.setValue(BigDecimal.valueOf(500));
		walletRepository.save(w);
		
		WalletItem wi = new WalletItem(1L, w, DATE, TYPE, DESCRIPTION, VALUE);
		
		WalletItem response = repository.save(wi);
		
		assertNotNull(response);
		assertEquals(response.getDescription(), DESCRIPTION);
		assertEquals(response.getType(), TYPE);
		assertEquals(response.getValue(), VALUE);
		assertEquals(response.getWallet().getId(), w.getId());
		
	}
}