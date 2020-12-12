
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Formatter;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebastian
 */
public class RegistroDisco extends Disco {
    
//  Obtener TAMAÑO DEL REGISTRO 
//        codigo = (6*2)                12
//        autor= (30*2)                 60
//        titulo= (30*2)                60
//        cantidad=0;(4)                 4
//        costo=0;  (8)                  8
//        precio=0; (8)                  8
//        anio=0;   (4)                  4
//        genero =  (30*2)              60
//        duracion = (8)                 8
//        sello = (15*2)                30
//                                     254
    
    
    
    public static final int TAMAÑO_REGISTRO = 254; 
    
    public RegistroDisco(){
        super("","","",0,0,0,0,"",0,"");
    }
    
    public RegistroDisco(String codigo,String autor,String titulo,int cantidad,double costo,double precio,int anio,String genero,double duracion,String sello){
        super(codigo,autor,titulo,cantidad,costo,precio,anio,genero,duracion,sello);
    }
    
    public void LEER(RandomAccessFile archivo) throws IOException 
    {
        setCodigo(leerCodigo(archivo));
        setAutor(leerAutor(archivo));
        setTitulo(leerTitulo(archivo));
        setCantidad(archivo.readInt());
        setCosto(archivo.readDouble());
        setPrecio(archivo.readDouble());
        setAnio(archivo.readInt());
        setGenero(leerGenero(archivo));
        setDuracion(archivo.readDouble());
        setSello(leerSello(archivo));
    }
    
    public void escribir(RandomAccessFile archivo) throws IOException {
        escribirCodigo(archivo, getCodigo());
        escribirAutor(archivo,getAutor());
        escribirTitulo(archivo,getTitulo());
        archivo.writeInt(getCantidad());
        archivo.writeDouble(getCosto());
        archivo.writeDouble(getPrecio());
        archivo.writeInt(getAnio());
        escribirGenero(archivo,getGenero());
        archivo.writeDouble(getDuracion());
        escribirSello(archivo,getSello());
    }
    
    public void escribirCodigo(RandomAccessFile archivo, String cod) throws IOException {
        long tamaño,numeroRegistros,Ncod;
        tamaño = archivo.length();
        numeroRegistros = (tamaño / TAMAÑO_REGISTRO);
        Ncod = numeroRegistros + 1;
        StringBuffer almacena = null;
        almacena = new StringBuffer(cod);
        almacena.setLength(6);                    //garantiza que se escriban 6 caracteres        
        archivo.writeChars(almacena.toString());
    }

    public void escribirAutor(RandomAccessFile archivo, String nombre) throws IOException {
        StringBuffer almacena = null;
        almacena = new StringBuffer(nombre);
        almacena.setLength(30);                    //garantiza que se escriban 30 caracteres
        archivo.writeChars(almacena.toString());
    }   

    public void escribirTitulo(RandomAccessFile archivo, String nombre) throws IOException {
        StringBuffer almacena = null;
        almacena = new StringBuffer(nombre);
        almacena.setLength(30);                    //garantiza que se escriban 30 caracteres
        archivo.writeChars(almacena.toString());
    }
    
    public void escribirGenero(RandomAccessFile archivo, String nombre) throws IOException {
        StringBuffer almacena = null;
        almacena = new StringBuffer(nombre);
        almacena.setLength(30);                    //garantiza que se escriban 30 caracteres
        archivo.writeChars(almacena.toString());
    }
    
    public void escribirSello(RandomAccessFile archivo, String nombre) throws IOException {
        StringBuffer almacena = null;
        almacena = new StringBuffer(nombre);
        almacena.setLength(15);                    //garantiza que se escriban 15 caracteres
        archivo.writeChars(almacena.toString());
    }
    
    public String leerSello(RandomAccessFile archivo) throws IOException {
        String sell = "";
        char temporal;
        for (int cuenta = 0; cuenta < 15; cuenta++) {
            temporal = archivo.readChar();
            if (temporal == '\0') {
                temporal = ' ';
            }
            sell += temporal;                    //garantiza que se lean 30 caracteres
        }
        return sell;
    }

    public String leerGenero(RandomAccessFile archivo) throws IOException {
        String gen = "";
        char temporal;
        for (int cuenta = 0; cuenta < 30; cuenta++) {
            temporal = archivo.readChar();
            if (temporal == '\0') {
                temporal = ' ';
            }
            gen += temporal;                    //garantiza que se lean 30 caracteres
        }
        return gen;
    }
    
    public String leerTitulo(RandomAccessFile archivo) throws IOException {
        String titul = "";
        char temporal;
        for (int cuenta = 0; cuenta < 30; cuenta++) {
            temporal = archivo.readChar();
            if (temporal == '\0') {
                temporal = ' ';
            }
            titul += temporal;                    //garantiza que se lean 30 caracteres
        }
        return titul;
    }
    
    public String leerAutor(RandomAccessFile archivo) throws IOException {
        String nombre = "";
        char temporal;
        for (int cuenta = 0; cuenta < 30; cuenta++) {
            temporal = archivo.readChar();
            if (temporal == '\0') {
                temporal = ' ';
            }
            nombre += temporal;                    //garantiza que se lean 30 caracteres
        }
        return nombre;
    }
    
  public String leerCodigo(RandomAccessFile archivo) throws IOException
  {
      String cod = "";
      char temporal;
      for (int cuenta = 0; cuenta < 6  ; cuenta++)
      {
          temporal = archivo.readChar();
          if (temporal == '\0')
            temporal = ' ';
          cod+= temporal;                    //garantiza que se lean 6 caracteres
      }
      
      return cod;
  }
    
    public void ingresar() throws IOException {
        long tamaño;
        RandomAccessFile archivo;
        archivo = new RandomAccessFile("discos.txt", "rw");
        try {
            tamaño = archivo.length();
            archivo.seek(tamaño);   //posiciona el puntero al final del archivo
            //System.out.println(tamaño);
            escribir(archivo);
            archivo.close();

        } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(null, "Error al grabar los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public int buscar(String cod) throws IOException {   // Búsqueda secuencial

        RandomAccessFile archivo;
        archivo = new RandomAccessFile("discos.txt", "r");
        int i = 0;
        boolean bandera;
        bandera = false;

        long tamaño;
        tamaño = archivo.length();

        long numeroRegistros = (tamaño / TAMAÑO_REGISTRO);

        while ((i < numeroRegistros) && (bandera == false)) {
            LEER(archivo);

            if (cod.equalsIgnoreCase(codigo)) {
                bandera = true;
            } else {
                i++;
            }
        }
        archivo.close();

        if (bandera == true) {
            return i;
        } else {
            return -1;
        }
    }
    
    public void modificar(int i) throws IOException {
        RandomAccessFile archivo;
        archivo = new RandomAccessFile("discos.txt", "rw");

        int posicion;
        posicion = i * TAMAÑO_REGISTRO;

        try {
            archivo.seek(posicion);             //posiciona el puntero del archivo en el lugar en el cual grabara lod datos nuevos
            escribir(archivo);
            JOptionPane.showMessageDialog(null, "El registro ha sido modificado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            archivo.close();
        } catch (IOException excepcion) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public RegistroDisco consultar(int i) throws IOException {
        RandomAccessFile archivo;
        archivo = new RandomAccessFile("discos.txt", "r");
        RegistroDisco REGISTRO = new RegistroDisco();
        try {
            archivo.seek(i * REGISTRO.TAMAÑO_REGISTRO);    //posiciona el puntero del archivo en el lugar correcto
            REGISTRO.LEER(archivo);
            archivo.close();
        } catch (IOException excepcion) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return REGISTRO;
    }

    
    public void eliminar(String Numero)
  {
      long tamaño, numeroRegistros;

      RegistroDisco REGISTRO = new RegistroDisco();
      RandomAccessFile archivo_guia, archivo_temp;

      try
      {
       
        archivo_guia = new RandomAccessFile("discos.txt", "rw");
        archivo_temp = new RandomAccessFile("temp.txt", "rw");
        tamaño = archivo_guia.length();
        numeroRegistros = (tamaño / REGISTRO.TAMAÑO_REGISTRO);
          for (int i = 0; i < numeroRegistros; i++) {
                REGISTRO.LEER(archivo_guia);
              if (REGISTRO.codigo.equals(Numero) && REGISTRO.codigo!=null) {
                    System.out.println(REGISTRO.codigo);
              }else{
                REGISTRO.escribir(archivo_temp);
              }
          }

                        archivo_guia.close();                //no olvidar cerrar los archivos
                archivo_temp.close();
          File archivo1 = new File("discos.txt");
          archivo1.delete();                            // borra el archivo libro.txt
          File archivo2 = new File("temp.txt");
          archivo2.renameTo(archivo1);                //renombra el archivo temporal.txt por libro.txt
      }

       catch (IOException excepcion)
       {
          JOptionPane.showMessageDialog(null,"Error al abrir el archivo","Error",JOptionPane.ERROR_MESSAGE);
       }
       JOptionPane.showMessageDialog(null,"El registro ha sido eliminado","Mensaje",JOptionPane.INFORMATION_MESSAGE);

    }
    
    public ArrayList listar() throws IOException {
        RandomAccessFile archivo;
        archivo = new RandomAccessFile("discos.txt", "r");

        long tamaño, numeroRegistros;
        ArrayList Elementos;
        Elementos = new ArrayList(5);
        RegistroDisco REGISTRO;

        try {

            tamaño = archivo.length();
            numeroRegistros = (tamaño / TAMAÑO_REGISTRO);
            for (int i = 0; i < numeroRegistros; i++) {
                LEER(archivo);
                REGISTRO = new RegistroDisco(getCodigo(),getAutor(),getTitulo(),getCantidad(),getCosto(),getPrecio(),getAnio(),getGenero(),getDuracion(),getSello());
                Elementos.add(REGISTRO);
            }
            archivo.close();

        } catch (IOException excepcion) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
        return Elementos;
    }
    
    public void eliminar(int posicion)
    {
      long tamaño, numeroRegistros;

      RegistroDisco REGISTRO = new RegistroDisco();
      RandomAccessFile archivo_guia, archivo_temp;

      try
      {
       
        archivo_guia = new RandomAccessFile("discos.txt", "r");
        archivo_temp = new RandomAccessFile("temp.txt", "rw");
        tamaño = archivo_guia.length();
        numeroRegistros = (tamaño / REGISTRO.TAMAÑO_REGISTRO);
        int ON = posicion * TAMAÑO_REGISTRO;
        for (int i=0; i<numeroRegistros; i++)
         {
             REGISTRO.LEER(archivo_guia);
             if (posicion != ON )
             {
                 System.out.println(REGISTRO.codigo);
                 REGISTRO.escribir(archivo_temp);    //guarda en el archivo temporal
             }
         }

         
            archivo_guia.close();                //no olvidar cerrar los archivos
            archivo_temp.close();

            File archivo1 = new File("guia.txt");
            archivo1.delete();                            // borra el archivo libro.txt
            File archivo2 = new File("temp.txt");
            archivo2.renameTo(archivo1);                //renombra el archivo temporal.txt por libro.txt

      }

       catch (IOException excepcion)
       {
          JOptionPane.showMessageDialog(null,"Error al abrir el archivo","Error",JOptionPane.ERROR_MESSAGE);
       }
       JOptionPane.showMessageDialog(null,"El registro ha sido eliminado","Mensaje",JOptionPane.INFORMATION_MESSAGE);

    }

}


