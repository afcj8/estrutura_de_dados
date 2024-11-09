# 10. TAD Vector

A TAD (Tipo Abstrato de Dados) Vector é uma estrutura de dados que se assemelha a um array dinâmico, onde o tamanho pode ser alterado conforme necessário, permitindo a adição e remoção de elementos em tempo de execução. Um vector armazena seus elementos em uma sequência linear, onde cada posição é acessível por meio de um índice numérico. Essa estrutura é especialmente útil quando o número de elementos é desconhecido previamente ou varia ao longo da execução do programa.

## 10.1. Estrutura

O vector é projetado para armazenar dados de maneira contígua na memória, o que proporciona acesso direto a cada elemento por meio de um índice. Diferente de arrays convencionais de tamanho fixo, o vector pode expandir sua capacidade para acomodar novos elementos. Quando seu limite inicial é atingido, a estrutura realoca seu espaço de memória, geralmente dobrando a capacidade atual, o que permite crescimento eficiente. Esse procedimento de realocação, porém, exige cópia dos elementos para a nova área de memória, tornando-o um processo relativamente custoso.