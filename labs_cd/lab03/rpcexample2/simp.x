/** simp.x
 *  the definition of the data type that will be passed to
 *  both of the remote procedures add() and sub() 
 */

struct operands {
	int x;
	int y;
};

/* program, version and procedure definitions. 
 */

program SIMP_PROG {
   version SIMP_VERSION {
     int ADD(operands) = 1;
     int SUB(operands) = 2;
     int DIVV(operands) = 3;
     int MUL(operands) = 4;
   } = 1;
} = 0x28976543;
