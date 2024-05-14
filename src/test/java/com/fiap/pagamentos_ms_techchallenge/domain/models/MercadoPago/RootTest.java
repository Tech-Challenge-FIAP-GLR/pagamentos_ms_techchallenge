package com.fiap.pagamentos_ms_techchallenge.domain.models.MercadoPago;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RootTest {

    @Test
    public void testGettersAndSetters() {
        CashOut cashOut = new CashOut();
        String description = "Description";
        String externalReference = "Reference123";
        ArrayList<Item> items = new ArrayList<>();
        String title = "Title";
        float totalAmount = 100.0f;

        Root root = new Root();
        root.setCash_out(cashOut);
        root.setDescription(description);
        root.setExternal_reference(externalReference);
        root.setItems(items);
        root.setTitle(title);
        root.setTotal_amount(totalAmount);

        assertNotNull(root.getCash_out());
        assertEquals(cashOut, root.getCash_out());
        assertEquals(description, root.getDescription());
        assertEquals(externalReference, root.getExternal_reference());
        assertEquals(items, root.getItems());
        assertEquals(title, root.getTitle());
        assertEquals(totalAmount, root.getTotal_amount(), 0.01);
    }
}
