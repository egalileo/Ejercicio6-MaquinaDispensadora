
package ejercicio6.maquinadispensadora;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
    Crear una aplicación que simulará una máquina dispensadora con ciertas peculiaridades. Primero tendrá cuatro productos que el usuario puede ver,
    Galletas, Soda, Churritos y Maní. El usuario verá un menú y su número de cliente. Un cliente podrá comprar una o varias unidades de uno o varios productos,
    hasta que el cliente no decida terminar la compra puede seguir comprando siempre y cuando haya existencias. 

    Las existencias serán 50 al inicio para cada producto que conforme se compre irá disminuyendo dependiendo de la cantidad vendida. 
    Si un cliente quiere comprar más unidades de las que hay en existencias la aplicación debe ser capaz de indicarle que no puede comprar más porque excede las existencias.
    Si un cliente desea comprar un producto que está en existencia 0 el programa debe ser capaz de indicarle que no hay en existencia. 
    Al finalizar cada compra por usuario el programa debe imprimir una especie de Ticket donde dará los siguientes datos: 
    Número de cliente, Listado de los productos comprados, unidades compradas y el precio unitario de la misma, y al final el total a cancelar. 
    Después el programa seguirá con el siguiente cliente.
    Si un cliente no compra nada, el número de cliente no debe incrementar. 
    Al estar en el punto de que las existencias se agotaron para los cuatro productos la aplicación debe cerrarse y escribir un mensaje 
    diciendo que todo ha sido vendido con éxito y mostrando los totales.
    Los precios son los siguientes: Galletas $0.15, Maní $0.25, Churritos $0.10 y Soda $0.50.
    El número de cliente será automático comenzando desde 1.
*/
public class Ejercicio6MaquinaDispensadora {
    public static void main(String[] args) {
        double precioGalletas = 0.15, precioSoda = 0.50, precioMani = 0.25, precioChurritos = 0.10, totalCliente = 0, totalMaquina = 0;
            int cantidadGalletas = 50, cantidadSoda = 50, cantidadMani = 50, cantidadChurritos = 50;
            int cuantaGalletas = 0, cuantaSoda = 50, cuantoMani = 0, cuantoChurritos = 0;
            String salida = "";
            int cliente = 1, opcion, comprar;
            boolean salir = false, compra = true;
            JTextArea hoja = new JTextArea();
            
            while(!salir){
                if(cantidadGalletas == 0 && cantidadSoda == 0 && cantidadMani == 0 && cantidadChurritos == 0){
                    JOptionPane.showMessageDialog(null, "Maquina fuera de Stock");
                    salida = "Total galletas vendidas: \t$"+(precioGalletas*50)+"\nTotal Sodas Vendidas: \t$"+(precioSoda*50)+"\nTotal Mani Vendido: \t$"+(precioMani*50)
                            +"\nTotal Churritos Vendidos: \t$"+(precioChurritos*50)+"\nTotal Acumulado \t $"+totalMaquina;
                    hoja.setText(salida);
                    JOptionPane.showMessageDialog(null, hoja);
                    salir = true;
                }else{
                    comprar = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido! Cliente #"+cliente+" desea comprar?\n1. Si\n2. No"));
                    if(comprar == 1){
                        salida = "Cliente #"+cliente+"\n";
                        while (compra){
                            opcion = Integer.parseInt(JOptionPane.showInputDialog("Cliente #"+cliente+" Ingrese el producto que desea comprar"
                                    + "\n1. Galletas $0.15\n2. Soda $0.50\n3. Mani $0.25\n4. Churritos $0.10\n5. Para confirmar compra"));
                            if(opcion == 1){ //Galletas
                                do{
                                    cuantaGalletas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Galleta(s) que desea comprar\nDisponibles: "
                                    +cantidadGalletas));
                                }while(cuantaGalletas < 0);
                                    if((cantidadGalletas - cuantaGalletas) < 0){
                                        //No hay galletas
                                        JOptionPane.showMessageDialog(null, "Lo Sentimos. No disponemos del suficiente stock para completar su orden");
                                    }else{
                                        //Si hay galletas
                                        salida = salida + "Galletas \t "+cuantaGalletas+" \t $"+precioGalletas+"\n";
                                        totalCliente = totalCliente + (precioGalletas * cuantaGalletas);
                                        cantidadGalletas = cantidadGalletas - cuantaGalletas;
                                    }
                            }else if(opcion == 2){ //Soda
                                do{
                                    cuantaSoda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Soda(s) que desea comprar\nDisponibles: "
                                    +cantidadSoda));
                                }while(cuantaSoda < 0);
                                    if((cantidadSoda - cuantaSoda) < 0){
                                        //No hay soda
                                        JOptionPane.showMessageDialog(null, "Lo Sentimos. No disponemos del suficiente stock para completar su orden");
                                    }else{
                                        //Si hay soda
                                        salida = salida + "Sodas \t "+cuantaSoda+" \t $"+precioSoda+"\n";
                                        totalCliente = totalCliente + (precioSoda * cuantaSoda);
                                        cantidadSoda = cantidadSoda - cuantaSoda;
                                    }
                            }else if(opcion == 3){ //Mani
                                do{
                                    cuantoMani = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Soda(s) que desea comprar\nDisponibles: "
                                    +cantidadMani));
                                }while(cuantoMani < 0);
                                    if((cantidadMani - cuantoMani) < 0){
                                        //No hay Mani
                                        JOptionPane.showMessageDialog(null, "Lo Sentimos. No disponemos del suficiente stock para completar su orden");
                                    }else{
                                        //Si hay Mani
                                        salida = salida + "Mani \t "+cuantoMani+" \t $"+precioMani+"\n";
                                        totalCliente = totalCliente + (precioMani * cuantoMani);
                                        cantidadMani = cantidadMani - cuantoMani;
                                    }
                            }else if(opcion == 4){ //Churritos
                                do{
                                    cuantoChurritos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Soda(s) que desea comprar\nDisponibles: "
                                    +cantidadChurritos));
                                }while(cuantoChurritos < 0);
                                    if((cantidadChurritos - cuantoChurritos) < 0){
                                        //No hay Mani
                                        JOptionPane.showMessageDialog(null, "Lo Sentimos. No disponemos del suficiente stock para completar su orden");
                                    }else{
                                        //Si hay Mani
                                        salida = salida + "Churritos \t "+cuantoChurritos+" \t $"+precioChurritos+"\n";
                                        totalCliente = totalCliente + (precioChurritos * cuantoChurritos);
                                        cantidadChurritos = cantidadChurritos - cuantoChurritos;
                                    }
                            }else if(opcion == 5){
                                if(totalCliente != 0){
                                    totalMaquina +=totalCliente ;
                                    salida = salida + "Total a pagar\t\t $"+totalCliente;
                                    hoja.setText(salida);
                                    JOptionPane.showMessageDialog(null, hoja);
                                    cliente++;
                                    salida = "";
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error. No ha efectuado ninguna compra");
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Escoja una opcion valida");
                                break;
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Gracias por su visita!");
                    }
                }
                
            }
    }
    
}
