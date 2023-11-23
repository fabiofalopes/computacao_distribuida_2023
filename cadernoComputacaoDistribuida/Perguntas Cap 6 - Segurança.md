## **Cap 6 - Segurança**
- Políticas de segurança; Modelo de segurança; Requisitos de segurança
- Criptografia, utilização, exemplos
- Autenticação, autenticação com chave secreta, autenticação com chave pública

### Pag 10
#### 1. Porque razão a segurança informática é tão importante? 
A segurança informática é importante porque protege os sistemas de computador e as informações que eles contêm contra ameaças, como hackers, vírus e malware. A falta de segurança pode levar a perda de dados, roubo de informações confidenciais e danos à reputação da empresa. 

Na aula:
- Por que nossa informação esta toda informatizada 

#### 2. O que é uma política de segurança? 
Uma política de segurança é um conjunto de regras e procedimentos que definem como uma organização protege seus sistemas de computador e informações confidenciais. Ela define as directrizes para a implementação de medidas de segurança, como:
- Isolamento dos Agentes
- Controlo dos Direitos de Acesso
- Controlo do Nível de informação

Na aula:
- O que quero proteger? 
- Para que tipo de ataques? 
- Como esses ataques se podem materializar?

Por exemplo site da lusófona:
- Proteger autenticidade e integridade da informação apresentada no site não seja extraviada . 

Netpa, etc:
- Queremos proteger a informação

Formas de proteger estes sistemas:
- Protecção de tráfego em relação ao exterior
- Criptografia


#### 3. O que significa o isolamento dos agentes? 
Um agente representa no sistema um utilizador humano. O utilizador autentica-se, estabelecendo de forma segura uma relação entre si e o agente que o representa no sistema. É garantida uma maquina virtual onde são executadas as operações em completo isolamento de outras maquinas virtuais de outros agentes. Esse isolamento implica que não é possível um agente sair do confinamento da VM ou usar outros canais para transmissão e recessão de informação entre o sistema.
O isolamento dos agentes é uma técnica de segurança que envolve a execução de diferentes processos ou aplicativos (agentes) em ambientes separados e isolados uns dos outros (uma VM por agente). Isso ajuda a prevenir que um agente mal-intencionado aceda ou danifique outros agentes ou informações confidenciais. 
#### 4. O que é uma Access Control List no modelo DAC? 
Uma Access Control List (ACL) é uma lista de permissões que define quais utilizadores ou grupos têm acesso a determinados recursos num sistema. Guardadas junto de cada objecto. Lista de pares (agente, direitos de acesso)
No modelo DAC (Discretionary Access Control), a ACL é usada para controlar o acesso a arquivos e pastas. 

Na aula: 
- Objecto contendo quais operacões cada agente pode fazer 

#### 5. Considerando uma aplicação cliente-servidor a funcionar no modelo DAC, onde e como têm que ser colocados as verificações de segurança? 
As verificações de segurança **devem ser colocadas no servidor**, que é responsável por controlar o acesso aos recursos. Isso pode incluir autenticação de usuários, verificação de permissões de acesso e criptografia de dados. 


#### 6. No modelo MAC, quem faz as verificações de segurança? 
No modelo MAC (Controle de Acesso Mandatório), as verificações de segurança são feitas pelos agentes (aplicações) que decidem onde e como efectuar as verificações de segurança. O controlo é
discricionário, fica à consideração da aplicação efectuar ou não esse controlo. 
O sistema operativo é responsável por controlar o acesso a recursos com base em políticas de segurança definidas pelo administrador do sistema. 

#### 7. Qual é a relação entre a classificação da informação e os níveis de acesso dos agentes? 
A classificação da informação é usada para definir o nível de segurança necessário para proteger as informações. Os níveis de acesso dos agentes são usados para controlar quem tem acesso a essas informações. Por exemplo, informações altamente confidenciais podem ser acedidas apenas por agentes com níveis de acesso mais altos, enquanto informações menos sensíveis podem ser acedidas
por agentes com níveis de acesso mais baixos.

Na aula: 
- Agentes so podem aceder ao nível actual ou inferior ao seu

### Pag 13
#### 1. Quais são os requisitos de segurança de um sistema distribuído? 
Requisitos de segurança:
- Privacidade: acesso à informação apenas por agentes autorizados
- Integridade: a informação está correcta e completa
- Autenticidade: identificação do agente que produziu a informação
- Não repúdio: impossibilidade de um agente negar uma acção que efectivamente cometeu

#### 2. Quais são as ameaças à segurança um sistema distribuído? 
As ameaças à segurança de um sistema distribuído incluem 2 tipos de ataques:
- **Passivos** 
	- Escuta de mensagens
- **Activos**
	- Interferência com o fluxo de mensagens (modificação, inserção, remoção, troca de ordem de mensagens)
	- Repetição de diálogos passados
	- Falsificação de identidades
	- Man-in-the-middle
	- Denial of service
Estas ameaças podem ser causadas por hackers, malware, vírus e outros agentes mal-intencionados. 
#### 3. Como é que cada ameaça pode comprometer os requisitos de segurança? 
Cada ameaça pode comprometer os requisitos de segurança de diferentes maneiras. 
Por exemplo, um ataque de negação de serviço pode comprometer a disponibilidade do sistema, enquanto uma interceptação de dados ou escuta de mensagens pode comprometer a confidencialidade. 
A modificação de dados pode comprometer a integridade dos mesmo, enquanto a falsificação de identidade pode comprometer a autenticação. 
Um bom sistema necessita de implementar medidas de segurança adequadas para proteger o sistema contra essas ameaças.

### Pag 23
#### 1. O que é a criptografia? 
A criptografia é o processo de codificação de informação de forma a tornar o seu conteúdo
incompreensível e de forma a apenas ser apenas descodificada com uma chave criptográfica que apenas pessoas autorizadas tenham acesso.
#### 2. É boa ideia a segurança de uma comunicação cifrada estar baseada no secretismo do algoritmo de cifra? Porquê? Qual é a solução correta? 
Não é uma boa ideia basear a segurança de uma comunicação cifrada no secretismo do algoritmo de cifra. Isso porque, se o algoritmo for descoberto, a segurança da comunicação será comprometida. A solução correta é usar algoritmos de criptografia bem conhecidos e testados, que são considerados seguros pela comunidade de segurança. 
#### 3. O que é cifra simétrica e cifra assimétrica? Qual é mais rápida? Porquê? 
A cifra simétrica é um método de criptografia que usa a mesma chave (Chave Secreta) para encriptar e desencriptar os dados. 
A cifra assimétrica, por outro lado, usa um par de chaves diferentes - uma chave pública para encriptar os dados e uma chave privada para desencriptar-los. A cifra simétrica é geralmente mais rápida do que a cifra assimétrica, porque requer menos processamento de computador. 

#### 4. Qual é a vulnerabilidade da cifra por blocos? 
- Um bloco cifrado é obtido pela cifra do bloco original
- Não depende dos blocos anteriores nem dos
seguintes. O mesmo valor, cifrado com a mesma
chave, produz sempre o mesmo resultado
- Algoritmo mais simples, facilita a análise
- **Susceptível de ataques de repetição de blocos**


#### 5. Como é que a cifra contínua ultrapassa a vulnerabilidade da cifra por blocos? 
A cifra contínua é um método de criptografia que usa uma chave de criptografia que é tão longa quanto a mensagem a ser encriptada. Isso significa que não há blocos de dados que possam ser modificados, tornando a cifra contínua mais segura contra ataques de modificação de dados. 
- Um bloco cifrado depende da cifra do bloco original e dos blocos anteriores
- Início da mensagem tem que conter um initialisation vector com um valor diferente em cada mensagem (ex: timestamp)

#### 6. Como é possível garantir privacidade e autenticidade numa comunicação usando cifra simétrica? E cifra assimétrica?
Para garantir privacidade e autenticidade em uma comunicação usando **cifra simétrica**, é necessário que as chaves de criptografia sejam mantidas em segredo e que a autenticação seja feita usando um protocolo de autenticação seguro. 
Para garantir privacidade e autenticidade em uma comunicação usando **cifra assimétrica**, é necessário que a chave privada seja mantida em segredo e que a chave pública seja compartilhada com as partes autorizadas. A autenticação pode ser feita usando a chave pública para verificar a assinatura digital.
#### 7. Como é construída e verificada uma assinatura digital? O que é que ela garante? 
Uma assinatura digital é construída usando um algoritmo de criptografia assimétrica, onde a chave privada é usada para assinar a mensagem e a chave pública é usada para verificar a assinatura. A assinatura digital garante a autenticidade da mensagem, pois somente a pessoa com a chave privada pode assinar a mensagem.

Informação assinada: calcula-se um resumo D de M $(D - digest)$
Cifra-se o digest: M, {D}K
- O digest da mensagem garante
	- Integridade: a mensagem não foi alterada e o digest também não (por estar cifrado)
	- Autenticidade: o digest cifrado garante que foi gerado por quem conhece a chave **– assinatura digital**


### Pag 37 
#### 1. O que é autenticação forte? 
A autenticação forte é um método de autenticação que requer mais do que 1 factor para verificar a identidade de um utilizador. 
1. Conhecimento: o que sabe. 
	- Ex: password, código PIN, número cartão cidadão
2. Propriedade: o que possui. 
	- Ex: token, cartão matriz, telemóvel
1. Inerência: o que é. 
	- Ex: características biométricas como impressão digital, retina

#### 2. Usando o mecanismo de chave pública (PKI), como é que A envia a B uma mensagem M autenticada? E com privacidade? E autenticada e com privacidade?
Para enviar uma mensagem M autenticada usando PKI, A encripta a mensagem com a chave pública de B e assina digitalmente a mensagem com sua própria chave privada. Isso garante que a mensagem venha de A e que não foi modificada durante a transmissão. Para enviar uma mensagem com privacidade, A encripta a mensagem com a chave pública de B. 
Para enviar uma mensagem autenticada e com privacidade, A encripta a mensagem com a chave pública de B e assina digitalmente a mensagem com sua própria chave privada. 

Autenticação
```
A → B{M}KApriv
B: {{M}KApriv}KApub
```

A envia a B uma mensagem M cifrada com a sua chave privada
B decifra a mensagem M com a chave pública de A
	• Mensagem autenticada: só pode ter sido gerada por A, pois só A conhece a sua chave privada
	• Conteúdo da mensagem é público: qualquer um pode decifrar a mensagem com a chave pública
	de A


Privacidade
```
A →B {M}KBpub
B: {{M}KBpub}KBpriv
```
A envia a B uma mensagem M cifrada com a chave pública de B
B decifra a mensagem M com a sua chave privada
	• Mensagem privada: só pode ser decifrada com a chave privada de B, que só este conhece
	• Conteúdo não autenticada: qualquer um pode enviar esta mensagem cifrada com a chave
	pública de B

Autenticação e Privacidade
```
A →B {{M}KApriv} KBpub
B: {{{{M}KApriv} KBpub}KBpriv}KApub 
```
A envia a B uma mensagem M cifrada com a sua chave privada e com a chave pública de B
B decifra a mensagem M com a sua chave privada e depois com a chave pública de A


#### 3. Como é que uma autoridade de certificação S envia a A a chave pública de B? E como envia a A a chave privada de B? 
A autoridade de certificação S envia a chave pública de B para A por meio de um certificado digital. O certificado digital contém a chave pública de B e é assinado digitalmente pela autoridade de certificação S. A chave privada de B nunca é enviada para A, pois é mantida em segredo por B. 

- S conhece as chaves públicas de A e B
- Todos conhecem a chave pública de S

|Etapa|Ação|
|---|---|
|1.  A → S: B|A solicita a chave pública de B à Autoridade de Certificação (CA).|
|2. S → A: {KBpub, B, Ts}KSpriv|A CA envia para A a chave pública de B (KBpub), autenticada através da cifra com a sua chave privada.|
|3. A → B: {M1, A, Ts} KBpub|A envia a B uma mensagem cifrada com a chave pública de B que contém o seu identificador e um carimbo temporal.|
|4. B → S: A|B solicita a CA a chave pública de A.|
|5.  S → B: {KApub A} KSpriv|A CA envia para B a chave pública de A (KApub), autenticada através da cifra com a sua chave privada.|
|6. B → A: {M2, B, Ts}KApub|B envia a A a mensagem de resposta cifrada com a chave pública de A.|

- **Etapa 1:** A primeira etapa do processo é A pedir à CA a chave pública de B. A CA é uma entidade confiável que armazena e distribui chaves públicas. A chave pública de B é um valor que pode ser usado para cifrar mensagens para B.
- **Etapa 2:** A CA envia para A a chave pública de B (KBpub), autenticada através da cifra com a sua chave privada. A mensagem é cifrada usando a chave privada da CA, que é conhecida apenas pela CA. A chave pública de B é decifrada usando a chave pública da CA, que é conhecida publicamente.
- **Etapa 3:** A terceira etapa é A enviar a B uma mensagem cifrada com a chave pública de B. A mensagem contém o identificador de A e um carimbo temporal. O identificador de A é um valor que identifica A de forma única. O carimbo temporal é um valor que indica quando a mensagem foi enviada.
- **Etapa 4:** A quarta etapa é B pedir à CA a chave pública de A. Esta etapa é semelhante à Etapa 1.
- **Etapa 5:** A quinta etapa é A CA enviar para B a chave pública de A (KApub), autenticada através da cifra com a sua chave privada. Esta etapa é semelhante à Etapa 2.
- **Etapa 6:** A sexta e última etapa é B enviar a A a mensagem de resposta cifrada com a chave pública de A. A mensagem contém o identificador de B e um carimbo temporal.
Este processo permite que A e B troquem mensagens de forma segura, mesmo que não se conheçam pessoalmente. A chave pública de cada parte é usada para encriptar as mensagens enviadas para a outra parte. A chave privada de cada parte é usada para desencriptar as mensagens recebidas da outra parte.


#### 4. O que é um certificado digital? 
Um certificado digital é um documento electrónico que contém informações sobre a identidade de uma pessoa, organização ou dispositivo. Ele é usado para autenticar a identidade de um utilizador e garantir a integridade das informações transmitidas. 

Certificado: documento assinado por uma autoridade de certificação
- Confirma a validade de uma chave pública
- Associa-a a informação do seu possuidor:
	- Informação sobre o dono (nome, e-mail, etc.)
	- Datas (de emissão, de validade)


#### 5. No protocolo Needham – Schroeder, porque é que B quando recebe a mensagem 3 acredita que ela vem de A? 
No protocolo Needham-Schroeder, B acredita que a mensagem 3 vem de A porque a mensagem contém um nonce (um número usado apenas uma vez) que foi criado por B e enviado para A na mensagem 2. A mensagem 3 contém o nonce de B, o que prova que a mensagem foi enviada por alguém que conhece o nonce de B, que é A.

**Protocolo de Needham-Schroeder** Autenticação com chave secreta
- S conhece as chaves privadas de A e B

|Etapa|Ação|
|---|---|
|1. A -> S: A,B, Na |A pede a S uma chave privada para comunicar com B. Inclui um valor arbitrario Na.|
|2. S -> A: {Na, B, Kab, {Ts, A, Kab}Kb}Ka|S gera a chave Kab. Envia a A, cifrado com a chave de A, a chave Kab, um timestam p e um ticket incompreensivel para A porque esta cifrado com a chave de B. A decifra a mensagem com a sua chave e obtém a chave Kab, a identificagao de B e Na. Confia na mensagem pois esta cifrada com a sua chave. Na garante que esta mensagem é a resposta ao seu pedido.|
|3. A —> B: {A, Ta}Kab, {Kab, A, Ts}Kb| A envia a B uma mensagem cifrada com a chave Kab contendo o seu identificador A, um timestamp Ta e o ticket que recebeu de S.  B decifra o ticket com a sua chave secreta e obtém a chave Kab. Confia no ticket porque esta cifrado com a sua chave secreta e Ts garante que é recente. Usando Kab decifra a outra parte da mensagem, obtém o identificador A e Ta. B confia na identidade de A pois recebeu essa informação cifrada com uma chave Kab que so pode ter sido gerada por S, que conhece a chave secreta de B.|
|4. B -> A: {Ta + 1}Kab| B responde a A com uma mensagem contendo um valor derivado de Ta e cifrada com a chave Kab. A confia na identidade de B pois este respondeu ao seu desafio (Ta) numa mensagem cifrada com a chave secreta |

#### 6. Usando o protocolo Needham – Schroeder como é que A pode enviar a B uma mensagem M autenticada e com privacidade? 
Para enviar uma mensagem M autenticada e com privacidade usando o protocolo Needham-Schroeder, A pode usar um esquema de criptografia de chave pública para criptografar a mensagem com a chave pública de B. A pode então assinar digitalmente a mensagem com sua própria chave privada. A mensagem criptografada e assinada é então enviada para B, juntamente com um nonce (um número usado apenas uma vez) gerado por A. B pode verificar a autenticidade da mensagem usando a chave pública de A e descriptografando a mensagem. B pode verificar a integridade da mensagem usando a assinatura digital de A. Para garantir a privacidade da mensagem, A deve criptografar a mensagem com a chave pública de B. 

**Kerberos: servidor de autenticação baseado no
protocolo Needham-Schroeder**

**TICKETxy: {X, Y, T1, T2, Kxy}Ky**
	T1: timestamp com início de validade do ticket
	T2: timestamp com fim de validade do ticket
**AUTHxy: {X, Tx}Kxy**
	

**Login**
1. A → S: A, TGS, Na
2. S → A: {Katgs, Na, TICKETatgs}Ka
**Pedido de acesso ao Servidor B**
3. A → TGS: TICKETatgs, AUTHatgs, B, Na
4. TGS → A: {Kab, Na, TICKETab}Katgs
**Comunicação inicial entre A e B**
5. A → B: TICKETab, AUTHab, Mrequest
6. B → A : {Treq+1}Kab , Mreply
**Comunicação autenticada entre A e B**
7. A → B: AUTHab, Mrequest
8. B → A : {Treq+1}Kab , Mreply

|Etapa|Ação|
|---|---|
|1. A -> S:A, TGS, Na|A pede a S uma chave para comunicar para o TGS.|
|2. S -> A: {Katgs, Na, TICKETatgs}Ka|S cria uma chave secreta para A comunicar com 0 TGS e devolve-a cifrada com a chave de A. Envia também um ticket incompreensivel para A. A obtém a chave para o TGS, guarda-a e apaga da memoria a sua chave secreta (password).|
|3. A -> TGS: TICKETatgs, AUTHatgs, B, Na | A envia ao TGS um pedido para comunicar com B onde inclui o ticket que recebeu de S, o autenticador cifrado com a chave secreta entre A e o TGS e a identificagao de B|  
|4. TGS -> A: {Kab, Na, TICKETab}Katgs| OTGS cria a chave Kab para A comunicar com B e um ticket cifrado com a chave de B. Envia ambos cifrados com a chave secreta de Ae TGS|   
|5. A -> B: TICKETab, AUTHab, Mrequest | A obtém a chave secreta Kab, envia a B 0 ticket recebido do TGS e autenticador cifrado com a chave secreta entre A e B. B decifra o ticket com a sua chave e obtém a chave secreta entre A e B. Com esta decifra o autenticador e confirma a identidade de A. O pedido esta autenticado.| 
|6: B -> A: {Treq+1}Kab , Mreply |B responde a A cifrando o “challenge” Treq com a chave Kab. A decifra a resposta e obtém o challenge” correcto. A resposta esta autenticada.|
|7. A -> B: AUTHab, Mrequest | Depois da autenticação inicial, A ja nao necessita de enviar o ticket a B, mas o autenticador tem que ser enviado em todas as mensagens.|
|8: B -> A: {Treq+1}Kab , Mreply | B tem que responder sempre com o “challenge” cifrado com a chave Kab para autenticar a resposta|

#### 7. Para que servem os elementos Na e Ts nas mensagens 1 e 2 do protocolo Needham – Schroeder? 
Os elementos Na e Ts nas mensagens 1 e 2 do protocolo Needham-Schroeder são usados para evitar ataques de repetição. Na é um nonce (um número usado apenas uma vez) gerado por A e incluído na mensagem 1. Ts é um timestamp (marca de tempo) gerado por S e incluído na mensagem 2. Quando A recebe a mensagem 2, ele pode verificar se o timestamp é recente e se corresponde ao nonce que ele enviou na mensagem 1. Isso garante que a mensagem 2 é uma resposta legítima à mensagem 1 e não uma mensagem repetida de um atacante.

#### 8. No Kerberos, porque é que os relógios dos clientes e servidores têm que estar sincronizados? 
No Kerberos, os relógios dos clientes e servidores devem estar sincronizados para evitar ataques de repetição. O Kerberos usa timestamps (marcas de tempo) para evitar ataques de repetição, e se os relógios dos clientes e servidores não estiverem sincronizados, os timestamps podem ser considerados inválidos. Isso pode permitir que um atacante repita uma mensagem anterior e engane o sistema de autenticação. Portanto, é importante que os relógios dos clientes e servidores estejam sincronizados para garantir a segurança do sistema de autenticação do Kerberos.


----
Na aula:

Podemos enviar mensagens :
- cifra com a própria chave privada 
- ou com a chave publica do destinatário


Assinaturas diginais:
- Calcular um digest do conteudo
	- mais pequeno que o documentos, de tal forma que se 1 bit for diferente -> checksum diferente

- Sender:
	- Assinatura: calcular digest + cifrar com chave private
	- enviar documento assinado (conjunto de M e assinatura)