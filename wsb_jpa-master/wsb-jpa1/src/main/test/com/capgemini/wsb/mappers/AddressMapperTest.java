package com.capgemini.wsb.mappers;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.mapper.AddressMapper;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.testng.annotations.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class AddressMapperTest {

    @Test
    public void testMapToTO() {

        // given //
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(1L);
        addressEntity.setAddressLine1("Wieliczkowa");
        addressEntity.setAddressLine2("przydrożna 2");
        addressEntity.setCity("Warszawa");
        addressEntity.setPostalCode("44-22");

        // when //
        AddressTO addressTO = new AddressMapper().mapToTO(addressEntity);

        // then //
        assertNotNull(addressTO);
        assertEquals(addressEntity.getId(), addressTO.getId());
        assertEquals(addressEntity.getAddressLine1(), addressTO.getAddressLine1());
        assertEquals(addressEntity.getAddressLine2(), addressTO.getAddressLine2());
        assertEquals(addressEntity.getCity(), addressTO.getCity());
        assertEquals(addressEntity.getPostalCode(), addressTO.getPostalCode());
    }

    @Test
    public void testMapToEntity() {

        // given //
        AddressTO addressTO = new AddressTO();
        addressTO.setId(1L);
        addressTO.setAddressLine1("Kamienna");
        addressTO.setAddressLine2("obornicka");
        addressTO.setCity("Bydgoszcz");
        addressTO.setPostalCode("54-222");

        // when //
        AddressEntity addressEntity = AddressMapper.mapToEntity(addressTO);

        // then //
        assertNotNull(addressEntity);
        assertEquals(addressTO.getId(), addressEntity.getId());
        assertEquals(addressTO.getAddressLine1(), addressEntity.getAddressLine1());
        assertEquals(addressTO.getAddressLine2(), addressEntity.getAddressLine2());
        assertEquals(addressTO.getCity(), addressEntity.getCity());
        assertEquals(addressTO.getPostalCode(), addressEntity.getPostalCode());
    }
}
