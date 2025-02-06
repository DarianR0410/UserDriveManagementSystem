

package Objects;

public class TvObject {
    String brand;
    String color;
    String serie;
    int width;
    int lenght;
    int price;
    
    public void Tv(String brand, String serie, int width, int length, int price){
        this.brand = brand;
        this.serie = serie;
        this.width = width;
        this.lenght = length;
        this.price = price;
        
    };
    
    public void TvSize(int lenght, int width){
        
        if (lenght == 0 && width <= 0){
            System.out.println("No existen televisores cuyo largo y ancho igual o menor que 0");
        } else {
            System.out.println("el largo de este TV es: "+ lenght + " y su largo es: "+ width);
        }
    }
    
    public void price(int price){
        if(price <= 0){
            System.out.println("El precio del televisor debe ser mayor que 0");
        } else {
            System.out.println("El costo del televisor es: $" + price + " dom pesos");
        }
    } 
    
    public void color(String color){
        if(color.equals("negro")){
            System.out.println("Su televisor es de color negro");
        } else if (color.equals("Gris")){
            System.out.println("Su televisor es de color gris");
        } else{
    System.out.println("No tenemos TV's de ese color");
}
    }
    
    public void brand(String brand){
       if (brand.equals("Samsung")){
           System.out.println("Esta es una TV de la marca Samsung");
       } else if (brand.equals("LG")){
           System.out.println("Esta es una TV de la marca LG");
       }else if (brand.equals("Sony")){
           System.out.println("Esta es una TV de la marca Sony");
       } else {
           System.out.println("Esta es de una marca poco conocida.");
       } 
    };   

}
    

