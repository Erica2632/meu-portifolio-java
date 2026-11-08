# API de Automação de Departamento Pessoal

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven&logoColor=white)
![Status](https://img.shields.io/badge/status-em_desenvolvimento-yellow)

## Problema

Este projeto foi inspirado por um problema que vivenciei no departamento pessoal de uma empresa de aproximadamente 130 funcionários. Como a contabilidade era terceirizada, o controle de folha de pagamento, comissionamento e outras informações era feito por meio de planilhas. Não existia um sistema para centralizar as informações dos funcionários dentro da empresa.<br>
Devido a essa ausência, para ter, por exemplo, uma lista de aniversariantes do mês, era necessário consultar a contabilidade.<br>
Com base nesse cenário, desenvolvi essa API como um projeto de estudo, com o objetivo de simular a centralização dessas operações em um único lugar e praticar os conceitos de desenvolvimento.

## O que a aplicação faz

- Cadastra e gerência funcionários, com datas de admissão e demissão.
- Gera folhas de pagamento.
- Calcula comissões, que entram na folha apenas para quem as recebe.
- Aplica descontos da empresa, com descrição do motivo (ex.: farmácia, perda de material).
- Gera relatório de descontos por funcionário.
- Calcula o salário líquido final.

## Regra de cálculo

```
salário líquido = salário base + comissão - descontos
```

> [!NOTE]
> Os descontos são apenas os da empresa. Encargos do governo (INSS, FGTS, IR) não são calculados.

## Escopo

Este projeto é um esboço de DP para controle interno. Serve de base para conferir a folha da contabilidade, sem preencher planilhas manualmente.

## Próximos passos

- [ ] Concluir a refatoração
- [ ] Implementar validações
- [ ] Limitar o desconto a 40% da remuneração
- [ ] Melhorar o tratamento de erros
- [ ] Criar testes automatizados
- [ ] Listar aniversariantes do mês
- [ ] Exportar dados para a contabilidade

## Como rodar

Requisitos: Java 17+, Maven e MySQL. Configuração do banco em `application.properties`.

Comando: `mvn spring-boot:run`

