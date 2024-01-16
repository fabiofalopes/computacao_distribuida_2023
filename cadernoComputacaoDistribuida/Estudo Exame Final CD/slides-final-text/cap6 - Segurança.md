Computação Distribuída
Cap VI – Segurança
Licenciatura em Engenharia Informática
Universidade Lusófona
Prof. Paulo Guedes (paulo.guedes@ulusofona.pt)

Politicas de Segurança
► Quando é que se torna necessário uma política de segurança ?
 Quando um bem com valor é colocado num espaço partilhado criam-se
condições para que o bem possa ser alvo de ameaças

► Uma política de segurança procura garantir a protecção do bem dentro
de determinados condicionantes.
► Uma política de segurança define-se respondendo às seguintes
questões:
 O que queremos proteger ?
 Quais as ameaças potenciais ?
 Como é que os ataques correspondentes às ameaças se podem
materializar ?
 Quais os procedimentos e mecanismos de protecção que podem impedir os
ataques considerados ?
 Qual o custo de implementação da política ?
Tecnologia de Sistemas
Distribuídos
6. Segurança

4.2

Licenciatura Eng.ª Informática

Politicas de Segurança nos Sistemas Informáticos
► Ameaças






Divulgação da informação
Modificação da informação
Execução de operações não autorizadas
Destruição de informação
Impedir o acesso a informação

► Motivações para os ataques







Reconhecimento, fama
“Diversão”, vandalismo
Bullying
Criminalidade (roubo, extorsão)
Ataque comercial
Ataque político

Tecnologia de Sistemas
Distribuídos
6. Segurança

4.3

Licenciatura Eng.ª Informática

Cybersecurity in the 2010s

Computação Distribuída

4.4

Licenciatura Eng.ª Informática

Cybersecurity as an enabler of organizational resiliency

Computação Distribuída

4.5

Licenciatura Eng.ª Informática

Politicas de Segurança nos Sistemas Informáticos
► Isolamento dos Agentes
► Controlo dos Direitos de Acesso
► Controlo do Nível de informação

Tecnologia de Sistemas
Distribuídos
6. Segurança

4.6

Licenciatura Eng.ª Informática

Isolamento dos Agentes
► Agentes: elementos activos no sistema (aplicações). Um agente
representa no sistema um utilizador humano
► Autenticação: estabelecimento de forma segura da relação entre o
utilizador humano e o agente que o representa no sistema
► O sistema garante que ao agente é atribuída uma máquina virtual em
que ele executa as operações sobre os objectos em completo
isolamento das máquinas virtuais atribuídas a outros agentes. Exemplo
de máquina virtual: canal de comunicação privado.
► O isolamento implica que não existem meios para um agente ultrapassar
os mecanismos de confinamento ou enviar informação através de canais
encobertos

Tecnologia de Sistemas
Distribuídos
6. Segurança

4.7

Licenciatura Eng.ª Informática

Controlo de direitos de acesso
DAC – Discretionary Access Control
►
Os objectos são protegidos por um monitor de segurança.
►
O agente (aplicação), antes de efectuar um acção sobre um objecto, pede autorização ao monitor
►
O monitor verifica se o agente está ou não autorizado através de uma matriz de direitos acesso
Agentes / Objectos

Obj 1

Obj 2

Obj 3

Obj 4

Agente 1

R

RW

RX

---

Agente 2

RX

---

RW

R

►

Construção da tabela



►
►
►

Listas de controlo de acesso (Access Control Lists, ACLs). Guardadas junto de cada objecto. Lista de pares
(agente, direitos de acesso)
Capacidades (capabilities). Guardadas junto de cada agente. Lista de (objecto, direitos de acesso)

Modelo habitual de controlo de segurança
Os agentes (aplicações) decidem onde e como efectuar as verificações de segurança. O controlo é
discricionário, fica à consideração da aplicação efectuar ou não esse controlo
Falha mais habitual desta política: incorrecta verificação pelo agente do controlo do monitor de
segurança.

Tecnologia de Sistemas
Distribuídos
6. Segurança

4.8

Licenciatura Eng.ª Informática

Controlo do Nível de Segurança da Informação
MAC – Mandatory Access Control
► O sistema efectua sempre, de forma mandatória, um controlo de acesso aos objectos
► Política oriunda da visão militar da segurança
►

No MAC são definidos dois conceitos:



►

Objectos e agentes são associados a níveis de confidencialidade e compartimentos:




►

Níveis de confidencialidade da informação: determinam o grau de confidencialidade da
informação. Ex: Não Classificado, Restrito, Secreto, Muito Secreto.
Níveis de acesso (clerance levels) dos agentes: definem o nível de confidencialidade da
informação a que os agentes podem aceder
Compartimentos (folders): classificam a informação por temas. Ex.: Notas de alunos, Salários de
colaboradores
Organização da informação (objectos) em compartimentos
Classificação da informação (objectos) em Restrito, Secreto, Muito secreto

Controlo de acesso dos agentes




Um agente só tem acesso a informação se realmente tiver necessidade de conhecer (need to
know), aplicando o sistema regras estritas para determinar quem tem acesso a quê.
Só podem ler informação classificada no seu nível de acesso e nos níveis abaixo
Só podem escrever informação classificada no seu nível de acesso e nos níveis acima

Tecnologia de Sistemas
Distribuídos
6. Segurança

4.9

Licenciatura Eng.ª Informática

Perguntas a que devo ser capaz de responder
►
►
►
►
►

Porque razão a segurança informática é tão importante ?
O que é uma política de segurança ?
O que significa o isolamento dos agentes ?
O que é uma Access Control List no modelo DAC ?
Considerando uma aplicação cliente-servidor a funcionar no
modelo DAC, onde e como têm que ser colocados as
verificações de segurança ?
► No modelo MAC, quem faz as verificações de segurança ?
► Qual é a relação entre a classificação da informação e os
níveis de acesso dos agentes ?

Computação Distribuída

4.10

Licenciatura Eng.ª Informática

Modelo de Segurança num Sistema Distribuído
Utilizador

Agente
(Aplicação
Cliente)

porto

porto
Aplicação
Servidor

Canal de Comunicação

Mensagem
enviada

Mensagem
recebida

objecto

operacao (utilizador, objecto, parametros)
resultado

Matriz de
direitos de
acesso
Agentes

Computação Distribuída

4.11

Objectos
Direitos de
acesso

Licenciatura Eng.ª Informática

Requisitos e ataques à segurança
Requisitos de segurança:
► Privacidade: acesso à informação apenas por agentes autorizados
► Integridade: a informação está correcta e completa
► Autenticidade: identificação do agente que produziu a informação
► Não repúdio: impossibilidade de um agente negar uma acção que efectivamente
cometeu
Ataques à segurança:
► Passivos:
 Escuta de mensagens

► Activos
 Interferência com o fluxo de mensagens (modificação, inserção, remoção, troca de
ordem de mensagens)
 Repetição de diálogos passados
 Falsificação de identidades
 Man-in-the-middle
 Denial of service
Tecnologia de Sistemas
Distribuídos
6. Segurança

4.12

Licenciatura Eng.ª Informática

Perguntas a que devo ser capaz de responder
► Quais são os requisitos de segurança de um sistema
distribuído ?
► Quais são as ameaças à segurança um sistema distribuído
?
► Como é que cada ameaça pode comprometer os requisitos
de segurança ?

Computação Distribuída

4.13

Licenciatura Eng.ª Informática

Criptografia
► Criptografia: codificação de informação de forma a tornar o seu conteúdo
incompreensível
Emissor
Receptor
E(K1, M)  {M}K1
Enviar ({M}K1)  Receber ({M}K1)
D(K2, {M}K1)  M

►

Algoritmos de cifra: funções bijectivas definidas por



►

Um algoritmo de transformação de dados
Uma chave que altera essa transformação

As cifras são reversíveis apenas por quem possuir o algoritmo inverso



►

Emissor cifra (“encrypt”) a mensagem M com a chave K1
Emissor envia a mensagem cifrada ao Receptor
Receptor decifra (“decrypt”) a mensagem com a chave K2

Modelo inverso de transformação dos dados
Chave inversa

Nomenclatura
M  {M}K1 : cifra da mensagem M com a chave K1.
É gerado um criptograma
{{M}K1 }K2  M : decifra do criptograma {M}K1 com a chave K2.
É obtida a mensagem original

Tecnologia de Sistemas
Distribuídos
6. Segurança

4.14

Licenciatura Eng.ª Informática

Exemplo: algoritmo de cifra xOR
void encrypt(char k[], char text[])
{
int n;
for (n= 0; n < 8; n++)
{
text[n] = text[n] ^ k[n];
}
}

void encrypt(char k[], char text[])
{
int n;
for (n= 0; n < 8; n++)
{
text[n] = text[n] ^ k[n];
}
}

void cipher (FILE *infile, FILE *outfile, char k[]) {
char text[8]; int i;
while(!feof(infile)) {
i = fread(text, 1, 8, infile);
/* read 8 bytes from infile */
if (i <= 0) break;
while (i < 8) { text[i++] = ' ';}
/* pad last block with spaces */
encrypt(k, text);
fwrite(text, 1, 8, outfile);
/* write 8 bytes to outfile */
}
}
Computação Distribuída

4.15

Licenciatura Eng.ª Informática

Exemplo: cifra com xOR
Mensagem original (em código binário): 1101 0101 1111 1011
Chave (4 bits): 1101
Cifrar:
Mensagem original 1101
Chave
1101
Mensagem cifrada 0000

0101
1101
1000

1111
1101
0010

1011
1101
0110

Decifrar:
Mensagem cifrada 0000
Chave
1101
Mensagem original 1101

1000
1101
0101

0010
1101
1111

0110
1101
1011

Computação Distribuída

4.16

xOR

xOR

Licenciatura Eng.ª Informática

Exemplo: algoritmo TEA (função de cifra)

void encrypt(unsigned long k[], unsigned long text[]) {
unsigned long y = text[0], z = text[1];
unsigned long delta = 0x9e3779b9, sum = 0; int n;
for (n= 0; n < 32; n++) {
sum += delta;
y += ((z << 4) + k[0]) ^ (z+sum) ^ ((z >> 5) + k[1]);
z += ((y << 4) + k[2]) ^ (y+sum) ^ ((y >> 5) + k[3]);
}
text[0] = y; text[1] = z;
}

Instructor’s Guide for Coulouris, Dollimore, Kindberg and Blair, Distributed Systems: Concepts and Design Edn. 5
Licenciatura
© Pearson Education 2012

4.17

1
2
3
4
5
6
7

Eng.ª Informática

Exemplo: algoritmo TEA (função de decifra)

void decrypt(unsigned long k[], unsigned long text[]) {
unsigned long y = text[0], z = text[1];
unsigned long delta = 0x9e3779b9, sum = delta << 5; int n;
for (n= 0; n < 32; n++) {
z -= ((y << 4) + k[2]) ^ (y + sum) ^ ((y >> 5) + k[3]);
y -= ((z << 4) + k[0]) ^ (z + sum) ^ ((z >> 5) + k[1]);
sum -= delta;
}
text[0] = y; text[1] = z;
}

Instructor’s Guide for Coulouris, Dollimore, Kindberg and Blair, Distributed Systems: Concepts and Design Edn. 5
Licenciatura
© Pearson Education 2012

4.18

1
2
3
4
5
6
7

Eng.ª Informática

Criptografia: cifras simétricas e assimétricas
► Cifras simétricas: K1 = K2

Chave Secreta

Emissor Receptor
E(K, M)  {M}K
Enviar ({M}K) 
Receber ({M}K)
D(K, {M}K)  M

Emissor cifra (“encrypt) a mensagem M com a chave K
Emissor envia a mensagem cifrada ao Receptor
Receptor decifra (“decrypt”) a mensagem com a chave K

 A chave K tem que ser secreta: só pode ser conhecida pelo emissor e receptor
 Normalmente usam técnicas de confusão e difusão. São muito mais rápidas que as
assimétricas

► Cifras assimétricas: K1 ≠ K2

Chave Pública

 Uma das chaves é pública e a outra privada
 Normalmente usam operações matemáticas complexas. Ex:
• Logaritmo modular
- Y = aX mod b;
Dados a, b e Y, calcular X
• Factorização de grandes números
- Y = ab, a e b primos;
Dado Y, calcular a ou b
Tecnologia de Sistemas
Distribuídos
6. Segurança

4.19

Licenciatura Eng.ª Informática

Cifra por blocos: exemplos de ataques
Mensagem original
Chave
Mensagem cifrada

1101
1101
0000

0101
1101
1000

Ataque 1: repetição de mensagens anteriores
Mensagem cifrada
0000
1000

1111
1101
0010

1011
1101
0110
Repetição da
mensagem

0010

0110

Ataque 2: repetição de blocos de mensagens anteriores
Mensagem original
1001
1110
0011
Chave
1101
1101
1101
Mensagem cifrada
0100
0011
1110
Mensagem alterada
0000
1000
0010

1000
1101
0101
0110

Computação Distribuída

4.20

Repetição de
blocos da
mensagem

Licenciatura Eng.ª Informática

Cifra por blocos e cifra contínua
► Cifra por blocos
 Um bloco cifrado é obtido pela cifra do bloco original
 Não depende dos blocos anteriores nem dos
seguintes. O mesmo valor, cifrado com a mesma
chave, produz sempre o mesmo resultado
 Algoritmo mais simples, facilita a análise
 Susceptível de ataques de repetição de blocos
 Exemplo: Electronic Code Book (ECB)
Ci = EK(Ti)
Ti = DK(Ci)

► Cifra Contínua



Um bloco cifrado depende da cifra do bloco original e dos
blocos anteriores
Início da mensagem tem que conter um initialization vector
com um valor diferente em cada mensagem (ex: timestamp)

 Exemplo: Cipher Block Chaining
Ci = EK(Ti ⊕ Ci-1)
Ti = DK(Ci ) ⊕ Ci-1
Computação Distribuída

4.21

Licenciatura Eng.ª Informática

Utilização da criptografia
►

Privacidade
Informação cifrada {M}K


►

Mesmo que o atacante veja a informação (escute as mensagens, aceda ao ficheiro), não entende
o seu conteúdo

Autenticidade
Informação cifrada {M}K


►

O facto da informação estar cifrada (e fazer sentido) garante que é autêntica: só quem conhece a
chave a podia ter cifrado

Integridade
Informação assinada: calcula-se um resumo D de M (D - digest)
Cifra-se o digest: M, {D}K


O digest da mensagem garante
• Integridade: a mensagem não foi alterada e o digest também não (por estar cifrado)
• Autenticidade: o digest cifrado garante que foi gerado por quem conhece a chave –
assinatura digital

►

Ataques ao canal de comunicação

Tecnologia de Sistemas
Distribuídos
 Criptografia não evita a reutilização das mensagens, denial of service, etc.
Licenciatura Eng.ª Informática
6. Segurança
4.22

Perguntas a que devo ser capaz de responder
► O que é a criptografia ?
► É boa ideia a segurança de uma comunicação cifrada estar
baseada no secretismo do algoritmo de cifra ? Porquê ?
Qual é a solução correta ?
► O que é cifra simétrica e cifra assimétrica ? Qual é mais
rápida ? Porquê ?
► Qual é a vulnerabilidade da cifra por blocos ?
► Como é que a cifra contínua ultrapassa a vulnerabilidade da
cifra por blocos ?
► Como é possível garantir privacidade e autenticidade numa
comunicação usando cifra simétrica ? E cifra assimétrica ?
► Como é construída e verificada uma assinatura digital ? O
que é que ela garante ?
Computação Distribuída

4.23

Licenciatura Eng.ª Informática

Autenticação
► A autenticação é a base da segurança
Autenticação forte: Baseia-se na combinação de pelo menos 2 de 3 elementos:
conhecimento, propriedade e inerência:
1. Conhecimento: o que sabe. Ex: password, código PIN, número cartão cidadão
2. Propriedade: o que possui. Ex: token, cartão matriz, telemóvel
3. Inerência: o que é. Ex: características biométricas como impressão digital, retina
►
►
►

Os elementos seleccionados devem ser independentes entre si: a violação de um não
compromete os outros
Pelo menos um dos elementos deve ser reutilizável, não replicável e não susceptível de
ser roubado clandestinamente
O procedimento de autenticação forte deve ser concebido de forma a proteger a
confidencialidade dos dados de autenticação

► A criptografia suporta normalmente o elemento de autenticação forte
baseado no conhecimento
Tecnologia de Sistemas
Distribuídos
6. Segurança

4.24

Licenciatura Eng.ª Informática

Autenticação com Chave Secreta
Agente
A
Alice

mensagem A → B
mensagem B → A

Servidor
B
Bob

Kab - Chave Secreta, só conhecida por A e B
Autenticação e Privacidade
A →B {M}Kab
A envia a B uma mensagem M cifrada com a chave secreta só conhecida por A e B
B: {{M}Kab}Kab
B decifra a mensagem M com a chave secreta só conhecida por A e B
• Mensagem autenticada: só pode ter sido gerada por A, pois para além de B, só A
conhece a chave secreta
• Conteúdo confidencial: mais ninguém conhece a chave secreta para decifrar a
mensagem
Todas as mensagens têm que ser autenticadas

Computação Distribuída

4.25

Licenciatura Eng.ª Informática

Autenticação com Chave Pública
Agente
A
Alice

mensagem A → B
mensagem B → A

KApriv - Chave privada de A, só conhecida por A
KApub - Chave pública de A, conhecida por toda a gente
Autenticação
A →B {M}KApriv
B: {{M}KApriv}KApub

Servidor
B
Bob
KBpriv - Chave privada de B, só conhecida por B
KBpub - Chave pública de B, conhecida por toda a gente

A envia a B uma mensagem M cifrada com a sua chave privada
B decifra a mensagem M com a chave pública de A
•
Mensagem autenticada: só pode ter sido gerada por A, pois só A conhece a sua chave privada
•
Conteúdo da mensagem é público: qualquer um pode decifrar a mensagem com a chave pública
de A

Privacidade
A →B {M}KBpub
B: {{M}KBpub}KBpriv

A envia a B uma mensagem M cifrada com a chave pública de B
B decifra a mensagem M com a sua chave privada
•
Mensagem privada: só pode ser decifrada com a chave privada de B, que só este conhece
•
Conteúdo não autenticada: qualquer um pode enviar esta mensagem cifrada com a chave
pública de B
Autenticação e Privacidade
A →B {{M}KApriv} KBpub
A envia a B uma mensagem M cifrada com a sua chave privada e com a chave pública de B
B: {{{{M}KApriv} KBpub}KBpriv}KApub B decifra a mensagem M com a sua chave privada e depois com a chave pública de A

Computação Distribuída

4.26

Licenciatura Eng.ª Informática

Utilização de Chave Pública e Chave Secreta
► A cifra com chave pública é muito mais lenta que com chave secreta
► Se a comunicação entre A e B for frequente, o mecanismo de chave pública é
utilizado inicialmente para obter uma chave secreta entre A e B
► As mensagens seguintes são cifradas com a chave secreta entre A e B

Computação Distribuída

4.27

Licenciatura Eng.ª Informática

Estabelecimento das Chaves
Autoridade de Certificação
S

Agente
A
Alice

•
•

mensagem A → B
mensagem B → A

Servidor
B
Bob

Um aspecto crucial da autenticação é estabelecer as chaves de forma segura
Autoridade de Certificação:
• Entidade de confiança das várias partes
• Armazena de forma segura as chaves públicas de cada entidade
• Oferece um protocolo para distribuir ou certificar as chaves

Computação Distribuída

4.28

Licenciatura Eng.ª Informática

Protocolo de distribuição de chaves públicas
•

Autoridade de Certificação
S
4: B → S: A

1: A → S: B

•

S conhece as chaves
públicas de A e B
Todos conhecem a
chave pública de S

2: S → A: {KBpub, B, Ts}KSpriv
5: S → B: {KApub, A, Ts}KSpriv

Agente
A
Alice

3: A → B: {M1, A, Ts} KBpub
6: B → A : { M2, B, Ts}KApub

Servidor
B
Bob

1. A → S: B

A pede à Autoridade de Certificação a chave pública de B.

2. S → A: {KBpub, B, Ts}KSpriv

A Autoridade de Certificação envia para A a chave pública de B (KBpub), autenticada através
da cifra com a sua chave privada
A mensagem é decifrada utilizando a chave pública do servidor de autenticação, conhecida
de todos. O cliente fica seguro, ao decifrar a mensagem, de que esta foi enviada por S,
porque apenas este conhece a chave privada correspondente.

3. A → B: {M1, A, Ts} KBpub

A envia a B uma mensagem cifrada com a chave pública de B que contém o seu identificador
e um carimbo temporal.

4. B → S: A

As etapas 4 e 5 repetem as etapas 1 e 3 o protocolo do lado de B. Este pede à Autoridade de
Certificação a chave pública de A.

5. S → B: {KApub A} KSpriv
Computação Distribuída

A Autoridade de Certificação envia para B a chave pública de A (KApub), autenticada através
da cifra com a sua chave privada

6. B → A: {M2, B, Ts}KApub

B envia a A a mensagem
de resposta cifrada com a chave pública
de A
Licenciatura
Eng.ª Informática
4.29

Certificados de chaves públicas
► Certificado: documento assinado por uma autoridade de
certificação
 Confirma a validade de uma chave pública
 Associa-a a informação do seu possuidor:
• Informação sobre o dono (nome, e-mail, etc.)
• Datas (de emissão, de validade)

► A norma X.509 é a mais utilizada para formato de
certificados
Subject

Distinguished Name, Public Key

Issuer

Distinguished Name, Signature

Period of validity

Not Before Date, Not After Date

Administrative information

Version, Serial Number

Extended Information
4.30

Licenciatura Eng.ª Informática

Protocolo de Needham-Schroeder
Autenticação com chave secreta
Autoridade de Certificação
S

•

S conhece as chaves
privadas de A e B

1. A → S: A, B, Na
2. S → A: {Na, B, Kab, {Ts, A, Kab}Kb}Ka

Agente
A
Alice

3. A → B: {A, Ta}Kab, {Kab, A, Ts}Kb
4: B → A : {Ta + 1}Kab

Servidor
B
Bob

1. A → S: A, B, Na

A pede a S uma chave privada para comunicar com B. Inclui um valor arbitrário Na.

2. S → A: {Na, B, Kab, {Ts, A, Kab}Kb}Ka

S gera a chave Kab. Envia a A, cifrado com a chave de A, a chave Kab, um timestamp e
um ticket incompreensível para A porque está cifrado com a chave de B.
A decifra a mensagem com a sua chave e obtém a chave Kab, a identificação de B e Na.
Confia na mensagem pois está cifrada com a sua chave. Na garante que esta mensagem
é a resposta ao seu pedido.

3. A → B: {A, Ta}Kab, {Kab, A, Ts}Kb

A envia a B uma mensagem cifrada com a chave Kab contendo o seu identificador A, um
timestamp Ta e o ticket que recebeu de S.
B decifra o ticket com a sua chave secreta e obtém a chave Kab. Confia no ticket porque
está cifrado com a sua chave secreta e Ts garante que é recente. Usando Kab decifra a
outra parte da mensagem, obtém o identificador A e Ta.
B confia na identidade de A pois recebeu essa informação cifrada com uma chave Kab
que só pode ter sido gerada por S, que conhece a chave secreta de B.

Computação
Distribuída
4. B
→ A: {Ta + 1}Kab

B responde a A com uma mensagem contendo um valor derivado de Ta e cifrada com a
chave Kab. A confia4.31
na identidade de B pois este respondeuLicenciatura
ao seu desafio
(Ta)
numa
Eng.ª
Informática
mensagem cifrada com a chave secreta

Kerberos: servidor de autenticação baseado no
protocolo Needham-Schroeder
Login
1. A → S: A, TGS, Na
2. S → A: {Katgs, Na, TICKETatgs}Ka

Kerberos (S)

Ticket Granting
Server (TGS)

TICKETxy: {X, Y, T1, T2, Kxy}Ky
T1: timestamp com início de validade do ticket
T2: timestamp com fim de validade do ticket
AUTHxy: {X, Tx}Kxy

Pedido de acesso ao Servidor B
3. A → TGS: TICKETatgs, AUTHatgs, B, Na
4. TGS → A: {Kab, Na, TICKETab}Katgs

Agente
A
Alice

Comunicação entre A e B
5. A → B: TICKETab, AUTHab, Mrequest
6: B → A : {Treq+1}Kab , Mreply

Servidor
B
Bob

1. A → S: A, TGS, Na

A pede a S uma chave para comunicar para o TGS.

2. S → A: {Katgs, Na, TICKETatgs}Ka

S cria uma chave secreta para A comunicar com o TGS e devolve-a cifrada com a chave
de A. Envia também um ticket incompreensível para A. A obtém a chave para o TGS,
guarda-a e apaga da memória a sua chave secreta (password).

3. A → TGS: TICKETatgs, AUTHatgs, B,
Na

A envia ao TGS um pedido para comunicar com B onde inclui o ticket que recebeu de S, o
autenticador cifrado com a chave secreta entre A e o TGS e a identificação de B

4. TGS → A: {Kab, Na, TICKETab}Katgs

O TGS cria a chave Kab para A comunicar com B e um ticket cifrado com a chave de B.
Envia ambos cifrados com a chave secreta de A e TGS

5. A → B: TICKETab, AUTHab, Mrequest

A obtém a chave secreta Kab, envia a B o ticket recebido do TGS e autenticador cifrado
com a chave secreta entre A e B.
B decifra o ticket com a sua chave e obtém a chave secreta entre A e B. Com esta decifra
o autenticador e confirma a identidade de A. O pedido está autenticado.

Computação
Distribuída
6: B
→ A : {Treq+1}Kab
, Mreply

B responde a A cifrando o “challenge” Treq com a chave Kab. A decifra a resposta e obtém
o “challenge” correcto.
A resposta está autenticada.
Licenciatura Eng.ª Informática
4.32

Kerberos: servidor de autenticação baseado no
protocolo Needham-Schroeder (cont.)
Login
1. A → S: A, TGS, Na
2. S → A: {Katgs, Na, TICKETatgs}Ka

Agente
A
Alice

Kerberos (S)

Ticket Granting
Server (TGS)

TICKETxy: {X, Y, T1, T2, Kxy}Ky
T1: timestamp com início de validade do ticket
T2: timestamp com fim de validade do ticket
AUTHxy: {X, Tx}Kxy

Pedido de acesso ao Servidor B
3. A → TGS: TICKETatgs, AUTHatgs, B, Na
4. TGS → A: {Kab, Na, TICKETab}Katgs
Comunicação inicial entre A e B
Servidor
5. A → B: TICKETab, AUTHab, Mrequest
B
6: B → A : {Treq+1}Kab , Mreply

Bob

Comunicação autenticada entre A e B
7. A → B: AUTHab, Mrequest
8: B → A : {Treq+1}Kab , Mreply
7. A → B: AUTHab, Mrequest

Depois da autenticação inicial, A já não necessita de enviar o ticket a B, mas o
autenticador tem que ser enviado em todas as mensagens.

8: B → A : {Treq+1}Kab , Mreply

B tem que responder sempre com o “challenge” cifrado com a chave Kab para autenticar a
resposta

Computação Distribuída

4.33

Licenciatura Eng.ª Informática

Kerberos: implementação
►

Nounces e timestamps são fundamentais para garantir a segurança do protocolo




►

Os relógios dos clientes e servidores têm que estar sincronizados para validar tickets e
authenticators


►

Kerberos rejeita mensagens com antiguidade superior a ~2 minutos. Os relógios têm que estar sincronizados com
um erro inferior a 2 minutos

Segurança do servidor Kerberos




►

Nounce (Nx): valor pré-definido conhecido por ambas as partes. Ex: nome do cliente, nome do
servidor.
• As mensagens têm que conter “nounces” para que o receptor reconheça que se trata de
uma mensagem válida, e não um conjunto de valores arbitrários
Timestamp (Tx): tempo real na máquina do emissor
• Uma chave antiga pode ser comprometida com um ataque brute force
• As mensagens têm que conter timestamps para garantir que são mensagens recentes e não
repetições de mensagens antigas

As chaves secretas dos clientes e servidores (A, B, TGS) são derivadas das suas passwords
Para as poder gerar, o servidor Kerberos e o TGS têm que saber as passwords originais dos clientes e servidores
A segurança lógica e física dos servidores e das respectivas BDs é fundamental

Escalabilidade

 Subdivisão em realms
 Cada realm possui um Saut e um TGS
Um realm pode aceitar autenticações feitas por outro
Tecnologiade Sistemas
Distribuídos
6. Segurança

4.34

Licenciatura Eng.ª Informática

Protocolo Diffie-Hellman
►
►
1.
2.
3.

4.
5.

6.

O objectivo deste protocolo é criar uma chave simétrica a partir da troca de valores em
claro entre os dois interlocutores
O algoritmo baseia-se na dificuldade computacional de calcular logaritmos de grandes
números.
A e B escolhem um número primo p e um número g que é uma raiz primitiva módulo p
A e B trocam os números p e g abertamente através na rede
A e B escolhem cada um número aleatório, A escolhe a e B escolhe b. A e B mantêm os
números a e b secretos. A e B calculam respectivamente:
 Ta = ga mod p
 Tb = gb mod p
Ta e Tb são trocados abertamente entre os dois interlocutores.
A e B calculam independentemente a chave secreta:
 A calcula Ka = Tba mod p
 B calcula Kb = Tab mod p
K = Ka = Kb. Os valores Ka e Kb são iguais e constituem a chave secreta

Computação Distribuída

4.35

Licenciatura Eng.ª Informática

Exemplo
Cryptographic explanation
►
The simplest and the original implementation of the protocol uses the multiplicative group of integers
modulo p, where p is prime, and g is a primitive root modulo p. Here is an example of the protocol, with
non-secret values in blue, and secret values in bold.
►
Alice and Bob agree to use a prime number p = 23 and base g = 5 (which is a primitive root modulo 23).
►
Alice chooses a secret integer a = 6, then sends Bob A = ga mod p


►

Bob chooses a secret integer b = 15, then sends Alice B = gb mod p


►

s = 196 mod 23 = 2

Bob computes s = Ab mod p


►
►

B = 515 mod 23 = 19

Alice computes s = Ba mod p


►

A = 56 mod 23 = 8

s = 815 mod 23 = 2

Alice and Bob now share a secret (the number 2).
Both Alice and Bob have arrived at the same value, because (ga)b (for Bob, 815 mod 23 =
(ga mod p)b mod p = (ga)b mod p) and (gb)a are equal mod p. Note that only a, b,
and(gab mod p = gba mod p) are kept secret. All the other values – p, g, ga mod p, and gb mod p – are
sent in the clear. Once Alice and Bob compute the shared secret they can use it as an encryption key,
known only to them, for sending messages across the same open communications channel.

Computação Distribuída

4.36

Licenciatura Eng.ª Informática

Perguntas a que devo ser capaz de responder
► O que é autenticação forte ?
► Usando o mecanismo de chave pública (PKI), como é que A envia a B
uma mensagem M autenticada ? E com privacidade ? E autenticada e
com privacidade ?
► Como é que uma autoridade de certificação S envia a A a chave pública
de B ? E como envia a A a chave privada de B ?
► O que é um certificado digital ?
► No protocolo Needham – Schroeder, porque é que B quando recebe a
mensagem 3 acredita que ela vem de A ?
► Usando o protocolo Needham – Schroeder como é que A pode enviar a
B uma mensagem M autenticada e com privacidade ?
► Para que servem os elementos Na e Ts nas mensagens 1 e 2 do
protocolo Needham – Schroeder ?
► No Kerberos, porque é que os relógios dos clientes e servidores têm que
estar sincronizados ?
Computação Distribuída

4.37

Licenciatura Eng.ª Informática

Bibliografia
“Distributed Systems: Concepts and Design” (5th Edition), by Coulouris,
Dollimore & Kindberg, Ed. Addison-Wiley, 2011 ISBN 0132143011
Capítulos da disciplina

Capítulos do livro

I. Introdução

1

II. Arquitecturas e Modelos de Comunicação Distribuída

2

III. Comunicação entre Processos Distribuídos (IPC)

4

IV. Invocação Remota (RPC) e Objectos Distribuídos (RMI)

5

V. Nomeação e Serviços de Directório

13

VI. Web Services (WS)

9

VII. Segurança

11

VII. Sistemas de Ficheiros Distribuídos

12

IX. Algoritmos Distribuídos

14, 15

X. Transacções

16, 17

XI. Hadoop

Computação Distribuída

--

4.38

Licenciatura Eng.ª Informática

