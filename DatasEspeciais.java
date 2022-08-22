import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Viana
 */
public class DatasEspeciais {
       
       private int dia;
       private int mes;
       private int ano;
       
    public DatasEspeciais(int ano2){
        
        ano = ano2;
        
        //ALGORITMO
        //passo1:Seja Y o ano do qual se deseja a data da Pascoa
        int y = ano;
        
        //passo2: Seja G o resto da divisao inteiraa de Y por 19 acrescido de uma unidade
        int g = (y%19)+1;
        
        //passo 3: Seja C o quociente da divisão inteira de Y por 100 acrescido de 1. 
        int c = (y / 100) + 1;
        
        //passo4:Seja X o quociente da divisão de 3*C por 4, menos 12 e Z o quociente da  divisão de 8*C+5 por 25, menos 5. 
        int x = ((3*c)/4)-12;
        int z = (((8*c)+5)/25)-5;
        
        //passo5: Seja E o resto da divisão inteira de (11*G+20+Z-X) por 30
        int e = (11*g+20+z-x)%30;
        
        //passo6: Se E = 25 e G > 11 ou se E = 24 então some 1 a E
        if((e==25 && g>11) || (e==24)){
            e++;
        }
        
        //passo7:Seja N = 44 - E. Se N < 21 então faça N receber N + 30.
        int n = 44-e;
        if(n<21){
            n = n+30;
        }
        
        //passo8:Seja D o quociente da divisão inteira de 5 * Y por 4, menos (X + 10). Faça N  receber N + 7 menos o resto da divisão de (D + N) por 7. 
        int d = ((5*y)/4)-(x+10);
        n = ((n+7)-((d+n)%7));
        
        //passo9:Se N>31 a Páscoa será no dia (N - 31) de abril, caso contrário será em N de  março.
        
        
        if(n>31){
            dia = (n-31);
            mes= 4;
        }else{
            dia= n;
            mes = 3;
        }
           System.out.println(dia + "/" + mes + "/" + ano);
    }
   
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    
    //Criar o GregorianCalendar
    
     public String getDataPascoa( ){
        GregorianCalendar pascoa = new GregorianCalendar(ano, mes-1, dia);
        String pascoa2 = formatador.format(pascoa.getTime());
        return pascoa2;
     }
        
         public String getDataCorpusChristi( ){
        //corpus christi
        GregorianCalendar corpusChristi = new GregorianCalendar(ano, mes-1, dia);
        corpusChristi.add(Calendar.DAY_OF_MONTH, 60);
        String corpus2 = formatador.format(corpusChristi.getTime());
        
        return corpus2;
         }
        
    public String getDataCarnaval( ){
        //carnaval: 47 dias antes da data da pascoa
        GregorianCalendar carnaval = new GregorianCalendar(ano, mes-1, dia);
        carnaval.add(Calendar.DAY_OF_MONTH, -47);
        String carnaval2 = formatador.format(carnaval.getTime());
        return carnaval2;
     
    }
   
   
}
