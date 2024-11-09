# 10. TAD Vector

A TAD (Tipo Abstrato de Dados) Vector é uma estrutura de dados que se assemelha a um array dinâmico, onde o tamanho pode ser alterado conforme necessário, permitindo a adição e remoção de elementos em tempo de execução. Um vector armazena seus elementos em uma sequência linear, onde cada posição é acessível por meio de um índice numérico. Essa estrutura é especialmente útil quando o número de elementos é desconhecido previamente ou varia ao longo da execução do programa.

## 10.1. Estrutura

O vector é projetado para armazenar dados de maneira contígua na memória, o que proporciona acesso direto a cada elemento por meio de um índice. Diferente de arrays convencionais de tamanho fixo, o vector pode expandir sua capacidade para acomodar novos elementos. Quando seu limite inicial é atingido, a estrutura realoca seu espaço de memória, geralmente dobrando a capacidade atual, o que permite crescimento eficiente. Esse procedimento de realocação, porém, exige cópia dos elementos para a nova área de memória, tornando-o um processo relativamente custoso.

## 10.2. Inserção de Elementos

A inserção em um vector pode ocorrer em três posições: no início, no fim ou em uma posição intermediária.

1. **Inserção no Início:** Inserir no início de um vector exige deslocar todos os elementos uma posição à direita, liberando a primeira posição para o novo elemento. Esse deslocamento pode tornar a operação custosa em termos de desempenho, especialmente em vetores grandes.

2. **Inserção no Fim:** Inserir no final do vector é, em geral, a operação mais eficiente, pois basta adicionar o novo elemento na próxima posição livre. Quando o vector atinge sua capacidade máxima, pode ser necessário expandi-lo, copiando os elementos para um espaço maior, o que aumenta o custo dessa operação ocasionalmente.

3. **Inserção em uma Posição Intermediária:** Inserir em uma posição específica entre os elementos exige mover os elementos à direita dessa posição uma casa à frente, criando espaço para o novo elemento. Esse deslocamento de elementos implica em um custo adicional proporcional à quantidade de elementos deslocados.