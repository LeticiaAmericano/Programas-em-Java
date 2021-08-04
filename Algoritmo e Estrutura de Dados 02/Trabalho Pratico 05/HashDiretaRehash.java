class Hash 
{
    String [] tabela;
    int tamTotal;
    String NULO = "-1";
 
    public Hash ()
    {
        this(25);
    }
    public Hash (int tamTotal)
    {
        this.tamTotal = tamTotal;
        this.tabela = new String [this.tamTotal];
        for(int i=0; i<tamTotal; i++)
        {
            tabela[i] = NULO;
        }
    }
    public int h(int elemento)
    {
        return elemento % tamTotal;
    }
    public int reh(int elemento)
    {
        return ++elemento % tamTotal;
    }
    public boolean inserir (String elemento, int altura)
    {
        boolean resp = false;
        if(!elemento.equals(NULO))
        {
            int pos = h(altura); 
            if(tabela[pos] == NULO)
            {
                tabela[pos] = elemento;
                resp = true;
            } 
            else
            {
                pos = reh(altura); 
                if(tabela[pos] == NULO)
                {
                    tabela[pos] = elemento;
                    resp = true;
                }
            }
        }
        return resp;
    }
    public boolean pesquisar (String elemento, int altura)
    {
        boolean resp = false;
        int pos = h(altura);
        if(tabela[pos] == elemento)
        {
            resp = true;
        } 
        else 
        {
            pos = reh(altura);
            if(tabela[pos] == elemento)
            {
                resp = true;
            }
        }
        return resp;
    }
}