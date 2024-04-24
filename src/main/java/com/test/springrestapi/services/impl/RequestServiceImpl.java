package com.test.springrestapi.services.impl;

import com.test.springrestapi.dto.request.RequestRequestDTO;
import com.test.springrestapi.dto.request.RequestResponseDTO;
import com.test.springrestapi.exceptions.entity.EntityNotFoundException;
import com.test.springrestapi.models.Request;
import com.test.springrestapi.repositories.RequestRepository;
import com.test.springrestapi.services.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    @Override
    public RequestResponseDTO getById(long id) {
        Request request = getEntityById(id);

        RequestResponseDTO responseDTO = RequestResponseDTO.builder()
                .product(request.getProduct())
                .deliveryAddress(request.getDeliveryAddress())
                .phoneNumber(request.getPhoneNumber())
                .quantity(request.getQuantity())
                .build();

        return responseDTO;
    }

    @Override
    public RequestResponseDTO create(RequestRequestDTO requestDto) {
        Request request = Request.builder()
                .product(requestDto.product())
                .quantity(requestDto.quantity())
                .deliveryAddress(requestDto.deliveryAddress())
                .phoneNumber(requestDto.phoneNumber())
                .build();
        requestRepository.save(request);

        RequestResponseDTO responseDTO = RequestResponseDTO.builder()
                .product(requestDto.product())
                .deliveryAddress(requestDto.deliveryAddress())
                .phoneNumber(requestDto.phoneNumber())
                .quantity(requestDto.quantity())
                .build();

        return responseDTO;
    }

    @Override
    public RequestResponseDTO update(long id, RequestRequestDTO requestDto) {
        Request request = getEntityById(id);
        request.setProduct(requestDto.product());
        request.setQuantity(requestDto.quantity());
        request.setDeliveryAddress(requestDto.deliveryAddress());
        request.setPhoneNumber(requestDto.phoneNumber());
        requestRepository.save(request);

        RequestResponseDTO responseDTO = RequestResponseDTO.builder()
                .product(requestDto.product())
                .deliveryAddress(requestDto.deliveryAddress())
                .phoneNumber(requestDto.phoneNumber())
                .quantity(requestDto.quantity())
                .build();

        return responseDTO;
    }
    @Override
    @Transactional
    public void delete(long id) {
        requestRepository.deleteById(id);
    }

    @Override
    public Request getEntityById(long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Request with id " + id + " not found!"));
    }
}
