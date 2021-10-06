package com.ederfaria.pontointeligente.api.controllers;

import com.ederfaria.pontointeligente.api.dtos.EmpresaDto;
import com.ederfaria.pontointeligente.api.entities.Empresa;
import com.ederfaria.pontointeligente.api.response.Response;
import com.ederfaria.pontointeligente.api.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/empresa")
@CrossOrigin(origins = "*")
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @PostMapping
    public ResponseEntity<Response<EmpresaDto>> salvar(@Valid @RequestBody EmpresaDto entity, BindingResult result) {
        System.out.println("Post empresa ");
        System.out.println("Empresa - " + entity.toString());
        Response<EmpresaDto> response = new Response<>();
        entity.setRazaoSocial(entity.getRazaoSocial() + " - " + new Date().toString());
        service.persistir(entity.toEntity());
        response.setData(entity);

        validaDto(entity, result);
        if (result.hasErrors()) {
            result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    private void validaDto(EmpresaDto empresa, BindingResult result) {
        if (empresa.getRazaoSocial() == null || empresa.getRazaoSocial().isEmpty()) {
            result.addError(new ObjectError("razaoSocial", "RazaoS ocial não pode ser vazio"));
        }
        if (empresa.getCnpj() == null || empresa.getCnpj().isEmpty()) {
            result.addError(new ObjectError("cnpj", "Cnpj não pode ser vazio"));
        }
    }

    @GetMapping
    public ResponseEntity<Response<List<EmpresaDto>>> read() {
        System.out.println("Get empresa");
        List<Empresa> list = service.findAll();

        List<EmpresaDto> listDto = list.stream()
                .map(emp -> new EmpresaDto(emp.getId(), emp.getCnpj(), emp.getRazaoSocial()))
                .collect(Collectors.toList());

        Response<List<EmpresaDto>> response = new Response<>();
        response.setData(listDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/dois")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Response<List<EmpresaDto>>> read2() {
        System.out.println("Get empresa");
        List<Empresa> list = service.findAll();

        List<EmpresaDto> listDto = list.stream()
                .map(emp -> new EmpresaDto(emp.getId(), emp.getCnpj(), emp.getRazaoSocial()))
                .collect(Collectors.toList());

        Response<List<EmpresaDto>> response = new Response<>();
        response.setData(listDto);
        return ResponseEntity.ok(response);
    }
}
