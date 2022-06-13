grammar input ;

prog : exp;

exps : exp
      |exp SEMICOLON exps
      ;

exp : ROLL                                              # rollExp
    | SINGLEROLL                                        # singleRollExp
    | cond = exp '?' opt1 = exp COLON opt2 = exp        # conditionalExp
    | leftExp = exp op = (MUL|DIV) rightExp = exp       # arithmeticExp
    | leftExp = exp op = (ADD|SUB) rightExp = exp       # arithmeticExp
    | leftExp = exp op = (AND|OR) rightExp = exp        # logicExp
    | leftExp = exp op = (EQ|NEQ) rightExp = exp        # compareExp
    | LPAREN exp RPAREN                                 # parensExp
    | ID                                                # varExp
    | value = INT                                       # valueExp
    | defType                                           # typeDefExp
    | defFun                                            # funDefExp
    | defVar                                            # varDefExp
    |                                                   # nilExp
    | LBRACE exps RBRACE                                # expList
    | initArrayExp                                      # arrayExp
    | funcallExp                                        # funExp
    | initStructExp                                     # structExp
    ;

fields : ID COLON idExp = typeID ( COMMA ID COLON idExp = typeID )*
        |;

defType : DEFTYPEKEY idExp = typeID LBRACE fields RBRACE      #regularTypeDefExp
         |DEFTYPEKEY idExp = typeID ASSIGN refer = typeID         #assignTypeDefExp
         ;

typeID : ID
        | array
        | option
        ;

defFun : DEFFUNKEY typeID ID LPAREN fields RPAREN LBRACE stmtList RBRACE;

funcallExp : ID LPAREN RPAREN
            |ID LPAREN params RPAREN
            ;

params : exp ( COMMA exp )*;

initArrayExp : NEW ID LBRACK  exp RBRACK OF exp;

initStructExp :NEW ID LBRACE ID ASSIGN exp ( COMMA ID ASSIGN exp )* RBRACE;

defVar : DEFVARKEY ID ASSIGN exp
        |DEFVARKEY ID COLON typeID ASSIGN exp
        ;

lvalue : ID
        |lvalue DOT ID
        |lvalue LBRACK exp RBRACK
        ;

ifStmt : IF condExp = exp THEN op1 = stmtField ELSE op2 = stmtField
       | IF condExp = exp THEN op1 = stmtField
       ;

whileStmt : WHILE exp DO stmtField;

forStmt : FOR ID ASSIGN exp TO exp DO stmtField;

returnStmt : RETURN exp;

stmts: ifStmt
      |whileStmt
      |forStmt
      |returnStmt
      |exp
      ;

stmtList : stmts
          |stmts SEMICOLON stmtList
          ;

stmtField : LBRACE stmtList RBRACE
            |stmts
            ;

array: 'array of' typeID;
option: 'option of' typeID;

EQ: '==';
NEQ: '!=';
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD: '%';
AND: '&&';
OR: '||';
ASSIGN: '=';
COLON: ':';
COMMA: ',' ;
LPAREN: '(' ;
RPAREN: ')' ;
LBRACK: '[' ;
RBRACK: ']' ;
LBRACE: '{' ;
RBRACE: '}' ;
SEMICOLON: ';' ;
DOT: '.' ;
NEW: 'new' ;
ROLL: INT ROLLKEY INT ;
SINGLEROLL: ROLLKEY INT;
INT: [0-9]+ ;
ROLLKEY: [d|D] ;
IF: 'if';
THEN: 'then';
ELSE: 'else';
WHILE: 'while';
RETURN: 'return';
DO: 'do';
FOR: 'for';
TO: 'to';
DEFTYPEKEY: 'type';
DEFFUNKEY: 'fun';
DEFVARKEY: 'var';
ID: [a-zA-Z][0-9a-zA-Z]* ;
WS: [ \t\r\n]+ -> skip ;