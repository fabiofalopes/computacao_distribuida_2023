# 1 
 É boa idea a segurança de uma comunicação cifrada estar baseada no secretismo do algoritmo de cifra? Porquê? Qual é a solução correta?




---
# 2
Como é feito o controlo de acessos num sistema **DAC (Discretionary Access Control)** ? Ilustre com o seguinte exemplo: um cliente esta a tentar ler um ficheiro remoto, tendo chamado o serviço: **read (ficheiro, utilizador)**




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


---
# 5 
Descreva 3 ameaças ou ataques a segurança em sistemas distribuídos


---
# 6 
Como é feito o controlo de acessos num sistema MAC (Mandatory Access Control) ? lustre com o seguinte exemplo: um cliente esta a tentar ler um ficheiro remoto, tendo chamado o serviço: read (ficheiro, utilizador)


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




---
# 9
Quais são os problemas que se pretendem resolver com os Web Services e porque razão o Sun RPC e o Java RMI não são adequados para resolver esses problemas ?

 



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


