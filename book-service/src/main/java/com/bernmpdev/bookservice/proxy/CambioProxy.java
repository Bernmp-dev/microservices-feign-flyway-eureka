package com.bernmpdev.bookservice.proxy;

import com.bernmpdev.bookservice.model.CambioEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cambio-service", url = "localhost:8000")
public interface CambioProxy {

    @GetMapping(value = "/cambio-service/{amount}/{from}/{to}")
    public CambioEntity getCambio(
            @PathVariable Double amount,
            @PathVariable String from,
            @PathVariable String to
    );
}
