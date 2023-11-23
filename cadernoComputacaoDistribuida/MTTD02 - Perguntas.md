# 1 
 E boa idea a segurança de uma comunicação cifrada estar baseada no secretismo do algoritmo de cifra ? Porquê ? Qual é a solução correta ?


---
# 2
Como é feito 0 controlo de acessos num sistema **DAC (Discretionary Access Control)** ? Ilustre com o seguinte exemplo: um cliente esta a tentar ler um ficheiro remoto, tendo chamado o serviço: **read (ficheiro, utilizador)**



---
# 3 
Considere 2 agentes, A e B, uma autoridade de certificação S, e as 4 mensagens do protocolo Needham - Schroeder de autenticação com chave secreta:
```
1. A -> S: A, B, Na
2. S -> A: {Na, B, Kab, {Ts, A, Kab}Kb}Ka
3. A -> B: {A, Ta}Kab, {Kab, A, Ts}Kb
4. B -> A: {Ta+1}Kab
```
Na mensagem 3, como é que B obtém a chave Kab ? Como é que tem a certeza que a chave é valida?


---
# 4
Descreva resumidamente a função do seguinte componente do WSDL: Message


**Message: definição das mensagens trocadas (colecção de parts; part: named argument e respectivo tipo)**
	- Cada elemento message pode ser usado como mensagem input, output ou fault numa operation
	- O atributo type da part pode ser qualquer tipo standard do schema XSD ou um tipo definido pelo utilizador

---
# 5 
Descreva 3 ameaças ou ataques a segurança em sistemas distribuídos

DOS
Man in the middle
Interferência com o fluxo de mensagens 


---
# 6 
Como é feito o controlo de acessos num sistema MAC (Mandatory Access Control) ? lustre com o seguinte exemplo: um cliente esta a tentar ler um ficheiro remoto, tendo chamado o serviço: read (ficheiro, utilizador)

Cliente: qual o nivel de acesso do user
-> Dependendo doo nivel de acesso, o SO sobre o qual o servidor do requesitante, ira permitir ou nao depe



---
# 7
```
void remotecalc_1(char *host)
{ 
	CLIENT *clnt; float *result_1; calcargs add_1_arg;
	clnt = clnt_create (host, REMOTECALC, CALCVERS, "udp’);
	if (clnt == NULL) clnt_pcreateerror (host) exit(1);
}

add_1_arg.a=1.0; add_1_arg.b=2.0;

result_1 = add_1(&add_1_arg, clnt);

if (result_1 == (float*) NULL) { clnt_perror (clnt,"call failed"); }

```
No exemplo do cliente Sun RPC acima, explique o que so e para que servem os argumentos na chamada a rotina add_1 na linha:
```
result_1 = add_1(add_1_arg, cint);

```



---
# 8
Considere 2 agentes, A e B, cada um com o seu par de chaves publica e privada, respetivamente:
	```A: KAPub, KAPriv B: KBPub, KBPriv```
Considere que B recebeu a seguinte mensagem: ```{M)KAPriv```
B sabe quem enviou esta mensagem? Mais alguém, para além de B, consegue entender o conteúdo desta mensagem? Justifique as suas respostas.


A encripta mensagem com a sua chave privada
Só A conhece a chave privada, no entanto a mensagem pode ser decifrada por quem conhecer a chave publica de A.
Como B recebe uma mensagem encriptada, se este não souber quem a enviou, ou isto é, se não conhecer a chave publica do remetente, não lhe é possível desencriptar a mensagem. 


---
# 9
Quais são os problemas que se pretendem resolver com os Web Services e porque razão o Sun RPC e o Java RMI não são adequados para resolver esses problemas ?

 

Web Services foram criados para resolver problemas de integração de sistemas heterogéneos, permitindo que diferentes aplicações comuniquem entre si e compartilhem dados de forma padronizada e independente de plataforma. Além disso, os Web Services também permitem a criação de serviços distribuídos, que podem ser acedidos por diferentes clientes em diferentes locais.

A arquitectura da Web adapta-se a esta realidade
- Web Services - maior flexibilidade e interoperabilidade
	- Definição das interfaces de forma independente das linguagens de programação (WSDL)
	- Clientes e servidores podem estar escritos em linguagens diferentes
	- Formato das mensagens independente da implementação (SOAP)

---
# 10
```
public interface Hello extends Remote {
		String sayHello()
	throws RemoteException;
}

public class Server implements Hello {
	public Server() {}
	public String sayHello() {
		return "Hello, world!";
}
```

No exemplo de Java RMI acima, descreva e explique o que so e para que servem no contexto do Java RMI a **interface Hello** e a **class Server**.



R:
**Interface Hello**: Contem as definições dos métodos disponíveis no servidor RMI que podem ser invocados remotamente;
**Class server**: implementa os métodos disponíveis na interface;