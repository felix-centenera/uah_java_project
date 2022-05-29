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
            InventoryServices.addProduct("MacBookAirM1", "Apple", "Ordenadores", 1500, "Img/shop/appleMacbookAirM1.png", 1);
            InventoryServices.getProducto("MacBookAirM1").introducirOpinion(o1);
            InventoryServices.getProducto("MacBookAirM1").introducirOpinion(o3);
            InventoryServices.getProducto("MacBookAirM1").introducirOpinion(o5);
            
                
            InventoryServices.addProduct("appleMacbookProM1", "Apple", "Ordenadores",3000, "Img/shop/appleMacbookProM1.png", 10);
            InventoryServices.getProducto("appleMacbookProM1").introducirOpinion(o4);
            InventoryServices.getProducto("appleMacbookProM1").introducirOpinion(o4);
            InventoryServices.getProducto("appleMacbookProM1").introducirOpinion(o1);


            InventoryServices.addProduct("dellXps13", "dell", "Ordenadores", 2000, "Img/shop/dellXps13.png", 10);
            InventoryServices.getProducto("appleMacbookProM1").introducirOpinion(o5);
            InventoryServices.getProducto("appleMacbookProM1").introducirOpinion(o4);
            InventoryServices.getProducto("appleMacbookProM1").introducirOpinion(o3);

            
            InventoryServices.addProduct("hpPavilion", "hp sobremesa", "Ordenadores", 1700, "Img/shop/hpPavilion.png", 10);
            InventoryServices.getProducto("hpPavilion").introducirOpinion(o5);
            InventoryServices.getProducto("hpPavilion").introducirOpinion(o4);
            InventoryServices.getProducto("hpPavilion").introducirOpinion(o3);
            
            InventoryServices.addProduct("PcComGOldi5", "PcComGOldi5 potente para jugar como un pro", "Ordenadores", 1500, "Img/shop/PcComGOldi5.png", 10);
            InventoryServices.getProducto("PcComGOldi5").introducirOpinion(o5);
            InventoryServices.getProducto("PcComGOldi5").introducirOpinion(o4);
            InventoryServices.getProducto("PcComGOldi5").introducirOpinion(o3);
            
            InventoryServices.addProduct("HpOmeni7", "HpOmeni7 potente para jugar como un pro", "Ordenadores", 1200, "Img/shop/HpOmeni7.png", 10);
            InventoryServices.getProducto("HpOmeni7").introducirOpinion(o5);
            InventoryServices.getProducto("HpOmeni7").introducirOpinion(o4);
            InventoryServices.getProducto("HpOmeni7").introducirOpinion(o3);
            
            
            InventoryServices.addProduct("SurfaceGoi5", "Portabilidad y rapidez", "Ordenadores", 1200, "Img/shop/SurfaceGoi5.png", 10);
            InventoryServices.getProducto("SurfaceGoi5").introducirOpinion(o5);
            InventoryServices.getProducto("SurfaceGoi5").introducirOpinion(o4);
            InventoryServices.getProducto("SurfaceGoi5").introducirOpinion(o3);
            
            
            InventoryServices.addProduct("Disco1TBHDD", "1 TB de almacenamiento", "Componentes", 300, "Img/shop/Disco1TBHDD.png", 10);
            InventoryServices.addProduct("IntelCore5", "Microprocesador i5", "Componentes", 300, "Img/shop/IntelCore5.png", 10);
            
            InventoryServices.addProduct("SamsungGalaxy", "SamsungGalaxy comunicate con el mundo", "Móviles y telefonía", 1200, "Img/shop/SamsungGalaxy.png", 10);
            InventoryServices.getProducto("SamsungGalaxy").introducirOpinion(o5);
            InventoryServices.getProducto("SamsungGalaxy").introducirOpinion(o4);
            InventoryServices.getProducto("SamsungGalaxy").introducirOpinion(o3);
            
            InventoryServices.addProduct("XiaomiRedmi", "XiaomiRedmi comunicate con el mundo", "Móviles y telefonía", 1200, "Img/shop/XiaomiRedmi.png", 10);
            InventoryServices.getProducto("XiaomiRedmi").introducirOpinion(o4);
            InventoryServices.getProducto("XiaomiRedmi").introducirOpinion(o4);
            InventoryServices.getProducto("XiaomiRedmi").introducirOpinion(o1);
            
            InventoryServices.addProduct("Pocom4", "Pocom4 comunicate con el mundo", "Móviles y telefonía", 1200, "Img/shop/Pocom4.png", 10);
            InventoryServices.getProducto("Pocom4").introducirOpinion(o1);
            InventoryServices.getProducto("Pocom4").introducirOpinion(o3);
            InventoryServices.getProducto("Pocom4").introducirOpinion(o5);
            
            
            InventoryServices.addProduct("CanonM6", "CanonM6 retrata el mundo", "TV, audio y foto", 1200, "Img/shop/CanonM6.png", 10);
            InventoryServices.getProducto("CanonM6").introducirOpinion(o5);
            InventoryServices.getProducto("CanonM6").introducirOpinion(o4);
            InventoryServices.getProducto("CanonM6").introducirOpinion(o3);
            
            InventoryServices.addProduct("XiaomiTv", "XiaomiTv viajando sin salir de casa", "TV, audio y foto", 1200, "Img/shop/XiaomiTv.png", 10);
            InventoryServices.getProducto("XiaomiTv").introducirOpinion(o5);
            InventoryServices.getProducto("XiaomiTv").introducirOpinion(o4);
            InventoryServices.getProducto("XiaomiTv").introducirOpinion(o3);
            
            InventoryServices.addProduct("SamsungTv", "SamsungTv viajando sin salir de casa", "TV, audio y foto", 1200, "Img/shop/SamsungTv.png", 10);
            InventoryServices.getProducto("SamsungTv").introducirOpinion(o5);
            InventoryServices.getProducto("SamsungTv").introducirOpinion(o4);
            InventoryServices.getProducto("SamsungTv").introducirOpinion(o3);
            
            InventoryServices.addProduct("LGTv", "LGTv viajando sin salir de casa", "TV, audio y foto", 1200, "Img/shop/LGTv.png", 10);
            InventoryServices.getProducto("LGTv").introducirOpinion(o5);
            InventoryServices.getProducto("LGTv").introducirOpinion(o4);
            InventoryServices.getProducto("LGTv").introducirOpinion(o3);
            
            InventoryServices.addProduct("LGTv2", "LGTv2 viajando sin salir de casa", "TV, audio y foto", 1200, "Img/shop/LGTv2.png", 10);
            InventoryServices.getProducto("LGTv2").introducirOpinion(o5);
            InventoryServices.getProducto("LGTv2").introducirOpinion(o4);
            InventoryServices.getProducto("LGTv2").introducirOpinion(o3);
            
            InventoryServices.addProduct("Ps4TheLastOfUs", "Ps4TheLastOfUs pierza de colección", "Consolas y videojuegos", 60, "Img/shop/Ps4TheLastOfUs.png", 10);
            InventoryServices.getProducto("Ps4TheLastOfUs").introducirOpinion(o5);
            InventoryServices.getProducto("Ps4TheLastOfUs").introducirOpinion(o4);
            InventoryServices.getProducto("Ps4TheLastOfUs").introducirOpinion(o3);
            
            InventoryServices.addProduct("Ps4Battledield", "Ps4Battledield pierza de colección", "Consolas y videojuegos", 60, "Img/shop/Ps4Battledield.png", 10);
            InventoryServices.getProducto("Ps4Battledield").introducirOpinion(o5);
            InventoryServices.getProducto("Ps4Battledield").introducirOpinion(o4);
            InventoryServices.getProducto("Ps4Battledield").introducirOpinion(o3);
            
            InventoryServices.addProduct("LittleHope", "Little Hope pierza de colección", "Consolas y videojuegos", 60, "Img/shop/LittleHope.png", 10);
            InventoryServices.getProducto("LittleHope").introducirOpinion(o5);
            InventoryServices.getProducto("LittleHope").introducirOpinion(o4);
            InventoryServices.getProducto("LittleHope").introducirOpinion(o3);
            
            InventoryServices.addProduct("RedDeadRedemption2", "RedDeadRedemption2 pierza de colección", "Consolas y videojuegos", 60, "Img/shop/RedDeadRedemption2.png", 10);
            InventoryServices.getProducto("RedDeadRedemption2").introducirOpinion(o5);
            InventoryServices.getProducto("RedDeadRedemption2").introducirOpinion(o4);
            InventoryServices.getProducto("RedDeadRedemption2").introducirOpinion(o3);
            
            InventoryServices.addProduct("Werewolf", "Werewolfpierza de colección", "Consolas y videojuegos", 60, "Img/shop/Werewolf.png", 10);
            InventoryServices.getProducto("Werewolf").introducirOpinion(o5);
            InventoryServices.getProducto("Werewolf").introducirOpinion(o4);
            InventoryServices.getProducto("Werewolf").introducirOpinion(o3);
            
            InventoryServices.addProduct("eFootballPES2020", "eFootballPES2020 de colección", "Consolas y videojuegos", 60, "Img/shop/eFootballPES2020.png", 10);
            InventoryServices.getProducto("eFootballPES2020").introducirOpinion(o5);
            InventoryServices.getProducto("eFootballPES2020").introducirOpinion(o4);
            InventoryServices.getProducto("eFootballPES2020").introducirOpinion(o3);
            
            InventoryServices.addProduct("WWE2K22", "WWE2K22 de colección", "Consolas y videojuegos", 60, "Img/shop/WWE2K22.png", 10);
            InventoryServices.getProducto("WWE2K22").introducirOpinion(o5);
            InventoryServices.getProducto("WWE2K22").introducirOpinion(o4);
            InventoryServices.getProducto("WWE2K22").introducirOpinion(o3);
            
            
            InventoryServices.addProduct("TotalWarThree", "TotalWarThree de colección", "Consolas y videojuegos", 60, "Img/shop/TotalWarThree.png", 10);
            InventoryServices.getProducto("TotalWarThree").introducirOpinion(o5);
            InventoryServices.getProducto("TotalWarThree").introducirOpinion(o4);
            InventoryServices.getProducto("TotalWarThree").introducirOpinion(o3);
            
            
            InventoryServices.addProduct("XboxSeriesS", "XboxSeriesS diversión infinita", "Consolas y videojuegos", 60, "Img/shop/XboxSeriesS.png", 10);
            InventoryServices.getProducto("XboxSeriesS").introducirOpinion(o5);
            InventoryServices.getProducto("XboxSeriesS").introducirOpinion(o4);
            InventoryServices.getProducto("XboxSeriesS").introducirOpinion(o3);
            
            InventoryServices.addProduct("XboxSeriesX", "XboxSeriesS diversión infinita", "Consolas y videojuegos", 60, "Img/shop/XboxSeriesX.png", 10);
            InventoryServices.getProducto("XboxSeriesX").introducirOpinion(o5);
            InventoryServices.getProducto("XboxSeriesX").introducirOpinion(o4);
            InventoryServices.getProducto("XboxSeriesX").introducirOpinion(o3);

//            InventoryServices.addProduct("dellXps132", "dell", "Ordenadores", 2000, "Img/laptops/dell/dellXps13.png", 10);
//            InventoryServices.addProduct("dellXps133", "dell", "Ordenadores", 2000, "Img/laptops/dell/dellXps13.png", 10);
//            InventoryServices.addProduct("dellXps134", "dell", "Ordenadores", 2000, "Img/laptops/dell/dellXps13.png", 10);
//            InventoryServices.addProduct("dellXps135", "dell", "Ordenadores", 2000, "Img/laptops/dell/dellXps13.png", 10);
//            InventoryServices.addProduct("dellXps136", "dell", "Ordenadores", 2000, "Img/laptops/dell/dellXps13.png", 10);
//            InventoryServices.addProduct("dellXps137", "dell", "Ordenadores", 2000, "Img/laptops/dell/dellXps13.png", 10);
//            InventoryServices.addProduct("dellXps138", "dell", "Ordenadores", 2000, "Img/laptops/dell/dellXps13.png", 10);
        
//            Inventario i1 = new Inventario();
//            i1.introducirProducto(p1, 4);
//            i1.introducirProducto(p2, 4);
//            i1.introducirProducto(p3, 4);
            
         // Introductir opniones
//            p1.introducirOpinion(o1);
//            p1.introducirOpinion(o2);
//            p1.introducirOpinion(o4);
//            p1.introducirOpinion(o6);
//            p2.introducirOpinion(o2);
//            p2.introducirOpinion(o3);
//            p2.introducirOpinion(o5);
//            p2.introducirOpinion(o6);
//            p3.introducirOpinion(o3);
//            p3.introducirOpinion(o1);
//            p3.introducirOpinion(o2);
//            p3.introducirOpinion(o4);
            
    } 
    
    
//    public  static void createMockUser() {
//         LocalDate fecha = LocalDate.of(2020, 9, 18); 
//         LocalDateTime fechaTime = LocalDateTime.now();
//         Token to1 = new Token(RadomGenerator.generateRandomPassword(20), LocalDateTime.now().plusMinutes(4));
//         TarjetaDeCredito t1 = new TarjetaDeCredito("Felix",1234_1234_1234_1234L,fecha);
//         Direccion d1 = new Direccion("calleEjemplo",2,28829,"Madrid");
//         ClienteParticular c1 = new ClienteParticular("20120000-F", "Felix", d1,t1,"91-2240234","pass","felix@uah.es",to1);
//         UserData.getInstance().getUserHashMap().put("felix@uah.es", c1);
//    }
    
    
    
}
