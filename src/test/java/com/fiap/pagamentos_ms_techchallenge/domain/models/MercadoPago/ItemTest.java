package com.fiap.pagamentos_ms_techchallenge.domain.models.MercadoPago;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void testGettersAndSetters() {
        String skuNumber = "SKU123";
        String category = "Food";
        String title = "Combo 1";
        String description = "Combo cliente x";
        float unitPrice = 500.0f;
        int quantity = 2;
        String unitMeasure = "unt";
        float totalAmount = unitPrice * quantity;

        Item item = new Item();
        item.setSku_number(skuNumber);
        item.setCategory(category);
        item.setTitle(title);
        item.setDescription(description);
        item.setUnit_price(unitPrice);
        item.setQuantity(quantity);
        item.setUnit_measure(unitMeasure);
        item.setTotal_amount(totalAmount);

        assertEquals(skuNumber, item.getSku_number());
        assertEquals(category, item.getCategory());
        assertEquals(title, item.getTitle());
        assertEquals(description, item.getDescription());
        assertEquals(unitPrice, item.getUnit_price(), 0.01);
        assertEquals(quantity, item.getQuantity());
        assertEquals(unitMeasure, item.getUnit_measure());
        assertEquals(totalAmount, item.getTotal_amount(), 0.01);
    }

    @Test
    public void testMockito() {
        String mockedSkuNumber = "MOCKEDSKU";
        String mockedCategory = "MOCKEDCATEGORY";
        String mockedTitle = "MOCKEDTITLE";
        String mockedDescription = "MOCKEDDESCRIPTION";
        float mockedUnitPrice = 10.0f;
        int mockedQuantity = 5;
        String mockedUnitMeasure = "MOCKEDMEASURE";
        float mockedTotalAmount = mockedUnitPrice * mockedQuantity;

        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getSku_number()).thenReturn(mockedSkuNumber);
        Mockito.when(item.getCategory()).thenReturn(mockedCategory);
        Mockito.when(item.getTitle()).thenReturn(mockedTitle);
        Mockito.when(item.getDescription()).thenReturn(mockedDescription);
        Mockito.when(item.getUnit_price()).thenReturn(mockedUnitPrice);
        Mockito.when(item.getQuantity()).thenReturn(mockedQuantity);
        Mockito.when(item.getUnit_measure()).thenReturn(mockedUnitMeasure);
        Mockito.when(item.getTotal_amount()).thenReturn(mockedTotalAmount);

        assertEquals(mockedSkuNumber, item.getSku_number());
        assertEquals(mockedCategory, item.getCategory());
        assertEquals(mockedTitle, item.getTitle());
        assertEquals(mockedDescription, item.getDescription());
        assertEquals(mockedUnitPrice, item.getUnit_price(), 0.01);
        assertEquals(mockedQuantity, item.getQuantity());
        assertEquals(mockedUnitMeasure, item.getUnit_measure());
        assertEquals(mockedTotalAmount, item.getTotal_amount(), 0.01);
    }
}
