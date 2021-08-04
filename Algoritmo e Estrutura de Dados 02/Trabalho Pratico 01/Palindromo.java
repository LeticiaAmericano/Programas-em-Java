public class Palindromo 
{
    public static void main (String[] args)
    {
        Boolean Fim = false;
        do
        {
            Boolean Palindromo=true;
            String Entrada = MyIO.readLine();
            if (Entrada.length() == 3 && Entrada.charAt(0) == 'F' && Entrada.charAt(1) == 'I' && Entrada.charAt(2) == 'M')
                Fim=true;
            else 
            {
                int Contador = Entrada.length();
                for (int i=0; i<Contador/2; i++)
                {
                    if(Entrada.charAt(i)!=Entrada.charAt(Contador-1-i))
                    {
                        Palindromo=false;
                    }
                }
                if (Palindromo==true)
                {
                    MyIO.println("SIM");
                }
                else 
                {
                    MyIO.println("NAO");
                }
            }
        }
        while (Fim==false);
        //Faça ... enquanto fim não aparecer
    }
}