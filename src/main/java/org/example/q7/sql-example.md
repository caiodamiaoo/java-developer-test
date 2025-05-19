# Consultas SQL


### 1) Retorne os nomes dos vendedores que não têm nenhum pedido com a empresa "Samsonic".
```
SELECT s.name
FROM Salesperson s
WHERE s.id NOT IN (
  SELECT o.salesperson_id
  FROM Orders o
  JOIN Customer c ON o.customer_id = c.id
  WHERE c.name = 'Samsonic'
);
```

###  Atualize os nomes dos vendedores que têm 2 ou mais pedidos, adicionando um * no final do nome.
```
UPDATE Salesperson
SET name = CONCAT(name, '*')
WHERE id IN (
  SELECT salesperson_id
  FROM Orders
  GROUP BY salesperson_id
  HAVING COUNT(*) >= 2
);
```

### c) Delete todos os vendedores que fizeram pedidos para a cidade de Jackson.

```
DELETE FROM Salesperson
WHERE id IN (
  SELECT DISTINCT o.salesperson_id
  FROM Orders o
  JOIN Customer c ON o.customer_id = c.id
  WHERE c.city = 'Jackson'
);
```

### d) Retorne o total de vendas por vendedor. Se o vendedor não vendeu nada, mostrar zero.

```
SELECT s.name, COALESCE(SUM(o.amount), 0) AS total_vendas
FROM Salesperson s
LEFT JOIN Orders o ON s.id = o.salesperson_id
GROUP BY s.name;
```
