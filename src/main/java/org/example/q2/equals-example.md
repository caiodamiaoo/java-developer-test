# Exemplo de quando sobrescrever o método equals:

Geralmente ocorre quando é necessário comparar objetos pela regra de negócio, e não pela referência de memória.

```java
Set<User> newUser = new HashSet<>();
newUser.add(new User("12345678900", "Caio"));
newUser.add(new User("12345678900", "Caio"));
```
Nesse caso, se não sobrescrever o equals e hashcode, o set vai tratar os dois objetos como diferentes, pois são
referências diferentes. Porém, eles são iguais.


# Implementação correta:

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return Objects.equals(cpf, user.cpf);
}

@Override
public int hashCode() {
    return Objects.hash(cpf);
}

```

