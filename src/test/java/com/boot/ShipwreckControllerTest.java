package com.boot;

import static org.junit.Assert.assertEquals;
import com.boot.controller.ShipwerckController;
import com.boot.model.Shipwreck;

import com.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class ShipwreckControllerTest {
    @InjectMocks
    private ShipwerckController sc;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipWreckGet()
    {
        Shipwreck sw = new Shipwreck();
        sw.setId(1l);
        when(shipwreckRepository.getOne(1l)).thenReturn(sw);

        Shipwreck wreck = sc.get(1L);
        verify(shipwreckRepository).getOne(1l);
        assertEquals(1l, wreck.getId().longValue());
    }
}
