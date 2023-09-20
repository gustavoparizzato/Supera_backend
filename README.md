# Processo Seletivo de Java

## Descrição 

- Este teste consiste em construir uma camada de serviço para uma operação muito realizada em bancos que é a emissão de extrato bancário.

## Requisitos de sistema

- Possuir a JDK 11 
- Uma IDE ou editor de sua preferência

## Descrição do Projeto

- A api fornecer os dados de transferência de acordo com o número da conta bacária.
- Caso não seja informado nenhum filtro, retorna todos os dados de transferência.
- Caso seja informado um período de tempo, retorna todas as transferências relacionadas à aquele período de tempo.
- Caso seja informado o nome do operador da transação, retorna todas as transferências relacionados à aquele operador.
- Caso todos os filtros sejam informados, retorna todas as transferências com base no período de tempo informado e o nome do operador.
- Operador de transação nada mais é que, o nome do responsável de destino da transação caso seja uma operação de transferência de saida ou o nome do responsável de onde se originou a transação caso seja uma operação de transferência de entrada.
- Os valores devem ser de ponto flutuante, e deve-se considerar apenas duas casas decimais.
- As transações devem ser exibidas junto com o saldo total e o saldo total no período de acordo com o protótipo do documento.

## Sobre
- Padrão RESTFul na construção da API.
- Existe um script sql no pacote resources que contém a modelagem do banco que pode ser seguida com valores iniciais. 
- Caso necessário, poderá ser criado novas tabelas
