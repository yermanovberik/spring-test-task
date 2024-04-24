package com.test.springrestapi.controllers;

import com.test.springrestapi.dto.request.RequestRequestDTO;
import com.test.springrestapi.dto.request.RequestResponseDTO;
import com.test.springrestapi.services.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RequestResponseDTO getRequestById(@PathVariable("id") long id) {
        return requestService.getById(id);
    }

    @PostMapping
    public RequestResponseDTO createRequest(@RequestBody RequestRequestDTO requestDto) {
        return requestService.create(requestDto);
    }

    @PutMapping("/{id}")
    public RequestResponseDTO updateRequest(@PathVariable("id") long id, @RequestBody RequestRequestDTO requestDto) {
        return requestService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void deleteRequest(
            @PathVariable long id
    ) {
        requestService.delete(id);
    }
}
