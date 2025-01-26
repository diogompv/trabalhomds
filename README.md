# Relatório 2ª parte do trabalho de MDS - "Implementação"

### Trabalho realizado por Gabriel César nº 52267 e Diogo Vitória nº 52619

Inicialmente começamos por remendar alguns dos erros que tínhamos na primeira parte do trabalho, melhorando o diagrama de classes, o diagrama de atividade.

De seguida começamos por inserir os issues no git hub, seguindo depois em criar o código do programa e depois os testes.

No "main" temos a implementação de um menu inicial onde é possível escolher entre o respetivo utilizador sendo eles:

* Gestor
* Hóspede
* Funcionário

No quarto.java esta classe permite criar, listar, editar e excluir quartos. Na reserva.java permite criar, listar, confirmar e cancelar reservas. estas são depois vinculadas aos quartos existentes, o sistema tem que validar a existência do quarto.

#### Testes

Testes de Reserva:

* Criar Reserva: Verifica se as reservas são criadas corretamente.
* Confirmar Reserva: Garante que reservas podem ser confirmadas.
* Cancelar Reserva: Valida o cancelamento de reservas e remove-as da lista.

Testes de Histórico:

* Histórico Existente: Retorna reservas associadas a um hóspede.
* Histórico Inexistente: Retorna histórico vazio para hóspedes sem reservas.
* Reserva Cancelada: Confirma que reservas canceladas não aparecem no histórico.

Testes de Manutenção:

* Registrar Manutenção: Valida que quartos podem ser colocados em manutenção.
* Concluir Manutenção: Garante que a manutenção pode ser concluída.

Testes de Quarto:

* Adicionar/Editar/Remover Quarto: Valida operações básicas para gerir os quartos.
* Listar Quartos: Confirma que a listagem retorna os quartos corretamente.

Para correr o programa tem que seguir o seguintes passos e inserir os seguintes comandos no terminal:

1.  mvn compile
2.  mvn exec:java -Dexec.mainClass="com.exemplo.hotel.Main"
