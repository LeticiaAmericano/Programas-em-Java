package Ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Jogador
class Jogador
{
    private int id = -1;
    private int altura = -1;
    private int peso = -1;
    private int anoNascimento = -1;
    private String nome = "-1";
    private String universidade = "-1";
    private String cidadeNascimento = "-1";
    private String estadoNascimento = "-1";        
    //Construtores
    public  Jogador () 
    {

    }
    public  Jogador (int id, int altura, int peso, int anoNascimento, String nome, String universidade, String cidadeNascimento, String estadoNascimento)
    {
        setid(id);
        setaltura(altura);
        setpeso(peso);
        setanoNascimento(anoNascimento);
        setnome(nome);
        setuniversidade(universidade);
        setcidadeNascimento(cidadeNascimento);
        setestadoNascimento(estadoNascimento);
    }
    //Sets
    public void setid(int id)
    {
        this.id = id;
    }
    public void setaltura(int altura)
    {
        this.altura = altura;
    }
    public void setpeso(int peso)
    {
        this.peso = peso;
    }
    public void setanoNascimento(int anoNascimento)
    {
        this.anoNascimento = anoNascimento;
    }
    public void setnome(String nome)
    {
        this.nome = nome;
    }
    public void setuniversidade(String universidade)
    {
        this.universidade = universidade;
    }
    public void setcidadeNascimento(String cidadeNascimento)
    {
        this.cidadeNascimento = cidadeNascimento;
    }
    public void setestadoNascimento(String estadoNascimento)
    {
        this.estadoNascimento = estadoNascimento;
    }
    //Gets
    public int getid()
    {
        return this.id;
    }
    public int getaltura()
    {
        return this.altura;
    }
    public int getpeso()
    {
        return this.peso;
    }
    public int getanoNascimento()
    {
        return this.anoNascimento;
    }
    public String getnome()
    {
        return this.nome;
    }
    public String getuniversidade()
    {
        return this.universidade;
    }
    public String getcidadeNascimento()
    {
        return this.cidadeNascimento;
    }
    public String getestadoNascimento()
    {
        return this.estadoNascimento;
    }
    //imprimir
    public void imprimir()
    {
        System.out.printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", id, nome, altura, peso, anoNascimento, universidade, cidadeNascimento, estadoNascimento);
    }
    //clone
    public Jogador clone()
    {
        Jogador Atleta = new Jogador();
        setid(id);
        setnome(nome);
        setaltura(altura);
        setpeso(peso);
        setuniversidade(universidade);
        setanoNascimento(anoNascimento);
        setcidadeNascimento(cidadeNascimento);
        setestadoNascimento(estadoNascimento);
        return Atleta;
    }
}
//Celula
class Celula
{
    public int elemento;
    public Celula prox;
    public Celula()
    {
        this(0);
    }
    public Celula(int x)
    {
        this.elemento=x;
        this.prox=null;
    }
}
//Lista
class Lista
{
    private Jogador [] atleta;
    private int contador;
    //Construtores
    public Lista()
    {
        this.atleta = new Jogador [4000];
        this.contador = 0;
    }
    //Inserir
    public void inserirInicio (Jogador jogador) throws Exception
    {
        if (contador>=atleta.length)
            throw new Exception("Erro!");
        for (int i=contador; i>0; i--)
        {
            atleta[i]=atleta[i-1];
        }
        atleta[0]=jogador;
        contador++;
    }
    public void inserir(Jogador jogador, int posicao)throws Exception 
    {
        if (contador>=atleta.length||posicao<0||posicao>contador)
            throw new Exception("Erro!");
        for (int i=contador; i>posicao; i--)
        {
            atleta[i]=atleta[i-1];
        }
        atleta[posicao]=jogador;
        contador++;
    }
    public void inserirFim(Jogador jogador)throws Exception 
    {
        if (contador>=atleta.length)
            throw new Exception("Erro!");
        atleta[contador]=jogador;
        contador++;
    }
    //Remover
    public Jogador removerInicio() throws Exception 
    {
        if (contador==0)
            throw new Exception("Erro!");
        Jogador remocao=atleta[0];
        contador--;
        for (int i=0; i<contador; i++)
        {
            atleta[i]=atleta[i+1];
        }
        return remocao;
    }
    public Jogador remover(int posicao) throws Exception
    {
        if (contador==0||posicao< 0||posicao>=contador)
            throw new Exception("Erro!");
        Jogador remocao=atleta[posicao];
        contador--;
        for (int i=posicao; i<contador; i++)
        {
            atleta[i]=atleta[i+1];
        }
        return remocao;
    }
    public Jogador removerFim() throws Exception 
    {
        if (contador==0)
            throw new Exception("Erro!");
        return atleta[--contador];
    }
    //Imprimir
    public void imprimir(int i)
    {
        System.out.printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n", i, atleta[i].getnome(), atleta[i].getaltura(), atleta[i].getpeso(), atleta[i].getanoNascimento(), atleta[i].getuniversidade(), atleta[i].getcidadeNascimento(), atleta[i].getestadoNascimento());
    }
    //ordenar
    public Jogador[] ordenar(Jogador[] atleta, int contador)
    {
        for (int i=1;i<10;i++) 
        {
            Jogador tmp = atleta[i];
            int j=i-1;                
            while ((j>=0) && (atleta[j].getid()>tmp.getid()))
            {    
                atleta[j+1]=atleta[j];
                j--;
            }
            atleta[j+1]=tmp;
        }
        return atleta;
    }
}
public class ListaAlocacaoFlexivel
{
    static int Contador;
    //Abrir, Ler e Passar arquivo players para a classe
    public static Jogador [] LeituraArquivo()
    {
        Jogador [] Atleta = new Jogador [4000];
        try
        {
            FileReader Arquivo = new FileReader("/tmp/players.csv");
            BufferedReader LinhaArquivo = new BufferedReader(Arquivo);
            String Linha = LinhaArquivo.readLine();
            Linha=LinhaArquivo.readLine();
            String [] Tmp = new String[8];
            String Excecao;
            int j=0;
            int Posicao=0;
            int Inicio=0;
            int i=0;
            while(Linha != null)
            {
                Posicao=0;
                Inicio=0;
                for (i=0;i<8;i++)
                {
                    if (i!=7)
                        Posicao=Linha.indexOf(",", Posicao+1);
                    else
                        Posicao=Linha.length();
                    Tmp[i] = Linha.substring(Inicio,Posicao);
                    if (!Tmp[i].isEmpty() && Tmp[i].charAt(0) == '\"')
                    {  
                        Posicao=Linha.indexOf(",", Posicao+1);
                        Inicio=Posicao+1;
                        Excecao = Linha.substring(Inicio,Posicao);
                        Tmp[i] = Tmp[i] +","+ Excecao;
                        i--;
                    }
                    if (i!=7)
                        Inicio=Posicao+1;
                }
                Atleta[j] = new Jogador();
                Atleta[j].setid(Integer.parseInt(Tmp[0]));
                if (!Tmp[1].isEmpty())
                    Atleta[j].setnome(Tmp[1]);
                else
                    Atleta[j].setnome("nao informado");
                Atleta[j].setaltura(Integer.parseInt(Tmp[2]));
                Atleta[j].setpeso(Integer.parseInt(Tmp[3]));
                if (!Tmp[4].isEmpty())
                    Atleta[j].setuniversidade(Tmp[4]);
                else
                    Atleta[j].setuniversidade("nao informado");
                Atleta[j].setanoNascimento(Integer.parseInt(Tmp[5]));
                if (!Tmp[6].isEmpty())
                    Atleta[j].setcidadeNascimento(Tmp[6]);
                else
                    Atleta[j].setcidadeNascimento("nao informado");
                if (!Tmp[7].isEmpty())
                        Atleta[j].setestadoNascimento(Tmp[7]);
                else
                    Atleta[j].setestadoNascimento("nao informado");
                Linha=LinhaArquivo.readLine();
                j++; 
            }
            LinhaArquivo.close();
            Arquivo.close();
        }
        catch(IOException Erro)
        {
            System.err.printf("Nao foi possivel continuar essa acao");
                Erro.getMessage();
        }
        return Atleta;
    }
    public static void main (String [] args)
    {
        try
        {
            Jogador [] atleta = LeituraArquivo();
            Lista lista = new Lista();
            //Entrada dos IDs a serem lidos
            String entrada;
            int contador = 0;
            entrada = MyIO.readLine();
            while(!entrada.contains("FIM"))
            {
                lista.inserirFim(atleta[Integer.parseInt(entrada)]);
                contador++;
                entrada=MyIO.readLine();
            }
            //Numero de registros a serem inseridos ou removidos
            int repeticao = MyIO.readInt();
            Jogador [] removidos = new Jogador[contador];
            int contadorremovidos=0;
            //Registros da Lista 
            for(int i=0;i<repeticao;i++)
            {
                //Leitura de String
                String registros  = MyIO.readLine();
                String[] operacoes = registros.split(" ");
                String operacao = operacoes[0];
                switch(operacao)
                {
                    case "RI": 
                        removidos[contadorremovidos]=lista.removerInicio();//Remover no Inicio
                        contadorremovidos++;
                        contador--;
                    break;
                    case "RF": 
                        removidos[contadorremovidos]=lista.removerFim();//Remover no Fim
                        contadorremovidos++;
                        contador--;
                    break;
                    case "II": 
                        lista.inserirInicio(atleta[Integer.parseInt(operacoes[1])]);//Inserir no Inicio
                        contador++;
                    break;
                    case "IF": 
                        lista.inserirFim(atleta[Integer.parseInt(operacoes[1])]);//Inserir no Fim
                        contador++;
                    break;
                    case "R*": 
                        removidos[contadorremovidos]=lista.remover(Integer.parseInt(operacoes[1]));//Remover em qualquer Posição
                        contadorremovidos++;
                        contador--;
                    break;
                    case "I*": lista.inserir(atleta[Integer.parseInt(operacoes[2])], Integer.parseInt(operacoes[1]));//Inserir em qualquer Posição
                        contador++;
                    break;
                }
            }
            //Impressão dos removidos
            for(int i=0; i<contadorremovidos; i++)
            {
                MyIO.println("(R) "+removidos[i].getnome());
            }
            //Impressao da lista
            for (int i=0; i<contador; i++)
            {
                lista.imprimir(i);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}