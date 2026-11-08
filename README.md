# API de Automação de Departamento Pessoal

API que automatiza o cadastro de funcionários e a geração de folhas de pagamento, calculando comissões, descontos e salário líquido.

## Problema

Rotinas de Departamento Pessoal envolvem cadastros repetitivos e cálculos manuais de remuneração. Esta API centraliza essas operações e padroniza o cálculo da folha de pagamento.

## O que a aplicação faz

- Cadastra e gerencia funcionários.
- Gera folhas de pagamento.
- Calcula comissões.
- Aplica descontos.
- Calcula o salário líquido final.

## Regra de cálculo

```
salário líquido = salário base + comissão - descontos
```



## Próximos passos

- Concluir a refatoração
- Implementar validações
- Melhorar o tratamento de erros
- Criar testes automatizados
