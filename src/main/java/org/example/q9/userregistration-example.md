# Cadastro de usuário

### 1) Descreva os tipos de testes que você implementaria (unitários, integração, fim a fim);

Testes Unitários:
- Campos obrigatórios (nome e email)
- Verificação de email único
- Validação de formato do email (se aplicável)

Testes de Integração:
- Inserção e atualização persistindo corretamente
- Rejeição de exclusão por usuários que não sejam admin
- Verificação de violação de chave única para email

Testes de Fim a Fim:
- Preencher formulário, salvar e conferir mensagem de sucesso
- Tentar apagar usuário como admin e como usuário comum
- Verificar mensagens de erro no frontend (ex: email já cadastrado)

### 2) Explique os cenários que testaria
- Cadastro de usuário completo com todos os campos preenchidos
- Cadastro apenas com nome e email 
- Tentar cadastrar dois usuários com o mesmo email
- Atualizar usuário com novos dados válidos
- Atualizar tentando usar um email já existente de outro usuário
- Deletar usuário como admin
- Deletar usuário não sendo admin (esperar erro ou bloqueio)
- Cadastro com e-mail inválido

### 3) Forneça exemplos de casos extremos

- Nome com espaços em branco ou apenas espaços
- Email com caracteres especiais (válido e inválido)
- Campos com valores muito longos
- Cadastro com campos null ou vazios

### 4) Inclua um exemplo de caso de teste em código ou pseudocódigo.

```java
@Test
void shouldNotAllowDuplicatedEmail() {
    Usuario usuario1 = new Usuario("Caio", "caio@email.com", "rua teste", "123");
    Usuario usuario2 = new Usuario("Camila", "camila@email.com", "rua teste", "456");

    usuarioService.salvar(usuario1);
    
    Exception e = assertThrows(EmailDuplicadoException.class, () -> {
        usuarioService.salvar(usuario2);
    });

    assertEquals("Email já cadastrado.", e.getMessage());
}
```