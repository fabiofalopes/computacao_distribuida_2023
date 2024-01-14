 ## **Cap 5 - Web Services**
- Objetivos e aplicações de Web Services (WS), exemplos
- Linguagem de Definição de Serviços (WSDL)
- Serviço de Directório de WS, UDDI, Protocolo SOAP
- Aplicações de Web Services

- **Modelo de Execução Web Services (WS)**  
	- Register, Discover, Invoke
- **O protocolo SOAP**  
	- Envelope, Headers e Body  
- **Linguagem de Definição de Serviços**  
	- Estrutura e exemplos de WSDL  
- **Serviço de Directório de WS**  
	- UDDI  
- **Comparação dos modelos de invocação WS e RMI**  
- **Integração com Java**  
	- JAX-WS e Utilização de um IDE  
- **Aplicações de Web Services**  
	- Integração entre empresas distintas  
	- SOA

### Pag. 17
#### 1. Quais são os problemas que se pretendem resolver com os Web Services ? 
Web Services foram criados para resolver problemas de integração de sistemas heterogéneos, permitindo que diferentes aplicações comuniquem entre si e compartilhem dados de forma padronizada e independente de plataforma. Além disso, os Web Services também permitem a criação de serviços distribuídos, que podem ser acedidos por diferentes clientes em diferentes locais.

A arquitectura da Web adapta-se a esta realidade
- Web Services - maior flexibilidade e interoperabilidade
	- Definição das interfaces de forma independente das linguagens de programação (WSDL)
	- Clientes e servidores podem estar escritos em linguagens diferentes
	- Formato das mensagens independente da implementação (SOAP)


#### 2. Porque razão o Sun RPC e o Java RMI não são adequados para resolver esses problemas ?
O Sun RPC e o Java RMI não são adequados para resolver esses problemas porque eles estão limitados a sistemas homogéneos, ou seja, sistemas que utilizam a mesma plataforma e linguagem de programação. Além disso, eles não fornecem um padrão para a comunicação entre sistemas, o que dificulta a integração de diferentes aplicações. Os Web Services, por outro lado, são baseados em padrões abertos e independentes de plataforma, permitindo a comunicação entre sistemas heterogéneos de forma padronizada e eficiente.

### Pag. 40

#### 1. Qual é a IDL dos Web Services? Como é que essa IDL se compara com a IDL do Sun RPC e a IDL do Java RMI?
A IDL (Interface Definition Language) dos Web Services é a WSDL (Web Services Description Language). 
A WSDL é usada para descrever a interface de um Web Service, incluindo as operações que ele fornece, as mensagens que espera e retorna e os protocolos que usa. Em comparação, o Sun RPC e o Java RMI usam suas próprias IDLs para definir as interfaces de seus objetos remotos.  

WSDL: Linguagem de definição de interface (IDL) baseada em XML para definir:
	• Interface do serviço
	• Protocolo de acesso
	• Endpoints de acesso
	• Aspectos de implementação

#### 2. Porque razão os Web Services definem o formato das mensagens trocadas entre cliente e servidor, ao contrário do Sun RPC e do Java RMI?
Os Web Services definem o formato das mensagens trocadas entre cliente e servidor porque são projetados para serem independentes de plataforma e linguagem. Ao definir um formato de mensagem padrão (como SOAP ou REST), os Web Services podem garantir que diferentes sistemas possam se comunicar entre si, independentemente da linguagem de programação ou plataforma que estão a usar. Em contraste, o Sun RPC e o Java RMI são projetados para uso dentro de uma única linguagem de programação ou plataforma, portanto, não precisam definir um formato de mensagem padrão.  

#### 3. O que se define na parte abstrata e na parte concreta do WSDL? 
A parte abstrata do WSDL define a interface do Web Service, incluindo as operações que ele fornece, as mensagens que espera e retorna e os protocolos que usa. A parte concreta do WSDL define a localização de rede do Web Service, incluindo o URL do ponto de extremidade do serviço e as informações de associação que especificam como acessar o serviço.  

#### 4. Quais são e para que servem os 6 elementos do WSDL? 
Elementos do WSDL
- **Service: definição da localização (URL) do serviço (colecção de ports relacionados, identificados por um único nome)**
	- Um documento WSDL pode conter vários service, mas por convenção contém apenas um
	- Cada serviço tem que ter um nome único
	- A convenção de nome é NomeService
- **Port: definição do endereço físico (URL) do serviço (especifica o endereço do WebService, normalmente um URL)**
	- Associa um único endereço, protocol-specific, ao elemento binding
	- Ports têm que ser únicos num documento WSDL
- **Binding: definição do formato da mensagem (define o formato da mensagem, de uma forma dependente do protocolo)**
	- Cada portType pode ter um ou mais elementos binding associados
	- Para um portType, o elemento binding especifica um par messaging e transport (SOAP/HTTP, SOAP/SMTP, etc).
- **PortType: definição dos métodos a invocar (descreve a interface do Web Service)**
	- Contém um único atributo name: nome_do_WSPortType
	- Contém um ou mais elementos operation, pode definir elementos input, output e fault
- **Message: definição das mensagens trocadas (colecção de parts; part: named argument e respectivo tipo)**
	- Cada elemento message pode ser usado como mensagem input, output ou fault numa operation
	- O atributo type da part pode ser qualquer tipo standard do schema XSD ou um tipo definido pelo utilizador
- **Types: definição dos tipos de dados utilizados (definição abstracta dos tipos definidos pelo utilizador)**
	- Um documento WSDL pode conter no máximo um elemento types
	- O elemento types pode conter simpleType ou complexType.
	- Elementos são definidos com um name e um atributo type


### Pág. 75

#### 1. Para que serve o UDDI?
O UDDI (Universal Description, Discovery, and Integration) é um protocolo de descoberta de serviços Web que permite que as empresas publiquem e descubram serviços Web num diretório centralizado. Fornece uma maneira padronizada de descrever serviços Web e seus recursos, permitindo que os usuários encontrem e utilizem esses serviços de forma mais eficiente.  

UDDI - Componentes
- **Service Registry**
	- Provides support for publishing and locating services
	- Like telephone yellow pages
- **Service Provider**
	- Provides e-business services
	- Publishes availability of these services through a registry
- **Service Requester**
	- Finds required services via the Service Registry
	- Binds to services via Service Provider

**Serviço de Directório Web Services: UDDI**
- Universal Description, Discovery, and Integration (UDDI)
	- Serviço de nomes e de directório para acesso a informação genérica sobre Web Services
- Permite dois tipos de acessos
	- White Pages - nomes
	- Yellow Pages - atributos
- O UDDI tem uma organização hierárquica em 4 níveis:
	- businessEntity: características da organização que fornece os serviços, tais como actividade, nome, endereço, etc..
	- businessServices: serviços agrupados por tipo designados por um nome e um ramo de actividade
	- bindingTemplate: endereço dos Web Services e referências para as suas descrições (por URL)
	- tModel: descrição detalhada do serviço, geralmente fornecida por um ficheiro wsdl
- Cada elemento (excepto o tModel) é identificado por uma chave e pode ser acedido directamente

**Operações UDDI**
- O UDDI fornece interfaces de acesso para procura e obtenção de informação sobre os WS
	- Operações de Procura (find_xxx) recebem um nome e retornam uma chave
		- find_business, find_service, find_binding, find_tModel
	- Operações para obtenção de informação (get_xxx) recebem uma chave e retornam dados
		- get_BusinessDetail, get_ServiceDetail, get_BindingDetail, get_tModelDetail
	- A partir da obtenção do tModel, o serviço pode ser invocado se o cliente tiver direitos de acesso
- Interface de Publicação
	- Permite registar um serviço e actualizar informação associada
- Registos
	- O conjunto da informação de uma dada instância de UDDI é armazenada em registos contidos em vários servidores que podem ser replicados
- Exemplos de serviços UDDI
	- XMethods
	- Microsoft


#### 2. Existem elementos semelhantes ao UDDI no Sun RPC e no Java RMI? Se sim, quais?

O SOAP suporta dois estilos de comunicação:
- **(Remote Procedure Call) RPC - Style**
	- Um Web Service de RPC-Style comporta-se como um objecto remoto para a aplicação cliente
	- A interacção entre o cliente e o serviço é centrada numa interface de especificação de serviço
	- O cliente exprime os seus pedidos através de uma invocação de método com um conjunto de argumentos, que retornam uma resposta contendo o valor associado
- **Document-Style**
	- Num Web Service Document-Style, o corpo da mensagem contém um fragmento de documento XML, sem estrutura explícita
	- O runtime SOAP aceita o elemento do corpo da mensagem tal como é enviado e passa-o à aplicação para o qual é destinado sem modificação
	- Pode ou não haver resposta associada a esta mensagem

**Comparação com o Modelo de Objectos**
- **O modelo de invocação de Web Services é muito semelhante ao do RMI**
	- Mas existem diferenças importantes 
- **Referências**
	- Uma referência para um objecto remoto designa a instância de uma classe que implementa uma interface
		- Um objecto pode ser instanciado remotamente
	- Uma referência para um WS designa uma interface e o WS não pode ser instanciado
	- Não podem ser passadas referências para objectos na invocação de um WS
- **Estado**
	- Um objecto remoto pode guardar estado entre a execução de métodos
	- Um WS não guarda estado normalmente, precisa de utilizar extensões para o fazer (WSRF)
- **Execução**
	- Um objecto remoto pode ser executado em modo stand-alone desde que contenha uma classe que implemente um servidor
	- Um Web Service tem de ser executado no contexto de um container


#### 3. Indique um exemplo de binding de Web Services com SOAP a um protocolo de transporte. 
Um exemplo de binding de Web Services com SOAP a um protocolo de transporte é o uso do HTTP (Hypertext Transfer Protocol) como protocolo de transporte para enviar e receber mensagens SOAP entre o cliente e o servidor. O SOAP pode usar os métodos GET ou POST do HTTP para enviar e receber mensagens, dependendo do tipo de operação que está sendo realizada.  

SOAP e HTTP
- A ligação (binding) SOAP a um protocolo é a descrição de como a mensagem é enviada usando esse protocolo de transporte
- A ligação típica do SOAP é HTTP
- O SOAP pode usar os métodos GET ou POST
	- GET: o pedido não é uma mensagem SOAP só a resposta
	- POST: pedido e resposta são ambos mensagens SOAP
- O SOAP utiliza os mesmos códigos de erro e estado do HTTP de forma a que as respostas possam ser directamente interpretadas pelo módulo SOAP

Aspectos do SOAP
- **As mensagens SOAP são independentes do protocolo, mas subsiste um problema a nível do endereçamento**
	- Não contém referências ao endereço de destino
	- O protocolo utilizado especifica o endereço 
- **No caso da utilização de HTTP em modo request-reply**
	- O POST transporta a mensagem de request
	- A resposta ao POST retorna o reply
	- O header HTTP
		- Indica um content-type: $application/soap+xml$
		- Contém uma referência para o método: Action: $<Web Service URL> #method$
		- Existe aqui alguma dependência entre protocolo HTTP e a mensagem
- **WS-Adressing**
	- Extensão do protocolo SOAP para incluir directivas de endereçamento nos headers
		• Identificação de mensagens
		• Definição de end-points (origem e destino)



#### 4. Como é que um IDE (Integrated Development Environment) pode facilitar o desenvolvimento de aplicações com Web Services?
Um IDE (Integrated Development Environment) pode facilitar o desenvolvimento de aplicações com Web Services fornecendo ferramentas e recursos para criar, testar e depurar serviços Web. Ele pode incluir recursos para gerar automaticamente o código necessário para criar e consumir serviços Web, bem como para testar e depurar esses serviços. Alguns IDEs também podem fornecer recursos para gerenciar serviços Web e seus recursos, como o UDDI. 

Utilização de Integrated Development Environments
- A implementação de Web Services é muito facilitada pela utilização de IDEs - Integrated Development Environments
- Integram ainda mais os aspectos programáticos da linguagem com as funcionalidades fornecidas pelos geradores de interfaces
- Todos os aspectos ligados à utilização de XML são escondidos pela ferramenta
- Exemplos
	- Eclipse, NetBeans, ...
- Tutorials
	- Java EE 5 e Web Services
		- http://java.sun.com/javaee/5/docs/tutorial/doc/index.html
	- NetBeans e Web Services com Java EE 5
		- http://www.netbeans.org/kb/55/websvc-jax-ws.html


---

**Contexto de Execução de um WS**
- Um Web Service é geralmente executado no contexto de um Servidor aplicacional
	- Pode correr dentro ou fora do servidor Web
- Exemplos:
	- Servlet Engine: Tomcat
	- App Server: JBOSS, Sun Java Application Server
	- Apache Server: módulo php
	- Microsoft .NET

**Java e Web Services**
- Embora o XML seja um formato literal, a programação das interfaces e do acesso a Web Services não é fácil de fazer directamente
- A linguagem Java fornece uma série de APIs que permitem:
	- Implementar Web Services e exportar as suas interfaces, através da geração automática de WSDL
	- Invocar directamente Web Services através do conhecimento do respectivo WSDL através da geração de
		- Proxy cliente e skeleton servidor
		- Mensagens em SOAP para envio do pedido e descodificação da resposta
- JAX-RPC:
	- Extensão do RMI que permite criar e invocar Web Services
	- Utiliza SOAP e XML based RPC
	- Suplantado pelo JAX-WS
- JAX-WS:
	- Nova plataforma integrada baseada em JEE 5 e no projecto GlassFish (Open Source)
	- Permite a descrição e binding de Web Services na própria linguagem Java
	- Cria uma correspondência directa entre documentos XML e objectos Java através da utilização do JAXB (Java Architecture for XML Binding)

**JAXB: Java Architecture for XML Binding**
- Framework genérica que permite a uma aplicação realizar o parsing de XML obedecendo a um schema determinado
- O binding compiler gera as classes Java a partir do schema ao qual obedece o documento, e estas são invocadas a partir da aplicação
- Através do package javax.xml.bind, o documento é convertido numa árvore de objectos com o conteúdo proveniente dos elementos XML
- Os dados podem ser modificados pela aplicação validados de acordo com o schema, e de novo serializados para um novo documento XML
- A fonte de XML pode ser qualquer, como por exemplo uma mensagem SOAP ou um ficheiro WSDL


**JAX-WS: Java Web Services**
- Java API for XML WebService
- Utiliza anotações inseridas no código para a definição das interfaces no servidor e das referências no cliente
- O gerador de interfaces (wsgen) utiliza as anotações para gerar o código de invocação do serviço no cliente e no servidor assim como a descrição do mesmo em WSDL 
- @WebService()
	- Indica que a classe anotada implementa um Web Service
- @WebMethod
	- Indica que o método anotado é a implementação de uma das funções do web Service
- @WebServiceRef
	- Permite a um cliente referenciar a descrição do serviço em WSDL
