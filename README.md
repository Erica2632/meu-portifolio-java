# API de Automação de Departamento Pessoal

## Problema

Na empresa onde trabalhei, a contabilidade era terceirizada e o Departamento Pessoal, sob minha responsabilidade, controlava tudo por planilhas separadas (folha, comissões e descontos). Sem um cadastro centralizado, qualquer consulta em massa era trabalhosa: para saber, por exemplo, os aniversariantes do mês entre 130 funcionários, seria preciso levantar a ficha de cada um e montar uma nova planilha.

Esta API centraliza essas operações em um só lugar.

## O que a aplicação faz

- Cadastra e gerencia funcionários, com datas de admissão e demissão.
- Gera folhas de pagamento.
- Calcula comissões, que entram na folha apenas para quem as recebe.
- Aplica descontos da empresa, com descrição do motivo (ex.: farmácia, perda de material).
- Gera relatório de descontos por funcionário.
- Calcula o salário líquido final.

## Regra de cálculo

```
salário líquido = salário base + comissão - descontos
```

Os descontos são apenas os da empresa. Encargos do governo (INSS, FGTS, IR) não são calculados.

## Escopo

É um esboço de DP para controle interno. Serve de base para conferir a folha da contabilidade, sem preencher planilhas manualmente.

## Próximos passos

- Concluir a refatoração
- Implementar validações
- Limitar o desconto a 40% da remuneração
- Melhorar o tratamento de erros
- Criar testes automatizados
- Listar aniversariantes do mês
- Exportar dados para a contabilidade

