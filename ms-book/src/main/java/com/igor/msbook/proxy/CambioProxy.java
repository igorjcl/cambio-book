package com.igor.msbook.proxy;

import com.igor.msbook.response.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cambio")
public interface CambioProxy {

    @GetMapping("/cambio/{amount}/{from}/{to}")
    ResponseEntity<Cambio> getCambio(@PathVariable("amount") Double amount,
                                     @PathVariable("from") String from,
                                     @PathVariable("to") String to);

}
