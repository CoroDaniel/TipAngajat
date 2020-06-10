package Teme;
import java.util.*;

/**
 *
 * @author Dani
 */
/*Bilet 2
Creați clasa Persoana care să fie caracterizată de nume, prenume și un întreg care indică nivelul
cumulat al competențelor deținute.
Creați clasele Muncitor si Vanzator ca două tipuri specifice de persoană:
·Muncitor care este capabil să munceasca și
·Vanzator care este capabil să vândă.
Implementarea acestui comportament se realizeaza prin mesaje specifice afișate pe consola
standard de ieșire.
Creați clasa Companie care agrega Persoana. În clasa Companie creați o funcție care creează
aleator 20 de angajati Muncitori și Vanzatori . Numele fiecarui angajat va fi de forma ‘Nx’,
prenumele de forma ‘Px’ (unde x reprezinta pozitia pe care va fi adaugat in lista), iar nivelul de
competenta al fiecaruia va fi generat aleator in intervalul 0..10.
Testați toate clasele și funcționalitățile create într-o clasă separată Test.
*/



class Persoana{
    String nume, prenume;
    int nivel;
}

class Muncitor extends Persoana{
    Muncitor(){
        System.out.println("Capabil sa munceasca");
    }
}

class Vanzator extends Persoana{
    Vanzator(){
        System.out.println("Capabil sa vanda");
    }
}


class NivelPreaMic extends Exception{
        public static void ex(){
            System.out.println("Capabil sa vanda");
        }
}

class Companie{
    Random r = new Random(1);
    int m=0, v=0; //vor tine evidenta numarului de muncitori, respectiv vanzatori
    Muncitor muncitor[]; //angajatii muncitori
    Vanzator vanzator[]; //angajatii vanzatori
    int aleator;
    
    void creare(){
        for(int i=1;i<=20;i++){
            aleator=r.nextInt(2);//se va alege aleator numarul 0 sau 1,
                                 //daca este 0 atunci vom crea o persoana de tip Muncitor,
                                 //daca este 1 atunci angajat vanzator
            if(aleator==0){
                m++;
                muncitor[m] = new Muncitor();
                muncitor[m].nume="N"+i;
                muncitor[m].prenume="P"+i; 
                muncitor[m].nivel=r.nextInt(11); //nivel primeste o valoare random de maxim 10
            }
            else{
                v++;
                vanzator[v] = new Vanzator();
                vanzator[v].nume="N"+i;
                vanzator[v].prenume="P"+i;
                vanzator[v].nivel=r.nextInt(11);
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Companie companie = new Companie();
        companie.creare();
        //afisam datele tuturor angajatiilo de tip muncitor
        System.out.println("Muncitori:");
        for(int i=1;i<=companie.m;i++){
            System.out.println("Nume:" + companie.muncitor[i].nume + "\n"
            +"Prenume: " + companie.muncitor[i].prenume+"\n" + "Nivel:" + companie.muncitor[i].nivel + "\n" );
        }
        
        //afisam datele tuturor angajatiilo de tip vanzator
        System.out.println("Vanzatori:");
        for(int i=1;i<=companie.v;i++){
            System.out.println("Nume:"+companie.vanzator[i].nume + "\n"
            +"Prenume: " + companie.vanzator[i].prenume+"\n" + "Nivel:" + companie.vanzator[i].nivel+"\n" ); 
        }
    }
}