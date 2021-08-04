class Ciframento
{
    public static void main (String[] args)
    {
        Boolean Fim = false;
        do
        {
            String Entrada = MyIO.readLine();
            int Contador = Entrada.length(),
                i,
                ContadorSaida=0;
            if (Entrada.length() == 3 && Entrada.charAt(0) == 'F' && Entrada.charAt(1) == 'I' && Entrada.charAt(2) == 'M')
                Fim=true;
            else
            {
                char[] Saida = new char[1000000];
                for (i=0;i<Contador;i++)
                {
                    Saida [i] = (char)(((int)(Entrada.charAt(i)))+3);
                    ContadorSaida++;
                }
                for (i=0;i<ContadorSaida;i++)
                {
                    MyIO.print(Saida[i]);
                }
                MyIO.println("");
            }
        }
        while(Fim == false);
    }
}