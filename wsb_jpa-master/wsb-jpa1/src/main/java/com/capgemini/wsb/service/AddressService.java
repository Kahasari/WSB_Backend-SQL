package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.AddressTO;

import java.util.Collection;

public interface AddressService
{
    Collection<AddressTO> showAllAddresses();
    AddressTO getAddressById(Long id);
    AddressTO addAddress(AddressTO addressTO);
    void removeAddress(Long id);
}
