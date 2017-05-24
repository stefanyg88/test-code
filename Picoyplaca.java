/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picoyplaca;

//import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author Antonio
 */
public class Picoyplaca {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        
        Scanner teclado=new Scanner(System.in);
        String fecha, hora;
        //Data Input
        System.out.println("Ingrese los 4 digitos de su placa");
        int placa=teclado.nextInt();
        String aux=Integer.toString(placa);
        while(aux.length()>4||aux.length()<4){
        System.out.println("No ha ingresado 4 digitos");
        System.out.println("Ingrese los 4 digitos de su placa");
        placa=teclado.nextInt();
        aux=Integer.toString(placa);
        }
        System.out.println("Ingrese la fecha en el formato(dd/mm/yyyy)");
        fecha=teclado.next();
        System.out.println("Ingrese la hora en el formato(hh:mm:ss)");
        hora=teclado.next();
        //Data Format
        SimpleDateFormat formatof=new SimpleDateFormat("dd/MM/yyy");
        Date fechaActual=formatof.parse(fecha);
        GregorianCalendar fechahora= new GregorianCalendar();
        fechahora.setTime(fechaActual);
        int dias=fechahora.get(Calendar.DAY_OF_WEEK);
        SimpleDateFormat formatoh=new SimpleDateFormat("HH:mm:ss");
        Date horaActual=formatoh.parse(hora);
        fechahora.setTime(horaActual);
        int horas=fechahora.get(Calendar.HOUR_OF_DAY);
        int min=fechahora.get(Calendar.MINUTE);
        //Conditions
        int placa1=placa%10;
        if((horas>6&&horas<9||horas>15&&horas<19)||(horas==9&&min<31||horas==19&&min<31)){
            if(((placa1==1||placa1==2)&&dias==2)||((placa1==3||placa1==4)&&dias==3)||((placa1==5||placa1==6)&&dias==4)||((placa1==7||placa1==8)&&dias==5)||((placa1==9||placa1==0)&&dias==6)){
                System.out.println(placa1+" "+dias+" Posible Multa...NO PUEDE CIRCULAR!!");
            }
           else 
            System.out.println("Puede circular");  
        }    
    }
}
