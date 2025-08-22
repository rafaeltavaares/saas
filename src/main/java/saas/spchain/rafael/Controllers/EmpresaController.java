package saas.spchain.rafael.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import saas.spchain.rafael.DTO.Empresa.EmpresaCreateDTO;
import saas.spchain.rafael.DTO.Empresa.EmpresaResponseDTO;
import saas.spchain.rafael.DTO.Empresa.EmpresaUpdateDTO;
import saas.spchain.rafael.Dominio.Usuario.Empresa;
import saas.spchain.rafael.Services.EmpresaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    /**
     * Endpoint para criar uma nova empresa.
     * HTTP POST /api/empresas
     */
    @PostMapping
    public ResponseEntity<EmpresaResponseDTO> create(@Valid @RequestBody EmpresaCreateDTO createDTO) throws Exception {
        EmpresaResponseDTO novaEmpresa = empresaService.create(createDTO);

        // Cria a URI do novo recurso criado, para retornar no cabeçalho "Location"
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novaEmpresa.id())
                .toUri();

        // Retorna 201 Created com a localização e o corpo da nova empresa
        return ResponseEntity.created(location).body(novaEmpresa);
    }

    /**
     * Endpoint para buscar todas as empresas ativas.
     * HTTP GET /api/empresas
     */
    @GetMapping
    public ResponseEntity<List<EmpresaResponseDTO>> findAllActive() {
        List<EmpresaResponseDTO> empresas = empresaService.findAllActive();
        return ResponseEntity.ok(empresas);
    }

    /**
     * Endpoint para buscar uma empresa específica pelo ID.
     * HTTP GET /api/empresas/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponseDTO> findById(@PathVariable Long id) {
        EmpresaResponseDTO empresa = empresaService.findById(id);
        return ResponseEntity.ok(empresa);
    }

    /**
     * Endpoint para atualizar uma empresa existente.
     * HTTP PUT /api/empresas/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmpresaResponseDTO> update(@PathVariable Long id, @Valid @RequestBody EmpresaUpdateDTO updateDTO) {
        EmpresaResponseDTO empresaAtualizada = empresaService.update(id, updateDTO);
        return ResponseEntity.ok(empresaAtualizada);
    }

    /**
     * Endpoint para desativar (soft delete) uma empresa.
     * HTTP DELETE /api/empresas/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empresaService.deleteById(id);
        // Retorna 204 No Content, indicando sucesso na operação sem corpo de resposta
        return ResponseEntity.noContent().build();
    }

}