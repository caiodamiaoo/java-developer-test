# Escreva um caso de uso ou user story com base nas informações

Como usuário do sistema XYZ, quero poder cadastrar, editar, buscar e excluir plantas,
para que o sistema possa utilizar essas informações nas etapas seguintes do processo.

Funcionalidades:
- Criar uma planta
- Atualizar uma planta
- Deletar uma planta(Apenas admin)
- Buscar uma planta por código ou descrição

# Destaque regras de negócio ou suposições
- O código da planta deve ser numérico, obrigatório e único.
- A descrição é opcional, mas se informada, deve ter no máximo 10 caracteres (alfanumérica).
- Somente usuários com perfil de administrador podem deletar uma planta.
- Não pode haver dois registros com o mesmo código.
# Descreva validações e medidas de segurança que você aplicaria

A nível de backend:
- Validação que o código da planta seja apenas numérico e obrigatório.
- Descrição tenha apenas no máximo 10 caracteres e sem caracteres especiais.
- O código da planta não deve existir na base antes de cadastrar, pois deve ser único.
- O usuário deve ter o perfil de administrador para deletar uma planta.

A nível de frontend:
- Mascara no momento do input para o código
- Validação de caracteres especiais na descrição.

# Sugira como testaria essa funcionalidade, incluindo casos extremos.

Testaria a funcionalidade com os seguintes casos:
- Cadastrar planta com código válido e descrição nula
- Cadastrar planta com descrição no limite de 10 caracteres.
- Tentar cadastrar com código já existente (esperar erro de duplicidade).
- Tentar cadastrar com código não numérico (esperar erro de validação).
- Usuário sem permissão tenta deletar planta (esperar erro 403).
- Planta deletada por admin com sucesso.
- Buscar planta com filtro parcial de descrição
Casos extremos seriam os casos mais específicos, como:
- Cadastro com campos vazios.
- Código com valor muito grande
- Inserção em massa
