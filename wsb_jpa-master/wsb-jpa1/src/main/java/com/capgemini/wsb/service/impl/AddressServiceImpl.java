package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.mapper.AddressMapper;
import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.service.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;


@Service
@Transactional
public class AddressServiceImpl implements AddressService
{
    private final AddressDao addressDao;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressDao addressDao, AddressMapper addressMapper) {
        this.addressDao = addressDao;
        this.addressMapper = addressMapper;
    }

    @Override
    public Collection<AddressTO> showAllAddresses() {
        return addressDao.findAll().stream().map(addressMapper::mapToTO).collect(Collectors.toList());
    }

    @Override
    public AddressTO getAddressById(Long id) {
        return addressMapper.mapToTO((AddressEntity) addressDao.getOne(id));
    }

    @Override
    public AddressTO addAddress(AddressTO addressTO) {
        return addressMapper.mapToTO(addressDao.save(AddressMapper.mapToEntity(addressTO)));
    }

    @Override
    public void removeAddress(Long id) {
        addressDao.delete(id);
    }
}
