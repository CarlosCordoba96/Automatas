package Carlos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;

public class GeneradorImagen {
	
	private Hashtable<String, Estado> tablaEstados;
	private Hashtable<String, Transicion> tablaTransiciones;
	private String graphString;
	
	public static final String RUTA_FICHERO = "";
	public static final String RUTA_FICHERO_TEX = RUTA_FICHERO + "salida.tex"; 
	
	public GeneradorImagen(Hashtable<String, Estado> tablaEstados, 
			Hashtable<String, Transicion> tablaTransiciones) {
		this.tablaEstados = tablaEstados;
		this.tablaTransiciones = tablaTransiciones; 
		this.graphString = graphStringGenerator();
	}

	public String graphStringGenerator() {
		Enumeration<Estado> estados = tablaEstados.elements();
		Estado estadoActual;
		String rstring = "";
		while( estados.hasMoreElements()) {
			estadoActual = estados.nextElement();
			rstring += estadoActual.getEstado();
			if(estadoActual.isInicial()) {
				rstring += "[initial";
				if(estadoActual.isEnd()) {
					rstring += ", accepting]";
				} else {
					rstring += "]";
				}
			} else if(estadoActual.isEnd()) {
				rstring += "[accepting]";
			}
			rstring += ";\n";
		}
		Enumeration<Transicion> transiciones = tablaTransiciones.elements();
		Transicion transicionActual;
		while( transiciones.hasMoreElements()) {
			transicionActual = transiciones.nextElement();
			rstring += transicionActual.getDesde().getEstado() + " ->" + 
			"[edge label=" + transicionActual.getTransicion() +
			(transicionActual.getDesde().getEstado().equals(
					transicionActual.getHasta().getEstado()) ? ",loop above] " : "] ") +
			transicionActual.getHasta().getEstado() + ";\n";
		}
		return rstring;
	}
	
	public void generarFichero() {
		String aEscribir;
		aEscribir = "\\documentclass{article}\n" + 

"\\usepackage{tikz}\n" +
"\\usetikzlibrary{graphs}\n" +
"\\usetikzlibrary{graphdrawing, automata}\n" +
"\\usegdlibrary{trees, layered, force}\n" +
"\\begin{document}\n" +
"\\pagestyle{empty}\n" +
"\\begin{tikzpicture}\n" +
"  \\tikz \\graph [spring layout, sibling distance=7mm, nodes={state},\n" +
"  node distance=2cm, edge quotes mid]\n" +
  "{\n" + graphString + 
  "};\n" +
"\\end{tikzpicture}\n" + 
"\\end{document}\n";
		System.out.println(aEscribir);
		try {
			Writer file = null;
			file = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(RUTA_FICHERO_TEX), "utf-8"));
			
			file.write(aEscribir);
			file.close();
		} catch(IOException e) {
			System.err.println("Error escribiendo al fichero");
		}
		
	}
	
	public void compilarFichero() throws IOException, InterruptedException {
		Process compileProcess = new ProcessBuilder(
				"lualatex", RUTA_FICHERO_TEX).start();
		
		compileProcess.waitFor();
		printStream(compileProcess.getInputStream());
		printStream(compileProcess.getErrorStream());
	}
	
	public void generarImagen() throws IOException, InterruptedException {
		Process convertProcess = new ProcessBuilder(
				"convert", "salida.pdf", "salida.png").start();
		convertProcess.waitFor();
		printStream(convertProcess.getInputStream());
		printStream(convertProcess.getErrorStream());
	}
	
	public static void printStream(InputStream is) throws IOException{
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;

		while ((line = br.readLine()) != null) {
		  System.out.println(line);
		}
	}
}
