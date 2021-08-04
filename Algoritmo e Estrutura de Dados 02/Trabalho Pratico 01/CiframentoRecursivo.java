class CiframentoRecursivo
{
    public static char[] Ciframento (String Entrada)
    {
        char[] Saida = new char[1000000];
        return Cifra (Entrada, 0, Entrada.length(), Saida);
    }
    public static char[] Cifra (String Entrada, int i, int Contador, char[] Saida)
    { 
        if( i<Contador )
        {
            Saida [i] = (char)(((int)(Entrada.charAt(i)))+3);
            Saida = Cifra (Entrada, ++i, Contador, Saida);
        }
        return Saida;
    }
    public static void main (String[] args)
    {
        Boolean Fim = false;
        do
        {
            String Entrada = MyIO.readLine();
            int Contador = Entrada.length();
            if (Contador == 3 && Entrada.charAt(0) == 'F' && Entrada.charAt(1) == 'I' && Entrada.charAt(2) == 'M')
                Fim=true;
            else
            {
                char[] Saida = Ciframento (Entrada);
                for (int i=0;i<Contador;i++)
                {
                    MyIO.print(Saida[i]);
                }
                MyIO.println("");
            }
        }
        while(Fim == false);
    }
}