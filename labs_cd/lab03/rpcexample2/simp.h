/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _SIMP_H_RPCGEN
#define _SIMP_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


struct operands {
	int x;
	int y;
};
typedef struct operands operands;

#define SIMP_PROG 0x28976543
#define SIMP_VERSION 1

#if defined(__STDC__) || defined(__cplusplus)
#define ADD 1
extern  int * add_1(operands *, CLIENT *);
extern  int * add_1_svc(operands *, struct svc_req *);
#define SUB 2
extern  int * sub_1(operands *, CLIENT *);
extern  int * sub_1_svc(operands *, struct svc_req *);
#define DIVV 3
extern  int * divv_1(operands *, CLIENT *);
extern  int * divv_1_svc(operands *, struct svc_req *);
#define MUL 4
extern  int * mul_1(operands *, CLIENT *);
extern  int * mul_1_svc(operands *, struct svc_req *);
extern int simp_prog_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define ADD 1
extern  int * add_1();
extern  int * add_1_svc();
#define SUB 2
extern  int * sub_1();
extern  int * sub_1_svc();
#define DIVV 3
extern  int * divv_1();
extern  int * divv_1_svc();
#define MUL 4
extern  int * mul_1();
extern  int * mul_1_svc();
extern int simp_prog_1_freeresult ();
#endif /* K&R C */

/* the xdr functions */

#if defined(__STDC__) || defined(__cplusplus)
extern  bool_t xdr_operands (XDR *, operands*);

#else /* K&R C */
extern bool_t xdr_operands ();

#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_SIMP_H_RPCGEN */
