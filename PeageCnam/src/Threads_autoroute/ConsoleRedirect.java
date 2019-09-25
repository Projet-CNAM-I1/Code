package Threads_autoroute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

class ConsoleRedirect extends Thread
{
    private final InputStream is;
    private final JTextArea text;
 
    public ConsoleRedirect(InputStream is, JTextArea text)
    {
        this.is = is;
        this.text = text;
    }
 
    public void run()
    {
        try
        {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line=null;
            while ( (line = br.readLine()) != null)
            {
                text.append(line + "\n"); // JTextArea.append is thread safe
            }
        }
        catch (IOException ioe)
        {
            text.append(ioe.toString()); // note below
            ioe.printStackTrace();  
        }
    }
}