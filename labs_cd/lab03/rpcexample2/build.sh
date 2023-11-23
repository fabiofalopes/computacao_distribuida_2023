#!/bin/sh

set -xe

CFLAGS=""
LIBS="-lm -ldl"

rpcgen simp.x
gcc $CFLAGS -o client_ex2 simp_client.c simp_clnt.c simp_xdr.c $LIBS
gcc $CFLAGS -o server_ex2 simp_server.c simp_svc.c simp_xdr.c $LIBS