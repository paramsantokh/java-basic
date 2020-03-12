package designPatterns.structural.adapter.javaExample;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class InputStreamExample {
  
  public static void main(String[] args) throws IOException {
    /**
     * BufferedReader Reads text from a character-input stream.
     * System.in provides byte stream where BufferedReader expects character stream.
     *
     * This is the ideal situation to put a adapter in between two incompatible interfaces.
     * InputStreamReader does exactly this thing and works adapter between System.in and BufferedReader.
     */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter String");
    String s = br.readLine();
    System.out.print("Enter input: " + s);
  
    //Another example
    Writer writer = new OutputStreamWriter(new FileOutputStream("c:\\data\\output.txt"));
    writer.write("Hello World");
  }
}
