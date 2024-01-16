As questões presentes ao longo dos slides da apresentação da aula 8 de Computação Distribuída são as seguintes:

Pagina 11
1. Quais são os módulos internos do sistema de ficheiros?
2. Que informação está no bloco de atributos (i-node) do ficheiro?
3. Como é que se sabe quais são os blocos de disco que contêm os dados do ficheiro?

Pagina 19
1. Num sistema de ficheiros distribuído, quais são os componentes do cliente e do servidor?
2. Que mecanismo é que os clientes usam para comunicar com o servidor?
3. Como é feito o controlo de acessos num sistema de ficheiros distribuído?

Pagina 37
1. No NFS, que estado mantém o servidor sobre os clientes?
2. Que mecanismo de comunicação é usado para os clientes comunicarem com o servidor?
3. Como é que o cliente passa a ter visibilidade sobre os ficheiros do servidor? Todos os clientes vêm da mesma forma os ficheiros dos servidores?
4. Como é feita a resolução dos nomes no NFS?
5. Como são otimizadas as operações de leitura e escrita através da cache?
6. Como é garantida a coerência da cache dos clientes?
7. Porque é que quase todas as operações devolvem o parâmetro “attr”, mesmo quando ele parece desnecessário?

Pagina 51
1. Quais são os componentes do AFS?
2. Como é construído o espaço de nomes?
3. O que acontece quando um cliente abre um ficheiro?
4. Quem garante a coerência da cache?
5. Porque é que o AFS é muito mais escalável que o NFS?

--- 
Sumário:

1. Introdução aos Sistemas de Ficheiros Distribuídos
   - Conceitos fundamentais de sistemas de ficheiros distribuídos.
   - Importância da distribuição de ficheiros em ambientes de computação distribuída.

2. Características e Arquiteturas de Sistemas de Ficheiros Distribuídos
   - Exploração da semântica de acessos, coerência e operações básicas em sistemas de ficheiros distribuídos.
   - Análise das diferentes arquiteturas de sistemas de ficheiros distribuídos, incluindo o modelo conceptual e as operações fundamentais.

3. Implementações do NFS e AFS
   - Detalhamento do modelo conceptual, métodos idempotentes, coerência fraca, gestão de cache e escalabilidade no contexto do Network File System (NFS) e do Andrew File System (AFS).
   - Comparação das vantagens e desvantagens de cada sistema, com ênfase nas diferenças de desempenho, segurança e escalabilidade entre o NFS e o AFS.

4. Implementação do NFS
   - Exploração do protocolo NFS para comunicação entre cliente e servidor.
   - Análise da utilização do transporte UDP ou TCP no contexto do NFS.
   - Discussão sobre a gestão de cache no NFS, incluindo estratégias e desafios associados.

5. Gestão de Cache no AFS
   - Detalhamento das técnicas de caching avançadas, como caching persistente de ficheiros no disco local e semântica de cópia única na modificação de ficheiros.
   - Exploração dos mecanismos de "callback promise" utilizados para gerenciar a coerência da cache no AFS.

6. Segurança nos Sistemas de Ficheiros Distribuídos
   - Análise aprofundada dos mecanismos de autenticação, como o Kerberos e o RPCSEC_GSS, utilizados para garantir a segurança nos sistemas de ficheiros distribuídos.
   - Crítica do modelo NFS em relação à consistência e segurança, com destaque para as vulnerabilidades e desafios de segurança associados.

7. Considerações Críticas
   - Análise crítica dos sistemas NFS e AFS, incluindo uma avaliação aprofundada das limitações e desafios enfrentados por cada sistema.

8. Resumo dos Conhecimentos Adquiridos
   - Recapitulação dos conceitos fundamentais de sistemas de ficheiros distribuídos.
   - Síntese das características das arquiteturas NFS e AFS, destacando suas diferenças e aplicações específicas.
   - Discussão aprofundada sobre a problemática do caching nos sistemas de ficheiros distribuídos, com ênfase nos modelos típicos utilizados no NFS e AFS.

Espero que este sumário forneça uma visão abrangente e aprofundada do capítulo 8, abordando os tópicos de forma detalhada e contextualizada.

---
# 1. Quais são os módulos internos do sistema de ficheiros?
Os módulos internos de um sistema de ficheiros (SGF) são componentes fundamentais que trabalham em conjunto para gerir o armazenamento, a recuperação e a atualização de dados em dispositivos de armazenamento. Os módulos internos de um SGF incluem:

1. **Naming Module (Módulo de Nomeação)**: Este módulo é responsável por relacionar os nomes dos ficheiros com os seus identificadores únicos (IDs de ficheiros). Permite que os utilizadores e aplicações acedam a ficheiros usando nomes em texto em vez de terem que lidar com identificadores de baixo nível.
2. **File Module (Módulo de Ficheiros)**: Este módulo lida com a relação entre os IDs de ficheiros e os próprios ficheiros. Ele gere as operações de nível de ficheiro, como a criação, exclusão e manipulação de dados dentro dos ficheiros.
3. **Access Control Module (Módulo de Controlo de Acesso)**: Este módulo verifica as permissões para as operações solicitadas. Ele garante que apenas utilizadores autorizados possam realizar ações específicas em ficheiros e diretorias, de acordo com as políticas de segurança estabelecidas.
4. **File Access Module (Módulo de Acesso a Ficheiros)**: Este módulo é responsável por ler ou escrever dados ou atributos de ficheiros. Ele lida com as operações de entrada e saída (I/O) que movem dados entre o armazenamento e a memória.
5. **Block Module (Módulo de Blocos)**: Este módulo lida com o acesso e a alocação de blocos de disco. Ele gere o espaço de armazenamento no nível de blocos, que são as unidades de alocação de espaço em disco.
6. **Device Module (Módulo de Dispositivo)**: Este módulo é responsável pelo I/O de disco e buffering. Ele interage diretamente com o hardware de armazenamento para realizar operações de leitura e escrita ao nível do dispositivo.

Estes módulos trabalham em camadas, onde cada nível utiliza os serviços das camadas inferiores. Em um SGF distribuído, são necessárias todas essas camadas, além de funcionalidades adicionais relacionadas à nomeação, localização, invocação, mensagens e comunicações para gerir o acesso distribuído aos ficheiros.

## 2. Que informação está no bloco de atributos (i-node) do ficheiro?
O bloco de atributos de um ficheiro, conhecido como i-node, contém metadados essenciais que descrevem as características do ficheiro. As informações armazenadas num i-node incluem:

1. **Length (Comprimento)**: O tamanho do ficheiro em bytes.
2. **Creation Timestamp**: A data e hora da criação do ficheiro.
3. **Read Timestamp**: A data e hora do último acesso para leitura do ficheiro.
4. **Write Timestamp**: A data e hora da última modificação do ficheiro.
5. **Attribute Timestamp**: A data e hora da última alteração dos atributos do ficheiro.
6. **Reference Count**: O número de referências ao ficheiro, como links simbólicos ou hard links.
7. **Version Number**: Um número de versão que pode ser usado para controlar diferentes versões do ficheiro.
8. **Ownership**: Informação sobre o proprietário do ficheiro, geralmente representada pelo ID do utilizador (UID) e ID do grupo (GID).
9. **Type**: O tipo do ficheiro, que pode indicar se é um ficheiro regular, diretório, link simbólico, entre outros.
10. **Access Control List (ACL)**: Uma lista de controlo de acesso que especifica as permissões de diferentes utilizadores e grupos para o ficheiro.
11. **Block List**: Uma lista de ponteiros para os blocos de disco onde os dados do ficheiro estão armazenados. Esta lista é essencial para que o sistema de ficheiros saiba onde encontrar os dados do ficheiro no armazenamento físico.

Estes atributos são armazenados nos diretórios e são usados pelo sistema de ficheiros para realizar operações como nomeação e localização de ficheiros, gestão de atributos, alocação e libertação de espaço de armazenamento, segurança e proteção dos acessos, e provimento de uma API de acesso e respectivos métodos.


## 3. Como é que se sabe quais são os blocos de disco que contêm os dados do ficheiro?
Para saber quais são os blocos de disco que contêm os dados do ficheiro, utiliza-se a informação armazenada no i-node do ficheiro. O i-node contém uma lista de ponteiros, conhecida como block list, que aponta diretamente para os blocos de disco onde os dados do ficheiro estão fisicamente armazenados. Ao ler o i-node do disco, o sistema de ficheiros obtém todos os metadados necessários para localizar e acessar o conteúdo do ficheiro.

# Pag 19
## 1. Num sistema de ficheiros distribuído, quais são os componentes do cliente e do servidor?
No sistema de ficheiros distribuído, os componentes do cliente geralmente incluem a interface de utilizador, o sistema de ficheiros virtual, a cache local e o módulo de comunicação de rede. Os componentes do servidor incluem o gestor de armazenamento, o sistema de ficheiros físico, o módulo de comunicação de rede e, potencialmente, uma cache do lado do servidor.

Num sistema de ficheiros distribuído, os componentes do cliente incluem a aplicação do utilizador, o módulo cliente do sistema de ficheiros (como o NFS Client ou o Venus no AFS), o sistema de ficheiros virtual (VFS) que abstrai o acesso a diferentes sistemas de ficheiros, e uma cache local para otimizar o desempenho através do armazenamento temporário de dados.

Os componentes do servidor consistem no módulo servidor do sistema de ficheiros (como o NFS Server ou o Vice no AFS), que gere as operações de ficheiros e diretórios, o sistema de ficheiros físico que armazena os dados, e potencialmente uma cache do lado do servidor para melhorar a eficiência das operações de leitura e escrita. O servidor também pode incluir mecanismos de segurança, como autenticação e autorização, e funcionalidades para garantir a coerência e a integridade dos dados.


## 2. Que mecanismo é que os clientes usam para comunicar com o servidor?
No contexto dos Sistemas de Ficheiros Distribuídos, os clientes utilizam o protocolo de chamada de procedimento remoto (RPC - Remote Procedure Call) para comunicar com o servidor. Este mecanismo permite que as funções sejam executadas num servidor remoto como se fossem locais ao cliente. No caso específico do NFS (Network File System), o protocolo RPC é utilizado para invocar operações de ficheiros no servidor, podendo operar sobre transporte UDP ou TCP. No AFS (Andrew File System), o RPC também é utilizado para a comunicação entre o componente cliente (Venus) e o componente servidor (Vice), permitindo a transferência de ficheiros, a gestão de cache e a manutenção de promessas de callback para a coerência dos dados.

## 3. Como é feito o controlo de acessos num sistema de ficheiros distribuído?
O controlo de acessos num sistema de ficheiros distribuído é implementado no lado do servidor, garantindo que cada acesso do cliente é validado, uma vez que a mensagem pode atravessar um meio desprotegido. A validação é realizada utilizando credenciais enviadas em cada chamada de procedimento remoto (RPC).

Existem duas opções principais para o controlo de acessos em sistemas de ficheiros distribuídos, como o NFS e o AFS:

1. **Envio da identificação no ato da resolução do nome**: Neste método, quando um cliente resolve um nome de ficheiro, o servidor retorna um identificador único do ficheiro (UFID) e uma capacidade (capability) de acesso para operações subsequentes nesse ficheiro. Este método é utilizado no AFS e permite uma implementação de servidores com estado (statefull), onde o servidor mantém informação sobre as capacidades emitidas.

2. **Envio da identificação em cada mensagem**: Neste método, a identificação do cliente é enviada com cada mensagem RPC. O servidor verifica as credenciais em cada operação para determinar se o cliente tem permissão para realizar a ação solicitada. Este método é utilizado no NFS e permite uma implementação de servidores sem estado (stateless), onde o servidor não precisa manter informação sobre operações anteriores do cliente.

Além disso, o AFS utiliza um mecanismo de segurança baseado em Kerberos para autenticação forte e Listas de Controle de Acesso (ACLs) para definir permissões detalhadas sobre os ficheiros e diretórios. Antes de aceder a um domínio ou célula AFS, é necessário efetuar um login usando o comando `klog`, que obtém um token encriptado (um ticket Kerberos). Este token é utilizado para validar as operações do cliente contra as ACLs associadas ao recurso que está sendo acessado.

Em resumo, o controlo de acessos num sistema de ficheiros distribuído é uma combinação de autenticação do cliente, validação de permissões e, em alguns casos, uso de mecanismos de segurança adicionais como Kerberos e ACLs para garantir que apenas clientes autorizados possam realizar operações nos ficheiros distribuídos.


# Pagina 37
## 1. No NFS, que estado mantém o servidor sobre os clientes?
No NFS (Network File System), o servidor mantém um estado mínimo ou nenhum sobre os clientes. O NFS foi projetado para ser um sistema de arquivos distribuído stateless, o que significa que o servidor não precisa manter informações sobre o estado dos clientes ou das operações de arquivos que estão sendo realizadas por eles. Isso é mencionado no [[cap8 - Sistemas de Ficheiros Distribuídos]] quando se discute a implementação do servidor NFS e a sua interação com os volumes locais através do nível VFS (Virtual File System).

A abordagem stateless do NFS simplifica o design do servidor e melhora a sua robustez em face de falhas de clientes ou de rede, pois não há necessidade de manter ou recuperar o estado do cliente após uma falha. No entanto, isso também significa que o NFS não pode garantir a coerência de cache tão fortemente quanto sistemas que mantêm mais estado, como o AFS, que utiliza um mecanismo de callback para manter a coerência entre os caches dos clientes e o servidor.


## 2. Que mecanismo de comunicação é usado para os clientes comunicarem com o servidor?
No contexto do NFS (Network File System), o mecanismo de comunicação utilizado para os clientes comunicarem com o servidor é o protocolo NFS, que é baseado no Sun RPC (Remote Procedure Call). Este protocolo permite a comunicação entre o módulo cliente e o módulo servidor do NFS, possibilitando que operações de sistema de ficheiros sejam realizadas em ficheiros remotos como se fossem locais. O protocolo NFS pode operar sobre transporte UDP (User Datagram Protocol) ou TCP (Transmission Control Protocol) e é um protocolo aberto, o que significa que qualquer cliente com as credenciais válidas pode realizar invocações ao servidor NFS.

## 3. Como é que o cliente passa a ter visibilidade sobre os ficheiros do servidor? Todos os clientes vêm da mesma forma os ficheiros dos servidores?
No contexto do NFS (Network File System), que é um dos sistemas de ficheiros distribuídos mencionados nas notas, o cliente passa a ter visibilidade sobre os ficheiros do servidor através do processo de montagem (mounting) de um volume NFS. Quando um volume NFS é montado no sistema de ficheiros local do cliente, um diretório local é designado como ponto de montagem e passa a ser o ponto de acesso ao sistema de ficheiros remoto no servidor NFS. Este processo é descrito no capítulo com referência a "mount points" e ao serviço "mountd".

A montagem é realizada através de um comando específico (por exemplo, o comando `mount` em sistemas Unix), que comunica com o serviço `mountd` no servidor NFS. O serviço `mountd` verifica as permissões e, se o cliente estiver autorizado, retorna um "file handle" que representa a diretoria raiz do volume remoto. Este "file handle" é utilizado pelo cliente para todas as operações subsequentes no sistema de ficheiros remoto.

Quanto à visibilidade dos ficheiros, todos os clientes que montam o mesmo volume NFS têm a mesma visão dos ficheiros e diretórios que estão presentes nesse volume, desde que tenham as permissões necessárias para aceder a esses ficheiros. No entanto, a visão de cada cliente pode ser personalizada através de permissões específicas, configurações de montagem e o uso de links simbólicos, como mencionado na secção sobre o espaço de nomeação no AFS, onde symbolic links são utilizados para criar uma nomeação transparente.

É importante notar que, embora os clientes vejam os mesmos ficheiros, a consistência dos dados pode ser afetada pelo caching local no cliente, como discutido nas secções sobre a problemática do caching e a coerência da cache no NFS. A consistência entre as visões dos clientes depende da política de caching e da frequência com que os dados são atualizados ou invalidados no cache local.


## 4. Como é feita a resolução dos nomes no NFS?
A resolução de nomes no NFS (Network File System) é realizada através de um processo iterativo que envolve a operação `lookup`. Esta operação é fundamental para mapear nomes de ficheiros textuais para os seus respectivos identificadores de ficheiros (file handles) dentro do sistema de ficheiros distribuído.

Quando um cliente NFS tenta aceder a um ficheiro, o processo de resolução de nomes ocorre da seguinte forma:

1. O cliente NFS começa por decompor o pathname do ficheiro desejado em componentes individuais, separados por barras ("/").

2. Para cada componente do pathname, o cliente NFS invoca a operação `lookup` no servidor NFS, começando pela raiz do sistema de ficheiros ou pelo ponto de montagem relevante.

3. O servidor NFS processa a operação `lookup`, procurando o componente do nome no diretório especificado e, se encontrado, retorna o file handle correspondente ao próximo componente do pathname.

4. Este processo continua iterativamente até que todos os componentes do pathname tenham sido resolvidos, resultando no file handle do ficheiro ou diretório desejado.

5. Com o file handle obtido, o cliente NFS pode então realizar operações adicionais no ficheiro, como leitura, escrita ou obtenção de atributos.

É importante notar que o NFS utiliza um espaço de nomeação uniforme, o que significa que os mesmos pathnames são utilizados para aceder a ficheiros locais ou remotos, proporcionando transparência de localização aos utilizadores e aplicações.

A resolução de nomes no NFS é descrita no [[cap8 - Sistemas de Ficheiros Distribuídos]] nas secções que abordam a organização do sistema de ficheiros distribuído, a arquitetura NFS e a operação `lookup` como parte da interface do serviço de nomeação.


## 5. Como são otimizadas as operações de leitura e escrita através da cache?
As operações de leitura e escrita em sistemas de ficheiros distribuídos, como o NFS (Network File System), são otimizadas através do uso de cache para melhorar o desempenho e reduzir a latência de rede. No contexto do NFS, conforme descrito no capítulo 8, a otimização ocorre da seguinte forma:

1. **Caching de Leitura (Read Caching):**
   - O cliente NFS mantém um cache de blocos de dados que foram lidos recentemente. Quando uma aplicação solicita a leitura de um ficheiro, o cliente NFS primeiro verifica se os dados estão disponíveis no cache local.
   - Se os dados estiverem no cache e forem considerados válidos (não expirados), o cliente NFS pode fornecer os dados diretamente do cache, evitando a necessidade de uma operação de rede para buscar os dados do servidor.
   - O cliente NFS pode também utilizar técnicas de *read-ahead*, onde lê e armazena no cache blocos de dados adjacentes antecipadamente, prevendo que esses dados possam ser necessários em breve, o que reduz o número de operações de leitura necessárias no futuro.

2. **Caching de Escrita (Write Caching):**
   - Em operações de escrita, o cliente NFS pode armazenar temporariamente as alterações no cache local em vez de enviá-las imediatamente para o servidor. Isso é conhecido como *write-back caching* ou *delayed writing*.
   - O cliente NFS pode decidir enviar as alterações para o servidor após um determinado intervalo de tempo ou quando o cache atinge um certo limite de dados. Isso pode reduzir o número de operações de escrita e a carga na rede.
   - No entanto, para garantir a consistência e a durabilidade dos dados, o cliente NFS pode ser configurado para usar *write-through caching*, onde as alterações são escritas no servidor imediatamente após serem feitas pelo cliente.

3. **Gestão de Coerência de Cache:**
   - Para garantir que os dados no cache estejam consistentes com os dados no servidor, o NFS utiliza um sistema de timestamps para verificar a validade dos dados no cache. Se os dados no cache forem considerados desatualizados, o cliente NFS irá buscar a versão mais recente dos dados do servidor.
   - O NFS também pode utilizar um sistema de *callback* para invalidar entradas de cache quando os dados no servidor são alterados por outros clientes.

Essas técnicas de caching são fundamentais para otimizar as operações de leitura e escrita em sistemas de ficheiros distribuídos, pois permitem que muitas operações sejam realizadas localmente no cliente, reduzindo a latência e o tráfego de rede. No entanto, a eficácia do caching depende da capacidade do sistema em manter a coerência dos dados entre o cache e o servidor, o que é um desafio significativo em ambientes distribuídos.

## 6. Como é garantida a coerência da cache dos clientes?
A coerência da cache dos clientes no contexto do NFS (Network File System) é garantida através de um mecanismo de timestamps e intervalos de confiança. Quando um cliente NFS lê dados de um servidor e os armazena em cache, ele também armazena um timestamp que indica quando os dados foram obtidos. Para garantir a coerência, o cliente NFS usa dois timestamps:

1. Tc (timestamp de validação do cache): o momento em que o item foi validado pela última vez.
2. Tm (timestamp de modificação): o momento em que o item foi modificado pela última vez.

Quando um cliente precisa acessar dados que estão em cache, ele verifica se o intervalo de tempo desde a última validação (T - Tc) é menor que um intervalo de confiança pré-determinado (t). Se for, o cliente assume que os dados em cache ainda são válidos. Se o intervalo de tempo for maior, o cliente faz uma nova solicitação ao servidor para obter o timestamp de modificação mais recente (Tm server) e compara com o Tm local. Se os timestamps de modificação forem iguais, os dados em cache são considerados válidos; caso contrário, os dados são atualizados a partir do servidor.

Este mecanismo não garante uma coerência estrita de cópia única, pois há um intervalo de tempo durante o qual as atualizações podem não ser refletidas imediatamente em todos os clientes. No entanto, ele oferece um equilíbrio entre desempenho (reduzindo a quantidade de comunicação necessária com o servidor) e coerência.

No AFS (Andrew File System), a coerência da cache é gerenciada de forma mais robusta através de um mecanismo de callback promises. Quando um cliente AFS (Venus) obtém uma cópia de um ficheiro do servidor AFS (Vice), ele também recebe uma promessa de callback (callback promise). Esta promessa é um compromisso do servidor de notificar o cliente caso o ficheiro seja modificado por outro cliente. Enquanto a promessa de callback estiver válida, o cliente pode confiar que sua cópia em cache é consistente. Se o ficheiro for modificado, o servidor envia um callback para cancelar a promessa, e o cliente sabe que deve atualizar sua cópia em cache.

Este sistema de callback promises permite que o AFS mantenha uma semântica de cópia única mais forte, garantindo que todas as cópias de um ficheiro sejam consistentes em todos os clientes.

## 7. Porque é que quase todas as operações devolvem o parâmetro “attr”, mesmo quando ele parece desnecessário?
A questão 7 refere-se ao motivo pelo qual quase todas as operações no NFS (Network File System) devolvem o parâmetro "attr", mesmo quando ele pode parecer desnecessário. Este parâmetro "attr" contém os atributos do ficheiro, como tamanho, timestamps de criação, modificação e acesso, permissões, entre outros.

No contexto do NFS, a devolução dos atributos do ficheiro em quase todas as operações é uma estratégia importante por várias razões:

1. **Atualização de Cache**: O cliente NFS mantém um cache dos atributos dos ficheiros para melhorar o desempenho e reduzir a carga na rede. Ao devolver os atributos com cada operação, o servidor NFS permite que o cliente atualize o seu cache de atributos, garantindo que tem a informação mais recente sobre o estado dos ficheiros.

2. **Coerência e Consistência**: Ao fornecer os atributos atualizados após cada operação, o NFS ajuda a manter a coerência e consistência dos dados entre o servidor e os clientes. Isto é particularmente importante em ambientes onde múltiplos clientes podem estar a acessar e modificar os mesmos ficheiros.

3. **Otimização de Desempenho**: Ao obter os atributos mais recentes após cada operação, o cliente pode evitar chamadas adicionais ao servidor apenas para verificar o estado atual do ficheiro. Isto reduz o número de mensagens trocadas entre o cliente e o servidor, otimizando assim o desempenho.

4. **Verificação de Permissões e Segurança**: Os atributos incluem informações de permissões de ficheiros, o que é crucial para a verificação de segurança. Ao devolver os atributos, o servidor NFS fornece ao cliente a informação necessária para determinar se as operações subsequentes são permitidas de acordo com as políticas de segurança.

5. **Simplificação do Protocolo**: Ao padronizar a resposta das operações para incluir os atributos, o protocolo NFS simplifica o design e a implementação tanto do lado do cliente quanto do servidor, pois ambos os lados podem sempre esperar um conjunto consistente de informações após cada operação.

Em resumo, a devolução dos atributos do ficheiro com quase todas as operações no NFS é uma prática que melhora a coerência, otimiza o desempenho e contribui para a segurança e simplicidade do protocolo.

# Pagina 51
## 1. Quais são os componentes do AFS?
Os componentes do Andrew File System (AFS) são:

1. **Módulo Cliente (Venus):** É um processo que opera em modo utilizador e é responsável por distinguir entre acessos a ficheiros locais e remotos. O Venus implementa as funcionalidades do módulo cliente do modelo de referência, gerindo o cache local de ficheiros e interagindo com o módulo servidor para aceder a ficheiros remotos.

2. **Módulo Servidor (Vice):** Também um processo em modo utilizador, o Vice implementa as funcionalidades do módulo servidor do modelo de referência. É responsável por gerir o armazenamento dos ficheiros, processar pedidos dos clientes e manter a consistência dos dados entre os vários clientes.

3. **Modificações Específicas do Kernel do Sistema Operativo:** São alterações feitas no kernel para interceptar chamadas ao sistema de ficheiros e redirecioná-las para o Venus quando se referem a ficheiros remotos. Além disso, estas modificações são responsáveis pela gestão da coerência do cache de ficheiros e pela implementação de medidas de segurança, como a autenticação Kerberos.

Estes componentes trabalham em conjunto para fornecer um sistema de ficheiros distribuído que permite o acesso a ficheiros remotos de forma transparente e segura, com um mecanismo de cache avançado para melhorar o desempenho e a escalabilidade.

## 2. Como é construído o espaço de nomes?
O espaço de nomes em sistemas de ficheiros distribuídos é construído de forma a permitir a organização e localização dos ficheiros e diretórios distribuídos. No contexto do AFS (Andrew File System), por exemplo, o espaço de nomes é construído como uma árvore de tipo Unix, em que o espaço partilhado é visível na diretoria raiz (/afs) ,[object Object],. Além disso, o espaço de nomes pode estar organizado por células ou domínios, como exemplificado por /afs/cs.cmu.edu ,[object Object],. A criação de nomeação transparente é feita através de symbolic links, que permitem a referência a ficheiros e diretórios em diferentes locais do sistema de ficheiros distribuído ,[object Object],.

Essa abordagem permite uma organização hierárquica e transparente dos ficheiros e diretórios, facilitando a localização e acesso aos recursos distribuídos no sistema de ficheiros ,[object Object],.



## 3. O que acontece quando um cliente abre um ficheiro?
Quando um cliente abre um ficheiro em um sistema de ficheiros distribuído, como no caso do AFS (Andrew File System), o seguinte processo ocorre:

1. O cliente envia uma solicitação de abertura de ficheiro para o servidor AFS.
2. O servidor AFS verifica se o cliente tem permissão para acessar o ficheiro solicitado.
3. Se o acesso for autorizado, o servidor AFS fornece ao cliente as informações necessárias para acessar o ficheiro, como a localização do ficheiro e os dados de acesso.
4. O cliente recebe as informações e pode então acessar o ficheiro, seja para leitura, escrita ou outras operações permitidas.

Durante esse processo, o AFS utiliza técnicas de caching avançadas para otimizar o desempenho e minimizar o tráfego na rede, garantindo uma experiência de acesso a ficheiros distribuídos comparável ao acesso a ficheiros locais ,[object Object],.

Essa abordagem permite que os clientes acessem os ficheiros de forma eficiente e segura, mesmo em ambientes distribuídos, contribuindo para a escalabilidade e desempenho do sistema de ficheiros distribuído ,[object Object],, ,[object Object],.


## 4. Quem garante a coerência da cache?
No contexto do AFS (Andrew File System), a coerência da cache é garantida pelo próprio sistema de ficheiros distribuído, por meio de um conjunto de mecanismos e políticas de gestão de cache implementados no cliente AFS, conhecido como Venus ,[object Object],.

O módulo cliente Venus é responsável por distinguir acessos locais de remotos, gerenciar a coerência do cache de ficheiros e garantir a segurança por meio da integração com o sistema de autenticação Kerberos ,[object Object],.

Essa abordagem permite que a coerência da cache seja mantida de forma eficiente e transparente para os clientes, contribuindo para a integridade e consistência dos dados armazenados em cache nos sistemas de ficheiros distribuídos ,[object Object],.

## 5. Porque é que o AFS é muito mais escalável que o NFS?
O AFS (Andrew File System) é considerado mais escalável que o NFS (Network File System) por diversos motivos, entre eles:

1. Caching avançado: o AFS utiliza técnicas de caching avançadas, como caching persistente de ficheiros no disco local e semântica de cópia única na modificação de ficheiros, o que permite uma melhor gestão da cache e redução do tráfego na rede ,[object Object],.

2. Semântica de cópia única: o AFS utiliza a semântica de cópia única na modificação de ficheiros, o que significa que apenas um cliente pode modificar um ficheiro por vez, garantindo a integridade e consistência dos dados ,[object Object],.

3. Gestão de cache baseada em callbacks: o AFS utiliza um sistema de callbacks para gerenciar a coerência da cache, garantindo que os clientes tenham acesso aos dados mais atualizados e reduzindo a necessidade de comunicação com o servidor ,[object Object],.

4. Escalabilidade horizontal: o AFS é projetado para ser escalável horizontalmente, permitindo a adição de novos servidores e clientes sem afetar o desempenho do sistema ,[object Object],.

Esses fatores contribuem para tornar o AFS mais escalável que o NFS, especialmente em ambientes com grande número de usuários e acesso simultâneo a ficheiros distribuídos ,[object Object],.


