## **Cap 4 RPC RMI**
- Remote Procedure Call (RPC)
	- Conceito, estrutura do programa cliente, estrutura do programa servidor 
	- Infraestrutura de RPC: Interface Description Language (IDL), rotinas de adaptação (stubs), biblioteca de RPC
	- Semânticas de RPC vs protocolos de comunicação, protocolos de representação de dados
- Sun RPC
	- Descrição, exemplos
- Invocação remota de objetos (RMI)
	-  Conceito de objetos distribuídos, interfaces remotas, instanciação remota 
	- Java RMI: descrição, exemplos

## Perguntas Cap 4
### Pag. 14
#### 1. Qual é a relação entre o RPC e a Arquitectura cliente-servidor? 
RPC é uma técnica usada em sistemas cliente-servidor para permitir que um programa em um computador chame um procedimento em outro computador sem se preocupar com os detalhes da comunicação entre os computadores. O RPC é uma forma de comunicação entre processos que permite que um programa em um computador chame um procedimento em outro computador como se fosse um procedimento local.

**Utilização no cliente**  
1. Estabelecimento da ligação (binding)  
	1) Identificação do servidor  
	2) Localização do servidor  
	3) Estabelecimento de um canal de transporte  
	4) Autenticação do cliente e/ou do servidor  
2. Chamada de procedimentos remotos  
3. Terminação da ligação  
	1. Eliminação do canal de transporte

**Utilização no servidor**  
1. Registo  
	1) Escolha da identificação do utilizador  
			• Nome do porto de transporte  
			• Outros nomes alternativos  
	2) Registo dessa identificação  
2. Esperar pela criação de ligações  
	1) Estabelecimento de um canal de transporte  
	2) Autenticação do cliente e/ou do servidor  
3. Esperar por pedido de execução de procedimentos
	- Enviados pelos clientes ligados  
4. Terminação da ligação  
	- Eliminação do canal de transporte

**Estrutura do Programa Cliente**  
- Inicialização  
	- Cria os seus canais de comunicação  
	- Efectua o binding ao servidor  
- Código da aplicação com  
	- Chamadas a procedimentos locais  
	- Chamadas a procedimentos remotos  
		(Poderá ser difícil de distinguir uns dos outros...) 
- Terminação da ligação ao servidor (opcional)

**Estrutura do Programa Servidor**  
- Inicialização  
	- Cria os seus canais de comunicação  
	- Regista a sua interface no Serviço de Nomes  
	- Chama a biblioteca de RPC  
- Código da aplicação  
	- Procedimentos isolados que serão chamados remotamente pelos clientes  
	- Não existe “programa principal” (“main()”). É a biblioteca de RPC que espera pelos pedidos e chama as rotinas do programa  
	- Aplicação funciona como uma máquina de estados:  
		- Um procedimento é chamado pelo cliente e executa-se. O estado fica mantido em variáveis globais, ficheiro, base de dados.
		- O procedimento retorna para a biblioteca de RPC que envia a resposta ao cliente.  
		- O servidor tem que estar preparado para qualquer sequência de chamada dos seus procedimentos. Ele não pode controlar o seu fluxo de execução, pois este é determinado pelas chamadas efectuadas pelos clientes.

#### 2. Quais são as componentes de um sistema de RPC?
As principais componentes de um sistema de RPC são: 
- A definição de interface usando a linguagem de definição de interface (IDL), 
- o gerador de código, 
- os stubs do cliente e do servidor, 
- o marshalling e o unmarshalling de parâmetros e resultados, 
- e o protocolo de transporte.

#### 3. Qual é a sequência de execução dos componentes de RPC durante a execução de uma chamada remota ?
A sequência de execução dos componentes de RPC durante a execução de uma chamada remota é a seguinte: o cliente chama o stub do cliente, que empacota os parâmetros em uma mensagem e a envia para o servidor; o servidor recebe a mensagem e a passa para o stub do servidor, que desempacota os parâmetros e chama o procedimento apropriado; o procedimento é executado e retorna um valor, que é empacotado pelo stub do servidor e enviado de volta para o stub do cliente; o stub do cliente desempacota o valor de retorno e o retorna para o cliente.

### Pag. 22
#### 1. O que é um IDL? 
IDL é a sigla para Interface Description Language, ou Linguagem de Descrição de Interface em português. É uma linguagem usada para descrever a interface de um serviço ou objeto distribuído. Através da definição de uma interface comum, diferentes sistemas podem se comunicar de forma transparente, independentemente da linguagem de programação ou plataforma utilizada. 
#### 2. O que é que um compilador de IDL produz? 
Um compilador de IDL produz código que pode ser usado para gerar stubs e skeletons, que são componentes essenciais em sistemas de RPC. Os stubs e skeletons são responsáveis por empacotar e desempacotar parâmetros e resultados, além de gerenciar a comunicação entre o cliente e o servidor. O compilador de IDL também pode gerar código para outras tarefas, como validação de parâmetros e geração de documentação. 
#### 3. Quais são as diferenças entre um IDL e uma linguagem de programação? 
IDL é uma linguagem de descrição de interface, enquanto uma linguagem de programação é usada para implementar a lógica de um programa. Enquanto uma linguagem de programação é usada para escrever código que será executado em um computador, o IDL é usado para descrever a interface de um serviço ou objeto distribuído. O IDL não possui recursos para implementar a lógica de um programa, como estruturas de controle de fluxo ou operações aritméticas. Em vez disso, ele se concentra em definir a estrutura e os tipos de dados que serão usados na comunicação entre os sistemas.

### Pag 31
#### 1. Quais são as semânticas possíveis na execução de um RPC? 
Existem três semânticas possíveis na execução de um RPC: síncrona, assíncrona e de confirmação. Na semântica síncrona, o cliente aguarda a resposta do servidor antes de continuar a execução. Na semântica assíncrona, o cliente não aguarda a resposta do servidor e continua a execução. Na semântica de confirmação, o servidor envia uma confirmação ao cliente após a execução do procedimento remoto. 
#### 2. Que semântica de execução de RPC se obtém com o protocolo TCP e com o protocolo UDP quando não há falhas? E quando há falhas? 
Tanto o protocolo TCP quanto o protocolo UDP podem ser usados para implementar RPC. Quando não há falhas, a semântica de execução de RPC com o protocolo TCP é síncrona, enquanto a semântica de execução de RPC com o protocolo UDP é assíncrona. Quando há falhas, a semântica de execução de RPC com o protocolo TCP é confiável, o que significa que o protocolo garante a entrega das mensagens e a ordem de entrega. Já a semântica de execução de RPC com o protocolo UDP é não confiável, o que significa que o protocolo não garante a entrega das mensagens nem a ordem de entrega. Nesse caso, é responsabilidade do aplicativo implementar mecanismos de detecção e correção de falhas.

### Pag 40
#### 1. Qual componente do sistema RPC implementa o protocolo de representação de dados? 

O componente que implementa o protocolo de representação de dados no contexto do RPC é o padrão XDR (eXternal Data Representation) para Sun RPC e, para Web Services e outros, seria o uso de XML com regras de codificação e schemas extensíveis.

XDR é um padrão que define um protocolo canônico para a conversão de dados entre diferentes formatos de máquina em um ambiente de RPC. Ele permite que dados estruturados sejam serializados de uma forma que é independente de arquitetura de computador, o que é crucial para a comunicação entre diferentes sistemas em uma rede.

RPC: Representação dos dados
-  Estrutura dos dados
	- Implícita
	- Autodescritiva (marcada, tagged)
- Políticas de conversão dos dados
	- Canónica
		- N formatos ⇒ N funções
		- Não há comportamentos variáveis
		- É preciso converter mesmo quando é inútil
	- O-receptor-converte (Receiver-makes-it-right)
		- Poupa conversões inúteis
		- N formatos ⇒ N x N funções

- Standard para Sun RPC: **XDR (eXternal Data Representation)**
	- Conversão: Canónica
	- Estrutura: Implícita
		- Comprimentos de vectores variáveis Alinhamento a 32 bits (excepto vectores de caracteres)

- Standard para Web Services, outros: **XML**
	- Conversão: Canónica
	- Estrutura: Explícita
		- Encoding Rules: Schemas extensíveis

#### 2. Como é possível ter um servidor RPC concorrente? 
Para ter um servidor RPC concorrente, é necessário que o servidor seja capaz de lidar com várias chamadas remotas simultaneamente. Existem várias técnicas para implementar um servidor RPC concorrente, como a criação de threads para lidar com cada chamada remota ou o uso de um modelo de programação baseado em eventos. Além disso, é importante garantir que o servidor seja capaz de gerenciar corretamente o acesso concorrente aos recursos compartilhados, como bancos de dados ou arquivos. O uso de técnicas de sincronização, como semáforos ou mutexes, pode ser necessário para garantir a consistência dos dados.

- Um pedido de cada vez
	- Serialização de pedidos
	- Uma única thread para todos os pedidos
- Vários pedidos em paralelo
	- Uma thread por pedido
	- A biblioteca de RPC tem que suportar paralelismo:
		- Sincronização no acesso a binding handles
		- Sincronização no acesso a canais de comunicação



### Pag 53
#### 1. Quais são as componentes do SUN RPC? 
As principais componentes do SUN RPC são: a linguagem de definição de interface (IDL), o compilador de IDL, os stubs do cliente e do servidor, o protocolo de transporte e a biblioteca de tempo de execução. O SUN RPC também inclui um mecanismo de autenticação para garantir a segurança das chamadas remotas. 

Na aula 
- SUN RCP IDL
- Stubs gerados pelo Sun RPC 
- Rotinas da biblioteca do Sun RPC


#### 2. Quais são as principais diferenças entre o IDL Sun RPC e a linguagem C? 
O IDL Sun RPC é uma linguagem de descrição de interface que é usada para definir a interface de um serviço ou objeto distribuído. Ele é usado para gerar código que pode ser usado para gerar stubs e skeletons, que são componentes essenciais em sistemas de RPC. A linguagem C, por outro lado, é uma linguagem de programação que é usada para implementar a lógica de um programa. As principais diferenças entre o IDL Sun RPC e a linguagem C são que o IDL é usado apenas para descrever a interface de um serviço ou objeto distribuído, enquanto a linguagem C é usada para implementar a lógica do programa. Além disso, o IDL é independente de plataforma e linguagem de programação, enquanto a linguagem C é específica de plataforma e linguagem de programação. 

Na aula 
- So tem partes declarativas 
- tipos de dados que o sun IDL tem que o c nao tem

#### 3. Que código produz o compilador de IDL Sun RPC? 
O compilador de IDL Sun RPC produz código em linguagem C que pode ser usado para gerar stubs e skeletons, que são componentes essenciais em sistemas de RPC. O código gerado pelo compilador de IDL inclui definições de estruturas de dados, protótipos de funções e outras informações necessárias para a comunicação entre o cliente e o servidor. 

Na aula 
- produz C
- stub do lado cliente / servidor
- gera esqueleto do cliente e servidor

#### 4. O cliente ou o servidor de Sun RPC pode estar escrito noutra linguagem de programação que não C? 
Embora o SUN RPC seja implementado em linguagem C, é possível escrever clientes e servidores em outras linguagens de programação, desde que essas linguagens possam se comunicar com a biblioteca de tempo de execução do SUN RPC. Para isso, é necessário que a linguagem de programação tenha suporte para chamadas de procedimento remoto (RPC) e para a serialização de dados. Algumas linguagens de programação, como Java e Python, possuem bibliotecas que permitem a implementação de clientes e servidores de RPC.

Na aula 
- So funciona com C dos dois lados

### Pag 72
#### 1. Porque é que o modelo de invocação remota de objetos se adequa muito bem à arquitetura cliente-servidor? 
O modelo de invocação remota de objetos se adequa bem à arquitetura cliente-servidor porque permite que os objetos distribuídos sejam acessados de forma transparente pelos clientes, independentemente da localização física dos objetos. Isso significa que os clientes podem chamar métodos em objetos remotos como se estivessem chamando métodos em objetos locais, sem precisar se preocupar com os detalhes da comunicação de rede. Além disso, o modelo de invocação remota de objetos permite que os objetos distribuídos sejam gerenciados de forma centralizada, o que simplifica a manutenção e o gerenciamento do sistema distribuído. 

Na aula:
- Porque o modelo de programação por objectos ja contem conceito de encapsulamento (atraves da definicao de interfaces)

#### 2. Em que é que a invocação remota de objetos pode diferir significativamente do RPC? 
A invocação remota de objetos difere significativamente do RPC em vários aspectos. Enquanto o RPC é baseado em chamadas de procedimento remoto, a invocação remota de objetos é baseada em chamadas de método remoto. Além disso, a invocação remota de objetos é orientada a objetos, o que significa que os objetos remotos são acessados como se fossem objetos locais, enquanto o RPC é orientado a procedimentos. Outra diferença importante é que a invocação remota de objetos geralmente usa um modelo de passagem de mensagens assíncrono, enquanto o RPC usa um modelo de passagem de mensagens síncrono. 

Na aula:
- se usarmos noção de retornar uma referencia para outro objecto no servidor. rpc so conhece metodos

#### 3. Qual é o IDL do Java para RMI? Como se definem as interfaces remotas? 
O IDL do Java para RMI é a interface remota. As interfaces remotas são definidas em Java usando a palavra-chave "interface" e estendendo a interface java.rmi.Remote. As interfaces remotas definem os métodos que podem ser chamados remotamente pelos clientes e os métodos que podem ser implementados pelos servidores. As interfaces remotas também podem definir exceções que podem ser lançadas pelos métodos remotos. 

Na aula
- é o proprio java com definiçao de interfaces 

#### 4. Que elementos do Java RMI têm as funções equivalentes aos stubs do RPC? 
No Java RMI, os elementos que têm funções equivalentes aos stubs do RPC são os proxies. Os proxies são objetos que representam os objetos remotos no lado do cliente. Quando um cliente chama um método em um objeto remoto, o proxy intercepta a chamada e a encaminha para o objeto remoto. O proxy também é responsável por empacotar e desempacotar os parâmetros e resultados da chamada remota e por gerenciar a comunicação com o objeto remoto. 

Na aula:
- sao os proxies (cliente)e os remote server (servidor)

#### 5. Porque é que a invocação remota de objetos pode conduzir à necessidade de garbage collection distribuída? 
A invocação remota de objetos pode conduzir à necessidade de garbage collection distribuída porque os objetos remotos podem ser referenciados por vários clientes em diferentes locais. Isso significa que a coleta de lixo local pode não ser suficiente para liberar a memória usada pelos objetos remotos. Para resolver esse problema, é necessário implementar uma estratégia de garbage collection distribuída que possa coletar a memória usada pelos objetos remotos em todos os locais em que eles são referenciados. Isso pode ser feito usando técnicas como a marcação e varredura distribuída ou a coleta de lixo por cópia distribuída.

Na aula:
- A unica forma de saber se o objecto ainda e referenciado e se o cliente comunicar que ja nao referencia o objecto.