import java.io.*;

public class ReaderDemo {

   public static void main(String[] args) {
      try {
         String s = "Hello World";

         // create a new StringReader
         Reader reader = new StringReader(s);

         // read the first five chars
         for (int i = 0; i < 5; i++) {
            char c = (char) reader.read();
            System.out.print("" + c);
         }

         // mark current position for maximum of 10 characters
         reader.mark(10);

         // read five more chars
         for (int i = 0; i < 6; i++) {
            char c = (char) reader.read();
            System.out.print("" + c);
         }

         // reset back to the marked position
         reader.reset();

         // change line
         System.out.println();

         // read six more chars
         for (int i = 0; i < 6; i++) {
            char c = (char) reader.read();
            System.out.print("" + c);
         }

         // close the stream
         reader.close();

      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }
}