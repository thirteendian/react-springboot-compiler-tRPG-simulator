grammar input ;

prog : exp;

exp : ROLL                                              # rollExp
    | SINGLEROLL                                        # singleRollExp
    | leftExp = exp op = (MUL|DIV) rightExp = exp       # arithmeticExp
    | leftExp = exp op = (ADD|SUB) rightExp = exp       # arithmeticExp
    | LPAREN exp RPAREN                                 # parensExp
    | cond = exp '?' opt1 = exp COLON opt2 = exp        # conditionalExp
    | ID                                                # varExp
    | value = INT                                       # valueExp
    | defType                                           # typeDefExp
    | defFun                                            # funDefExp
    |                                                   # nilExp
    ;

defTypeBody : (ID COLON ID COMMA)* ;

defType : DEFTYPEKEY ID LBRACE defTypeBody RBRACE ;

fields : ID COLON ID (COMMA ID COLON ID)* ;

defFun : DEFFUNKEY ID LPAREN fields RPAREN LBRACE exp RBRACE ;

ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
COLON : ':';
COMMA : ',' ;
LPAREN : '(' ;
RPAREN : ')' ;
LBRACE : '{' ;
RBRACE : '}' ;
SEMICOLON : ';' ;
ROLL : INT ROLLKEY INT ;
SINGLEROLL : ROLLKEY INT;
INT : [0-9]+ ;
ROLLKEY : [d] ;
DEFTYPEKEY : 'deftype';
DEFFUNKEY : 'deffun';
ID : [a-zA-Z][0-9a-zA-Z]* ;
WS: [ \t\r\n]+ -> skip ;