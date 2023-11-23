
#1 (30)

"No que respeita a segurança, alguns dos principais desafios dos sistemas distribuídos são:

Implementação de sistema de autenticação, a segurança e integridade dos dados, construção de um sistema tolerante a falhas, entre outros pontos mas marcando estes como muito importantes."

  

#2 (50)

"Principais desafios dos sistemas distribuídos no que respeita à gestão de falhas:
- Falhas na comunicação entre componentes da arquitetura do sistema;
- Falhas de hardware na infraestrutura;
- Escala da infraestrutura, arquiteturas grandes e complexas, dificulta a gestão de falhas;"

#3 (100)

"Para construir este sistema apresentado para um app móvel usaria os seguintes componentes:

- User interface: Contendo a mobile app para os utilizadores.
- Camada lógica: Onde é feito o processamento dos dados relativos a compras de bilhetes por exemplo e outras operações e processamento de dados relevantes para a aplicação.
- Base de dados: onde iram ser guardados os dados para processamento na aplicação."

#4 (100)
"A características de uma arquitetura cliente-servidor são, uma divisão das partes da aplicação de forma a que todos os dados ou resultados que necessitem de ser processados ou gravados, etc por parte do cliente vão ser processados noutra parte da mesma aplicação num servidor que ira servir esses mesmos pedidos.

Esta arquitetura permite que os principais componentes da arquitetura estejam centralizados de forma a que possam por exemplo ser partilhados com outros clientes.

Será mais acessível fazer a manutenção do sistema estando ele centralizado"

  
#5 (70)

"O sistema seria constituído por pagina que será o cliente da aplicação que se conecta com um servidor para armazenar dados, executar operações, etc.

Em contraste numa arquitetura peer-to-peer, a aplicação que está a correr nas maquinas dos utilizadores é tanto um cliente como um servidor o que pode ajudar o ecossistema a escalar no sentido de poder suportar mais pedidos pois cada cliente atua como servidor também.

Portanto ambas têm o potencial de escalar, no entanto uma arquitetura cliente-servidor poderá ser mais simples de implementar e manter em comparação quando o ecossistema da aplicação crescer.

Um desafio que poderá criar um impasse numa aplicação desta natura no caso peer-to-peer será manter a integridade e coesão assim como sincronismo dos dados num sistema com estas características."

  

#6 (50)

É necessario converter mensagens usando um protocolo de representação de dados de forma a permitir que sistemas diferentes a nível de implementação, ou que utilize protocolos de comunicação ou processamento consigam comunicar entre si e conhecerem "a mesma linguagem" no sentido de envio e receção de dados, pois caso contrario, p.e., o método de leitura e criação de objetos, etc de servidor, pode ser completamente diferente de um cliente com o qual comunica e que então iria receber e interpretar erradamente os dados.

  

#7 (80)

Uma IDL serve para descrever a interface entre componentes e portanto facilitando a ligação e comunicação entre sistemas diferentes entre si. Uma linguagem de programação serve para criar programas que vão ser executados em maquinas.

  

#8 (50)

Stubs servidor de um sistema RPC, serve para "agregar" e enviar resultados de métodos enviando-os para o cliente. Da mesma forma quando um cliente efetua um pedido, que chama um método no servidor, irá receber e interpretar os parâmetros para as operações do procedimento remoto.

  

#9 (100)

"Se SUN RPC, utilizando o protocolo UDP retornou com sucesso, sabemos que pelo menos umas vez [Pelo-menos-uma-vez (at-least-once)] foi processado no servidor.

Só podemos concluir isto pois a natureza do UDP não é possível receber resposta de confirmação que os pacotes de dados transmitidos foram recebidos. Até pode ter sido processado o mesmo pedido 100x , mas só podemos afirmar, sabendo que houve retorno com sucesso, que pelo menos 1 vez correu"

  

#10  (0) - "no-máximo-uma-vez" opção correta

SUN RPC usando TCP, retornou timeout. Neste caso não conseguimos determinar se o pedido foi sequer atendido. Havendo timeout existem vários fatores que podem ter influencia no erro mas não são óbvios, pois pode ser uma falha de rede, ou uma falha de hardware no lado do servidor, etc. Neste caso a semântica correta é [Talvez (Maybe)]