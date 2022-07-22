package testvuyoaquaiumproject;
import Parametres.*;
import java.util.Scanner;


public class TestVuyoAquariumProject {

    static final int MN0_Inici = -1;
    static final int MN1_Lectures = 1;
    static final int MN2_ElTeuAcuari = 2;
    static final int MN3_Alarmes = 3;
    static final int MN4_Sortir = 4;
    static final int MN1_1_Macros = 1;
    static final int MN1_2_AnteriorsLectures = 2;
    static final int MN1_3_Endarrere = 3;
    static final int MN2_1_IntroduirHabitant = 1;
    static final int MN2_2_LlistaHabitants = 2;
    static final int MN2_3_Endarrere = 3;   
    static final int MN3_1_SobreLectures = 1;
    static final int MN3_2_SobreFeines = 2;
    static final int MN3_3_Endarrere = 3;   


    
    public static void main(String[] args) {
        
        Scanner lector = new Scanner(System.in);  // el defineixo a nivell de Main, el passaré a les funcions que en faci ús.
        
        ParametresMenu lOpcions = new ParametresMenu();
        Macros lValors = new Macros();

        
        do {
            
            if (lOpcions.opcio2 != -1) {
                
                GestionaOpcionsNivell2(lOpcions,lValors,lector);
                
            } else if (lOpcions.opcio1 != MN0_Inici) {
                
                PresentaOpcionsNivell1_i_DemanaSeleccioPerNivell2(lOpcions,lector);
                
            }else { // si entrem aquí és o bé pq és la primera volta de bucle, o perquè estem tornant des de les opcions inferiors al menú inicial
                
                PresentaOpcionsNivell0_i_DemanaSeleccioPerNivell1(lOpcions,lector);
                
            }
            
        } while(lOpcions.opcio1 != MN4_Sortir);

    }
    
    /**
     *  PRECONDICIÓ: 
     *	   - No hi ha precondicions
     * 
     *  ACCIONS:
     *     - Presentem per pantalla les opcions del menú principal, Nivell 0
     *     - I demanem a l'usuari que ens digui quina opció d'aquestes vol fer.
     *
     *	POSTCONDICIÓ:
     *	   - Al acabar aquest mètode l'atribut opcio_1 de l'objecte pOpcions estarà informat amb la opció seleccionada per l'usuari
     *
     *  @param pOpcions tipus parametresMenu que utilitzo per tenir informades les opcions que ha anat seleccionant l'usuari
     *  @param pLector tipus Scanner, l'utilitzo per demanar per consola la següent opció
     */
    private static void PresentaOpcionsNivell0_i_DemanaSeleccioPerNivell1(ParametresMenu pOpcions,Scanner pLector ){
       
        System.out.println("");
        System.out.println("");
        System.out.println("Vuyo Aquarium");
        System.out.println("");
        System.out.println("Opcions: ");
        System.out.println("   " + MN1_Lectures + " - Lectures");
        System.out.println("   " + MN2_ElTeuAcuari + " - El teu Aquari");
        System.out.println("   " + MN3_Alarmes + " - Alarmes");
        System.out.println("   " + MN4_Sortir + " - Sortir");
        System.out.println("");
        System.out.println("Quina opció vols fer ?");
        System.out.flush();
        pOpcions.opcio1 = pLector.nextInt();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    
    /**
     *  PRECONDICIÓ: 
     *	   - l'Atribut opcio1 de pOpcions ha d'estar informat amb un valor conegut, sino haurem de resetejar les opcions i no fer res
     * 
     *  ACCIONS:
     *     - Presentem per pantalla les opcions relacionades a l'opció 1 seleccionada anteriorment
     *     - Demanem a l'usuari que ens digui quina opció de Nivell 2 vol fer
     *
     *	POSTCONDICIÓ:
     *	   - Sempre que el paràmetre opcio1 fos correcte
     *         A l'acabar aquest mètode l'atribut opcio_2 de l'objecte pOpcions estarà informat amb la opció seleccionada per l'usuari
     *     
     *  @param pOpcions tipus parametresMenu que utilitzo per tenir informades les opcions que ha anat seleccionant l'usuari
     *  @param pLector tipus Scanner, l'utilitzo per demanar per consola la següent opció
     */    
    private static void PresentaOpcionsNivell1_i_DemanaSeleccioPerNivell2(ParametresMenu pOpcions,Scanner pLector ){
        
         Boolean totOk = true;
          
         switch(pOpcions.opcio1)
         {
             case MN1_Lectures:
                    
                    System.out.println(" Opcions sobre Lectures: ");
                    System.out.println("    " + MN1_1_Macros + " - Introduir valors Macros i tempreraura ");
                    System.out.println("    " + MN1_2_AnteriorsLectures + " - Visualitza les dades anteriors");
                    System.out.println("    " + MN1_3_Endarrere + " - Endarrere");
                 
                 break;
             
             case MN2_ElTeuAcuari:
                 
                    System.out.println(" Opcions sobre el Teu Aquari: ");
                    System.out.println("    " + MN2_1_IntroduirHabitant + " - Introduir nou habitant ");
                    System.out.println("    " + MN2_2_LlistaHabitants + " - Visualitza llista habitants");
                    System.out.println("    " + MN2_3_Endarrere + " - Endarrere");
                    
                 break;
                 
             case MN3_Alarmes:
                 
                 System.out.println(" Opcions sobre Alarmes: ");
                 System.out.println("    " + MN3_1_SobreLectures + " - Alarmes de lectures ");
                 System.out.println("    " + MN3_2_SobreFeines + " - Alarmes de feines per fer");
                 System.out.println("    " + MN3_3_Endarrere + " - Endarrere");
                 break;

             default:
                    //si entrem aquí és per un error de l'alogritme, ja que tenim com a precondició que opció1 estigui inforamda
                    //amb algun dels valors coneguts, així que el que fem és cridar a un mètode de la classe ParametresMenus que
                    //reseteja tots els atributs, seria el mateix que fer aquí: 
                    //pOpcions.opcio1=-1;
                    //pOpcions.opcio2=-1;
                    //pOpcions.opcio3=-1;
                    pOpcions.ResetejaOpcions();
                    totOk = false;
                 break; 
         }
         
         if (totOk)
          {
                System.out.println("");
                System.out.println("Quina opció vols fer ?");
                System.out.flush();
                pOpcions.opcio2 = pLector.nextInt();
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
          }
    }
    
    private static void GestionaOpcionsNivell2(ParametresMenu pOpcions, Macros pValors, Scanner pLector){
          
        switch(pOpcions.opcio1)
         {
             case MN1_Lectures:
                    
                    switch(pOpcions.opcio2)
                    {
                        case MN1_1_Macros:
                                ExecutaIntroduirMacro(pValors,pLector,pOpcions );
                            break;
                        case MN1_2_AnteriorsLectures:
                                ExecutaVeureLectures(pOpcions,pValors,pLector);
                            break;
                        case MN1_3_Endarrere:
                                pOpcions.opcio2 = -1; 
                                pOpcions.opcio1 = -1; // posant aquest valor quan anem a la volta de bucle del main, 
                                                      // el sistema interpretarà que no sap quina opcio ha seleccionat 
                                                      // i per tant ha de presentarli el menú principal
                            break;
                        default:
                            break;
                    }
                    
                 break;
             
             case MN2_ElTeuAcuari:
                 
                    switch(pOpcions.opcio2)
                    {
                        case MN2_1_IntroduirHabitant:
                                 ExecutaIntroduirHabitant(pOpcions,pValors,pLector);
                            break;
                        case MN2_2_LlistaHabitants:
                                 ExecutaVeureHabitants(pOpcions,pValors);
                            break;
                        case MN2_3_Endarrere:
                                pOpcions.opcio2 = -1; 
                                pOpcions.opcio1 = -1; // posant aquest valor quan anem a la volta de bucle del main, 
                                                      // el sistema interpretarà que no sap quina opcio ha seleccionat 
                                                      // i per tant ha de presentarli el menú principal                            
                            break;
                        default:
                            break;
                    }
                    break;
                       
                  
  
            case MN3_Alarmes:

                switch (pOpcions.opcio2) {

                    case MN3_1_SobreLectures:
                            ExecutaAlarmesLectures(pOpcions,pValors);
                        break;
                        
                    case MN3_2_SobreFeines:
                            ExecutaAlarmesSobreFeines(pOpcions,pLector);
                            //per definir
                        break;
                        
                    case MN3_3_Endarrere:
                            pOpcions.opcio2 = -1;
                            pOpcions.opcio1 = -1; // posant aquest valor quan anem a la volta de bucle del main, 
                            // el sistema interpretarà que no sap quina opcio ha seleccionat 
                            // i per tant ha de presentarli el menú principal                            
                        break;
                    default:               
                        break;
                }
                break;
        }

    }
        
    private static void ExecutaIntroduirMacro(Macros pValors, Scanner pLector, ParametresMenu pOpcions) {

        System.out.println("");
        //preguntem quants dies vol posar per si tancar el bucle a aquesta quantitat
        System.out.println("Quants dies vols posar?");
        pValors.comptadorDies = pLector.nextInt();
        //l'index "i" seran el dies
        for (pValors.i = 0; pValors.i < pValors.macros.length; pValors.i++) {
            // quan l'index sigui superior o igual al número de dies introduït per l'usuari, tencarem el bucle.
            if (pValors.i >= pValors.comptadorDies) {
                break;
            }

            System.out.println("");
            System.out.println("");
            System.out.println("introdueix el valor dels NO3 del dia: " + (pValors.i + 1));
            // iniciem variable de nitrats per guardar les dades que llegim de l'usuari
            float nitrats = pLector.nextFloat();
            // Guardem el valor a la primera columna i al dia corresponent (i)
            pValors.macros[pValors.i][0] = nitrats;

            System.out.println("Introdueix el valor dels PO4 del dia: " + (pValors.i + 1));
            // iniciem variable de fosfats per guardar les dades que llegim de l'usuari

            float fosfats = pLector.nextFloat();
            // Guardem el valor a la primera columna i al dia corresponent (i)
            pValors.macros[pValors.i][1] = fosfats;

            System.out.println("Introdueix el valor de K del dia: " + (pValors.i + 1));
            // iniciem variable de potasi per guardar les dades que llegim de l'usuari
            float potasi = pLector.nextFloat();
            // Guardem el valor a la segona columna i al dia corresponent (i)                                
            pValors.macros[pValors.i][2] = potasi;

            System.out.println("Introdueix el valor de temp del dia: " + (pValors.i + 1));
            // iniciem variable de temperatura per guardar les dades que llegim de l'usuari
            float temperatura = pLector.nextFloat();
            // Guardem el valor a la tercera columna i al dia corresponent (i)
            pValors.macros[pValors.i][3] = temperatura;

            System.out.println("");
            System.out.println("");
            // A cada volta imprimim els valors de cada dia 
            pValors.resultat = "NO3: " + pValors.macros[pValors.i][0] + " / PO4: " + pValors.macros[pValors.i][1] + " / K: " + pValors.macros[pValors.i][2] + " / Temperatura: " + pValors.macros[pValors.i][3];
            // Els imprimim amb una array
            System.out.println(pValors.resultat);
            System.out.println("");

            // els valors ja els hem emmagatzemat a l'index "j"
            for (pValors.j = 0; pValors.j < pValors.macros[0].length; pValors.j++) {

            }
        }

        pOpcions.opcio1= MN0_Inici;
        pOpcions.opcio2  = -1; //una vegada feta l'acció volem que a la següent volta de bucle escrigui les opcions del nivell 1 al que estem          

        PresentaOpcionsNivell0_i_DemanaSeleccioPerNivell1(pOpcions, pLector);

    }
      
    private static void ExecutaVeureLectures(ParametresMenu pOpcions,Macros pValors,Scanner pLector){
  
        System.out.println("");
        System.out.println("Has sel·leccionat: LECTURES ");
        System.out.println("");
        System.out.println("");
        // A cada volta imprimim els valors de cada dia 
        pValors.resultat = "NO3: " + pValors.macros[pValors.i][0] + " / PO4: " + pValors.macros[pValors.i][1] + " / K: " + pValors.macros[pValors.i][2] + " / Temperatura: " + pValors.macros[pValors.i][3];
        // Els imprimim amb una array
        System.out.println(pValors.resultat);
        System.out.println("");
        int i = pLector.nextInt();
        pOpcions.opcio1 = MN0_Inici;
        PresentaOpcionsNivell0_i_DemanaSeleccioPerNivell1(pOpcions, pLector);
        pOpcions.opcio2 = -1; //una vegada feta l'acció volem que a la següent volta de bucle escrigui les opcions del nivell 1 al que estem          
    }

    private static void ExecutaIntroduirHabitant(ParametresMenu pOpcions, Macros pValors, Scanner pLector) {

        System.out.println("Has sel·leccionat: Defineix el teu acuari");
        System.out.println("");
        // Escribim habitants com a submenú, ja que és el que es mostrarà
        System.out.println("HABITANTS");
        System.out.println("");
        // preguntem si l'usuari vol introoduir algun habitant
        System.out.println("Vols afegir algun habitant?");
        String s = pLector.nextLine();
        //llegim la resposta i l'assignem a la variable String resposta
        pValors.resposta = pLector.nextLine();
        //String inputString = lector.nextLine();
        // Designem un boolean per marcar si la resposta ha sigut positiva o negativa i saber si seguim en el bucle
        boolean continuacio = true;
        // tornem a reiniciar menú i per fer un altre bucle 
        pValors.i = 0;

        if (pValors.resposta.equals("no")) {

            continuacio = false;

        }

        if (pValors.resposta.equals("si")) {

            continuacio = true;

        }

        if (continuacio == true) {
            // iniciem bucle per introduir nous habitants
            for (pValors.i = 0; pValors.i < pValors.nomHabitant.length; pValors.i++) {

                System.out.println("");
                System.out.println("");
                System.out.println("Escriu el nom del habitant");
                pValors.nomHabitant[pValors.i] = pLector.nextLine();
                System.out.println("");
                System.out.println("");
                System.out.println("Vols afegir més habitants?");
                pValors.resposta = pLector.nextLine();
                if (pValors.resposta.equals("si")) {
                    continuacio = true;
                }
                if (pValors.resposta.equals("no")) {
                    continuacio = false;
                    break;
                }

            }
        }
        pOpcions.opcio2 = -1; //una vegada feta l'acció volem que a la següent volta de bucle escrigui les opcions del nivell 1 al que estem          
    }
 
    private static void ExecutaVeureHabitants(ParametresMenu pOpcions,Macros pValors){
         
            System.out.println("");
            System.out.println("");
            System.out.println("Els noms del habitants son: ");
            System.out.println("");
            System.out.println("");

            // iniciem bucle de nou per imprimir per pantalla els habitants del acuari
            for (pValors.i = 0; pValors.i < pValors.nomHabitant.length; pValors.i++) {
            System.out.println(pValors.nomHabitant[pValors.i]);

            }

            pOpcions.opcio1 = MN0_Inici;
            pOpcions.opcio2  = -1; //una vegada feta l'acció volem que a la següent volta de bucle escrigui les opcions del nivell 1 al que estem          


    }
    
    private static void ExecutaAlarmesLectures(ParametresMenu pOpcions,Macros pValors){
        if (pValors.macros[pValors.i-1][0] >= pValors.macros[pValors.i][0] + 10) {
            System.out.println("Increment dels Nitrats massa elevat");
        }
        if (pValors.macros[pValors.i-1][1] >= pValors.macros[pValors.i][1] + 1) {
                System.out.println("Increment dels Fosfats massa elevat");
        }
        if (pValors.macros[pValors.i-1][2]>= pValors.macros[pValors.i][2]+15){
            System.out.println("Increment del Potasi massa elevat");
        }
        if (pValors.macros[pValors.i-1][3]>= pValors.macros[pValors.i][3]+ 5){
            System.out.println("Increment de la Temperatura massa elevat");
  
        }
                pOpcions.opcio1= MN0_Inici;
                pOpcions.opcio2  = -1; //una vegada feta l'acció volem que a la següent volta de bucle escrigui les opcions del nivell 1 al que estem          
    }
    private static void ExecutaAlarmesSobreFeines(ParametresMenu pOpcions,Scanner Lector){
        //per definir
        System.out.println("S'està construint");
        pOpcions.opcio1= MN0_Inici;
        pOpcions.opcio2  = -1; //una vegada feta l'acció volem que a la següent volta de bucle escrigui les opcions del nivell 1 al que estem          
        PresentaOpcionsNivell1_i_DemanaSeleccioPerNivell2(pOpcions,Lector);
        
    }

       
}

