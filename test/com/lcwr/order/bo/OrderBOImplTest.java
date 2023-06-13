package com.lcwr.order.bo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import com.lcwr.order.bo.exception.BOException;
import com.lcwr.order.dao.OrderDAO;
import com.lcwr.order.dto.Order;

public class OrderBOImplTest {

	@Mock
	OrderDAO dao;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
		
		OrderBOImpl bo = new OrderBOImpl();
		bo.setDao(dao);

		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(1));
		
		boolean result = bo.placeOrder(order);
		
		assertTrue(result);
		verify(dao).create(order);
	}
	
	

}
