class  Hash {
    int tabela [];
    int m;
    int  NULO  =  - 1 ;
 
    public  Hash () {
       este ( 13 );
    }
 
    public  Hash ( int  m ) {
       isso . m = m;
       isso . tabela =  new  int [ this . m];
       para ( int i =  0 ; i < m; i ++ ) {
          tabela [i] =  NULO ;
       }
    }
 
    public  int  h ( int  elemento ) {
       return elemento % m;
    }
 
    public  int  reh ( int  elemento ) {
       return  ++ elemento % m;
    }
 
     inserir booleano  público ( int elemento ) { 
       boolean resp =  false ;
 
       if (elemento ! =  NULO ) {
 
          pos int = h (elemento);
 
          if (tabela [pos] ==  NULO ) {
             tabela [pos] = elemento;
             resp =  verdadeiro ;
 
          } else {
 
             pos = reh (elemento);
 
             if (tabela [pos] ==  NULO ) {
                tabela [pos] = elemento;
                resp =  verdadeiro ;
             }
          }
       }
 
       return resp;
    }
 
    public  boolean  pesquisando ( int  elemento ) {
       boolean resp =  false ;
 
       pos int = h (elemento);
 
       if (tabela [pos] == elemento) {
          resp =  verdadeiro ;
 
       } else {
          pos = reh (elemento);
 
          if (tabela [pos] == elemento) {
             resp =  verdadeiro ;
          }
       }
       return resp;
    }
 
     removedor booleano ( int  elemento ) {
       boolean resp =  false ;
 
       // ...
 
       return resp;
    }
 }