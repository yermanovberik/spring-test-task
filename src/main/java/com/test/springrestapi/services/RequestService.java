package com.test.springrestapi.services;

import com.test.springrestapi.dto.request.RequestRequestDTO;
import com.test.springrestapi.dto.request.RequestResponseDTO;
import com.test.springrestapi.models.Request;

public interface RequestService extends CrudService<Request, RequestRequestDTO, RequestResponseDTO> {
}
