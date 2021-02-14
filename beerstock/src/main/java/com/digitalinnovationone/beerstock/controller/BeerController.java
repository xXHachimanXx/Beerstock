package com.digitalinnovationone.beerstock.controller;

import com.digitalinnovationone.beerstock.dto.BeerDTO;
import com.digitalinnovationone.beerstock.exception.BeerAlreadyRegisteredException;
import com.digitalinnovationone.beerstock.exception.BeerNotFoundException;
import com.digitalinnovationone.beerstock.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/beers")
public class BeerController implements BeerControllerDocs {
    private final BeerService beerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDTO createBeer(@RequestBody @Valid BeerDTO beerDTO) throws BeerAlreadyRegisteredException
    {
        return beerService.createBeer(beerDTO);
    }

    @GetMapping("/{name}")
    public BeerDTO findByName(@PathVariable String name) throws BeerNotFoundException
    {
        return beerService.findByName(name);
    }

    @GetMapping
    public List<BeerDTO> listBeers()
    {
        return beerService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BeerNotFoundException
    {
        beerService.deleteById(id);
    }


}
