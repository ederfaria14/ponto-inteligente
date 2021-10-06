package com.ederfaria.pontointeligente.api.controllers;

import com.ederfaria.pontointeligente.api.dtos.EmpresaDto;
import com.ederfaria.pontointeligente.api.entities.Empresa;
import com.ederfaria.pontointeligente.api.response.Response;
import com.ederfaria.pontointeligente.api.security.JwtAuthenticator;
import com.ederfaria.pontointeligente.api.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "*")
public class AuthenticatorController {

    @Autowired
    private EmpresaService service;

    @PostMapping
    public ResponseEntity<Response<EmpresaDto>> gerarTokenJwt(@Valid @RequestBody JwtAuthenticator authenticationDto, BindingResult result) {
        System.out.println("Post empresa ");
        Response<EmpresaDto> response = new Response<>();
//        service.persistir(entity.toEntity());
//        response.setData(entity);
//        validaDto(entity, result);
//        if (result.hasErrors()) {
//            result.getAllErrors().forEach(e->response.getErrors().add(e.getDefaultMessage()));
//            return ResponseEntity.badRequest().body(response);
//        }
        return ResponseEntity.ok(response);
    }

}
