import java.io.*;

class Arquivo
{
    public static void main (String[] args) throws Exception
    {
        int Contador = MyIO.readInt();
        RandomAccessFile Escrita = new RandomAccessFile("Arquivo.txt", "rw");
        float Variavel;
        for (int i=0; i<Contador; i++)
        {
            Variavel = MyIO.readFloat();
            Escrita.writeFloat(Variavel);
        }
        Escrita.close();
        RandomAccessFile Leitura = new RandomAccessFile("Arquivo.txt", "r");
        long Tamanho = Leitura.length() - 8;
        for (long i=Tamanho; i >= 0; i = i - 8)
        {
            Leitura.seek(i);
            String Verifica = MyIO.readLine(Leitura.seek(i));
            int InveiroVerifica = Integer.valueOf(Verifica).intValue();
            Float RealVerifica = Float.valueOf(Verifica).floatValue();
            if (!(InveiroVerifica == RealVerifica))
                MyIO.println(InveiroVerifica);
            MyIO.println(RealVerifica);
        }
        Leitura.close();
    }
}
