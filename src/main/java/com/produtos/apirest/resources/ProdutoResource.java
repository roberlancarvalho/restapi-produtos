package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produtos") // Listar todos os produtos cadastrados
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produto/{id}") // Listar produto específico por ID
	@ApiOperation(value="Retorna um único produto")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping("/produto") // Criar novo produto
	@ApiOperation(value="Salva um produto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produto") // Deletar produto
	@ApiOperation(value="Deleta um produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}

	@PutMapping("/produto") // Atualizar produto
	@ApiOperation(value="Atualiza/edita um produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
