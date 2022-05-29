/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.allsafe.service;

import com.allsafe.mock.UserData;
import com.allsafe.model.ClienteEmpresa;
import com.allsafe.model.ClienteParticular;
import com.allsafe.model.Direccion;
import com.allsafe.model.Inventario;
import com.allsafe.model.Opinion;
import com.allsafe.model.Producto;
import com.allsafe.model.TarjetaDeCredito;
import com.allsafe.model.Token;
import com.allsafe.model.Usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author felixcentenera
 */
public class GenerateMockDemoObjects {
    
    // ******************************************************************************************************************** 
    /**
     * Nos permite iniciar la tienda en modo Demo, se crearan  ClientesParticulares, ClientesEmpresa, Productos
     * opiniones de productos con proposito de poder hacer una demostración de la aplicación.
     */
    public static void  generateDemoData(){
        
        //Fecha prueba.
            LocalDate fecha = LocalDate.of(2023, 9, 18); 
            LocalDateTime fechaTime = LocalDateTime.now();

        //Crear Dirección
            Direccion d1 = new Direccion("calleEjemplo",2,28829,"Madrid");
            Direccion d2 = new Direccion("Calle Picapedreros",3,46014,"Valencia");
            Direccion d3 = new Direccion("Avenida de Viya", 7 ,11009,"Cadiz");
            Direccion d4 = new Direccion("Lago Constanza",2,28017,"Madrid");
            Direccion d5 = new Direccion("Calle Provenza",2,8025,"Barcelona");
            Direccion d6 = new Direccion("Calle Dr.Cerrada",2,50005,"Zaragoza");
            Direccion d7 = new Direccion("Campus Universitario, Ctra. Madrid-Barcelona",33,28805,"Madrid");

        //Crear TarjetaCredito
        //(String nombreTitular, long numeroTarjetaCredito, LocalDate fechaCaducidad)
            TarjetaDeCredito t1 = new TarjetaDeCredito("Josefina Castellví",1234_1234_1234_1234L,fecha);
            TarjetaDeCredito t2 = new TarjetaDeCredito("María Blasco MArhuenda",1234_1234_1234_1234L,fecha);
            TarjetaDeCredito t3 = new TarjetaDeCredito("Alicia Calderón",1234_1234_1234_1234L,fecha);
            TarjetaDeCredito t4 = new TarjetaDeCredito("Montserrat Calleja",1234_1234_1234_1234L,fecha);
            TarjetaDeCredito t5 = new TarjetaDeCredito("Rosa María Menéndez",1234_1234_1234_1234L,fecha);
            TarjetaDeCredito t6 = new TarjetaDeCredito("Carmen Magallón",1234_1234_1234_1234L,fecha);
            TarjetaDeCredito t7 = new TarjetaDeCredito("uah",1234_1234_1234_1234L,fecha);
            

        //Crear token LocalDateTime
            Token to1 = new Token(RadomGenerator.generateRandomPassword(20),LocalDateTime.now().plusMinutes(4));
            Token to2 = new Token(RadomGenerator.generateRandomPassword(20),LocalDateTime.now().plusMinutes(4));
            Token to3 = new Token(RadomGenerator.generateRandomPassword(20),LocalDateTime.now().plusMinutes(4));
            

        //Crear clienteParticular
            ClienteParticular c1 = new ClienteParticular("12345678Z", "Josefina Castellví", d1,t1,"91-2240234","pass","JosefinaCastellví@csic.com",to1);
            ClienteParticular c2 = new ClienteParticular("12345678Z", "María Blasco MArhuenda", d2,t2,"91-2240234","pass","MariaBlasco@cnio.com",to2);
            ClienteParticular c3 = new ClienteParticular("12345678Z", "Alicia Calderón", d3,t3,"91-2240234","pass","AliciaCalderón@Unican.com",to3);
            ClienteParticular c4 = new ClienteParticular("12345678Z", "Montserrat Calleja", d4,t4,"91-2240234","pass","MontserratCalleja@csic.com",to1);
            ClienteParticular c5 = new ClienteParticular("12345678Z", "Rosa María Menéndez", d5,t5,"91-2240234","pass","RosaMariaMenéndez@csic.com",to2);
            ClienteParticular c6 = new ClienteParticular("12345678Z", "Carmen Magallón", d6,t6,"91-2240234","pass","CarmenMagallón@unizar.com",to3);
            
        //Crear entidad
            ClienteEmpresa e1 = new ClienteEmpresa("E04026233","www.uah.es","UAH",d7,t7,"918 85 65 05", "pass", "uah@uah.es",to3);
        
            
        // Add users 
            UserData.getInstance().getUserHashMap().put("JosefinaCastellví@csic.com", c1);
            UserData.getInstance().getUserHashMap().put("MariaBlasco@cnio.com", c2);
            UserData.getInstance().getUserHashMap().put("AliciaCalderón@Unican.com", c3);
            UserData.getInstance().getUserHashMap().put("MontserratCalleja@csic.com", c4);
            UserData.getInstance().getUserHashMap().put("RosaMariaMenéndez@csic.com", c5);
            UserData.getInstance().getUserHashMap().put("CarmenMagallón@unizar.com", c6);
            UserData.getInstance().getUserHashMap().put("uah@uah.es", e1);
            
            
//            ClienteParticular c2 = new ClienteParticular("201200d0-F", "Pepe", d1,t1,"91-2240234","pass","pepe@miempresa.com",to2);
//            ClienteParticular c3 = new ClienteParticular("20112sd0-F", "Maria", d1,t1,"91-2240234","pass","maria@miempresa.com",to3);
            //Usuario c4 = new ClienteParticular("20112sd0-F", "Maria", d1,t1,"91-2240234","pass","maria@miempresa.com",to3);
         
        // Crear opiniones
            Opinion  o1 = new Opinion(3, "Satisfecho con la compra",c1.getCorreo()); 
            Opinion  o2 = new Opinion(0, "No comprar, malisimo, por ese precido debería hacerme la cama",c2.getCorreo()); 
            Opinion  o3 = new Opinion(5, "Estoy muy contenta con la compra realizada, tanto por el artículo como por la atención de la plataforma. Fue muy sencillo realizar la selección y el pago ya que el poder financiar un producto da mucho que decir sobre AllSafe. Para mí, es un punto a favor ya que no siempre viene bien hacer un pago entero. En cuanto al MacBook Air es un encanto, vino muy bien embalado y protegido. El paquete me llegó en menos de 48 horas, una cosa increíble ya que en otras plataformas te tarda mucho más y si lo necesitas urgentemente, no lo puedes usar, pero en caso de PcComponentes sí. Esto es otro punto positivo que reflejo con mi compra ya que no esperaba que llegase tan pronto. El portátil funciona perfectamente y además, con la opción Aplazame de PcComponentes, puedes cambiar hasta tres veces la forma de tu financiación, o directamente, puedes pagar toda la cantidad que queda en el momento que tú quieras. Estoy muy contenta y sé que voy a seguir comprando artículos de tecnología aquí. :)!",c3.getCorreo());
            Opinion  o4 = new Opinion(3, "Ni fu ni fa, esperaba más la verdad",c3.getCorreo()); 
            Opinion  o5 = new Opinion(0, "Es un autentico timo",c4.getCorreo()); 
            Opinion  o6 = new Opinion(5, "INcreible, va como una bala",c5.getCorreo());
            
        // Generar producto
//            Producto p1 = new Producto("MacBookAirM1","Apple", "Portatiles",1000,"Img/shop/appleMacbookAirM1.png", 1);
//            Producto p2 = new Producto("MacBookProM1","Apple", "Portatiles",1000,"Img/shop/appleMacbookProM1.png", 1);
//            Producto p3 = new Producto("Dell XPS","Dell", "Portatiles",1000,"Img/shop/dellXps13.png", 1);
        
        // Añadir a inventario productos y opiniones:
            InventoryServices.addProduct("MacBookAirM1", "Apple M1 8GB 256GB SSD GPU Hepta Core/13.3\" Plata", "Ordenadores", 1200, "Img/shop/appleMacbookAirM1.png", 1);
            InventoryServices.getProducto("MacBookAirM1").introducirOpinion(o1);
            InventoryServices.getProducto("MacBookAirM1").introducirOpinion(o3);
            InventoryServices.getProducto("MacBookAirM1").introducirOpinion(o5);
            
                
            InventoryServices.addProduct("MacbookProM1", "Apple M1/16GB/512GB SSD/13.3\" Gris Espacial", "Ordenadores",2000, "Img/shop/appleMacbookProM1.png", 10);
            InventoryServices.getProducto("MacbookProM1").introducirOpinion(o4);
            InventoryServices.getProducto("MacbookProM1").introducirOpinion(o4);
            InventoryServices.getProducto("MacbookProM1").introducirOpinion(o1);


            InventoryServices.addProduct("dellXps13", "Intel Core i7-10850H/16GB/512GB SSD/Quadro RTX 3000", "Ordenadores", 2500, "Img/shop/dellXps13.png", 10);
            InventoryServices.getProducto("dellXps13").introducirOpinion(o5);
            InventoryServices.getProducto("dellXps13").introducirOpinion(o4);
            InventoryServices.getProducto("dellXps13").introducirOpinion(o3);

            
            InventoryServices.addProduct("HPVictus", "HP Victus 16-e0090ns AMD Ryzen 7 ", "Ordenadores", 500, "Img/shop/HPVictus.png", 10);
            InventoryServices.getProducto("HPVictus").introducirOpinion(o5);
            InventoryServices.getProducto("HPVictus").introducirOpinion(o4);
            InventoryServices.getProducto("HPVictus").introducirOpinion(o3);
            
            InventoryServices.addProduct("MSI", "MSI WS63 8SL-013ES Vpro Intel Core i7", "Ordenadores", 4557, "Img/shop/MSI.png", 10);
            InventoryServices.getProducto("MSI").introducirOpinion(o5);
            InventoryServices.getProducto("MSI").introducirOpinion(o4);
            InventoryServices.getProducto("MSI").introducirOpinion(o3);
            
            InventoryServices.addProduct("AcerNitro", "Acer Nitro 5 AN515-45-R4CS AMD Ryzen 5 ", "Ordenadores", 1098, "Img/shop/AcerNitro.png", 10);
            InventoryServices.getProducto("AcerNitro").introducirOpinion(o5);
            InventoryServices.getProducto("AcerNitro").introducirOpinion(o4);
            InventoryServices.getProducto("AcerNitro").introducirOpinion(o3);
            
            
            InventoryServices.addProduct("SurfaceGoi5", "Surface Laptop Go Intel Core i5-1035G1/8GB/128GB SSD/12.4\" Táctil", "Ordenadores", 619, "Img/shop/SurfaceGoi5.png", 10);
            InventoryServices.getProducto("SurfaceGoi5").introducirOpinion(o5);
            InventoryServices.getProducto("SurfaceGoi5").introducirOpinion(o4);
            InventoryServices.getProducto("SurfaceGoi5").introducirOpinion(o3);
            
            
            InventoryServices.addProduct("Disco1TBHDD", "1 TB de almacenamiento", "Componentes", 300, "Img/shop/Disco1TBHDD.png", 10);
            InventoryServices.addProduct("IntelCore5", "Microprocesador i5", "Componentes", 300, "Img/shop/IntelCore5.png", 10);
            
            InventoryServices.addProduct("SamsungGalaxy", "Galaxy A22 5G 64GB Negro Libre", "Móviles y telefonía", 1200, "Img/shop/SamsungGalaxy.png", 10);
            InventoryServices.getProducto("SamsungGalaxy").introducirOpinion(o5);
            InventoryServices.getProducto("SamsungGalaxy").introducirOpinion(o4);
            InventoryServices.getProducto("SamsungGalaxy").introducirOpinion(o3);
            
            InventoryServices.addProduct("XiaomiRedmi", "Redmi Note 11 4/128GB Gris Grafito Libre", "Móviles y telefonía", 185, "Img/shop/XiaomiRedmi.png", 10);
            InventoryServices.getProducto("XiaomiRedmi").introducirOpinion(o4);
            InventoryServices.getProducto("XiaomiRedmi").introducirOpinion(o4);
            InventoryServices.getProducto("XiaomiRedmi").introducirOpinion(o1);
            
            InventoryServices.addProduct("Pocom4", "POCO M4 Pro 8 256GB Negro Libre + Auriculares Mi In-Ear", "Móviles y telefonía", 120, "Img/shop/Pocom4.png", 10);
            InventoryServices.getProducto("Pocom4").introducirOpinion(o1);
            InventoryServices.getProducto("Pocom4").introducirOpinion(o3);
            InventoryServices.getProducto("Pocom4").introducirOpinion(o5);
            
            
            InventoryServices.addProduct("CanonM6", "M6 Mark II 32.5MP WiFi Cuerpo", "TV, audio y foto", 979, "Img/shop/CanonM6.png", 10);
            InventoryServices.getProducto("CanonM6").introducirOpinion(o5);
            InventoryServices.getProducto("CanonM6").introducirOpinion(o4);
            InventoryServices.getProducto("CanonM6").introducirOpinion(o3);
            
            InventoryServices.addProduct("XiaomiTv", "Xiaomi TV P1E 55\" LED UltraHD 4K HDR10", "TV, audio y foto", 379, "Img/shop/XiaomiTv.png", 10);
            InventoryServices.getProducto("XiaomiTv").introducirOpinion(o5);
            InventoryServices.getProducto("XiaomiTv").introducirOpinion(o4);
            InventoryServices.getProducto("XiaomiTv").introducirOpinion(o3);
            
            InventoryServices.addProduct("SamsungTv", "UE55AU8005KXXC 55\" LED UltraHD 4K", "TV, audio y foto", 589, "Img/shop/SamsungTv.png", 10);
            InventoryServices.getProducto("SamsungTv").introducirOpinion(o5);
            InventoryServices.getProducto("SamsungTv").introducirOpinion(o4);
            InventoryServices.getProducto("SamsungTv").introducirOpinion(o3);
            
            InventoryServices.addProduct("LGTv", "OLED UltraHD 4K HDR10 ", "TV, audio y foto", 922, "Img/shop/LGTv.png", 10);
            InventoryServices.getProducto("LGTv").introducirOpinion(o5);
            InventoryServices.getProducto("LGTv").introducirOpinion(o4);
            InventoryServices.getProducto("LGTv").introducirOpinion(o3);
            
            InventoryServices.addProduct("LGTv2", "OLED Ultra HD 4K HDR10 Pro", "TV, audio y foto", 1530, "Img/shop/LGTv2.png", 10);
            InventoryServices.getProducto("LGTv2").introducirOpinion(o5);
            InventoryServices.getProducto("LGTv2").introducirOpinion(o4);
            InventoryServices.getProducto("LGTv2").introducirOpinion(o3);
            
            InventoryServices.addProduct("Ps4TheLastOfUs", "The Last of Us Parte II PS4", "Consolas y videojuegos", 19, "Img/shop/Ps4TheLastOfUs.png", 10);
            InventoryServices.getProducto("Ps4TheLastOfUs").introducirOpinion(o5);
            InventoryServices.getProducto("Ps4TheLastOfUs").introducirOpinion(o4);
            InventoryServices.getProducto("Ps4TheLastOfUs").introducirOpinion(o3);
            
            InventoryServices.addProduct("Ps4Battledield", "Battlefield 2042 PS4", "Consolas y videojuegos", 58, "Img/shop/Ps4Battledield.png", 10);
            InventoryServices.getProducto("Ps4Battledield").introducirOpinion(o5);
            InventoryServices.getProducto("Ps4Battledield").introducirOpinion(o4);
            InventoryServices.getProducto("Ps4Battledield").introducirOpinion(o3);
            
            InventoryServices.addProduct("LittleHope", "The Dark Pictures Anthology: Little Hope Xbox One", "Consolas y videojuegos", 25, "Img/shop/LittleHope.png", 10);
            InventoryServices.getProducto("LittleHope").introducirOpinion(o5);
            InventoryServices.getProducto("LittleHope").introducirOpinion(o4);
            InventoryServices.getProducto("LittleHope").introducirOpinion(o3);
            
            InventoryServices.addProduct("RedDeadRedemption2", "RedDeadRedemption2 pierza de colección", "Consolas y videojuegos", 60, "Img/shop/RedDeadRedemption2.png", 10);
            InventoryServices.getProducto("RedDeadRedemption2").introducirOpinion(o5);
            InventoryServices.getProducto("RedDeadRedemption2").introducirOpinion(o4);
            InventoryServices.getProducto("RedDeadRedemption2").introducirOpinion(o3);
            
            InventoryServices.addProduct("Werewolf", "Werewolfpierza de colección", "Consolas y videojuegos", 55, "Img/shop/Werewolf.png", 10);
            InventoryServices.getProducto("Werewolf").introducirOpinion(o5);
            InventoryServices.getProducto("Werewolf").introducirOpinion(o4);
            InventoryServices.getProducto("Werewolf").introducirOpinion(o3);
            
            InventoryServices.addProduct("eFootballPES2020", "eFootballPES2020 de colección", "Consolas y videojuegos", 43, "Img/shop/eFootballPES2020.png", 10);
            InventoryServices.getProducto("eFootballPES2020").introducirOpinion(o5);
            InventoryServices.getProducto("eFootballPES2020").introducirOpinion(o4);
            InventoryServices.getProducto("eFootballPES2020").introducirOpinion(o3);
            
            InventoryServices.addProduct("WWE2K22", "WWE2K22 de colección", "Consolas y videojuegos", 15, "Img/shop/WWE2K22.png", 10);
            InventoryServices.getProducto("WWE2K22").introducirOpinion(o5);
            InventoryServices.getProducto("WWE2K22").introducirOpinion(o4);
            InventoryServices.getProducto("WWE2K22").introducirOpinion(o3);
            
            
            InventoryServices.addProduct("TotalWarThree", "TotalWarThree de colección", "Consolas y videojuegos", 60, "Img/shop/TotalWarThree.png", 10);
            InventoryServices.getProducto("TotalWarThree").introducirOpinion(o5);
            InventoryServices.getProducto("TotalWarThree").introducirOpinion(o4);
            InventoryServices.getProducto("TotalWarThree").introducirOpinion(o3);
            
            
            InventoryServices.addProduct("XboxSeriesS", " Xbox Series S 512GB", "Consolas y videojuegos", 300, "Img/shop/XboxSeriesS.png", 10);
            InventoryServices.getProducto("XboxSeriesS").introducirOpinion(o5);
            InventoryServices.getProducto("XboxSeriesS").introducirOpinion(o4);
            InventoryServices.getProducto("XboxSeriesS").introducirOpinion(o3);
            
            InventoryServices.addProduct("XboxSeriesX", " Xbox Series X 512GB", "Consolas y videojuegos", 220, "Img/shop/XboxSeriesX.png", 10);
            InventoryServices.getProducto("XboxSeriesX").introducirOpinion(o5);
            InventoryServices.getProducto("XboxSeriesX").introducirOpinion(o4);
            InventoryServices.getProducto("XboxSeriesX").introducirOpinion(o3);

            // Generate Ventas
            //c1.getCarritoCompra().
            c1.getCarritoCompra().addToProducto(InventoryServices.getProducto("SamsungGalaxy"));
            c2.getCarritoCompra().addToProducto(InventoryServices.getProducto("XboxSeriesX"));
            c2.getCarritoCompra().addToProducto(InventoryServices.getProducto("MSI"));
            c3.getCarritoCompra().addToProducto(InventoryServices.getProducto("LGTv"));
            c3.getCarritoCompra().addToProducto(InventoryServices.getProducto("MacBookAirM1"));
            SalesDataService.Sales(c1);
            SalesDataService.Sales(c2);
            SalesDataService.Sales(c3);
    } 

// ********************************************************************************************************************     
   
    
// ********************************************************************************************************************     
//    public  static void createMockUser() {
//         LocalDate fecha = LocalDate.of(2020, 9, 18); 
//         LocalDateTime fechaTime = LocalDateTime.now();
//         Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
//         TarjetaDeCredito t1 = new TarjetaDeCredito("Felix",1234_1234_1234_1234L,fecha);
//         Direccion d1 = new Direccion("calleEjemplo",2,28829,"Madrid");
//         ClienteParticular c1 = new ClienteParticular("20120000-F", "Felix", d1,t1,"91-2240234","pass","felix@uah.es",to1);
//         UserData.getInstance().getUserHashMap().put("felix@uah.es", c1);
//    }
 // ********************************************************************************************************************    
    
    
}
