# 5. Prevenção de SQL Injection
##    Quais técnicas você usa para prevenir ataques de SQL Injection em aplicações web?

Não concateno strings para criar query. Sempre valido os dados de entrada para utilizar nas queries.
As vezes, utilizo validações para cada usuário, como por exemplo, se o usuário é admin ou não.

##    Dê exemplos de código seguro usando queries parametrizadas ou ORMs.
```java
@Query("SELECT u FROM Usuario u WHERE u.name = :name")
Usuario findByUser(@Param("name") String name);
```
##    Mencione medidas extras que você adota para proteger o banco de dados.

Sempre utilizo validações tanto na camada de front, quanto na camada de backend, tais como formatos, tamanho, tipos, 
listas de valores permitidos, etc.

