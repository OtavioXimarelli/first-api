package com.example.card_aplication_project.controller // Define o pacote (localização lógica) da classe

// Importações de classes de DTOs (Data Transfer Objects), entidade e serviço
import com.example.card_aplication_project.dto.CustomerDto
import com.example.card_aplication_project.dto.CustomerUpdateDto
import com.example.card_aplication_project.dto.CustomerView
import com.example.card_aplication_project.entity.Customer
import com.example.card_aplication_project.service.impl.CustomerService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

// Importações de anotações do Spring para mapeamento de endpoints REST
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

// Anotação que indica que esta classe é um controlador REST
@RestController
// Anotação que define o caminho base para todos os endpoints desta classe
@RequestMapping("/api/customers")
class CustomerResource( // Declaração da classe CustomerResource
    private val customerService: CustomerService // Injeção de dependência do serviço CustomerService
) {

    // Anotação que indica que este método responde a requisições POST (criação de cliente)
    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): ResponseEntity<String> { // Método para salvar um novo cliente
        val savedCustomer = this.customerService.save(customerDto.toEntity()) // Salva o cliente usando o serviço
        return ResponseEntity.status(HttpStatus.CREATED).body( "Customer ${savedCustomer.email} successfully saved!") // Retorna uma mensagem de sucesso
    }

    // Anotação que indica que este método responde a requisições GET (busca de cliente por ID)
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> { // Método para buscar um cliente por ID
        val customer: Customer = this.customerService.findByID(id) // Busca o cliente usando o serviço
        return ResponseEntity.status(HttpStatus.OK).body( CustomerView(customer)) // Retorna uma visão (DTO) do cliente encontrado
    }

    // Anotação que indica que este método responde a requisições DELETE (exclusão de cliente por ID)
    @DeleteMapping("/{id}")
    fun deleteByID(@PathVariable id: Long) = this.customerService.delete(id) // Método para excluir um cliente por ID

    // Anotação que indica que este método responde a requisições PATCH (atualização parcial de cliente)
    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long, // Parâmetro da requisição que representa o ID do cliente
        @RequestBody customerUpdateDto: CustomerUpdateDto // DTO com os dados para atualização do cliente
    ): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findByID(id) // Busca o cliente a ser atualizado
        val customerToUpdate: Customer = customerUpdateDto.toEntity(customer) // Converte o DTO em entidade
        val updatedCustomer: Customer = customerService.save(customerToUpdate) // Salva o cliente atualizado
        return ResponseEntity.status(HttpStatus.OK).body( CustomerView(updatedCustomer)) // Retorna uma visão (DTO) do cliente atualizado
    }
}
