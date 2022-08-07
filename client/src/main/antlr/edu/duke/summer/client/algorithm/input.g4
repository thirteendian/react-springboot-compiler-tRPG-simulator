grammar input ;

prog : exp;

exps : exp
      |exp SEMICOLON exps
      ;

exp : ROLL                                                          # rollExp
    | SINGLEROLL                                                    # singleRollExp
    | cond = exp '?' opt1 = exp COLON opt2 = exp                    # conditionalExp
    | leftExp = exp op = (MUL|DIV) rightExp = exp                   # arithmeticExp
    | leftExp = exp op = (PLUS|MINUS) rightExp = exp                # arithmeticExp
    | leftExp = exp op = (AND|OR) rightExp = exp                    # arithmeticExp
    | leftExp = exp op = (EQ|NE|LT|LE|GT|GE) rightExp = exp         # arithmeticExp
    | leftExp = exp op = MOD rightExp = exp                         # arithmeticExp
    | LPAREN exp RPAREN                                             # parensExp
    | ID                                                            # simpleVarExp
    | exp DOT LENGTH                                                # lenExp
    | exp DOT ID LPAREN exps RPAREN                                 # fieldFunCallExp
    | value = INT                                                   # intExp
    | STRING                                                        # strExp
    | TRUE                                                          # trueExp
    | FALSE                                                         # falseExp
    | '!' exp                                                       # nonExp
    | MINUS exp                                                     # uminusExp
    | decs                                                          # decList
    |                                                               # nilExp
    | LBRACE exps RBRACE                                            # expList
    | funcallExp                                                    # callExp
    | DEFSTRUCTKEY ID LBRACE finalFields RBRACE                     # structExp
    | lvalue                                                        # lvalueExp
    | assign                                                        # assignExp
    | optionVal                                                     # optionExp
    ;


//optionExp
optionVal : SOME LPAREN exp RPAREN
           |NONE
;

//declaration
dec : defType
     |defFun
     |defVar
     ;

decs: dec
     |dec decs
     ;

//fields dec related to type and struct
typefield : ID COLON typeID;

typefields : typefield
        |typefield COMMA typefields;

finalFields : typefields                #regularFields
              |                         #emptyFields
              ;

defType : DEFTYPEKEY ID LBRACE finalFields RBRACE          #regularTypeDefExp
         |DEFTYPEKEY ID ASSIGN refer = typeID              #assignTypeDefExp
         ;

//typeId
typeID : ID
     | typeID OPTION
     | typeID LBRACK RBRACK
     | typeID LBRACK INT RBRACK
     ;

//params related to function dec
paramList : typeID ID paramRest*
            |
            ;

paramRest : COMMA typeID ID;


//vars declaration
defVar : DEFVARKEY ID ASSIGN exp
        |DEFVARKEY ID COLON typeID ASSIGN exp
        |DEFVARKEY ID COLON typeID ASSIGN LBRACE initArray RBRACE
        |DEFVARKEY ID ASSIGN LBRACE initArray RBRACE
        |DEFVARKEY ID COLON typeID
        ;

//function call
params : exp                #singleParam
        |exp COMMA params   #mulParam
        ;

funcallExp : ID LPAREN RPAREN
            |ID LPAREN params RPAREN
            ;

//lvalue
lvalue : ID DOT ID                  #simpleFieldVar
        | ID LBRACK exp RBRACK      #simpleSubscriptVar
        | lvalue DOT ID             #fieldVar
        | lvalue LBRACK exp RBRACK  #subscriptVar
        ;
//initArray
initArray : exp (COMMA exp)* ;

//assignExp
assign :    ID ASSIGN exp                          #simpleAssign
           |lvalue ASSIGN exp                      #lvalueAssign
           |lvalue ASSIGN LBRACE initArray RBRACE  #initArrayAssign
           |ID ASSIGN LBRACE initArray RBRACE      #simpleInitArrayAssign
           ;

//statements
ifStmt : IF LPAREN condExp = exp RPAREN THEN op1 = stmts ELSE op2 = stmts
       | IF LPAREN condExp = exp RPAREN THEN op1 = stmts
       ;

whileStmt : WHILE LPAREN exp RPAREN stmts;

forStmt : FOR LPAREN ID COLON exp RPAREN stmts;

returnStmt : RETURN exp SEMICOLON;

expStmt : exp SEMICOLON;

decStmt : defVar SEMICOLON;

stmts: LBRACE stmts* RBRACE
      |ifStmt
      |whileStmt
      |forStmt
      |returnStmt
      |decStmt
      |BREAK SEMICOLON
      |expStmt
      ;

defFun : DEFFUNKEY typeID ID LPAREN paramList RPAREN LBRACE decStmt* stmts* returnStmt RBRACE;

EQ: '==';
NE: '!=';
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
LT: '<';
LE: '<=';
GT: '>';
GE: '>=';
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
ROLLKEY: [d|D] ;
SOME: 'some'|'SOME';
NONE: 'NONE';
IF: 'if';
THEN: 'then';
ELSE: 'else';
WHILE: 'while';
RETURN: 'return';
BREAK: 'break';
ARRAY: 'array';
OPTION: 'option';
LENGTH: 'length';
TRUE : 'true';
FALSE : 'false';
PRINT : 'print';
DO: 'do';
FOR: 'for';
OF: 'of';
TO: 'to';
DEFTYPEKEY: 'type';
DEFFUNKEY: 'fun';
DEFVARKEY: 'var';
DEFSTRUCTKEY: 'struct';
INT: [0-9]+ ;
ID: [a-zA-Z][0-9a-zA-Z]* ;
STRING: '"' (ESC|.)*? '"' ;
fragment
ESC : '\\"' | '\\\\' ;
WS: [ \t\r\n]+ -> skip ;
LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ;
COMMENT      : '/*' .*? '*/'       -> skip ;
