package vn.fouridiots.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.fouridiots.provider.dto.ProviderDto;
import vn.fouridiots.provider.model.Provider;
import vn.fouridiots.provider.repository.ProviderRepository;
import vn.fouridiots.provider.service.impl.ProviderServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1")
public class ProviderController {

    @Autowired
    ProviderServiceImpl providerService;

    @Autowired
    ProviderRepository providerRepository;

    @GetMapping("provider/List")
    public ResponseEntity<Page<Provider>> getAllProviderList(@RequestParam("1") int page,
                                                             @RequestParam("10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Provider> providers = providerService.findAllProvider(pageable);
        if (providers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(providers);
    }

    @GetMapping("provider/List/{name}")
    public ResponseEntity<Page<Provider>> getAllProviderByName(@PathVariable String name,
                                                               @RequestParam("1") int page,
                                                               @RequestParam("10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Provider> providers = providerService.findProviderByNameProvider(name, pageable);
        if (providers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(providers);
    }

    @GetMapping("provider/List/{taxCode}")
    public ResponseEntity<Page<Provider>> getAllProviderByTaxCode(@PathVariable String taxCode,
                                                                  @RequestParam("1") int page,
                                                                  @RequestParam("10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Provider> providers = providerService.findProviderByTaxCodeProvider(taxCode, pageable);
        if (providers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(providers);
    }

    @PostMapping("provider/Create")
    public ResponseEntity<Provider> createProvider(@Validated @RequestBody Provider provider) {
        try {
            providerService.createProvider(provider);
            return ResponseEntity.ok().body(provider);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("provider/Edit/{id}")
    public ResponseEntity<ProviderDto> updateProviderInfor(@PathVariable Long id,
                                                        @RequestBody ProviderDto providerDto) {
        providerService.editProvider(providerDto, id);
        return new ResponseEntity<ProviderDto>(providerDto, HttpStatus.OK);
    }

    @PutMapping("provider/Delete/{id}")
    public ResponseEntity<Provider> deleteProvider(@PathVariable Long id) {
        Provider provider = providerRepository.findAllByisDeleteIsFalseAndIdIs(id);
        if (provider == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        this.providerService.deleteProvider(provider);
        return ResponseEntity.ok().body(provider);
    }
}
