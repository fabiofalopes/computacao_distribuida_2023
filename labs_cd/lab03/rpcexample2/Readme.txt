
rpcbind -> serviço de gestao de todos os rpc

$ rpcgen simp.x 
-Gera:
    -> simp_clnt.c
    -> simp_xdr.c
    -> simp_svc.c
    -> simp.h

-> Compile Client
$ gcc -o client_ex2 simp_client.c simp_clnt.c simp_xdr.c

-> Compile Server
$ gcc -o client_ex2 simp_client.c simp_clnt.c simp_xdr.c


EXERCICIO em aula:

- Adicionar a calculadora, multiplição e divisão
- Nao editar ficheiros gerados pelo rpcgen simp.x

Procedimento: 

CUIDADO div é uma paravra reservada -> chama divv ou wharever

Comecar por editar o simp.x e adicionamos novas funcoes:
    int DIVV(operands) = 3; 
    int MUL(operands) = 4;

Depois podemos editar o servidor e o cliente de forma a incluir os metodos:
-> Definir no server
-> Call no client

Assim quando corremos novamente rpcgen simp.x o header simp.h ja vai incluir os novos metodos

