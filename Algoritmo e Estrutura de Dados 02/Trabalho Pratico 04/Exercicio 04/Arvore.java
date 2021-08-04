//Jogador
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
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
class No
{
   public boolean cor;
   public String elemento;
   public No esquerdo;
   public No direito;
   //Construtores
   public No()
   {
      this("-1");
   }
   public No(String elemento)
   {
      this.elemento = elemento;
      this.cor = false;
      this.esquerdo = null;
      this.direito = null;
   }
   public No(String elemento, boolean cor)
   {
      this.elemento = elemento;
      this.cor = cor;
      this.esquerdo = null;
      this.direito = null;
   }
   public No(String elemento, boolean cor, No esquerdo, No direito)
   {
      this.cor = cor;
      this.elemento = elemento;
      this.esquerdo = esquerdo;
      this.direito = direito;
    }
}
class Alvinegra 
{
	private No raiz;
	//Construtor
   public Alvinegra() 
   {
		raiz = null;
	}
   //Pesquisar
   public boolean pesquisar(String elemento) 
   {
		return pesquisar(elemento, raiz);
	}
   private boolean pesquisar(String elemento, No i) 
   {
      boolean resp;
      if (i == null) 
      {
         Arvore.NCompare++;
         resp = false;
         MyIO.println("NAO");
      } 
      else if (elemento.equals(i.elemento)) 
      {
         Arvore.NCompare++;
         resp = true;
         MyIO.println("SIM");
      } 
      else if (elemento.compareTo(i.elemento)<0)
      {
         Arvore.NCompare++;
         MyIO.print("esq ");
         resp = pesquisar(elemento, i.esquerdo);
      } 
      else 
      {
         MyIO.print("dir ");
         resp = pesquisar(elemento, i.direito);
      }
      return resp;
	}
   //Inserir
   public void inserir(String elemento)
   {
      if(raiz == null)
      {
         Arvore.NCompare++;
         raiz = new No(elemento, false);
      } 
      else if (raiz.esquerdo == null && raiz.direito == null)
      {
         if (raiz.elemento.compareTo(elemento)>0)
         {
            Arvore.NCompare++;
            raiz.esquerdo = new No(elemento, true);
         } 
         else 
         {
            Arvore.NCompare++;
            raiz.direito = new No(elemento, true);
         }
      } 
      else if (raiz.esquerdo == null)
      {
         Arvore.NCompare++;
         if(raiz.elemento.compareTo(elemento)>0)
         {
            Arvore.NCompare++;
            raiz.esquerdo = new No(elemento);
         } 
         else if (raiz.direito.elemento.compareTo(elemento)>0)
         {
            Arvore.NCompare++;
            raiz.esquerdo = new No(raiz.elemento);
            raiz.elemento = elemento;
         } 
         else 
         {
            raiz.esquerdo = new No(raiz.elemento);
            raiz.elemento = raiz.direito.elemento;
            raiz.direito.elemento = elemento;
         }
         raiz.esquerdo.cor = raiz.direito.cor = false;
      } 
      else if (raiz.direito == null)
      {
         Arvore.NCompare++;
         if(raiz.elemento.compareTo(elemento)<0)
         {
            Arvore.NCompare++;
            raiz.direito = new No(elemento);
         } 
         else if (raiz.esquerdo.elemento.compareTo(elemento)<0)
         {
            Arvore.NCompare++;
            raiz.direito = new No(raiz.elemento);
            raiz.elemento = elemento;
         } 
         else 
         {
            Arvore.NCompare++;
            raiz.direito = new No(raiz.elemento);
            raiz.elemento = raiz.esquerdo.elemento;
            raiz.esquerdo.elemento = elemento;
         }
         raiz.esquerdo.cor = raiz.direito.cor = false;
      } 
      else 
      {
		   inserir(elemento, null, null, null, raiz);
      }
      raiz.cor = false;
   }
   private void inserir(String elemento, No bisavo, No avo, No pai, No i) 
   {
      if (i == null) 
      {
         Arvore.NCompare++;
         if(elemento.compareTo(pai.elemento)<0)
         {
            Arvore.NCompare++;
            i = pai.esquerdo = new No(elemento, true);
         } 
         else 
         {
            i = pai.direito = new No(elemento, true);
         }
         if(pai.cor == true)
         {
            Arvore.NCompare++;
            balancear(bisavo, avo, pai, i);
         }
      } 
      else 
      {
         if(i.esquerdo != null && i.direito != null && i.esquerdo.cor == true && i.direito.cor == true)
         {
            Arvore.NCompare+=4;
            i.cor = true;
            i.esquerdo.cor = i.direito.cor = false;
            if(i == raiz)
            {
               Arvore.NCompare++;
               i.cor = false;
            }
            else if(pai.cor == true)
            {
               Arvore.NCompare++;
               balancear(bisavo, avo, pai, i);
            }
         }
         if (elemento.compareTo(i.elemento)<0) 
         {
            Arvore.NCompare++;
            inserir(elemento, avo, pai, i, i.esquerdo);
         }
         else if (elemento.compareTo(i.elemento)>0) 
         {
            Arvore.NCompare++;
            inserir(elemento, avo, pai, i, i.direito);
         }
      }
	}
   //Balancear
   private void balancear(No bisavo, No avo, No pai, No i)
   {
      if(pai.cor==true)
      {
         Arvore.NCompare++;
         if(pai.elemento.compareTo(avo.elemento)>0)
         {
            Arvore.NCompare++;
            if(i.elemento.compareTo(pai.elemento)>0)
            {
               Arvore.NCompare++;
               avo = rotacaoEsq(avo);
            } 
            else 
            {
               Arvore.NCompare++;
               avo = rotacaoDirEsq(avo);
            }
         } 
         else 
         {
            if(i.elemento.compareTo(pai.elemento) < 0)
            {
               Arvore.NCompare++;
               avo = rotacaoDir(avo);
            } 
            else 
            {
               Arvore.NCompare++;
               avo = rotacaoEsqDir(avo);
            }
         }
         if (bisavo == null)
         {
            Arvore.NCompare++;
            raiz = avo;
         } 
         else 
         {
            if(avo.elemento.compareTo(bisavo.elemento)<0)
            {
               Arvore.NCompare++;
               bisavo.esquerdo = avo;
            } 
            else 
            {
               Arvore.NCompare++;
               bisavo.direito = avo;
            }
         }
         avo.cor = false;
         avo.esquerdo.cor = avo.direito.cor = true;
      }
   }
   private No rotacaoDir(No no) 
   {
      No noEsq = no.esquerdo;
      No noEsqDir = noEsq.direito;
      noEsq.direito = no;
      no.esquerdo = noEsqDir;
      return noEsq;
   }
   private No rotacaoEsq(No no) 
   {
      No noDir = no.direito;
      No noDirEsq = noDir.esquerdo;
      noDir.esquerdo = no;
      no.direito = noDirEsq;
      return noDir;
   }
   private No rotacaoDirEsq(No no) 
   {
      no.direito = rotacaoDir(no.direito);
      return rotacaoEsq(no);
   }
   private No rotacaoEsqDir(No no) 
   {
      no.esquerdo = rotacaoEsq(no.esquerdo);
      return rotacaoDir(no);
   }
}
public class Arvore
{
   static int Contador;
   static int NCompare;
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
   //Criação da Função Log
   public static void CriaLog(int Matricula, long Tempo) throws IOException
   {
      File Dados = new File("matrıcula avinegra.txt");
      Dados.createNewFile();
      FileWriter ArquivoDados = new FileWriter(Dados);
      BufferedWriter EscreverDados = new BufferedWriter(ArquivoDados);
      EscreverDados.write(Integer.toString(Matricula)+"\t"+Integer.toString(NCompare)+"\t"+"\t"+Long.toString(Tempo));
      EscreverDados.close();
      ArquivoDados.close();
   }
   public static void main (String [] args)
   {
      long TempUm = System.currentTimeMillis();
      NCompare = 0;
      Jogador [] atleta = LeituraArquivo();
      String entrada = MyIO.readLine();
      Alvinegra No = new Alvinegra();
      while(!entrada.contains("FIM"))
      {
         No.inserir(atleta[Integer.parseInt(entrada)].getnome());
         entrada=MyIO.readLine();
      }
      String nomes = MyIO.readLine();
      while(!nomes.contains("FIM"))
      {
         MyIO.print(nomes+" raiz ");
         No.pesquisar(nomes);
         nomes = MyIO.readLine();
      }
      try
      {
         CriaLog (691290, System.currentTimeMillis() - TempUm);
      }
      catch (IOException Erro)
      {
         System.err.printf("Nao foi possivel continuar");
         Erro.getMessage();
      }
   }
}